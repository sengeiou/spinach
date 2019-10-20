package me.zohar.lottery.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthorizationTokenFilter authenticationTokenFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/masterControl/getInviteRegisterSetting").permitAll()
		.antMatchers("/userAccount/register").permitAll()
		.antMatchers("/userAccount/getUserAccountInfo").permitAll()
		.antMatchers("/game/findAllOpenGame").permitAll()
		.antMatchers("/game/findAllGameCategory").permitAll()
		.antMatchers("/game/findAllGameSituation").permitAll()
		.antMatchers("/game/findGameSituationByGameCategoryId").permitAll()
		.antMatchers("/recharge/muspayCallback").permitAll()
		.antMatchers("/betting/findTop50WinningRank").permitAll()
		.antMatchers("/systemNotice/findTop5PublishedSystemNotice").permitAll()
		.antMatchers("/lotteryInformation/**").permitAll()
		.antMatchers("/issue/findLotteryHistory").permitAll()
		.antMatchers("/game/findGameByGameCode").permitAll()
		.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/plugins/**", "/**.ico");
	}
	
}
