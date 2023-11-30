package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;

//DAO (Database Access Object) - DB에 쿼리문 보내고 결과 반영하는 객체
public class ReservationDao {
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

	/**
	 * DB에서 해당 예약번호에 대한 정보를 하나만 받고 싶을때
	 * 
	 * 
	 * @param reservation_number = 예약번호 뒤 6자리
	 * @return DB에서 검색후 예약번호에 맞는 Reservation 객체를 return
	 */
	public Reservation getReservstion(String reservation_number) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM reservation WHERE reservation_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + reservation_number);
				Reservation reservation = new Reservation();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						reservation.setReservation_id(rs.getInt(1));
						reservation.setReservation_number(rs.getString(2));
						reservation.setCustomer_email(rs.getString(3));
						reservation.setRoom_number(rs.getInt(4));
						reservation.setReservation_start(rs.getString(5));
						reservation.setReservation_end(rs.getString(6));
					}
					return reservation;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Reservation> getReservstions(String reservation_number) {
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

	/**
	 * DB에서 해당 예약번호의 예약을 찾아 삭제(체크아웃) 시켜주는 메서드
	 * 
	 * @param reservation_number == 예약번호
	 * @return DB reservation delete
	 */
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
	
	/**
	 * DB에서 해당 예약번호의 예약을 찾아 삭제(체크아웃) 시켜주는 메서드
	 * 
	 * @param reservation_number == 예약번호
	 * @return DB reservation delete
	 */
	public int adminCompulsionChkOut(String reservation_number) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "DELETE FROM reservation WHERE reservation_number = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, reservation_number);
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	// 예약정보를 가져와 확인후 그 방을 체크아웃 시켜주는 메서드

	// 아이디 중복검사를 해주는 메서드

	/**
	 * DB에 있는 고객정보를 확인해서 Customer객체로 리턴해주는 메서드
	 * 
	 * @param email    = 고객 로그인 아이디(이메일)
	 * @param password = 고객 비밀번호
	 * @return Customer
	 */
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

	/**
	 * DB에 있는 예약정보들을 관리자창에 보여주기위해서 Object화 해서 리스트에 담아 리턴
	 * 
	 * @return new Object[]{n,e,r,s,end,isPass} => List로
	 */
	public List<Object[]> getReservationsObject() {
		String sql = "SELECT * FROM reservation ORDER BY reservation_end";
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<Object[]> list = new ArrayList<>();
			while (rs.next()) {
				String n = rs.getString(2);
				String e = rs.getString(3);
				int r = rs.getInt(4);
				String s = rs.getString(5);
				String end = rs.getString(6);

				Date date = new Date(dateFormat.parse(end).getTime());
				Date today = new Date(dateFormat.parse(todayfm).getTime());
				int compare = date.compareTo(today);
				String isPass;
				if (compare > 0) {
					isPass = "N";
				} else if (compare < 0) {
					isPass = "Y";
				} else {
					isPass = "C";
				}
				Object[] o = new Object[] { n, e, r, s, end, isPass };
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

	// 체크인 가능한 방 조회하는 메서드?
	public List<Room> getAvailableCheckInRoom(String checkInDate, String checkOutDate) {
		// 사용중이지 않은 방 쿼리문

		// 사용중이 아닌 방을 선택하고 Reservation 테이블에 있는 예약된 방을 제외함
		String sql = "SELECT * FROM Room WHERE room_is_using_yn = 'N' AND room_id NOT IN "
				+ "(SELECT room_id FROM Reservation " + "WHERE (reservation_start <= ? AND reservation_end >= ?) OR "
				+ "(reservation_start <= ? AND reservation_end >= ?) OR "
				+ "(reservation_start >= ? AND reservation_end <= ?))";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, checkInDate);
			pstmt.setString(2, checkInDate);
			pstmt.setString(3, checkOutDate);
			pstmt.setString(4, checkOutDate);
			pstmt.setString(5, checkInDate);
			pstmt.setString(6, checkOutDate);

			List<Room> availableRooms = new ArrayList<>();

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					availableRooms
							.add(new Room(rs.getInt("room_id"), rs.getInt("room_number"), rs.getString("room_type"),
									rs.getInt("room_fare"), rs.getString("room_is_using_yn"), rs.getInt("room_floor")));
				}
				return availableRooms;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * DB에 해당 방번호를 입력하면 그 방에대한 정보를 Room 객체에 담아 리턴해주는 매서드
	 * 
	 * @param room_number = 방번호
	 * @return Room
	 */
	public Room getRoom(String room_number) {
		try (Connection conn = DBConnection.getConnection();) {
			String sql = "SELECT * FROM room WHERE room_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, room_number + "%");
				Room room = new Room();
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next() == true) {
						room.setRoom_id(rs.getInt(1));
						room.setRoom_number(rs.getInt(2));
						room.setRoom_type(rs.getString(3));
						room.setRoom_fare(rs.getInt(4));
						room.setRoom_is_using_yn(rs.getString(5));
						room.setRoom_floor(rs.getInt(6));
					}
					return room;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param reservation_number
	 * @return 업데이트하면 1 아니면 -1
	 */
	public int updateChkOutRoom(String roomNum) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "UPDATE Room SET room_is_using_yn = 'N' WHERE room_number = ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, roomNum);
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * 예약시 DB에 저장하기 위한 메서드
	 * 
	 * @param reservation
	 * @return
	 */
	public int updateReservation(Reservation reservation) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql1 = "INSERT INTO reservation VALUES (reservation_id_seq.nextval,?,?,?,?,?)";
			try (PreparedStatement pstmt = conn.prepareStatement(sql1)) {
				pstmt.setString(1, reservation.getReservation_number());
				pstmt.setString(2, reservation.getCustomer_email());
				pstmt.setInt(3, reservation.getRoom_number());
				pstmt.setString(4, reservation.getReservation_start());
				pstmt.setString(5, reservation.getReservation_end());
				return pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			return -1;
		}

	}

	/**
	 * 체크인 시작 날짜에만 체크인 가능하게
	 * 
	 * @param reservation_number - 예약번호
	 * @return String 체크인 시작 날짜
	 */
	public String getChkInStartDate(String reservation_number) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "SELECT reservation_start FROM reservation WHERE reservation_number LIKE ?";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, "%" + reservation_number);
				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						return rs.getString("reservation_start");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * date가 startDate와 EndDate 사이에 있는지 반환
	 * 
	 * @param date      yyyymmdd
	 * @param startDate yyyymmdd
	 * @param endDate   yyyymmdd
	 * @return
	 */
	public static boolean isWithinRange(String date, String startDate, String endDate) throws ParseException {
		if (date.length() != 10 || startDate.length() != 10 || endDate.length() != 10) {
			return false;
		}

		LocalDate localdate = LocalDate.parse(date);
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		endLocalDate = endLocalDate.plusDays(1); // endDate는 포함하지 않으므로 +1일을 해줘야함.

		return (!localdate.isBefore(startLocalDate)) && (localdate.isBefore(endLocalDate));
	}

	/**
	 * 예약내용에서 저장되어 있는 방 정보 불러오기
	 * 
	 * @return
	 */
	public static List<Room> getReservationRoom(String start, String end) {
		String sql = "SELECT * FROM reservation INNER JOIN room USING (room_number)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			List<Room> rooms = new ArrayList<>();
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next() == true) {
					// 예약되어 있는 기간 받아오고
					String resStart = rs.getString("reservation_start");
					String resEnd = rs.getString("reservation_end");
					// 그 예약내용 방 객체 만들고
					Room room = new Room(rs.getInt("Room_id"), rs.getInt("Room_number"), rs.getString("Room_type"),
							rs.getInt("Room_fare"), rs.getString("Room_is_using_yn"), rs.getInt("Room_floor"));
					// 선택 날짜에 사용가능한지 확인 후 가능하면 rooms list에 저장
					if (isWithinRange(start, resStart, resEnd) == true
							|| isWithinRange(end, resStart, resEnd) == true) {
						rooms.add(room);
					}

				}

				return rooms;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
