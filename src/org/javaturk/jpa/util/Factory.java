package org.javaturk.jpa.util;

import java.util.Random;

import org.javaturk.jpa.ch02.Person;

public class Factory {

	private static Random random = new Random();
	
	private static String[] firstnames = { "Ali", "Ayse", "Bahar", "Cem", "Demet", "Eylem",
			"Faruk", "Fatma", "Ganime", "Haydar", "Halil", "Ismail", "Jale", "Kemal", "Leman",
			"Mustafa", "Nedim", "Nilufer", "Selim", "Selman", "Sevda", "Tarik", "Teoman", "Yeliz",
			"Zuhal" };
	private static String[] lastnames = { "Arabaci", "Aslan", "Batur", "Bulut", "Ceviz", "Karli",
			"Lale", "Ozturk", "Pasa", "Sari", "Serim", "Telli", "Torbaci", "Yazar", "Zafer" };
	
	private static String[] makes = { "Audi", "Benley", "Ferrari", "Honda", "Hyundai", "Jaguar", "Lexus", "Mercedes",
		"Nissan", "Oldsmobile", "Polymouth", "Porche", "Skoda", "Toyota"};
	
	private static String[] models = { "Active", "Bold", "Fast", "New", "Power"};
	
	private static String[] years = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011"};

	
	public static Person createPerson(){
		Person person = new Person();
		person.setFirstName(createFirstName());
		person.setLastName(createLastName());
		return person;
	}
	
	private static String createFirstName(){
		int randomInt = random.nextInt(25);
		return firstnames[randomInt];
	}
	
	private static String createLastName(){
		int randomInt = random.nextInt(15);
		return lastnames[randomInt];
	}
	
	private static String createYear() {
		int randomInt = random.nextInt(12);
		return years[randomInt];
	}

	private static String createMake(){
		int randomInt = random.nextInt(15);
		return makes[randomInt];
	}
	
	private static String createModel(){
		int randomInt = random.nextInt(5);
		return models[randomInt];
	}
	
	public static int createId() {
		return random.nextInt(1_000_000_000);
	}
}
