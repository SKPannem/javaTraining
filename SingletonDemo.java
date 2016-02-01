package com.test;

import java.util.Scanner;

public class SingletonDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Movie Tickets booking. There are only 10 seats avaialble.");
		System.out.println("Enter 1 to book a ticket.");
		System.out.println("Enter 2 to cancel a ticket.");
		System.out.println("Enter 3 to exit.");
		while (true) {

			int k = sc.nextInt();

			MovieTickets instance = MovieTickets.getInstance();

			if (k == 1) {
				if (instance.getSeats() > 0) {
					instance.bookSeat();
					System.out.println("Your Ticket has booked.");
				}
			} else if (k == 2) {
				if (instance.getSeats() < 10) {
					instance.cancelSeat();
					System.out.println("Your Ticket has cancelled.");
				}
			} else
				System.exit(1);
			System.out.println("Seats Available:" + instance.getSeats());
		}

	}
}

class MovieTickets {
	public static MovieTickets instance = null;
	private int seats = 0;

	private MovieTickets() {
		seats = 10;
	}

	public static MovieTickets getInstance() {
		if (instance == null) {
			instance = new MovieTickets();
		}
		return instance;
	}

	public int getSeats() {
		return seats;
	}

	public void bookSeat() {
		seats--;
	}

	public void cancelSeat() {
		seats++;
	}
}
