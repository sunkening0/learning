package com.skn.Learning.springiocdemo;

public class Zhangsan extends HumanWithCar {
	public Zhangsan(Car car) {
		super(car);
	}

	@Override
	public void goHome() {
		
		car.start();
		car.turnLeft();
		car.turnRight();
		car.stop();
	}


	

}
