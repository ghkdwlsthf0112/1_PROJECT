package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationChkInNow;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class ChkReservationBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton ChkReservationBtn;
	JButton CheckInReservationBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkReservationBtn) {
			new ReservationInquiryLayout();
			mainFrame.dispose();
		} else if(e.getSource() == CheckInReservationBtn) {
			new ReservationChkInNow();
			mainFrame.dispose();
		}
	}
	
	public ChkReservationBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.ChkReservationBtn = mainFrame.b3;
	}
	
	// 체크인 방법 선택창에서 같이 들어옴
	public ChkReservationBtnActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.CheckInReservationBtn = mainFrame.b1;
	}
}
