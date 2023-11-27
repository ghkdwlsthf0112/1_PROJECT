package gui.layout.login.member_login_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.CustomerDao;
import gui.layout.login.findIdPwd.Id_PwdFind;
import gui.layout.login.member_login_window.MemberLoginLayout;

public class FindIdPwdBtnActionListener  implements ActionListener{
	JButton findIDBtn;
	JFrame mainFrame;

	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== findIDBtn) {
			new Id_PwdFind();
		}
	}
	
	
	public FindIdPwdBtnActionListener(MemberLoginLayout mainFrame) {
		this.findIDBtn = mainFrame.b5;
		this.mainFrame = mainFrame;
		
	}
}
