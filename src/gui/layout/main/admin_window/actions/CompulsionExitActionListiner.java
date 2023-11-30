package gui.layout.main.admin_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import database.ReservationDao;
import gui.layout.main.admin_window.AdminChkResv;
import oracle.jdbc.logging.annotations.StringBlinder;

public class CompulsionExitActionListiner implements ActionListener {
	AdminChkResv mainFrame;
	JButton compulsionBtn;
	JTextPane room;
	StringBuilder selectRes;
	
	ReservationDao resDao = new ReservationDao();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == compulsionBtn) {
			System.out.println("확인"+selectRes);
			resDao.adminCompulsionChkOut(selectRes.toString().trim());
			new JOptionPane().showMessageDialog(mainFrame, "강제로 체크아웃되었습니다", "Message",JOptionPane.INFORMATION_MESSAGE );
			new AdminChkResv();
			mainFrame.dispose();
		}
	}

	public CompulsionExitActionListiner(AdminChkResv mainFrame) {
		this.compulsionBtn = mainFrame.compulsionBtn;
		this.mainFrame = mainFrame;
		this.room = mainFrame.selectRoomInfo;
		this.selectRes = mainFrame.selectRes;
	}
}
