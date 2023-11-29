package gui.layout.paymentWindow.check_totalpay_window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import database.ReservationDao;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.paymentWindow.check_totalpay_window.actions.PaymentBtnActionListener;
import gui.layout.paymentWindow.check_totalpay_window.actions.TermsCancelBtnActionListener;
import gui.layout.paymentWindow.check_totalpay_window.actions.TermsCheckBtnActionListener;
import gui.layout.paymentWindow.check_totalpay_window.buttons.CencelBtn;
import gui.layout.paymentWindow.check_totalpay_window.buttons.PaymentBtn;

public class AgreePopupLayout extends JFrame{
	final protected static String termlocal = "src/gui/layout/paymentWindow/check_totalpay_window/terms/term.txt"; 
	
	public JTextArea terms = new JTextArea();
	public JScrollPane jscp1 = new JScrollPane(terms);
	public JButton paymentBtn = new PaymentBtn();
	public JButton cencelBtn = new CencelBtn();
	public JCheckBox chbox = new JCheckBox();

	public Reservation reservstion;
	public Customer customer;
	public Room room;
	public JFrame prevMainFrame;
	
	public AgreePopupLayout(Reservation reservstion, Customer customer,Room room,JFrame mainFrame) {
		setLayout(null);
		
		this.reservstion = reservstion;
		this.customer = customer;
		this.room = room;
		this.prevMainFrame = mainFrame;
		JPanel reservationInfo = new JPanel(new BorderLayout());
		try {
			FileReader reader = new FileReader(termlocal);
			terms.read(reader, termlocal);
		} catch (IOException e) {
			e.printStackTrace();
		}
		terms.setEditable(false);
		
		terms.setLineWrap(true);
		terms.setFont(new Font("나눔고딕", Font.BOLD, 13));
		
		// 스크롤 제일 밑으로 했을경우 버튼 누르게 가능하려고 했던 흔적
//		int endPosition = terms.getDocument().getLength();
//		terms.getDocument().getEndPosition();

		jscp1.setBounds(10,10,364,400);
		add(jscp1);
		
		JLabel label = new JLabel("약관 동의 : ");
		label.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label.setBounds(280, 420, 70, 20);
		add(label);
		
		add(chbox);
		chbox.setBounds(350,420,20,20);
		chbox.setVisible(true);
		chbox.addActionListener(new TermsCheckBtnActionListener(this));
		
		cencelBtn.addActionListener(new TermsCancelBtnActionListener(this));
		add(cencelBtn);
		
		paymentBtn.setEnabled(false);
		paymentBtn.addActionListener(new PaymentBtnActionListener(this));
		add(paymentBtn);
		
		
		
		// 스크롤 다 안하면 체크 못하게 막고 체크 하면 버튼 누를수 있게 설정
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(750, 300);
		setSize(384, 512);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
	
	
}
