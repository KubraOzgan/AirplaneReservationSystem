package airplane;

public class Passenger {
	
	private String name, surname, phone, email;
	
	public Passenger(String name, String surname, String phone, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}
	
	Seats seat;
	
	public Seats getSeat() {
		return this.seat;
	}
    
	public void setSeat(Seats seat) {
		this.seat = seat;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printPassenger() {
		System.out.println("Passenger name: " + this.getName() + " " + this.getSurname());
	}
	
	
}
