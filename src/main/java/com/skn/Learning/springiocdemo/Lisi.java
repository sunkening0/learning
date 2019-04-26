package com.skn.Learning.springiocdemo;

public class Lisi extends HumanWithCar {
	public Lisi(Car car) {
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

