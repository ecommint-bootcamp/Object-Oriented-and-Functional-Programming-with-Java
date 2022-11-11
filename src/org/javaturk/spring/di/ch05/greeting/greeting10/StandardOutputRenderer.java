package org.javaturk.spring.di.ch05.greeting.greeting10;

public class StandardOutputRenderer implements GreetingRenderer {

	private GreetingProvider greetingProvider = null;
	
	public void setartibisi(GreetingProvider greetingProvider) {
		System.err.println("==> in setGreetingProvider()");
		this.greetingProvider = greetingProvider;
	}

//	public void asetttttt(GreetingProvider greetingProvider) {
//		System.err.println("==> in setAProvider()");
//		this.greetingProvider = greetingProvider;
//	}
	
	public void render() {
		System.out.println(greetingProvider.getGreeting());
	}
}
