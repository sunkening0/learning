package com.skn.Learning.designpatterndemo.observer.java;

/**
 * 模拟两个服务号，两个观察者
* 类名称：Test   
* 类描述：   
* 创建人：skn   
* 创建时间：2019年9月22日 下午10:35:38   
* @version
 */
public class Test {
	public static void main(String[] args) {
		SubjectFor3d subjectFor3d = new SubjectFor3d();
		SubjectForSSQ subjectForSSQ = new SubjectForSSQ();
		Observer1 observer1 = new Observer1();
		observer1.registerSubject(subjectFor3d);
		observer1.registerSubject(subjectForSSQ);
		
		Observer2 observer2 = new Observer2();
		observer2.registerSubject(subjectFor3d);
		observer2.registerSubject(subjectForSSQ);
		
		
		subjectFor3d.setMsg("hello 3d'nums : 110 ");
		subjectForSSQ.setMsg("ssq'nums : 12,13,31,5,4,3 15");
	}

}
