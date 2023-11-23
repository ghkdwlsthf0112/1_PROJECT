package gui.layout.main.hotel_main.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class ChkInBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton ChkInBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkInBtn) {
			new CheckInLayout();
			mainFrame.dispose();
		}
		
	}
	
	public ChkInBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.ChkInBtn = mainFrame.b1;
	}

}
