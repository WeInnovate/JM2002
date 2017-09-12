package com.jm2002.learn.annotation.cust;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Preamble {
	String author() default "Dheeraj";
	String[] reviewers();
	double version();
}
