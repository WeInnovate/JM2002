package com.jm2002.learn.annotation.pre;

public class TvsBike {
	
	@Deprecated
	public void startUsingKick(){
		System.out.println("TvsBike is started using Kick");
	}
	
	public void move(){
		System.out.println("TvsBike is moving.");
	}
	
	public void stop(){
		System.out.println("TvsBike is stopped.");
	}
	
	public void startUsingSelf(){
		System.out.println("TvsBike is started using Self");
	}
}
