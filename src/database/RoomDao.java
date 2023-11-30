package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.dbObjects.Room;

public class RoomDao {
	/**
	 * 예약내용에서 저장되어 있는 방 정보 불러오기
	 * 
	 * @return
	 */
	public static Map<Integer, Room> getRooms() {
		String sql = "SELECT * FROM reservation INNER JOIN room USING (room_number)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			Map<Integer, Room> rooms = new HashMap<>();
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next() == true) {
					int roomNum = rs.getInt("Room_number");
					Room room = new Room(
							rs.getInt("Room_id"), 
							roomNum, rs.getString("Room_type"),
							rs.getInt("Room_fare"), 
							rs.getString("Room_is_using_yn"), 
							rs.getInt("Room_floor"));
					
					rooms.put(roomNum, room);
				}
				return rooms;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 예약내용에서 저장되어 있는 방 정보 불러오기
	 * 
	 * @return
	 */
	public static Map<Integer, Room> getRoomsMap() {
		String sql = "SELECT * FROM room";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			Map<Integer, Room> rooms = new HashMap<>();
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next() == true) {
					int roomNum = rs.getInt("Room_number");
					Room room = new Room(
							rs.getInt("Room_id"), 
							roomNum, rs.getString("Room_type"),
							rs.getInt("Room_fare"), 
							rs.getString("Room_is_using_yn"), 
							rs.getInt("Room_floor"));
					
					rooms.put(roomNum, room);
				}
				return rooms;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 예약내용에서 저장되어 있는 방 정보 불러오기
	 * 
	 * @return
	 */
	public static List<Room> getRoomsList() {
		String sql = "SELECT * FROM room";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			List<Room> rooms = new ArrayList();
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next() == true) {
					Room room = new Room(
							rs.getInt("Room_id"), 
							rs.getInt("Room_number"), 
							rs.getString("Room_type"),
							rs.getInt("Room_fare"), 
							rs.getString("Room_is_using_yn"), 
							rs.getInt("Room_floor"));
					
					rooms.add(room);
				}
				return rooms;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
