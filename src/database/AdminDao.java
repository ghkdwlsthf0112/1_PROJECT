package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.reservation.Reservation;

//DAO (Database Access Object) - DB에 쿼리문 보내고 결과 반영하는 객체
public class AdminDao {
	// 예약번호로 정보를 가져와 확인하는 메서드 예약이 있으면 1 없으면 -1
	public int chkReservation(String reservation_number) {
		int re = -1;
		try (Connection conn = DBConnection.getConnection();) {

			String sql = "SELECT * FROM reservation WHERE reservation_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + reservation_number);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next() == true) {
						re = 1;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Reservation> getReservstion(String reservation_number) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM reservation WHERE reservation_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + reservation_number);
				List<Reservation> list = new ArrayList<>();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						list.add(new Reservation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
								rs.getString(5), rs.getString(6)));
					}
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	// 예약정보를 가져와 확인후 그 방의 체크인 상태를 바꿔주는 메서드

	// 예약정보를 가져와 확인후 그 방을 체크아웃 시켜주는 메서드
	// 아이디 중복검사를 해주는 메서드
	// 아이디 확인 후 비밀번호가 맞는지 확인해주는 메서드
	// 체크인이 되어 있는 방을 골라주는 메서드
	public List<Reservation> getReservstion() {
		// DB에서 커밋을 하지 않으면 나오지 않는다
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM reservation";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				List<Reservation> list = new ArrayList<>();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						list.add(new Reservation(
								rs.getInt(1), 
								rs.getString(2),
								rs.getString(3), 
								rs.getInt(4),
								rs.getString(5), 
								rs.getString(6)));
					}
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//
}
