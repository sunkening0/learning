package com.skn.Learning.reflectdemo;

public class MainBoard {
	public void run(){
		System.out.println("run.......");
	}
	
	public void usePCI(PCI p){
		if(p!=null){
			p.open();
			p.close();			
		}
	}
}
