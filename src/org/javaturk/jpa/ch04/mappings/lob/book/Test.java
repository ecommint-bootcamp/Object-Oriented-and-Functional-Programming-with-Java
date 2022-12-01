package org.javaturk.jpa.ch04.mappings.lob.book;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.javaturk.jpa.util.PersistenceUtil;

public class Test {
	private BookDisplayer displayer = new BookDisplayer();
	
	public Test() {
		PersistenceUtil.setPersistenceUnitName("lob");
	}

	public static void main(String[] args) {
		Test test = new Test();
//		test.createBooks();
		test.retrieveBook("978-0132761697");
//		test.retrieveBook("978-0071809252");
	}

	public void createBooks() {
		System.out.println("Creating a books.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Book book1 = new Book("978-0132761697", "The Java Tutorial: A Short Course on the Basics", "Raymond Gallardo",
				"Addison-Wesley Professional", new Date(), 200, new Timestamp(new Date().getTime()));
		book1.setDescription(
				"The Java® Tutorial, Fifth Edition, is based on Release 7 of the Java Platform Standard Edition. This revised and updated edition introduces the new features added to the platform, including a section on NIO.2, the new file I/O API, and information on migrating legacy code to the new API. The deployment coverage has also been expanded, with new chapters such as “Doing More with Rich Internet Applications” and “Deployment in Depth,” and a section on the fork/join feature has been added to the chapter on concurrency. Information reflecting Project Coin developments, including the new try-with-resources statement, the ability to catch more than one type of exception with a single exception handler, support for binary literals, and diamond syntax, which results in cleaner generics code, has been added where appropriate. The chapters covering generics, Java Web Start, and applets have also been updated. In addition, if you plan to take one of the Java SE 7 certification exams, this guide can help. A special appendix, \n“Preparing for Java Programming Language Certification,” lists the three exams available, details the items covered on each exam, and provides cross-references to where more information about each topic appears \nin the text. All of the material has been thoroughly reviewed by members of Oracle Java engineering to ensure that the information is accurate and up to date.");

		addPicture(book1, "/Users/akin/Java/Eclipse/Photon EE/workspace/JPA WS/JPA Training/src/resources/image/The Java Tutorial.png");
		em.persist(book1);
		
		Book book2 = new Book("978-0071809252", "Java: A Beginner's Guide", "Herbert Schildt",
				"Mcgraw-Hill Osborne Media", new Date(), 200, new Timestamp(new Date().getTime()));
		book2.setDescription("Essential Java Programming Skills--Made Easy!\n" + 
				"Fully updated for Java Platform, Standard Edition 8 (Java SE 8), Java: A Beginners Guide, Sixth Edition gets you started programming in Java right away. Bestselling programming author Herb Schildt begins with the basics, such as how to create, compile, and run a Java program. He then moves on to the keywords, syntax, and constructs that form the core of the Java language. This Oracle Press resource also covers some of Javas more advanced features, including multithreaded programming, generics, and Swing. Of course, new Java SE 8 features such as lambda expressions and default interface methods are described. An introduction to JavaFX, Javas newest GUI, concludes this step-by-step tutorial.\n" + 
				"\n" + 
				"Designed for Easy Learning:\n" + 
				"\n" + 
				"Key Skills & Concepts -- Chapter-opening lists of specific skills covered in the chapter\n" + 
				"Ask the Expert -- Q&A sections filled with bonus information and helpful tips\n" + 
				"Try This -- Hands-on exercises that show you how to apply your skills\n" + 
				"Self Tests -- End-of-chapter quizzes to reinforce your skills\n" + 
				"Annotated Syntax -- Example code with commentary that describes the programming techniques being illustrated\n" + 
				"The books code examples are available FREE for download.");
		addPicture(book2, "/Users/akin/Java/Eclipse/Photon EE/workspace/JPA WS/JPA Training/src/resources/image/Java A Beginner's Guide.png");
		em.persist(book2);
		
		tx.commit();
		em.close();
	}

	public void retrieveBook(String isbn) {
		System.out.println("Creating a books.");
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		Book book = em.find(Book.class, isbn);
		displayer.displayBook(book);
		em.close();
	}
	
	
	private void addPicture(Book book, String imagePath) {
		BufferedImage bufferimage;
		try {
			bufferimage = ImageIO.read(new File(imagePath));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(bufferimage, "jpg", output);
			byte[] coverPicture = output.toByteArray();
			book.setCoverPicture(coverPicture);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
