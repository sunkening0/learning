package com.skn.Learning.reflectdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * µÁƒ‘‘À––
 * @author skn
 *
 */
public class ComputerDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		MainBoard mBoard = new MainBoard();
		mBoard.run();
		
		Properties properties = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResource("pci.properties").openStream();
		properties.load(in);
		for(int i = 0;i<properties.size();i++){
			String classname = properties.getProperty("pci"+i);
			Class clazz = Class.forName(classname);
			
			PCI object = (PCI) clazz.newInstance();
			mBoard.usePCI(object);
		}
	}
}
