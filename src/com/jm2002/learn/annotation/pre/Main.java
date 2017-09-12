package com.jm2002.learn.annotation.pre;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Lion lion = new Lion();
		lion.eat();
		
		TvsBike tvsBike = new TvsBike();
		tvsBike.startUsingKick();
//		tvsBike.startUsingSelf();
		tvsBike.move();
		tvsBike.stop();
	}
}
