package com.test;

import java.util.Scanner;

interface Info {
	public void showInfo();

}

class Author implements Info {
	String authorName;
	int age;
	String place;

	public Author(String name, int age, String place) {
		this.authorName = name;
		this.age = age;
		this.place = place;

	}

	@Override
	public void showInfo() {

		System.out.println("Author name is :" + authorName);
		System.out.println("Author age: " + age);
		System.out.println("place: " + place);

	}
}

class Book implements Info {
	String name;
	int price;
	String auth;

	public Book(String n, int p, String at) {

		this.name = n;
		this.price = p;
		this.auth = at;

	}

	@Override
	public void showInfo() {

		System.out.println("Book is: " + name);
		System.out.println("price: $" + price);
		System.out.println("Author is: " + auth);

	}
}

public class TestJava extends Book {

	public TestJava(String n, int p, String at) {
		super(n, p, at);

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		Author ath = new Author("Herbert Schildt", 64, "Chicago");
		Book b = new TestJava("Advanced Java Concepts", 250, "Herbert Schildt");
		Info info1 = new TestJava("MySql-Solutions for Database", 200, "Anderw");
		Info info2 = new Author(" Andrew ", 55, "California");

		boolean check = false;
		try {
			do {
				System.out.println("Hello");
				System.out.println("Enter 1 to view Info of Java Book.");
				System.out.println("Enter 2 to view Info of Java Book Author");
				System.out.println("Enter 3 to view Info of MySql book");
				System.out.println("Enter 4 to view Info of MySql book Author.");
				int i = sc.nextInt();
				switch (i) {
				case 1:
					b.showInfo();

					break;
				case 2:
					ath.showInfo();

					break;
				case 3:
					info1.showInfo();

					break;

				case 4:
					info2.showInfo();

					break;

				default:
					System.out.println("Input is invalid ");
					break;

				}
				System.out.println("enter 1 if you want to contniue");
				check = (sc.nextInt() == 1) ? false : true;
			} while (!check);
			sc.close();
		} catch (Exception e) {
			System.out.println("Type mismatch exception");
			e.printStackTrace();
		}
	}
}

/*OUTPUT
 * Hello
Enter 1 to view Info of Java Book.
Enter 2 to view Info of Java Book Author
Enter 3 to view Info of MySql book
Enter 4 to view Info of MySql book Author.
1
Book is: Advanced Java Concepts
price: $250
Author is: Herbert Schildt
enter 1 if you want to contniue
1
Hello
Enter 1 to view Info of Java Book.
Enter 2 to view Info of Java Book Author
Enter 3 to view Info of MySql book
Enter 4 to view Info of MySql book Author.
2
Author name is :Herbert Schildt
Author age: 64
place: Chicago
enter 1 if you want to contniue
1
Hello
Enter 1 to view Info of Java Book.
Enter 2 to view Info of Java Book Author
Enter 3 to view Info of MySql book
Enter 4 to view Info of MySql book Author.
3
Book is: MySql-Solutions for Database
price: $200
Author is: Anderw
enter 1 if you want to contniue

1
Hello
Enter 1 to view Info of Java Book.
Enter 2 to view Info of Java Book Author
Enter 3 to view Info of MySql book
Enter 4 to view Info of MySql book Author.
4
Author name is : Andrew 
Author age: 55
place: California
enter 1 if you want to contniue
mmdjff
Type mismatch exception
java.util.InputMismatchException
	at java.util.Scanner.throwFor(Scanner.java:864)
	at java.util.Scanner.next(Scanner.java:1485)
	at java.util.Scanner.nextInt(Scanner.java:2117)
	at java.util.Scanner.nextInt(Scanner.java:2076)
	at com.test.Test.main(Test.java:104)

 */
