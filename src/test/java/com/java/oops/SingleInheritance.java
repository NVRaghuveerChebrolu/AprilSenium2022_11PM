package com.java.oops;

class Animal9875 {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog2765 extends Animal9875 {
	void bark() {
		System.out.println("barking...");
	}
	/*
	 * void eat() { System.out.println("eating in child class"); }
	 */
}

class SingleInheritance {
	public static void main(String args[]) {
		Dog2765 d = new Dog2765();
		d.bark();
		d.eat();
	}
}