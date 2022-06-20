package com.java.oops;

interface Printable {
	void print();//this is an abstract method. No need to use abstract key word. 
}

interface Showable {
	void show();
	void print();
}

class multipleInheritanceInterface implements Printable, Showable {
	public void print() {
		System.out.println("Hello");
	}

	public void show() {
		System.out.println("Welcome");
	}

	public static void main(String args[]) {
		multipleInheritanceInterface obj = new multipleInheritanceInterface();
		obj.print();
		obj.show();
	}
}