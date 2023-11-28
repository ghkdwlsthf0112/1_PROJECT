package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import actions.EmailSend;
import database.AdminDao;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.paymentWindow.ReservationCode;
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
	AdminDao admindao = new AdminDao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == paymentBtn) {
			while (reservstion.getRoom_number() != null) {
				String reservationCode = generateCode();
				if (admindao.getReservstion(reservationCode) == null) {
					reservstion.setReservation_number(reservationCode);
					
//					new EmailSend().ReservationSend(reservstion.getReservation_number(), customer.getCustomer_name(),
//							reservstion.getRoom_number(), reservstion.getReservation_start(), reservstion.getReservation_end(), reservationCode,
//							reservationCode);
				}
			}

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

	public static void main(String[] args) {
		String reservationCode = generateCode();

		System.out.println(reservationCode);
	}
}
