package gui.layout.login.non_member_check_in.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.reservation_window.ReservationLayout;

public class NonMemberOkBtnActionListener implements ActionListener {
	JTextField name;
	JTextField phoneNum;
	JTextField email;
	JButton nonMemberOkBtn;
	JFrame mainFrame;
	Customer nonMemInfo = new Customer();

	JOptionPane info = new JOptionPane();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nonMemberOkBtn) {
			// 미입력 예외처리
			if (email.getText().equals("") || name.getText().equals("") || phoneNum.getText().equals("")) {
				info.showMessageDialog(mainFrame, "정보를 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
			} else if (
			// 이름 전화번호 이메일 예외처리
					isValidPhoneNumber(phoneNum.getText()) == false || 
					isValidEmail(email.getText()) == false || 
					isValidName(name.getText()) == false) {
				System.out.println(phoneNum.getText());
				info.showMessageDialog(mainFrame, "올바르지 않은 정보입니다", "Message", JOptionPane.ERROR_MESSAGE);
			} else {
				nonMemInfo.setCustomer_email(email.getText());
				nonMemInfo.setCustomer_name(name.getText());
				nonMemInfo.setCustomer_phone_number(phoneNum.getText());
				nonMemInfo.setCustomer_yn("N");
				new ReservationLayout(nonMemInfo); // 입력받은 값으로 새로운 Customer를 만들어 보내줌
				mainFrame.dispose();
			}

		}
	}

	public NonMemberOkBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.name = mainFrame.name;
		this.phoneNum = mainFrame.phoneNum;
		this.email = mainFrame.email;
		this.nonMemberOkBtn = mainFrame.b4;
		this.mainFrame = mainFrame;
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {
		if (!phoneNumber.startsWith("010")) {
			System.out.printf("[INFO] %s는 010으로 시작하지 않는 휴대폰번호입니다.\n", phoneNumber);
			return false;
		}

		String hyponRemovedNumber = phoneNumber.replace("-", "");

		for (int i = 0, len = hyponRemovedNumber.length(); i < len; i++) {
			if (!Character.isDigit(hyponRemovedNumber.charAt(i))) {
				System.out.printf("[INFO] %s는 숫자가 아닌것이 포함되어 있습니다.\n", phoneNumber);
				return false;
			}
		}

		if (hyponRemovedNumber.length() != 11) {
			System.out.printf("[INFO] %s는 숫자가 아닌것이 포함되어 있습니다.\n", phoneNumber);
			return false;
		}

		int len = phoneNumber.length();

		if (!(len == 11 || len == 13)) {
			System.out.printf("[INFO] %s는 번호 길이가 잘못되었습니다.\n", phoneNumber);
			return false;
		}

		if (len == 13) {
			if (phoneNumber.charAt(3) != '-' || phoneNumber.charAt(8) != '-') {
				System.out.printf("[INFO] %s는 '-'가 없거나 위치가 이상합니다.\n", phoneNumber);
				return false;
			}
			int hyponCount = 0;
			for (int i = 0; i < len; i++) {
				if (phoneNumber.charAt(i) == '-') {
					++hyponCount;
				}
			}
			if (hyponCount != 2) {
				System.out.printf("[INFO] %s는 올바른 형식의 핸드폰 번호가 아닙니다.\n", phoneNumber);
				return false;
			}
		}

		return true;
	}

	private static boolean isValidEmail(String email) {
//		Pattern domainPattern = Pattern.compile(".+@(.+)");
//		Matcher matcher = domainPattern.matcher(email);
		return Pattern.matches(".+@(.+)", email);
	}

	private static boolean isValidName(String name) {
		return Pattern.matches("([가-힣]{2,6}|[a-zA-Z]*)", name);
	}

	public static void main(String[] args) {
		System.out.println(isValidPhoneNumber("010-3333-1234"));
	}

}
