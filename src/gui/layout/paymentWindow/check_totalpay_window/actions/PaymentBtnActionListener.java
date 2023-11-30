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
import database.PaymentDao;
import database.ReservationDao;
import database.ReservationHistoryDao;
import database.dbObjects.Customer;
import database.dbObjects.Payment;
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
	Payment payment;
	
	JButton paymentBtn;
	JFrame prevMainFrame;
	JFrame mainFrame;
	static ReservationDao admindao = new ReservationDao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == paymentBtn) {
			
			String newReservationNum = duplicateNum();
			reservstion.setReservation_number(newReservationNum);
			payment.setReservation_number(newReservationNum);
			new EmailSend().ReservationSend(
					reservstion.getReservation_number(), 
					customer.getCustomer_name(),
					reservstion.getRoom_number().toString(), 
					reservstion.getReservation_start(), 
					reservstion.getReservation_end(),
					Integer.toString(reservstion.getDiffDate().getDays()), 
					Integer.toString(payment.getPay_total()),
					customer.getCustomer_phone_number());
			String popUpMess = customer.getCustomer_name()+"님\n예약번호 "+reservstion.getReservation_number()+"의 결제가 완료되었습니다!\n감사합니다\n[입력하신 메일로 예약내역이 발송되었습니다]";
			admindao.updateReservation(reservstion);
			new ReservationHistoryDao().updateReservationHistory(reservstion);
			new PaymentDao().InsertPayment(payment);
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
		this.payment = mainFrame.payment;
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
		// 랜덤 예약번호 받기
		String reservationCode = generateCode();
		
		// 중복 체크
		List<String> reNum = getReservations();
		if(reNum!=null) {
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
		return reservationCode;
	}

}
