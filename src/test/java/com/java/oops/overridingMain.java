package com.java.oops;

class A985 {
	public static void main(String[] args) {
		System.out.println("This is the main method of the superclass");
	}
}

class B353 extends A985 {
	public static void main(String[] args) {
		System.out.println("This is the main method of the subclass");
	}
}

public class overridingMain {
	public static void main(String args[]) {
		overridingMain obj = new overridingMain();
	//	obj.main(args);
		A985.main(args);
		B353.main(args);
	}
}