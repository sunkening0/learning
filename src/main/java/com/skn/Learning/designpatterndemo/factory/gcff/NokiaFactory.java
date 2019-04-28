package com.skn.Learning.designpatterndemo.factory.gcff;

public class NokiaFactory extends PhoneFactory {

	@Override
	public Phone creatPhone() {
		// TODO Auto-generated method stub
		return new NokiaPhone();
	}

}
