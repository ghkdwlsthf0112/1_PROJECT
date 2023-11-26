package gui.layout.main.check_in_window;

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
import gui.layout.main.check_in_window.buttons.FieldCheckInBtn;
import gui.layout.main.check_in_window.buttons.OnSiteCheckInBtn;
import image.getImages;

public class CheckInLayout extends JFrame {
	
	final static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/체크인선택화면.png");
	
	static ImageIcon FieldCheckIn = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/FieldCheckIn.png");	
	
	public JButton b1 = new OnSiteCheckInBtn();
	public JButton b2 = new FieldCheckInBtn();
	public JButton b3 = new PrevBtn();
	public JButton b4 = new HomeBtn();
	public JButton b5 = new FloorGuideBtn();
	
	public CheckInLayout(){
		setLayout(null);
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		
		b1.addActionListener(new ChkReservationBtnActionListener(this));
		imageLabel.add(b1);
		
		b2.addActionListener(new OnSitecCheckInActionListener(this));
		imageLabel.add(b2);
		
		b3.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b3);
		
		b4.addActionListener(new HomeBtnActionListener(this));
		imageLabel.add(b4);

		b5.addActionListener(new FloorGuideBtnActionListener(this));
		imageLabel.add(b5);

		add(imageLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		b2.setFocusPainted(false);
}
	
	  public static void main(String[] args) {
		  
		  new CheckInLayout();

	  }
}
