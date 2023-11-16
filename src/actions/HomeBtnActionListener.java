package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class HomeBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton HomeBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == HomeBtn) {
			new HotelMainLayout();
			mainFrame.dispose();			
		}
		
	}
	
	public HomeBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b6;	
	}
	
	public HomeBtnActionListener(ReservationInquiryLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b1;	
	}
	
	
}
