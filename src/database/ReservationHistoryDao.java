package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import database.dbObjects.Reservation;
import database.dbObjects.Reservation_history;

public class ReservationHistoryDao {
	  // 예약 취소 시 히스토리 테이블 컬럼 R or C 로 update
	   public int updateRorC(String reservation_number) {
	      try (Connection conn = DBConnection.getConnection()) {
	         String sql = "UPDATE Reservation_history SET R_or_C = 'C' WHERE reservation_number = ?";
	         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, reservation_number);
	            return pstmt.executeUpdate();
	         }
	      } catch (SQLException e) {
	         return -1;
	      }
	   }
	   
	   //히스토리 리스트
	   public List<Reservation_history> getReservstions(String reservation_number) {
	      try (Connection conn = DBConnection.getConnection();) {
	         String sql = "SELECT * FROM reservation_history ";
	         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            //pstmt.setString(1, "%" + reservation_number);
	            List<Reservation_history> list = new ArrayList<>();
	            try (ResultSet rs = pstmt.executeQuery()) {
	               while (rs.next() == true) {
	                  list.add(new Reservation_history(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
	                        rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
	               }
	               return list;
	            }
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return null;
	      }
	   }
	   
	   /**
	    * 예약시 예약내용 히스토리로 저장하는 메서드
	    * @param reservation
	    * @return
	    */
	   public int updateReservationHistory(Reservation reservation) {
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			try (Connection conn = DBConnection.getConnection()) {
				String sql1 = "INSERT INTO Reservation_history VALUES (reservation_history_seq.nextval,?,?,?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
					pstmt.setString(1, reservation.getReservation_number());
					pstmt.setString(2, reservation.getCustomer_email());
					pstmt.setInt(3, reservation.getRoom_number());
					pstmt.setString(4, reservation.getReservation_start());
					pstmt.setString(5, reservation.getReservation_end());
					pstmt.setString(6, newDtFormat.parse(LocalDateTime.now().toString()).toString());
					pstmt.setString(7, "R");
					
					return pstmt.executeUpdate();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		
		}
	   
	   /**
	    * 예약시 예약내용 히스토리로 저장하는 메서드
	    * @param reservation
	    * @return
	    */
	   public int updateCencelReservationHistory(Reservation reservation) {
			SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
			try (Connection conn = DBConnection.getConnection()) {
				String sql1 = "INSERT INTO Reservation_history VALUES (reservation_history_seq.nextval,?,?,?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
					pstmt.setString(1, reservation.getReservation_number());
					pstmt.setString(2, reservation.getCustomer_email());
					pstmt.setInt(3, reservation.getRoom_number());
					pstmt.setString(4, reservation.getReservation_start());
					pstmt.setString(5, reservation.getReservation_end());
					pstmt.setString(6, newDtFormat.parse(LocalDateTime.now().toString()).toString());
					pstmt.setString(7, "C");
					
					return pstmt.executeUpdate();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		
		}

}
