package gui.layout.main.admin_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.admin_window.AdminLayout;
import gui.layout.main.admin_window.AdminReservationHistory;

public class AdminChkHistoryBtnActionListiner implements ActionListener{
	JFrame mainFrame;
	JButton chkHistoryBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == chkHistoryBtn) {
			new AdminReservationHistory();
			mainFrame.dispose();
		}
		
	}
	public AdminChkHistoryBtnActionListiner(AdminLayout mainFrame) {
		this.chkHistoryBtn = mainFrame.b6;
		this.mainFrame = mainFrame;
	}
}
