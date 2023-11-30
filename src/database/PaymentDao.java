package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

import database.dbObjects.Payment;

public class PaymentDao {
	 /**
	    * 예약시 결제내용을 DB에 저장하는 메서드
	    * @param reservation
	    * @return
	    */
	   public int InsertPayment(Payment payment) {
			try (Connection conn = DBConnection.getConnection()) {
				String sql1 = "INSERT INTO Payment VALUES (pay_id_seq.nextval,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
					pstmt.setString(1, payment.getReservation_number());
					pstmt.setDouble(2, payment.getDiscount_pct());
					pstmt.setInt(3, payment.getPay_total());
		
					return pstmt.executeUpdate();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		
		}
}
