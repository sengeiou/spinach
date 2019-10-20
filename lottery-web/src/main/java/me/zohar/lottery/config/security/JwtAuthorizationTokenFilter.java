package me.zohar.lottery.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.ExpiredJwtException;
import me.zohar.lottery.api.UserAccountApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.useraccount.vo.LoginAccountInfoVO;

@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserAccountApi userAccountApi;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private String tokenHeader = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String authToken = request.getHeader(tokenHeader);
		String username = null;
		if (StrUtil.isNotBlank(authToken)) {
			try {
				username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("an error occurred during getting username from token", e);
			} catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
			}
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserAccountDetails userAccountDetails;
			try {
				Result result = userAccountApi.getLoginAccountInfo(username);
				LoginAccountInfoVO loginAccountInfo = JSON.parseObject(JSON.toJSONString(result.getData()),
						LoginAccountInfoVO.class);
				userAccountDetails = new UserAccountDetails(loginAccountInfo);
			} catch (UsernameNotFoundException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
				return;
			}
			if (jwtTokenUtil.validateToken(authToken, userAccountDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userAccountDetails, userAccountDetails.getPassword(), userAccountDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		chain.doFilter(request, response);
	}
}
