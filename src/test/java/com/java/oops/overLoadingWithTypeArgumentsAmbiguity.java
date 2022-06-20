package com.java.oops;

class overLoadingWithTypeArgumentsAmbiguity {
	void sum(int a, long b) {
		System.out.println("a method invoked");
		System.out.println(a+b);
	}

	
	  void sum(float a, int b) {
		  System.out.println("b method invoked"); 
		  }
	 
	void sum(char a, int b, long c) {
		System.out.println("b method invoked");
	}

	public static void main(String args[]) {
		overLoadingWithTypeArgumentsAmbiguity obj = new overLoadingWithTypeArgumentsAmbiguity();
	//	obj.sum(20, 20);// now ambiguity because int type is promoted to long which is used in both sum methods
	//	obj.sum(20, 20,30);
	}
}

//Note : One type is not de-promoted implicitly for example 
//double cannot be depromoted to any type implicitly.