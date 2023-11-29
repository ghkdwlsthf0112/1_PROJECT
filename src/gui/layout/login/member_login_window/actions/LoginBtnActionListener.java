package gui.layout.login.member_login_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.ReservationDao;
import database.dbObjects.Customer;
import gui.layout.login.member_login_window.MemberLoginLayout;
import gui.layout.main.reservation_window.ReservationLayout;
import pwdconv.PwdChange;

public class LoginBtnActionListener implements ActionListener {
	
	JButton loginBtn;
	JFrame mainFrame;
	JTextField eamil;
	JTextField password;
	ReservationDao adminDao = new ReservationDao();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loginBtn) {
			Customer member = adminDao.getCustomer(eamil.getText(), new PwdChange().getPassWordToXEMD5String(password.getText()));
			if(member.getCustomer_id() != null) {
				new ReservationLayout(member);
				mainFrame.dispose();
			} else {
				new JOptionPane().showMessageDialog(mainFrame, "아이디,비밀번호를 확인해주세요", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public LoginBtnActionListener(MemberLoginLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.eamil = mainFrame.eamil;
		this.password = mainFrame.password;
		this.loginBtn = mainFrame.b4;
	}
}
