package gui.layout.main.check_in_window;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.ChkInBtn;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class CheckInLayout extends JFrame {
	
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background5.png");
	
	static ImageIcon CheckInReservation = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/CheckInReservation.png");
	static ImageIcon FieldCheckIn = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/FieldCheckIn.png");	
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home.png");
	ActionListener HomeBtnActionListener;
	static ImageIcon guideBtnImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap.png");
	
	
	public JButton b1 = new ChkInBtn(CheckInReservation);
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
		imageLabel.add(b1);
		
		b2.setBounds(25, 615, 700, 170);
		imageLabel.add(b2);
		
		b3.setBounds(30, 920, 40, 40);
		b3.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b3);
		
		b4.setBounds(80, 920, 40, 40);
		b4.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b4);

		b5.setBounds(130, 920, 80, 40);
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
