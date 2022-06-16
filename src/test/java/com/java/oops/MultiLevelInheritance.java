package com.java.oops;

class Animal {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog extends Animal {
	void bark() {
		System.out.println("barking...");
	}
}

class cat extends Dog {
	void meow() {
		System.out.println("meowing...");
	}
}

public class MultiLevelInheritance extends cat {
	void weep() {
		System.out.println("weeping...");
	}

	public static void main(String args[]) {
		//using child class object we can access parent class methods
		MultiLevelInheritance d = new MultiLevelInheritance();
		d.weep();
		d.meow();
		d.bark();
		d.eat();
	}
}

