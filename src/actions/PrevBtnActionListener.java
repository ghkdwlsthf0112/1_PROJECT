package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.admin_window.AdminLayout;
import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.cover.CoverLayout;
import gui.layout.main.guide_map.GuideMapLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationChkIn;
import gui.layout.main.reservation_inquiry.ReservationChkInNow;
import gui.layout.main.reservation_inquiry.ReservationInfo;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class PrevBtnActionListener implements ActionListener {
	JFrame mainFrame;
	JButton HotelMainLayoutPrevBtn;
	JButton ReservationInquiryLayoutPrevBtn;
	JButton CheckInLayoutPrevBtn;
	JButton NonMemberCheckLayoutPrevBtn;
	JButton MemberLoginLayoutPrevBtn;
	JButton ReservationInfoPrevBtn;
	JButton ReservationChkInNowPrevBtn;
	JButton ReservationChkInPrevBtn;
	JButton GuideMapLayoutPrevBtn;
	JButton AdminLayoutPrevBtn;


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == HotelMainLayoutPrevBtn) {
			new CoverLayout();
			mainFrame.dispose();
		} else if(e.getSource() == ReservationInquiryLayoutPrevBtn) {
			new HotelMainLayout();
			mainFrame.dispose();
		} else if(e.getSource() == CheckInLayoutPrevBtn) {
			new HotelMainLayout();
			mainFrame.dispose();
		} else if(e.getSource() == NonMemberCheckLayoutPrevBtn) {
			new CheckInLayout();
			mainFrame.dispose();
		} else if(e.getSource() == MemberLoginLayoutPrevBtn) {
			new NonMemberCheckLayout();
			mainFrame.dispose();
		} else if(e.getSource() == ReservationInfoPrevBtn) {
			new ReservationInquiryLayout();
			mainFrame.dispose();
		} else if(e.getSource() == ReservationChkInNowPrevBtn) {
			new CheckInLayout();
			mainFrame.dispose();
		} else if(e.getSource() == ReservationChkInPrevBtn) {
			new ReservationChkInNow();
			mainFrame.dispose();
		} else if(e.getSource() == GuideMapLayoutPrevBtn) {
			new HotelMainLayout();
			mainFrame.dispose();
		} else if(e.getSource() == AdminLayoutPrevBtn) {
			new HotelMainLayout();
			mainFrame.dispose();
		}
	}
	
	public PrevBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.HotelMainLayoutPrevBtn = mainFrame.b5;
		
	}
	
	public PrevBtnActionListener(ReservationInquiryLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.ReservationInquiryLayoutPrevBtn = mainFrame.b2;
	}
	
	public PrevBtnActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.CheckInLayoutPrevBtn = mainFrame.b3;
	}

	public PrevBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.NonMemberCheckLayoutPrevBtn = mainFrame.b3;
	}
	
	public PrevBtnActionListener(MemberLoginLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.MemberLoginLayoutPrevBtn = mainFrame.b1;
	}

	public PrevBtnActionListener(ReservationInfo mainFrame) {
		this.mainFrame = mainFrame;
		this.ReservationInfoPrevBtn = mainFrame.b1;
	}
	
	public PrevBtnActionListener(ReservationChkInNow mainFrame) {
		this.mainFrame = mainFrame;
		this.ReservationChkInNowPrevBtn = mainFrame.b2;
	}
	
	public PrevBtnActionListener(ReservationChkIn mainFrame) {
		this.mainFrame = mainFrame;
		this.ReservationChkInPrevBtn = mainFrame.b1;
	}
	
	public PrevBtnActionListener(GuideMapLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.GuideMapLayoutPrevBtn = mainFrame.b1;
	}
	
	public PrevBtnActionListener(AdminLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.AdminLayoutPrevBtn = mainFrame.b1;
	}
}
