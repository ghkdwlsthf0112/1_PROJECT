package gui.layout.main.check_in_window;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.check_in_window.actions.ChkReservationBtnActionListener;
import gui.layout.main.check_in_window.actions.OnSitecCheckInActionListener;
import gui.layout.main.check_in_window.buttons.OnSiteCheckInBtn;
import gui.layout.main.hotel_main.buttons.ChkInBtn;
import image.getImages;

public class CheckInLayout extends JFrame {
	
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background5.png");
	
	static ImageIcon CheckInReservation = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/CheckInReservation.png");
	ActionListener ChkReservationBtnActionListener;
	static ImageIcon FieldCheckIn = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/FieldCheckIn.png");	
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home.png");
	ActionListener HomeBtnActionListener;
	static ImageIcon guideBtnImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap.png");
	ActionListener FloorGuideBtnActionListener;
	
	public JButton b1 = new OnSiteCheckInBtn(CheckInReservation);
	public JButton b2 = new ChkInBtn(FieldCheckIn);
	public JButton b3 = new PrevBtn(backImage);
	public JButton b4 = new HomeBtn(homeBtnImage);
	public JButton b5 = new FloorGuideBtn(guideBtnImage);
	
	public CheckInLayout(){
		setLayout(null);
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		
		b1.setBounds(25, 440, 700, 170);
		b1.addActionListener(new ChkReservationBtnActionListener(this));
		imageLabel.add(b1);
		
		b2.setBounds(25, 615, 700, 170);
		b2.addActionListener(new OnSitecCheckInActionListener(this));
		imageLabel.add(b2);
		
		b3.setBounds(30, 920, 40, 40);
		b3.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b3);
		
		b4.setBounds(80, 920, 40, 40);
		b4.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b4);

		b5.setBounds(130, 920, 80, 40);
		b5.addActionListener(new FloorGuideBtnActionListener(this));
		imageLabel.add(b5);

		add(imageLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
		b1.setFocusPainted(false);
		b2.setFocusPainted(false);
}
	
	  public static void main(String[] args) {
		  
		  new CheckInLayout();

	  }
}
