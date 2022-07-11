package com.javaExceptionHandling;

class ExceptionPropogationInCheckedException {
	void m() {
	//	throw new java.io.IOException("device error");// checked exception
	}

	void n() {
		m();
	}

	void p() {
		try {
			n();
		} catch (Exception e) {
			System.out.println("exception handeled");
		}
	}

	public static void main(String args[]) {
		ExceptionPropogationInCheckedException obj = new ExceptionPropogationInCheckedException();
		obj.p();
		System.out.println("normal flow");
	}
}

//Note: By default, Checked Exceptions are not forwarded in calling chain (propagated).