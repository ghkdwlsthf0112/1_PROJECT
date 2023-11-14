package gui.layout.main.hotel_main;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.buttons.AdminBtn;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.buttons.chkInBtn;
import gui.buttons.chkOutBtn;
import gui.buttons.chkReservationBtn;
import image.getImages;

public class HotelMainLayout extends JFrame {
	public HotelMainLayout() {
		super("델루나호텔");
		setLayout(new BorderLayout());
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(new getImages().getImageIcon(768,1024,"src/image/hotel_image/델루나 메인.png"));
		
//		add(imageLabel);
		imageLabel.add(new AdminBtn());
		imageLabel.add(new chkInBtn());
		imageLabel.add(new chkOutBtn());
		imageLabel.add(new chkReservationBtn());
		

		
		JLabel bottomLabel = new JLabel("bottom");
		bottomLabel.setLayout(new GridLayout(0,8));
		bottomLabel.add(new PrevBtn());
		bottomLabel.add(new HomeBtn());
		bottomLabel.add(new FloorGuideBtn());

		add(imageLabel);
		add(bottomLabel, BorderLayout.SOUTH);
		bottomLabel.setBackground(Color.black);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768,1024);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new HotelMainLayout();
	}
}
