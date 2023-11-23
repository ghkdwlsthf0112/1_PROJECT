package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.dbObjects.Customer;
import database.dbObjects.Reservation;

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
	public int setReservationChkOut(String reservation_number) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "DELETE FROM reservation WHERE reservation_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + reservation_number);
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	// 예약정보를 가져와 확인후 그 방을 체크아웃 시켜주는 메서드
	// 아이디 중복검사를 해주는 메서드
	// 아이디 확인 후 비밀번호가 맞는지 확인해주는 메서드
	public Customer getCustomer(String email, String password) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM customer WHERE customer_email LIKE ? AND customer_password LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				Customer customer = new Customer();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						customer.setCustomer_id(rs.getInt(1));
						customer.setCustomer_email(rs.getString(2));
						customer.setCustomer_password(rs.getString(3)); 
						customer.setCustomer_phone_number(rs.getString(4)); 
						customer.setCustomer_name(rs.getString(5));
						customer.setCustomer_yn(rs.getString(6));
					}
					return customer;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
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
	// 예약내용에서 테이블명을 가져오는 메서드
	public List<Object[]> getColumnNames() {
		String sql = "SELECT * FROM reservation ORDER BY reservation_end";
	    String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try(
			Connection conn = DBConnection.getConnection();		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			List<Object[]> list = new ArrayList<>();
			while(rs.next())  {
				String n = rs.getString(2);
				String e = rs.getString(3); 
				int r = rs.getInt(4);
				String s = rs.getString(5); 
				String end =rs.getString(6);
				
				Date date = new Date(dateFormat.parse(end).getTime()); 
				Date today = new Date(dateFormat.parse(todayfm).getTime());
				int compare = date.compareTo(today); 
				String isPass;
				if(compare > 0) {
					isPass = "N";
				}else if(compare < 0) {
					isPass = "Y";
				}else {
					isPass = "C";
				}
				Object[] o = new Object[]{n,e,r,s,end,isPass};
				list.add(o);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
