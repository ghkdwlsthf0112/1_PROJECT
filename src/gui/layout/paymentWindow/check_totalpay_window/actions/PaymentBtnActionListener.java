package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.dbObjects.Customer;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.hotel_main.HotelMainLayout;
import gui.layout.paymentWindow.check_totalpay_window.AgreePopupLayout;
import oracle.net.aso.j;

public class PaymentBtnActionListener implements ActionListener{
	Reservation reservstion;
	Customer customer;
	Room room;
	
	JButton paymentBtn;
	JFrame prevMainFrame;
	JFrame mainFrame;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == paymentBtn) {
			new HotelMainLayout();
			mainFrame.dispose();
			prevMainFrame.dispose();
		}
	}
	
	public PaymentBtnActionListener(AgreePopupLayout mainFrame) {
		this.reservstion = mainFrame.reservstion;
		this.customer = mainFrame.customer;
		this.room = mainFrame.room;
		this.prevMainFrame = mainFrame.prevMainFrame;
		this.paymentBtn = mainFrame.paymentBtn;
		this.mainFrame = mainFrame;
	
	}
}
