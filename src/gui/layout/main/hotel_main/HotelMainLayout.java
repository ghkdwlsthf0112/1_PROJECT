package gui.layout.main.hotel_main;



import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.FloorGuideBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.hotel_main.actions.AdminBtnActionListener;
import gui.layout.main.hotel_main.actions.ChkInBtnActionListener;
import gui.layout.main.hotel_main.actions.ChkOutBtnActionListener;
import gui.layout.main.hotel_main.actions.ChkReservBtnActionListener;
import gui.layout.main.hotel_main.buttons.AdminBtn;
import gui.layout.main.hotel_main.buttons.ChkInBtn;
import gui.layout.main.hotel_main.buttons.ChkOutBtn;
import gui.layout.main.hotel_main.buttons.ChkReservationBtn;
import image.getImages;

public class HotelMainLayout extends JFrame {

	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon checkInImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/checkIn.png");
	static ImageIcon checkOutImage = new getImages().getImageIcon(340, 170, "src/image/icon_image/btn/checkOut.png");
	static ImageIcon chkResvImage = new getImages().getImageIcon(340, 170,
			"src/image/icon_image/btn/ConfirmationOfReservation.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideBtnImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");

	public JButton b1 = new ChkInBtn(checkInImage);
	public JButton b2 = new ChkOutBtn(checkOutImage);
	public JButton b3 = new ChkReservationBtn(chkResvImage);
	public JButton b4 = new AdminBtn();
	public JButton b5 = new PrevBtn(backImage);
	public JButton b6 = new HomeBtn(homeBtnImage);
	public JButton b7 = new FloorGuideBtn(guideBtnImage);
	
	public HotelMainLayout() {
		super("델루나호텔");
		setLayout(null);

		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);

		// 예약하기 버튼
		b1.setBounds(25, 440, 700, 170);
		b1.addActionListener(new ChkInBtnActionListener(this));
		imageLabel.add(b1);

		// 체크아웃 버튼
		b2.addActionListener(new ChkOutBtnActionListener(this));
		imageLabel.add(b2);

		// 예약확인 버튼
		b3.addActionListener(new ChkReservBtnActionListener(this));
		imageLabel.add(b3);

		// 관리자 버튼 안보이는 버튼
		b4.addActionListener(new AdminBtnActionListener(this));
		imageLabel.add(b4);

		// 뒤로가기 버튼
		b5.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b5);
		
		// 홈버튼
		imageLabel.add(b6);

		// 안내도 버튼
		b7.addActionListener(new FloorGuideBtnActionListener(this));
		imageLabel.add(b7);

		add(imageLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	
}
