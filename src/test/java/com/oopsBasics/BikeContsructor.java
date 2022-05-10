package com.oopsBasics;

public class BikeContsructor {
	int id;
	String s;

	//constructor without arguments as no arguments constructor
	 BikeContsructor() {
		System.out.println("constructor is created/invoked");
	}

	 //constructor with arguments or parameters is called parameterized
	BikeContsructor(int a, String b) {
		{
			id = a;
			s = b;
			System.out.println("parameter constructor is created/invoked");
			System.out.println(a + b);
		}
	}

	void display() {
		System.out.println(id + " " + s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BikeContsructor b1 = new BikeContsructor();
		BikeContsructor b2 = new BikeContsructor(5, "Arun");
		BikeContsructor b3 = new BikeContsructor(99, "hello");
		b1.display();
		b2.display();
		b3.display();

	}

}
