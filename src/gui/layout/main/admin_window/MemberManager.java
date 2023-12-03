package gui.layout.main.admin_window;

import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DBConnection;

public class MemberManager {
	public static final Object Checkbox = null;
	private static Connection conn;
	private static JTable table;
	private static DefaultTableModel guiTableModel;

	static class Member {
		String name;
		String email;
		String phoneNumber;
		String reservation;
		private static List<Member> members = new ArrayList<>();
		private static String[][] tableData = new String[0][];

		public Member(String name, String email, String phoneNumber, String reservation) {
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.reservation = reservation;
		}

		public static void addMember(String name, String email, String phoneNumber, String reservation) {
			members.add(new Member(name, email, phoneNumber, reservation));
		}

		public static List<Member> searchMembers(String searchTerm, boolean emailChecked, boolean nameChecked) {
			List<Member> searchResults = new ArrayList<>();

			for (Member member : members) {
				if ((emailChecked && member.email.equalsIgnoreCase(searchTerm))
						|| (nameChecked && member.name.equalsIgnoreCase(searchTerm))) {
					searchResults.add(member);
				}
			}

			return searchResults;
		}

		public static boolean deleteMember(String searchTerm, boolean emailChecked, boolean nameChecked) {
			for (Member member : members) {
				if ((emailChecked && member.email.equalsIgnoreCase(searchTerm))
						|| (nameChecked && member.name.equalsIgnoreCase(searchTerm))) {
					members.remove(member);
					return true;
				}
			}
			return false;
		}

		public static void memberManagementSystem(String customer_email, String customer_name,
				String customer_phone_number, String customer_yn) {

			try {
				conn = DBConnection.getConnection();
				conn.setAutoCommit(false);

				JFrame frame = new JFrame("회원 관리 시스템");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(550, 10, 768, 1024);
				JPanel panel = new JPanel();
				frame.add(panel);
				placeComponents(panel);
				frame.setVisible(true);

				guiTableModel = new DefaultTableModel();
				guiTableModel.addColumn("이름");
				guiTableModel.addColumn("이메일");
				guiTableModel.addColumn("핸드폰번호");
				guiTableModel.addColumn("예약여부");

				table = new JTable(guiTableModel);
				table.setFont(new Font("굴림", Font.PLAIN, 18));

				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(60, 240, 630, 650);
				panel.add(scrollPane);

				fetchDataFromDatabase();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private static void fetchDataFromDatabase() {
			try {
				String query = "SELECT * FROM customer";
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();

				guiTableModel.setRowCount(0);

				while (rs.next()) {
					String name = rs.getString("customer_name");
					String email = rs.getString("customer_email");
					String phoneNumber = rs.getString("customer_phone_number");
					String reservation = rs.getString("customer_yn");

					guiTableModel.addRow(new Object[] { name, email, phoneNumber, reservation });
				}

				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private static void placeComponents(JPanel panel) {
			panel.setLayout(null);
			
			JLabel memberListLabel = new JLabel("회원 리스트");
			memberListLabel.setBounds(270, 70, 300, 35);
			memberListLabel.setFont(new Font("굴림", Font.PLAIN, 35));
			panel.add(memberListLabel);

			JCheckBox nameCheckbox = new JCheckBox("이 름 검 색");
			nameCheckbox.setBounds(60, 170, 120, 25);
			nameCheckbox.setFont(new Font("굴림", Font.BOLD, 18));
			panel.add(nameCheckbox);

			JCheckBox emailCheckbox = new JCheckBox("이메일검색");
			emailCheckbox.setBounds(60, 195, 120, 25);
			emailCheckbox.setFont(new Font("굴림", Font.BOLD, 18));
			panel.add(emailCheckbox);

			JTextField searchField = new JTextField(20);
			searchField.setBounds(200, 191, 300, 30);
			searchField.setFont(new Font("굴림", Font.BOLD, 18));
			panel.add(searchField);

			JButton searchButton = new JButton("검색");
			searchButton.setBounds(510, 190, 80, 30);
			searchButton.setFont(new Font("굴림", Font.BOLD, 18));
			panel.add(searchButton);

			JButton deleteButton = new JButton("삭제");
			deleteButton.setBounds(600, 190, 80, 30);
			deleteButton.setFont(new Font("굴림", Font.BOLD, 18));
			panel.add(deleteButton);

			String col[] = { "이름", "이메일", "핸드폰번호", "예약여부" };
			
			JTable table = new JTable(Member.tableData, col);
			table.setFont(new Font("굴림", Font.PLAIN, 18));
			table.setVisible(true);

			JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane);

			// 검색칸에서 엔터를 누르면 "검색" 버튼이 눌림
			searchField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
						e.consume(); // 이벤트 소비 처리
						searchButton.doClick();
					}
				}
			});

			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String searchTerm = searchField.getText();
					System.out.println("검색어: " + searchTerm);
					boolean emailChecked = emailCheckbox.isSelected();
					System.out.println("이메일 체크중" + emailCheckbox.isSelected());
					boolean nameChecked = nameCheckbox.isSelected();
					System.out.println("이름 체크중" + nameCheckbox.isSelected());
					fetchDataFromDatabase();
					try {
						if (conn == null || conn.isClosed()) {
							conn = DBConnection.getConnection();
						}

						String query = "SELECT " 
									 + "customer_name, " 
									 + "customer_email, "
									 + "customer_phone_number, "
									 + "customer_yn " 
									 + "FROM customer WHERE ";

						if (emailChecked && nameChecked) {
							query += "customer_email = ? OR customer_name = ?";
						} else if (emailChecked) {
							query += "customer_email = ?";
						} else if (nameChecked) {
							query += "customer_name = ?";
						} else {
							System.out.println("이메일 또는 이름에 체크해주세요.");
							return;
						}

						PreparedStatement pstmt = conn.prepareStatement(query);
						if (emailChecked && nameChecked) {
							pstmt.setString(1, searchTerm);
							pstmt.setString(2, searchTerm);
						} else {
							pstmt.setString(1, searchTerm);
						}

						ResultSet rs = pstmt.executeQuery();
						StringBuilder displayResult = new StringBuilder();
						guiTableModel.setRowCount(0);
						while (rs.next()) {
							displayResult.append("이름: ").append(rs.getString("customer_name")).append(", 이메일: ")
									.append(rs.getString("customer_email")).append(", 핸드폰번호: ")
									.append(rs.getString("customer_phone_number")).append(", 예약여부: ")
									.append(rs.getString("customer_yn")).append("\n");
							String name = rs.getString("customer_name");
							String email = rs.getString("customer_email");
							String phoneNumber = rs.getString("customer_phone_number");
							String reservation = rs.getString("customer_yn");
							guiTableModel.addRow(new Object[] { name, email, phoneNumber, reservation });
						}

						if (displayResult.length() > 0) {
							System.out.println(displayResult.toString());
							displayResult.toString();
						} else {
							System.out.println("검색 결과를 찾을 수 없습니다.");
						}

						pstmt.close();
						rs.close();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String searchTerm = searchField.getText();
					boolean emailChecked = emailCheckbox.isSelected();
					boolean nameChecked = nameCheckbox.isSelected();
					
					String query = "DELETE * FROM customer WHERE customer_yn = 'N' AND ";

					try {
						if (emailChecked && nameChecked && 
								guiTableModel.getRowCount() < 2) {
							query += "customer_email = ? OR customer_name = ?";
							System.out.println("삭제는 이메일만 체크해서 하세요.");
							JOptionPane.showMessageDialog(scrollPane, "삭제가 완료됐습니다.");
						} else if (emailChecked) {
							query += "customer_email = ?";
							System.out.println("삭제가 완료됐습니다.");
							JOptionPane.showMessageDialog(scrollPane, "삭제가 완료됐습니다.");
						} else if (nameChecked) {
							System.out.println("삭제는 이메일 체크후에 가능합니다.");
							JOptionPane.showMessageDialog(scrollPane, "삭제는 이메일 체크후에 가능합니다.");
						} else {
							System.out.println("삭제는 이메일 체크후에 가능합니다.");
							JOptionPane.showMessageDialog(scrollPane, "삭제는 이메일 체크후에 가능합니다.");
							return;
						}

						PreparedStatement pstmt = conn.prepareStatement(query);
						pstmt.setString(1, searchTerm);
						if (emailChecked && nameChecked) {
							pstmt.setString(2, searchTerm);
						}

						int deletedRows = pstmt.executeUpdate();
						if (deletedRows > 0) {
							System.out.println("선택된 항목이 삭제되었습니다.");
						} else {
							System.out.println("삭제할 항목을 찾을 수 없습니다.");
						}

						pstmt.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
		}
	}

	public MemberManager() {
		Member.memberManagementSystem("aA1234@daum.net", "mint", "011-3233-1234", "Y");
	}
	public static void main(String[] args) {
		Member.memberManagementSystem("aA1234@daum.net", "mint", "011-3233-1234", "Y");
	}
}