package gui.layout.main.check_out_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.AdminDao;
import gui.layout.main.check_out_window.CheckOut;
import gui.layout.main.reservation_inquiry.ReservationChkIn;
import gui.layout.main.reservation_inquiry.ReservationInfo;

public class ChkOutResvBtnActionListener implements ActionListener{
	
	JButton ChkOutBtn;
	JFrame mainFrame;
	JTextField displayField;
	JOptionPane info = new JOptionPane();
	AdminDao admindao = new AdminDao();

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkOutBtn) {
			System.out.println(displayField.getText());
			
			if(admindao.setReservationChkOut(displayField.getText()) == 1) {
				// 체크아웃되면 방 상태도 업데이트
				if (admindao.updateChkOutRoom(displayField.getText()) == 1) {
					info.showMessageDialog(mainFrame, "체크아웃되었습니다.", "Message",JOptionPane.INFORMATION_MESSAGE );
				}
			} else {
				info.showMessageDialog(mainFrame, "확인되는 예약이 없습니다.", "Message",JOptionPane.ERROR_MESSAGE );
			}
		}
	}
	
	public ChkOutResvBtnActionListener(CheckOut mainFrame) {
		this.ChkOutBtn = mainFrame.b3;
		this.mainFrame = mainFrame;
		this.displayField = mainFrame.displayField;
	}
}
