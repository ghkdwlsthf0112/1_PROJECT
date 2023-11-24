package gui.layout.main.reservation_window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import actions.CalendarBtnActionListener;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.buttons.CalendarBtn;
import gui.layout.main.reservation_window.actions.SearchBtnActionListener;
import gui.layout.main.reservation_window.buttons.SearchBtn;
import image.getImages;

public class ReservationLayout extends JFrame {
	static ImageIcon calendarImage = new getImages().getImageIcon(40, 40, "src/image/calendar/calendar1.png");
	static ImageIcon searchImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/check.png");
	public static JTextField chkInDateTextField;
	public static JTextField chkOutDateTextField;
	ActionListener CalendarBtnActionListener;
	ActionListener SearchBtnActionListener;
	public static JButton calendarBtn1 = new CalendarBtn(calendarImage);
	public static JButton searchBtn = new SearchBtn(searchImage);
	public static JPanel centerPanel;
	public static JScrollPane scrollPane;
	Customer customer;
	Reservation reservation;


	public ReservationLayout(Customer customer) {
		

//		this.customer = customer;
//		System.out.println(customer.toString());
		setLayout(null);
		this.customer = customer;
//		System.out.println(customer.toString());
//		JLabel imageLabel = new JLabel();
		JLabel chkInLabel = new JLabel("입실날짜");
		
//		reservation.setCustomer_email(customer.getCustomer_email());
//		reservation.setReservation_start(getName());
//		reservation.setReservation_end(getName());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 280, 740, 600);
		
		setLayout(null);
		
		JLabel chkInLabel = new JLabel("입실 날짜");
		JLabel chkOutLabel = new JLabel("퇴실 날짜");
		
		chkInLabel.setBounds(10, 50, 60, 60);
		chkOutLabel.setBounds(10, 120, 60, 60);
		
		chkInDateTextField = new JTextField();
		chkInDateTextField.setHorizontalAlignment(chkInLabel.CENTER);
		chkInDateTextField.setBounds(100, 50, 200, 80);
		chkInDateTextField.setEnabled(false);
		
		chkOutDateTextField = new JTextField();
		chkOutDateTextField.setHorizontalAlignment(chkOutLabel.CENTER);
		chkOutDateTextField.setBounds(100, 140, 200, 80);
		chkOutDateTextField.setEnabled(false);
		calendarBtn1.setBounds(500, 100, 40, 40);
		calendarBtn1.addActionListener(new CalendarBtnActionListener(this));
		
		searchBtn.setBounds(500, 165, 100, 100);
		searchBtn.addActionListener(new SearchBtnActionListener(this));
		
		add(scrollPane);
		add(chkInLabel);
		add(chkOutLabel);
		add(chkInDateTextField);
		add(chkOutDateTextField);
		add(calendarBtn1);
		
		add(searchBtn);
		
		
		setTitle("객실 선택창");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		Customer customer = null; // -> 회원 비회원 전부 Customer 객체를 이용해서 전달
		new ReservationLayout(customer);

	}
}
