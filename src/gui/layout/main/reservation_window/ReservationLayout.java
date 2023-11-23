package gui.layout.main.reservation_window;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.CalendarBtnActionListener;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import gui.buttons.CalendarBtn;
import gui.buttons.SearchBtn;
import image.getImages;

public class ReservationLayout extends JFrame  {
	
	static ImageIcon calendarImage = new getImages().getImageIcon(40, 40, "src/image/calendar/calendar1.png");
	static ImageIcon searchImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/check.png");
	
	public static JTextField chkInDateTextField;
	public static JTextField chkOutDateTextField;

	ActionListener CalendarBtnActionListener;
	public JButton calendarBtn = new CalendarBtn(calendarImage);
	public JButton searchBtn = new SearchBtn(searchImage);
	Customer customer;
	Reservation reservation;
	public ReservationLayout(Customer customer) {
		
		setLayout(null);
		this.customer = customer;
		System.out.println(customer.toString());
//		JLabel imageLabel = new JLabel();
		JLabel chkInLabel = new JLabel("입실날짜");
		JLabel chkOutLabel = new JLabel("퇴실 날짜");
		
		

		
		reservation.setCustomer_email(customer.getCustomer_email());
//		reservation.setReservation_start(getName());
//		reservation.setReservation_end(getName());
		
		chkInDateTextField = new JTextField(20);
		chkInDateTextField.setHorizontalAlignment(chkInLabel.CENTER);
		chkInDateTextField.setBounds(50, 100, 200, 80);
		chkInDateTextField.setEnabled(false);
		
		chkOutDateTextField = new JTextField();
		chkOutDateTextField.setHorizontalAlignment(chkOutLabel.CENTER);
		chkOutDateTextField.setBounds(100, 140, 200, 80);
		chkOutDateTextField.setEnabled(false);

		
		calendarBtn.setBounds(500, 100, 40, 40);
		calendarBtn.addActionListener(new CalendarBtnActionListener(this));
		
		add(chkInLabel);
		add(chkInDateTextField);
		add(chkOutDateTextField);
		add(calendarBtn);
		
		
		setTitle("객실 선택창");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}
	
//	public static void setDateTextField(String date) {
//		dateTextField.setText(date);
//	}
	
	
	
	public static void main(String[] args) {
		Customer customer = null; // -> 회원 비회원 전부 Customer 객체를 이용해서 전달
		new ReservationLayout(customer);
	}
	
	
}





















