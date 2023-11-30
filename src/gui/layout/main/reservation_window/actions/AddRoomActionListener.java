package gui.layout.main.reservation_window.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.reservation_window.ReservationLayout;

public class AddRoomActionListener implements ActionListener{
	JFrame mainFrame;
	JButton roomBtn;
	Reservation reservation;
	Room selectRoom;
	JPanel addRoom;
	JTextField choiceRoomInfo;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== roomBtn) {
			choiceRoomInfo.setText(selectRoom.toString());
			reservation.setRoom_number(selectRoom.getRoom_number());
//			addRoom.setBackground(Color.lightGray);
		}
	}
	public AddRoomActionListener(ReservationLayout mainFrame, Room selectRoom , JButton selectBtn , JPanel addRoom) {
		this.mainFrame = mainFrame;
		this.roomBtn = selectBtn;
		this.selectRoom = selectRoom;
		this.reservation = mainFrame.reservation;
		this.addRoom = addRoom;
		this.choiceRoomInfo = mainFrame.choiceRoomInfo;
	}
}
