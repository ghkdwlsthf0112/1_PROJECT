package gui.layout.main.check_in_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.chk_ismember.LoginChkLayout;
import gui.layout.main.check_in_window.CheckInLayout;

public class OnSitecCheckInActionListener implements ActionListener {
	JFrame mainFrame;
	JButton OnSitecCheckInBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == OnSitecCheckInBtn) {
			new LoginChkLayout();
			mainFrame.dispose();			
		}
	}
	
	public OnSitecCheckInActionListener(CheckInLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.OnSitecCheckInBtn = mainFrame.b2;
	}
}
