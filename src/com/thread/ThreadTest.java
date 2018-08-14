package com.thread;

public class ThreadTest {

	public static void main(String[] args) {
		String s1 = new String("132");
		String s2 = new String("132");
		System.out.println(s1.intern()==s2.intern());
		String s3 = "132";
		String s4 = "132";
		System.out.println(s4 == s1.intern());
}
}
