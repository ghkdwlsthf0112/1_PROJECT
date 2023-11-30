package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.dbObjects.Customer;
import database.dbObjects.Payment;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.paymentWindow.check_totalpay_window.AgreePopupLayout;
import gui.layout.paymentWindow.check_totalpay_window.CheckTotalpayLayout;

public class ConfirmedBtnActionListener implements ActionListener{
	Reservation reservstion;
	Customer customer;
	Room room;
	Payment payment;
	JFrame mainFrame;
	JButton OkBtn;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == OkBtn) {
			new AgreePopupLayout(reservstion, customer, room, payment, mainFrame);
		}
		
	}
	
	public ConfirmedBtnActionListener(CheckTotalpayLayout mainFrame) {
		this.reservstion = mainFrame.reservstion;
		this.customer = mainFrame.customer;
		this.payment = mainFrame.payment;
		this.room = mainFrame.room;
		this.OkBtn = mainFrame.b3;
		this.mainFrame = mainFrame;
	}
	
	
}
