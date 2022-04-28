package com.JavaBasics;

public class Varaibles {
	static int m = 100;// static variable or class variable : declared with static key word
	int data = 50;// instance variable : declared inside class but outside method
	 //int data = 60;
	 void method() {
		 int n = 90;// local variable : declared inside method 
		System.out.println(n);
	}
	 
	 static void hello() {
		 int n = 70;// local variable : declared inside method 
		System.out.println(n);
	}

	public static void main(String args[]) {
		//int data = 50;// local variable
		Varaibles v1 = new Varaibles();
		System.out.println(v1.data);
		v1.method();
		System.out.println(Varaibles.m);
		Varaibles.hello();

	}

}