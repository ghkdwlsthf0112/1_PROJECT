package gui.layout.main.admin_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.admin_window.AdminLayout;
import gui.layout.main.admin_window.MemberManager;

public class AdminChkCustomerBtnActionListiner implements ActionListener{
	JFrame mainFrame;
	JButton ChkCustomerBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkCustomerBtn) {
			new MemberManager();
			mainFrame.dispose();
		}
		
	}
	public AdminChkCustomerBtnActionListiner(AdminLayout mainFrame) {
		this.ChkCustomerBtn = mainFrame.b5;
		this.mainFrame = mainFrame;
	}
}
