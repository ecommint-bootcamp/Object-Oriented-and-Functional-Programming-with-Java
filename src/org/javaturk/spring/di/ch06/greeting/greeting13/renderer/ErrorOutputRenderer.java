package org.javaturk.spring.di.ch06.greeting.greeting13.renderer;

import org.javaturk.spring.di.ch06.greeting.greeting13.provider.GreetingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ErrorOutputRenderer implements GreetingRenderer {

	@Autowired
	private GreetingProvider helloWorldGreetingProvider;

	@Override
	public void render() {
		System.err.println(helloWorldGreetingProvider.getGreeting());
	}
}
