package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.dbObjects.Reservation;
import database.dbObjects.RoomImage;

public class RoomImageDao {
	
	public StringBuilder getRoomImageRute(int roomNum) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM room_image WHERE room_number = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, roomNum);
				StringBuilder imageRute = new StringBuilder();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						imageRute.append(rs.getString(3));
						imageRute.append(rs.getString(2));
					}
					return imageRute;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
