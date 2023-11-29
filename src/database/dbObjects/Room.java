package database.dbObjects;

public class Room {
	Integer room_id;
	Integer room_number;
	String room_type;
	Integer room_fare;
	String room_is_using_yn;
	Integer room_floor;
	
	public Room() {
	}
	
	public Room(
			Integer room_id,
			Integer room_number,
			String room_type,
			Integer room_fare,
			String room_is_using_yn,
			Integer room_floor
			) {
		this.room_id = room_id;
		this.room_number = room_number;
		this.room_type = room_type;
		this.room_fare = room_fare;
		this.room_is_using_yn = room_is_using_yn;
		this.room_floor = room_floor;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Integer getRoom_number() {
		return room_number;
	}

	public void setRoom_number(Integer room_number) {
		this.room_number = room_number;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public Integer getRoom_fare() {
		return room_fare;
	}

	public void setRoom_fare(Integer room_fare) {
		this.room_fare = room_fare;
	}

	public String getRoom_is_using_yn() {
		return room_is_using_yn;
	}

	public void setRoom_is_using_yn(String room_is_using_yn) {
		this.room_is_using_yn = room_is_using_yn;
	}

	public Integer getRoom_floor() {
		return room_floor;
	}

	public void setRoom_floor(Integer room_floor) {
		this.room_floor = room_floor;
	}
	
	@Override
	public String toString() {
		return String.format("방번호 : %d/ 방종류 : %s/ 방요금 : %d \n", room_number,room_type,room_fare);
	}
}


