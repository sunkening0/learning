package com.skn.Learning.spring.test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skn.Learning.spring.Apple;

@Service
public class TestService {
//	@Qualifier("apple2")
	@Autowired
	//@Resource
	Apple apple;
	
	public void test1(){
		System.out.println(apple);
	}
	
}
