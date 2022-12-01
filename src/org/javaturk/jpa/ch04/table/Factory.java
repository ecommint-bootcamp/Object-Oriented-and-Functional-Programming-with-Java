package org.javaturk.jpa.ch04.table;

import java.math.BigDecimal;
import java.util.Random;

public class Factory {

	private static Random random = new Random();
	
	private static String[] firstnames = { "Ahmet", "Ali", "Ayse", "Bahar", "Belgin", "Cem", "Demet", "Emin", "Emine", "Etem", "Eylem",
			"Faruk", "Fatma", "Ganime", "Haydar", "Halil", "Ismail", "Jale", "Kemal", "Leman",
			"Mustafa", "Nedim", "Nilufer", "Selim", "Selman", "Sevda", "Tarik", "Teoman", "Yeliz",
			"Zeynep", "Zuhal" };
	private static String[] lastnames = { "Arabaci", "Aslan", "Aymaz", "Batur", "Boyaci", "Bulut", "Cavaci", "Ceviz", "Derin",
										  "Develi", "Esen", "Farli", "Hanci", "Karli",
			"Lale", "Ozturk", "Pasa", "Sari", "Serim", "Telli", "Torbaci", "Yazar", "Zafer" };
	
	private static String[] makes = { "Audi", "Benley", "Ferrari", "Honda", "Hyundai", "Jaguar", "Lexus", "Mercedes",
		"Nissan", "Oldsmobile", "Polymouth", "Porche", "Skoda", "Toyota"};
	
	private static String[] models = { "Active", "Bold", "Fast", "New", "Power"};
	
	private static String[] years = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011"};

	
	public static Person createPerson(){
		Person person = new Person();
		person.setId(createId());
		person.setFirstName(createFirstName());
		person.setLastName(createLastName());
		person.setRate(createRate());
		person.setSalary(createSalary());
		System.out.println(person);
		return person;
	}
	
	private static int createId(){
		return random.nextInt((int) Math.pow(2, 32));
	}
	
	private static String createFirstName(){
		int randomInt = random.nextInt(25);
		return firstnames[randomInt];
	}
	
	private static String createLastName(){
		int randomInt = random.nextInt(15);
		return lastnames[randomInt];
	}
	
	private static BigDecimal createRate() {
		double randomDouble = 10 * random.nextDouble();
		String string = new Double(randomDouble).toString();
		return new BigDecimal(string);
	}

	private static BigDecimal createSalary(){
		double randomDouble = 10000 * random.nextDouble();
		String string = new Double(randomDouble).toString();
		return new BigDecimal(string);
	}
}
