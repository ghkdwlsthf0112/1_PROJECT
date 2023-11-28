package gui.layout.main.reservation_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.reservation_window.ReservationLayout;
import gui.layout.paymentWindow.check_totalpay_window.CheckTotalpayLayout;

public class NextBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton nextBtn;
	Customer customer;
	Reservation reservation;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nextBtn) {
			new CheckTotalpayLayout(reservation, customer);
			System.out.println(reservation.toString());
			System.out.println(customer.toString());
			mainFrame.dispose();
		}
		
	}
	
	public NextBtnActionListener(ReservationLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.nextBtn = mainFrame.b3;
		this.customer = mainFrame.customer;
		this.reservation = mainFrame.reservation;
	}
}
