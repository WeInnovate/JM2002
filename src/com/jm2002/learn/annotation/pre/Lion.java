package com.jm2002.learn.annotation.pre;

public class Lion implements Animal {

	@Override
	public void eat() {
		System.out.println(this.getClass().getSimpleName() + " is eating.");
	}

	@Override
	public void walk() {
		System.out.println(this.getClass().getSimpleName() + " is walking.");
		
	}
}
