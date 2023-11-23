package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.chk_ismember.LoginChkLayout;
import gui.layout.login.member_login_window.MemberLoginLayout;

public class MemberBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton MemberBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == MemberBtn) {
			new MemberLoginLayout();
			mainFrame.dispose();
		}
		
	}
	
	public MemberBtnActionListener(LoginChkLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.MemberBtn = mainFrame.b1;
	}
}
