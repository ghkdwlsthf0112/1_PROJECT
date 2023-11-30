package gui.layout.main.reservation_window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

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
import database.ReservationDao;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.buttons.CalendarBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.reservation_window.actions.NextBtnActionListener;
import gui.layout.main.reservation_window.actions.SearchBtnActionListener;
import gui.layout.main.reservation_window.buttons.NextBtn;
import gui.layout.main.reservation_window.buttons.SearchBtn;
import image.getImages;

public class ReservationLayout extends JFrame {
	final static ImageIcon main = new getImages().getImageIcon(768, 1024, "src/image/background_image/roomselectbackground.png");
	final static ImageIcon calendarImage = new getImages().getImageIcon(40, 40, "src/image/calendar/calendar1.png");
	final static ImageIcon searchImage = new getImages().getImageIcon(154, 50, "src/image/icon_image/btn/check.png");
	
	public JTextField chkInDateTextField;
	public JTextField chkOutDateTextField;
	public JTextField choiceRoomInfo;

	
	public JButton calendarBtn1 = new CalendarBtn(calendarImage);
	public JButton searchBtn = new SearchBtn(searchImage);
	public JPanel centerPanel = new JPanel();
	public JScrollPane scrollPane = new JScrollPane();	
	
	public Customer customer;
	public Reservation reservation = new Reservation();

	
	public JButton b1 = new HomeBtn();
	public JButton b2 = new PrevBtn();
	public JButton b3 = new NextBtn();

	ReservationDao adminDao = new ReservationDao();
	public ReservationLayout(Customer customer) {
		
		setLayout(null);
		this.customer = customer;
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(main);
		add(imageLabel);
		
//		System.out.println(customer.toString());
		
		reservation.setCustomer_email(customer.getCustomer_email());
	

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(80, 270, 620, 525);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.add(new JButton());
		
		centerPanel.setBackground(new Color(243,243,243));
		GridLayout layout = new GridLayout(0,1,3,10);
		layout.minimumLayoutSize(imageLabel);
		centerPanel.setLayout(layout);

		
		scrollPane.setViewportView(centerPanel);
		
		setLayout(null);

		
		
		
		
		chkInDateTextField = new JTextField();
		chkInDateTextField.setBounds(200, 87, 300, 40);
		chkInDateTextField.setFont(new Font("굴림", Font.BOLD, 25));
		chkInDateTextField.setForeground(Color.black);
		chkInDateTextField.setBorder(null);
		chkInDateTextField.setEnabled(false);
		
		chkOutDateTextField = new JTextField();
		chkOutDateTextField.setBounds(200, 160, 300, 40);
		chkOutDateTextField.setFont(new Font("굴림", Font.BOLD, 25));
		chkOutDateTextField.setForeground(Color.black);
		chkOutDateTextField.setBorder(null);
		chkOutDateTextField.setEnabled(false);
		
		calendarBtn1.setBounds(608, 95, 40, 40);
		calendarBtn1.addActionListener(new CalendarBtnActionListener(this));
		
		searchBtn.setBounds(549, 150, 154, 50);
		searchBtn.addActionListener(new SearchBtnActionListener(this));
		
		choiceRoomInfo = new JTextField();
		choiceRoomInfo.setBounds(100, 870, 350, 40);
		choiceRoomInfo.setFont(new Font("굴림", Font.BOLD, 20));
		choiceRoomInfo.setForeground(Color.black);
		choiceRoomInfo.setBorder(null);
		choiceRoomInfo.setEnabled(false);
		
		
		imageLabel.add(scrollPane);
		imageLabel.add(chkInDateTextField);
		imageLabel.add(chkOutDateTextField);
		imageLabel.add(calendarBtn1);
		imageLabel.add(choiceRoomInfo);
		imageLabel.add(searchBtn);
		
		b1.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b1);

		b2.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b2);
		
		b3.addActionListener(new NextBtnActionListener(this));
		imageLabel.add(b3);
		
		setTitle("객실 선택창");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	
//	public static void main(String[] args) {
//		Customer customer = null; // -> 회원 비회원 전부 Customer 객체를 이용해서 전달
//		new ReservationLayout(customer);
//
//	}
}
