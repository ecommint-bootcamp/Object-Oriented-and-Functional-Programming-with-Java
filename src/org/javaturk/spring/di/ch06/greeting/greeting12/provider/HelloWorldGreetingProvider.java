package org.javaturk.spring.di.ch06.greeting.greeting12.provider;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldGreetingProvider implements GreetingProvider {

	public HelloWorldGreetingProvider() {
		System.out.println("in HelloWorldGreetingProvider()");
	}
	
	@Override
	public String getGreeting() {
		return "Hello World!";
	}
}
