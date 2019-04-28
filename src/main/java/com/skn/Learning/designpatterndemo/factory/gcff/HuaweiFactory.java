package com.skn.Learning.designpatterndemo.factory.gcff;

public class HuaweiFactory extends PhoneFactory {

	@Override
	public Phone creatPhone() {
		// TODO Auto-generated method stub
		return new HuaweiPhone();
	}

}
