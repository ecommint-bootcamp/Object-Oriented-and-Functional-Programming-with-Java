package org.javaturk.spring.di.ch06.greeting.greeting14.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.javaturk.spring.di.ch06.greeting.greeting14.custom.*;

@Component
@Primary
//@Qualifier("selam")
//@Selam
public class SelamGreetingProvider implements GreetingProvider{

	@Override
	public String getGreeting() {
		return "Selam :)";
	}
}
