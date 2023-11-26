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
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.buttons.CalendarBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.reservation_window.actions.SearchBtnActionListener;
import gui.layout.main.reservation_window.buttons.SearchBtn;
import image.getImages;

public class ReservationLayout extends JFrame {
	final static ImageIcon main = new getImages().getImageIcon(768, 1024, "src/image/background_image/roomselectbackground.png");
	static ImageIcon calendarImage = new getImages().getImageIcon(40, 40, "src/image/calendar/calendar1.png");
	static ImageIcon searchImage = new getImages().getImageIcon(154, 50, "src/image/icon_image/btn/check.png");
	
	public static JTextField chkInDateTextField;
	public static JTextField chkOutDateTextField;
	
	
	public static JButton calendarBtn1 = new CalendarBtn(calendarImage);
	public static JButton searchBtn = new SearchBtn(searchImage);
	public static JPanel centerPanel;
	public static JScrollPane scrollPane;
	Customer customer;
	Reservation reservation;

	
	public JButton b1 = new HomeBtn();
	public JButton b2 = new PrevBtn();

	public ReservationLayout(Customer customer) {
		
		setLayout(null);
		this.customer = customer;
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(main);
		add(imageLabel);
//		System.out.println(customer.toString());
//		JLabel imageLabel = new JLabel();
		
//		reservation.setCustomer_email(customer.getCustomer_email());
//		reservation.setReservation_start(getName());
//		reservation.setReservation_end(getName());
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane(centerPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(80, 270, 620, 525);
		
		setLayout(null);
		
		
		
		
		
		chkInDateTextField = new JTextField();
		chkInDateTextField.setBounds(200, 87, 300, 40);
		chkInDateTextField.setEnabled(false);
		
		chkOutDateTextField = new JTextField();
		chkOutDateTextField.setBounds(200, 160, 300, 40);
		chkOutDateTextField.setEnabled(false);
		
		calendarBtn1.setBounds(608, 95, 40, 40);
		calendarBtn1.addActionListener(new CalendarBtnActionListener(this));
		
		searchBtn.setBounds(549, 150, 154, 50);
		searchBtn.addActionListener(new SearchBtnActionListener(this));
		
		imageLabel.add(scrollPane);
		imageLabel.add(chkInDateTextField);
		imageLabel.add(chkOutDateTextField);
		imageLabel.add(calendarBtn1);
		
		imageLabel.add(searchBtn);
		
		b1.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b1);

		b2.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b2);
		
		
		setTitle("객실 선택창");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setUndecorated(true);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		Customer customer = null; // -> 회원 비회원 전부 Customer 객체를 이용해서 전달
		new ReservationLayout(customer);

	}
}
