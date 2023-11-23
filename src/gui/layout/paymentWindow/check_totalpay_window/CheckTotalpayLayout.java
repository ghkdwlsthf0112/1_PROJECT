package gui.layout.paymentWindow.check_totalpay_window;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.buttons.HomeBtn;
import gui.buttons.OkBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class CheckTotalpayLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon memberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/MemberCustomers.png");
	static ImageIcon nonmemberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/NonMemberCustomers.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");

	Reservation reservstion;
	public Customer customer;
	Room room;
	
	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new OkBtn(okImage);
	
	public CheckTotalpayLayout(Reservation reservstion, Customer customer, Room room) {
		super("결제확인창");
		setLayout(null);
		this.reservstion = reservstion;
		this.customer = customer;
		this.room = room;
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		
		
//		JLabel resNum = new JLabel(reservstion.getReservation_number());
//		resNum.setBounds(340, 225, 300, 100);
//		resNum.setFont(new Font("굴림", Font.BOLD, 40));
//		add(resNum);
		
		JLabel resRoomNum = new JLabel(reservstion.getRoom_number().toString()+"호");
		resRoomNum.setBounds(340, 345, 300, 100);
		resRoomNum.setFont(new Font("굴림", Font.BOLD, 40));
		add(resRoomNum);
		
		JLabel resStartDate = new JLabel(reservstion.getReservation_start());
		resStartDate.setBounds(340, 465, 300, 100);
		resStartDate.setFont(new Font("굴림", Font.BOLD, 40));
		add(resStartDate);
		
		JLabel resEndDate = new JLabel(reservstion.getReservation_end());
		resEndDate.setBounds(340, 585, 300, 100);
		resEndDate.setFont(new Font("굴림", Font.BOLD, 40));
		add(resEndDate);
		
		JLabel resTotalFare = new JLabel("총금액");
		resTotalFare.setBounds(340, 805, 300, 100);
		resTotalFare.setFont(new Font("굴림", Font.BOLD, 40));
		add(resTotalFare);
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b2);
		

		
		// 확인 버튼 -> 새창으로 동의서 체크후 확인 누르면 DB INSERT 후 이메일 발송
		b3.setBounds(410, 720, 200, 80);
		b3.addActionListener(null);
		imageLabel.add(b3);

		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
}
