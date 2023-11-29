package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import actions.EmailSend;
import database.ReservationDao;
import database.ReservationHistoryDao;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.paymentWindow.check_totalpay_window.AgreePopupLayout;

public class PaymentBtnActionListener implements ActionListener {
	final private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final private static int CODE_LENGTH = 7;

	Reservation reservstion;
	Customer customer;
	Room room;

	JButton paymentBtn;
	JFrame prevMainFrame;
	JFrame mainFrame;
	static ReservationDao admindao = new ReservationDao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == paymentBtn) {
			admindao.getReservstions("%").get(1);
			String newReservationNum = duplicateNum();
			reservstion.setReservation_number(newReservationNum);
			int totalFare = room.getRoom_fare()*reservstion.getDiffDate().getDays();
			System.out.println(room.toString());
			System.out.println(reservstion.toString());
			System.out.println(customer.toString());
			new EmailSend().ReservationSend(
					reservstion.getReservation_number(), 
					customer.getCustomer_name(),
					reservstion.getRoom_number().toString(), 
					reservstion.getReservation_start(), 
					reservstion.getReservation_end(),
					Integer.toString(reservstion.getDiffDate().getDays()), 
					Integer.toString(totalFare),
					customer.getCustomer_phone_number());
			String popUpMess = customer.getCustomer_name()+"님\n예약번호 "+reservstion.getReservation_number()+"의 결제가 완료되었습니다!\n감사합니다\n[입력하신 메일로 예약내역이 발송되었습니다]";
			admindao.updateReservation(reservstion);
			new ReservationHistoryDao().updateReservationHistory(reservstion);
			new JOptionPane().showMessageDialog(mainFrame, popUpMess , "Message",JOptionPane.INFORMATION_MESSAGE );
			new HotelMainLayout();
			
			mainFrame.dispose();
			prevMainFrame.dispose();
		}
	}

	public PaymentBtnActionListener(AgreePopupLayout mainFrame) {
		this.reservstion = mainFrame.reservstion;
		this.customer = mainFrame.customer;
		this.room = mainFrame.room;
		this.prevMainFrame = mainFrame.prevMainFrame;
		this.paymentBtn = mainFrame.paymentBtn;
		this.mainFrame = mainFrame;

	}

	private static char generateRandomAlphabet() {
		Random random = new Random();
		int randomIndex = random.nextInt(ALPHABET.length());
		return ALPHABET.charAt(randomIndex);
	}

	private static int generateRandomNumber() {
		Random random = new Random();

		return random.nextInt(10); // 0부터 9까지
	}

	private static String generateCode() {
		StringBuilder codeBuilder = new StringBuilder();

		// 첫 글자는 랜덤 영어 대문자
		char firstChar = generateRandomAlphabet();
		codeBuilder.append(firstChar);

		// 뒤는 숫자 6자리 랜덤
		for (int i = 0; i < CODE_LENGTH - 1; i++) {
			int randomNumber = generateRandomNumber();
			codeBuilder.append(randomNumber);
		}
		return codeBuilder.toString();
	}

	private static List getReservations() {
		List<Reservation> res = admindao.getReservstions("%");
		List<String> reNum = new ArrayList<>();
		for (Reservation re : res) {
			reNum.add(re.getReservation_number().toString());
		}
		return reNum;
	}

	private static String duplicateNum() {
		String reservationCode = generateCode();
		List<String> reNum = getReservations();

		int count = reNum.size();
		while (count > 0) {
			for (String num : reNum) {
				if (num.equals(reservationCode)) {
					reservationCode = generateCode();
					count = reNum.size();
				} else {
					--count;
				}
			}
		}
		return reservationCode;
	}

}
