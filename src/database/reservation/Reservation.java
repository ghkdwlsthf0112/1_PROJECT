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
}
