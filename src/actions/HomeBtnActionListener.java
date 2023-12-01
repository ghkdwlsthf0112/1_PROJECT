package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.chk_ismember.LoginChkLayout;
import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.admin_window.AdminChkResv;
import gui.layout.main.admin_window.AdminLayout;
import gui.layout.main.admin_window.AdminReservationHistory;
import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.check_out_window.CheckOut;
import gui.layout.main.guide_map.GuideMapLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationChkIn;
import gui.layout.main.reservation_inquiry.ReservationChkInNow;
import gui.layout.main.reservation_inquiry.ReservationInfo;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;
import gui.layout.main.reservation_window.ReservationLayout;
import gui.layout.paymentWindow.check_totalpay_window.CheckTotalpayLayout;
import gui.layout.paymentWindow.pay_exit_window.PayExitLayout;

public class HomeBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton homeBtn;
	JButton okBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == homeBtn || e.getSource() == okBtn) {
			new HotelMainLayout();
			mainFrame.dispose();			
		} 
		
	}
	
	public HomeBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b6;	
	}
	
	public HomeBtnActionListener(ReservationInquiryLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b1;	
	}
	
	public HomeBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;	
	}
	
	public HomeBtnActionListener(PayExitLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	

	public HomeBtnActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b4;	
	}
	
	public HomeBtnActionListener(MemberLoginLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;	
	}
	
	public HomeBtnActionListener(ReservationInfo mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
		this.okBtn = mainFrame.b5;
	}
	
	public HomeBtnActionListener(ReservationChkInNow mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b1;
	}
	
	public HomeBtnActionListener(ReservationChkIn mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	
	public HomeBtnActionListener(GuideMapLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	
	public HomeBtnActionListener(AdminLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	
	public HomeBtnActionListener(CheckOut mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b1;
	}

	public HomeBtnActionListener(LoginChkLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b4;
	}
	
	public HomeBtnActionListener(CheckTotalpayLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	
	public HomeBtnActionListener(ReservationLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b1;
	}
	
	public HomeBtnActionListener(AdminChkResv mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
	
	public HomeBtnActionListener(AdminReservationHistory mainFrame) {
		this.mainFrame = mainFrame;
		this.homeBtn = mainFrame.b2;
	}
}
