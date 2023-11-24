package gui.layout.login.create_id_window;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MemberDao {

	public static boolean duplicateTF;

	public static boolean isDuplicateTF() {
		return duplicateTF;
	}

	public static void dupliTest(String emailDomain) {

		try (Connection conn = DBConnector.getConnection()) {
			conn.setAutoCommit(false);

			String countSQL = "SELECT COUNT(m_email) AS email_count FROM member WHERE m_email = ?";

			try (PreparedStatement countStatement = conn.prepareStatement(countSQL)) {
				countStatement.setString(1, emailDomain);

				ResultSet rs = countStatement.executeQuery();
				if (rs.next()) {
					int emailCount = rs.getInt("email_count");
					if (emailCount > 0) {
						System.out.println("현재 사용중인 이메일입니다.");
						duplicateTF = true;
					} else {
						System.out.println("사용 가능한 이메일입니다");
						duplicateTF = false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public static void addMember(String emailDomain, String pwd, String name, String phoneNum) {

		try (Connection conn = DBConnector.getConnection()) {
			conn.setAutoCommit(false);

			String countSQL = "SELECT COUNT(m_email) AS email_count FROM member WHERE m_email = ?";

			try (PreparedStatement countStatement = conn.prepareStatement(countSQL)) {
				countStatement.setString(1, emailDomain);

				ResultSet rs = countStatement.executeQuery();

				if (rs.next()) {
					int emailCount = rs.getInt("email_count");
					if (emailCount > 0) {
						System.out.println("중복되는 이메일입니다");
					} else if (emailCount == 0 && emailDomain != null && pwd != null && name != null
							&& phoneNum != null) {
						System.out.println("회원가입이 완료됐습니다.");
						JOptionPane.showMessageDialog(null, "회원가입이 완료 됐습니다.");
						
						String insertSQL = "INSERT INTO member (" + "m_no, m_email, m_pwd, m_name, m_phonenum) "
								+ "VALUES (m_no_seq.nextval, ?, ?, ?, ?)";

						try (PreparedStatement insertStatement = conn.prepareStatement(insertSQL)) {
							insertStatement.setString(1, emailDomain);
							insertStatement.setString(2, pwd);
							insertStatement.setString(3, name);
							insertStatement.setString(4, phoneNum);

							insertStatement.executeUpdate();
						}
						conn.commit();
					} else {
						System.out.println("정보를 모두 입력해주세요.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
