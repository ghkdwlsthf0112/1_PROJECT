package gui.layout.paymentWindow.check_totalpay_window;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.AdminDao;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.buttons.HomeBtn;
import gui.buttons.OkBtn;
import gui.buttons.PrevBtn;
import gui.layout.paymentWindow.check_totalpay_window.actions.ConfirmedBtnActionListener;
import image.getImages;

public class CheckTotalpayLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon memberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/MemberCustomers.png");
	static ImageIcon nonmemberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/NonMemberCustomers.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");

	public Reservation reservstion;
	public Customer customer;
	public Room room;
	
	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new OkBtn(okImage);
	
	public CheckTotalpayLayout(Reservation reservstion, Customer customer, Room room) {
		super("결제확인창");
		setLayout(null);
		this.reservstion = reservstion;
		this.customer = customer;
		this.room = room;
		
		// CheckTotalpayLayout이 생성되면서 고객정보에서 이메일을 예약쪽에 등록
		reservstion.setCustomer_email(customer.getCustomer_email());
		
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		
		JLabel resRoomNum = new JLabel(reservstion.getRoom_number().toString()+"호");
		resRoomNum.setBounds(340, 230, 300, 100);
		resRoomNum.setFont(new Font("굴림", Font.BOLD, 40));
		add(resRoomNum);
		
		JLabel resStartDate = new JLabel(reservstion.getReservation_start());
		resStartDate.setBounds(340, 340, 300, 100);
		resStartDate.setFont(new Font("굴림", Font.BOLD, 40));
		add(resStartDate);
		
		JLabel resEndDate = new JLabel(reservstion.getReservation_end());
		resEndDate.setBounds(340, 450, 300, 100);
		resEndDate.setFont(new Font("굴림", Font.BOLD, 40));
		add(resEndDate);
		
		//이용기간 계산 후 총 요금 계산		
		int totalFare = room.getRoom_fare()*reservstion.getDiffDate().getDays();
		
		JLabel resTotalFare = new JLabel(Integer.toString(totalFare)+"원");
		resTotalFare.setBounds(340, 560, 300, 100);
		resTotalFare.setFont(new Font("굴림", Font.BOLD, 40));
		add(resTotalFare);
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b2);
		

		
		// 확인 버튼 -> 새창으로 동의서 체크후 확인 누르면 DB INSERT 후 (예약번호 생성 후)이메일 발송
		b3.setBounds(270, 720, 200, 80);
		b3.addActionListener(new ConfirmedBtnActionListener(this));
		imageLabel.add(b3);

		add(imageLabel);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		Reservation reservstion = new AdminDao().getReservstion("222222");
		Customer customer = new Customer(1,"ez123@naver.com","qweASD123!","01012341234","김신","Y");
		Room room = new Room(1,201,"스위트",50000,"N",2);
		new CheckTotalpayLayout(reservstion, customer, room);
	}
}
