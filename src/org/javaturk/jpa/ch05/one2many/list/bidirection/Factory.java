package org.javaturk.jpa.ch05.one2many.list.bidirection;

import java.util.Random;

public class Factory {

	private static Random random = new Random();
	
	private static String[] firstnames = { "Ali", "Ayse", "Bahar", "Cem", "Demet", "Eylem",
			"Faruk", "Fatma", "Ganime", "Haydar", "Halil", "Ismail", "Jale", "Kemal", "Leman",
			"Mustafa", "Nedim", "Nilufer", "Selim", "Selman", "Sevda", "Tarik", "Teoman", "Yeliz",
			"Zuhal" };
	private static String[] lastnames = { "Arabaci", "Aslan", "Batur", "Bulut", "Ceviz", "Karli",
			"Lale", "Ozturk", "Pasa", "Sari", "Serim", "Telli", "Torbaci", "Yazar", "Zafer" };
	
	private static String[] makes = { "Audi", "Benley", "Ferrari", "Honda", "Hyundai", "Jaguar", "Lexus", "Mercedes",
		"Nissan", "Oldsmobile", "Opel", "Polymouth", "Porche", "Skoda", "Toyota"};
	
	private static String[] models = { "Active", "Bold", "Fast", "New", "Power"};
	
	private static String[] years = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011"};

	
	public static Person createPersonWithCars(){
		Person person = new Person();
		person.setFirstName(createFirstName());
		person.setLastName(createLastName());
		int carNumber = random.nextInt(5);
		for(int i=0; i<carNumber; i++){
			person.addCar(createCar());
		}
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
	
	public static Car createCar(){
		Car car = new Car();
		car.setMake(createMake());
		car.setModel(createModel());
		car.setYear(createYear());
		return car;
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
}
