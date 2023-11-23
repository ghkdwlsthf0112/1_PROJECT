package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.chk_ismember.LoginChkLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;

public class NonMemberBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton NonMemberBtn;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NonMemberBtn) {
			new NonMemberCheckLayout();
			mainFrame.dispose();
		}
		
	}
	
	public NonMemberBtnActionListener(LoginChkLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.NonMemberBtn = mainFrame.b2;
	}
}
