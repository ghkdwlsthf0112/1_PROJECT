package gui.layout.main.admin_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.admin_window.AdminChkResv;
import gui.layout.main.admin_window.AdminLayout;

public class AdminChkResActionListiner implements ActionListener {
	JFrame mainFrame;
	JButton chkResBtn;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chkResBtn) {
			new AdminChkResv();
			mainFrame.dispose();
		}
	}

	public AdminChkResActionListiner(AdminLayout mainFrame) {
		this.chkResBtn = mainFrame.b4;
		this.mainFrame = mainFrame;
	}
}
