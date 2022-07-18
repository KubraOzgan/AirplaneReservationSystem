package airplane;

import java.util.Scanner;

public class Booking {
	
	Scanner sc = new Scanner(System.in);

	EconomyClass economy = new EconomyClass();
	BusinessClass business = new BusinessClass();
	
	int row, col, count = 0;
	char seat;
	
	public Passenger passengerInfo() {

		String name = sc.next();
		String surname = sc.next();
		String phone = sc.next();
		String email = sc.next();
	
		Passenger passenger = new Passenger(name, surname, phone, email);
		return passenger;
	}
	
	public void takeInput(Seats classType) {
		row = sc.nextInt();
		seat = sc.next().charAt(0);
		col = classType.findSeatNum(row-1, seat);
	}
	
	public void select(Passenger passenger, Seats classType) {
		classType.selectSeat(row, seat);
		Seats selected = new Seats(row, seat);
		passenger.setSeat(selected);
		passenger.printPassenger();
		passenger.getSeat().printSeatInfo();
	}
	
	public void reservation() {
		System.out.println("How many tickets do you want to buy?");
		int ticket = sc.nextInt();
		
		while(count != ticket) {
			System.out.println("It's time for your reservation. Please enter your: \n"
					+ "name, surname, phone number, email");
			
			
			Passenger passenger = passengerInfo();
			
			System.out.println("Please select your ticket type:\n");
			System.out.println("1 - Economy Class \n");
			System.out.println("2 - Business Class \n");
			System.out.println("3 - Exit");
			
			int choose = sc.nextInt();
			switch(choose) {
			
				case 1:
					economy.printSeats();
					System.out.println("\nPlease enter row and seat:");
					takeInput(economy);
					
					if(economy.getSeats(row, col) == 'X') {
						System.out.println("This seat is already taken! Please enter row and seat again:");
						takeInput(economy);
						select(passenger, economy);
					}
					else {
						select(passenger, economy);
					}
					count++;
					break;
				case 2:
					business.printSeats();
					System.out.println("Please enter row and seat:");
					takeInput(business);
					
					if(business.getSeats(row, col) == 'X') {
						System.out.println("This seat is already taken! Please enter row and seat again:");
						takeInput(business);
						select(passenger, business);
					}
					else {
						select(passenger, business);
					}
					count++;
					break;
				case 3:
					return;
				default:
					System.out.println("Please enter a valid value!");
					continue;
			}
		}
	}

}
