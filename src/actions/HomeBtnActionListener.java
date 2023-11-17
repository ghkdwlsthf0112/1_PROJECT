package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;
import gui.layout.paymentWindow.pay_exit_window.PayExitLayout;

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
	
	public HomeBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b4;	
	}
	
	public HomeBtnActionListener(PayExitLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b2;
	}
	

	public HomeBtnActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b4;	
	}
	
	public HomeBtnActionListener(MemberLoginLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HomeBtn = mainFrame.b2;	
	}

}
