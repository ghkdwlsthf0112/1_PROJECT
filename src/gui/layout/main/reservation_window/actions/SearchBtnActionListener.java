package gui.layout.main.reservation_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.AdminDao;
import database.dbObjects.Room;
import gui.layout.main.reservation_window.ReservationLayout;

public class SearchBtnActionListener implements ActionListener {

	JButton SearchBtn;
	JFrame mainFrame;
	AdminDao adminDao = new AdminDao();
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SearchBtn) {
			List<Room> availableRooms = adminDao.getAvailableCheckInRoom(
					ReservationLayout.chkInDateTextField.getText(),
					ReservationLayout.chkOutDateTextField.getText()
			);
			
			if (availableRooms != null && !availableRooms.isEmpty()) {
				System.out.println("체크인 가능한 방 목록");
				for (Room room : availableRooms) {
					System.out.println(room.getRoom_number()+"호" + "-" + room.getRoom_type()+"타입");
				}
			} else {
				System.out.println("체크인 가능한 방이 없습니다.");
			}
		}
	}
	
	public SearchBtnActionListener(ReservationLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.SearchBtn = mainFrame.searchBtn;
	}
}
