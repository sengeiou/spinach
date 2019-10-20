package me.zohar.lottery.mastercontrol.convert;

import org.springframework.beans.BeanUtils;

import me.zohar.lottery.mastercontrol.domain.InviteRegisterSetting;
import me.zohar.lottery.mastercontrol.domain.RechargeSetting;
import me.zohar.lottery.mastercontrol.domain.RegisterAmountSetting;
import me.zohar.lottery.mastercontrol.vo.InviteRegisterSettingVO;
import me.zohar.lottery.mastercontrol.vo.RechargeSettingVO;
import me.zohar.lottery.mastercontrol.vo.RegisterAmountSettingVO;

public class ConvertVoWithMasterControl {
	
	public static RegisterAmountSettingVO convertRegisterAmountSetting(RegisterAmountSetting registerAmountSetting) {
		if (registerAmountSetting == null) {
			return null;
		}
		RegisterAmountSettingVO vo = new RegisterAmountSettingVO();
		BeanUtils.copyProperties(registerAmountSetting, vo);
		return vo;
	}

	
	public static RechargeSettingVO convertRechargeSetting(RechargeSetting rechargeSetting) {
		if (rechargeSetting == null) {
			return null;
		}
		RechargeSettingVO vo = new RechargeSettingVO();
		BeanUtils.copyProperties(rechargeSetting, vo);
		return vo;
	}
	
	public static InviteRegisterSettingVO convertInviteRegisterSetting(InviteRegisterSetting inviteRegisterSetting) {
		if (inviteRegisterSetting == null) {
			return null;
		}
		InviteRegisterSettingVO vo = new InviteRegisterSettingVO();
		BeanUtils.copyProperties(inviteRegisterSetting, vo);
		return vo;
	}

}
