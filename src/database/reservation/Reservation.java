package database.reservation;

public class Reservation {
	Integer reservation_id;
	String reservation_number;
	String customer_email;
	Integer room_number;
	String reservation_start;
	String reservation_end;

	public Reservation(
			Integer reservation_id, 
			String reservation_number, 
			String customer_email, 
			Integer room_number,
			String reservation_start, 
			String reservation_end) {
		this.reservation_id = reservation_id;
		this.reservation_number = reservation_number;
		this.customer_email = customer_email;
		this.room_number = room_number;
		this.reservation_start = reservation_start;
		this.reservation_end = reservation_end;
	}

	public Integer getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Integer reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getReservation_number() {
		return reservation_number;
	}

	public void setReservation_number(String reservation_number) {
		this.reservation_number = reservation_number;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public Integer getRoom_number() {
		return room_number;
	}

	public void setRoom_number(Integer room_number) {
		this.room_number = room_number;
	}

	public String getReservation_start() {
		return reservation_start;
	}

	public void setReservation_start(String reservation_start) {
		this.reservation_start = reservation_start;
	}

	public String getReservation_end() {
		return reservation_end;
	}

	public void setReservation_end(String reservation_end) {
		this.reservation_end = reservation_end;
	}
	
	
}
