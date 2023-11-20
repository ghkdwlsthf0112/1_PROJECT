package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//github.com/PigKidney/Hotel_teamProject.git
import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.check_in_window.CheckInLayout;
import gui.layout.main.guide_map.GuideMapLayout;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.main.reservation_inquiry.ReservationChkIn;
import gui.layout.main.reservation_inquiry.ReservationInfo;

public class FloorGuideBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton FloorGuideBtn;	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == FloorGuideBtn) {
			new GuideMapLayout();
			mainFrame.dispose();
		}
	}
	
	public FloorGuideBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b7;	
	}
	
	public FloorGuideBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b5;	
	}
	
	public FloorGuideBtnActionListener(MemberLoginLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b3;	
	}

	public FloorGuideBtnActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b5;	
	}
	
	public FloorGuideBtnActionListener(ReservationInfo mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b3;	
	}
	
	public FloorGuideBtnActionListener(ReservationChkIn mainFrame) {
		this.mainFrame = mainFrame;
		this.FloorGuideBtn = mainFrame.b3;	
	}
}
