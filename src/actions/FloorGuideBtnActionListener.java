package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.non_member_check_in.NonMemberCheckLayout;
import gui.layout.main.guide_map.GuideMapLayout;
import gui.layout.main.hotel_main.HotelMainLayout;

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

}
