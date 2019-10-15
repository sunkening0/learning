package com.skn.Learning.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
public class Apple {
	private String name="1";
	/*
	public Apple(String name){
		this.name=name;
	}
*/
	
	@Override
	public String toString() {
		return "Apple [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
