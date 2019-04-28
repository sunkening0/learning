package com.skn.Learning.designpatterndemo.factory.cxgc;

import com.skn.Learning.designpatterndemo.factory.gcff.HuaweiPhone;

public class HuaweiFactory extends PhoneFactory {

	@Override
	public PhonePm creatPhonePm() {
		// TODO Auto-generated method stub
		return new HuaweiPm();
	}

	@Override
	public PhoneDc creatPhoneDc() {
		// TODO Auto-generated method stub
		return new HuaweiDc();
	}

}
