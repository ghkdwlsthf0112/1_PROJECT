package gui.layout.main.hotel_main.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class ChkReservBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton ChkReservationBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkReservationBtn) {
			new ReservationInquiryLayout();
			mainFrame.dispose();
		}
	}
	
	public ChkReservBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.ChkReservationBtn = mainFrame.b3;
	}
}
