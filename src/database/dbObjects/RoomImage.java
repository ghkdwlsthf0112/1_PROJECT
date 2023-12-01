package database.dbObjects;

public class RoomImage {
	Integer room_image_id;
	String room_image_name;
	String room_image_route;
	Integer room_number;
	
	public RoomImage() {
	
	}
	
	public RoomImage(
			Integer room_image_id,
			String room_image_name,
			String room_image_route,
			Integer room_number) {
		this.room_image_id =room_image_id;
		this.room_image_name = room_image_name;
		this.room_image_route = room_image_route;
		this.room_number = room_number;
	}

	public Integer getRoom_image_id() {
		return room_image_id;
	}

	public void setRoom_image_id(Integer room_image_id) {
		this.room_image_id = room_image_id;
	}

	public String getRoom_image_name() {
		return room_image_name;
	}

	public void setRoom_image_name(String room_image_name) {
		this.room_image_name = room_image_name;
	}

	public String getRoom_image_route() {
		return room_image_route;
	}

	public void setRoom_image_route(String room_image_route) {
		this.room_image_route = room_image_route;
	}
	
	@Override
	public String toString() {
		return room_image_route+room_image_name;
	}
	
}
