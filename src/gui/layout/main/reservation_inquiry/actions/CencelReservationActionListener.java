package gui.layout.main.reservation_inquiry.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.AdminDao;
import database.dbObjects.Reservation;
import gui.layout.main.reservation_inquiry.ReservationInfo;

public class CencelReservationActionListener implements ActionListener{
	JFrame mainFrame;
	JButton cencelBtn;
	Reservation reservstion;
	JOptionPane info = new JOptionPane();
	AdminDao admindao = new AdminDao();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cencelBtn) {
			System.out.println(reservstion.getReservation_number());
			admindao.setReservationChkOut(reservstion.getReservation_number());
			info.showMessageDialog(mainFrame, "예약이 취소되었습니다", "Message",JOptionPane.INFORMATION_MESSAGE );
		}
		
	}
	public CencelReservationActionListener(ReservationInfo mainFrame) {
		this.cencelBtn = mainFrame.b4;
		this.mainFrame = mainFrame;
		this.reservstion = mainFrame.reservstion;
	
	}
}
