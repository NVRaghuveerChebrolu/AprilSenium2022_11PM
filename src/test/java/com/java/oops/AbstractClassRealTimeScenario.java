package com.java.oops;

interface A453 {
	void a();
	void b();
	void c();
	void d();
	//int sum(int a , int b);
	  
}

interface B953 extends A453{
	void abc();
}

abstract class B9873948 implements B953 {
	public void c() {
		System.out.println("I am c");
	}
	public void a() {
		System.out.println("I am a in parent class");
	}
}

class M extends B9873948 {
	public void a() {
		System.out.println("I am a in child class");
	}

	public void b() {
		System.out.println("I am b");
	}

	public void d() {
		System.out.println("I am d");
	}

	@Override
	public void abc() {
		System.out.println(" inside abc");
		
	}
}

class AbstractClassRealTimeScenario {
	public static void main(String args[]) {
		A453 a = new M();//upcasting
		a.a();
		a.b();
		a.c();
		a.d();
		B953 b = new M();
		b.abc();
	}
}