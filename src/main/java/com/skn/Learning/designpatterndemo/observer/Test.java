package com.skn.Learning.designpatterndemo.observer;

public class Test{
	public static void main(String[] args)
	{
		//模拟一个3D的服务号
		ObjectFor3D subjectFor3d = new ObjectFor3D();
		//客户1
		Observer observer1 = new Observer1(subjectFor3d);
		//客户2
		Observer observer2 = new Observer2(subjectFor3d);

		subjectFor3d.setMsg("20190922的3D号码是：127" );
		subjectFor3d.setMsg("20190923的3D号码是：333" );	
	}

}
