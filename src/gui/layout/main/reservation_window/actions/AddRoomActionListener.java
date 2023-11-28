package gui.layout.main.reservation_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.reservation_window.ReservationLayout;

public class AddRoomActionListener implements ActionListener{
	JFrame mainFrame;
	JButton roomBtn;
	Reservation reservation;
	Room selectRoom;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== roomBtn) {
			reservation.setRoom_number(selectRoom.getRoom_number());
		}
	}
	public AddRoomActionListener(ReservationLayout mainFrame, Room selectRoom , JButton selectBtn) {
		this.mainFrame = mainFrame;
		this.roomBtn = selectBtn;
		this.selectRoom = selectRoom;
		this.reservation = mainFrame.reservation;
	}
}
