package gui.layout.login.non_member_check_in.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.create_id_window.SignUpInterface;
import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.login.non_member_check_in.NonMemberCheckLayout;

public class CreatIdBtnActionListener implements ActionListener{
	JButton CreateIDBtn;
	JFrame mainFrame;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== CreateIDBtn){
			new SignUpInterface();
		}
	}
	public CreatIdBtnActionListener(NonMemberCheckLayout mainFrame) {
		this.CreateIDBtn = mainFrame.b5;
		this.mainFrame = mainFrame;
		
	}
	
	public CreatIdBtnActionListener(MemberLoginLayout mainFrame) {
		this.CreateIDBtn = mainFrame.b6;
		this.mainFrame = mainFrame;
		
	}
}
