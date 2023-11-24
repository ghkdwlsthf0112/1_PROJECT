package gui.layout.main.reservation_inquiry;

import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.AdminDao;
import database.dbObjects.Reservation;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.OkBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.reservation_inquiry.buttons.CancelReservationBtn;
import image.getImages;

public class ReservationChkIn extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/ex1.png");
	static ImageIcon memberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/MemberCustomers.png");
	static ImageIcon nonmemberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/NonMemberCustomers.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	static ImageIcon cancelImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/CancelReservation.png");
	static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/예약조회check.png");

	Reservation reservstion;
	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new FloorGuideBtn(guideImage);
//	public JButton b4 = new CancelReservationBtn(cancelImage);
	public JButton b5 = new OkBtn(okImage);

	public ReservationChkIn(Reservation reservstion) {
		setLayout(null);
		setTitle("예약정보창");
		this.reservstion = reservstion;
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		System.out.println(reservstion.toString());
		
		JLabel resNum = new JLabel(reservstion.getReservation_number());
		resNum.setBounds(340, 225, 300, 100);
		resNum.setFont(new Font("굴림", Font.BOLD, 40));
		add(resNum);
		
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
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
		
		// 안내 버튼
		b3.addActionListener(new FloorGuideBtnActionListener(this));
		Label.add(b3);
		
		// 예약 취소 버튼
//		b4.setBounds(160, 720, 200, 80);
//		Label.add(b4);
		
		// 확인 버튼
		b5.setBounds(280, 720, 200, 80);
//		b5.addActionListener(new HomeBtnActionListener(this));
		Label.add(b5);

		
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		AdminDao admindao = new AdminDao();

		Reservation reservstion = admindao.getReservstion("111111");
		new ReservationChkIn(reservstion);
	}
}
