package gui.layout.main.hotel_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.buttons.AdminBtn;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.buttons.ChkInBtn;
import gui.buttons.ChkOutBtn;
import gui.buttons.ChkReservationBtn;
import image.getImages;

public class HotelMainLayout extends JFrame {

	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/hotel_image/델루나 메인.png");
	static ImageIcon checkInImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/checkIn.png");
	static ImageIcon checkOutImage = new getImages().getImageIcon(340, 170, "src/image/icon_image/btn/checkOut.png");
	static ImageIcon chkResvImage = new getImages().getImageIcon(340, 170,
			"src/image/icon_image/btn/ConfirmationOfReservation.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home.png");
	static ImageIcon guideBtnImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap.png");

	static JButton b1 = new ChkInBtn(checkInImage);
	static JButton b2 = new ChkOutBtn(checkOutImage);
	static JButton b3 = new ChkReservationBtn(chkResvImage);
	static JButton b4 = new AdminBtn("관리자버튼");
	static JButton b5 = new PrevBtn(backImage);
	static JButton b6 = new HomeBtn(homeBtnImage);
	static JButton b7 = new FloorGuideBtn(guideBtnImage);

	public HotelMainLayout() {
		super("델루나호텔");
		setLayout(null);

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);

		// 예약하기 버튼
		b1.setBounds(25, 480, 700, 170);
		imageLabel.add(b1);

		// 체크아웃 버튼
		b2.setBounds(25, 655, 340, 170);
		imageLabel.add(b2);

		// 예약확인 버튼
		b3.setBounds(380, 655, 340, 170);
		imageLabel.add(b3);

		// 관리자 버튼 안보이는 버튼
		imageLabel.add(b4);

		// 뒤로가기 버튼
		b5.setBounds(30, 920, 40, 40);
		imageLabel.add(b5);

		// 홈버튼
		b6.setBounds(80, 920, 40, 40);
		imageLabel.add(b6);

		// 안내도 버튼
		b7.setBounds(130, 920, 80, 40);
		imageLabel.add(b7);

		add(imageLabel);

		// 기본셋팅
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	

	public static void main(String[] args) {
		new HotelMainLayout();
	}
}
