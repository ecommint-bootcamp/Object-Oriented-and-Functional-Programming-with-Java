package org.javaturk.jpa.ch08.oql.simple;

import java.math.BigDecimal;
import java.util.Random;

public class Factory {

	private static Random random = new Random();
	
	private static String[] firstnames = { "Ahmet", "Ali", "Aslan", "Ayse", "Aysun", "Bahar", "Belgin", "Cem", "Demet", "Emin", "Emine", "Etem", "Eylem",
			"Faruk", "Fatma", "Ganime", "Haydar", "Halil", "Ismail", "Jale", "Kemal", "Leman",
			"Mustafa", "Nedim", "Nilufer", "Selim", "Selman", "Sevda", "Tarik", "Teoman", "Yeliz",
			"Zeynep", "Zuhal" };
	private static String[] lastnames = { "Arabaci", "Aslan", "Aymaz", "Ayna", "Batur", "Boyaci", "Bulut", "Cavaci", "Ceviz", "Derin",
										  "Develi", "Esen", "Farli", "Hanci", "Karli",
			"Lale", "Ozturk", "Pasa", "Sari", "Serim", "Telli", "Torbaci", "Yasar", "Yazar", "Zafer" };
	
	public static Person createPerson(){
		Person person = new Person();
		person.setId(createId());
		person.setFirstName(createFirstName());
		person.setLastName(createLastName());
		person.setRate(createRate());
		person.setSalary(createSalary());
//		System.out.println(person);
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

	private static long createSalary(){
		int randomInt = random.nextInt(10000);
		return randomInt;
	}
}
