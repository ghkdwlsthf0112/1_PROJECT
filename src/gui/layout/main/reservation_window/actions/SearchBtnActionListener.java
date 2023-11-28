package gui.layout.main.reservation_window.actions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.AdminDao;
import database.dbObjects.Reservation;
import database.dbObjects.Room;
import gui.layout.main.reservation_window.ReservationLayout;
import gui.layout.main.reservation_window.buttons.SelectBtn;
import image.getImages;

public class SearchBtnActionListener implements ActionListener {

	JButton SearchBtn;
	ReservationLayout mainFrame;
	JPanel centerPanel;
	JScrollPane scrollPane;
	Reservation reservation;
	
	AdminDao adminDao = new AdminDao();
	JOptionPane info = new JOptionPane();
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SearchBtn) {
			List<Room> availableRooms = adminDao.getAvailableCheckInRoom(
					ReservationLayout.chkInDateTextField.getText(),
					ReservationLayout.chkOutDateTextField.getText()
			);
			reservation.setReservation_start(ReservationLayout.chkInDateTextField.getText());
			reservation.setReservation_end(ReservationLayout.chkOutDateTextField.getText());
			if (availableRooms != null && !availableRooms.isEmpty()) {
				System.out.println("체크인 가능한 방 목록");
				for (Room room : availableRooms) {
					System.out.println(room.getRoom_number()+"호" + "-" + room.getRoom_type()+"타입");
					JPanel addRoom= new JPanel(new GridLayout(1,0,2,2));
					addRoom.setBackground(Color.white);
					JLabel roomImage = new JLabel();
					addRoom.setPreferredSize(new Dimension(600,120));
		
					ImageIcon Image = new getImages().getImageIcon(200, 130, "src/image/hotel_image/디럭스룸1.png");
					roomImage.setIcon(Image);
					addRoom.add(roomImage);
					
					StringBuilder info = new StringBuilder();
					info.append("<html>"+room.getRoom_number().toString()+"호<br>");
					info.append(room.getRoom_type().toString()+"<br>");
					JLabel roomNum = new JLabel(info.toString());
					roomNum.setFont(new Font("굴림", Font.BOLD, 25));
					roomNum.setHorizontalAlignment(JLabel.CENTER);
					addRoom.add(roomNum);
					
					JLabel roomfare = new JLabel(room.getRoom_fare().toString()+"원");
					roomfare.setFont(new Font("굴림", Font.BOLD, 25));
					roomfare.setHorizontalAlignment(JLabel.RIGHT);

					addRoom.add(roomfare);
					
					JButton selectBtn = new SelectBtn();
					selectBtn.addActionListener(new AddRoomActionListener(mainFrame, room ,selectBtn));
					addRoom.add(selectBtn);
					centerPanel.add(addRoom);
					
				}
			} else {
				centerPanel.removeAll();
				info.showMessageDialog(mainFrame, "선택가능한 방이 없습니다", "Message",JOptionPane.INFORMATION_MESSAGE );
				System.out.println("체크인 가능한 방이 없습니다.");
			}
			scrollPane.setViewportView(centerPanel);
		}
	}
	
	public SearchBtnActionListener(ReservationLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.SearchBtn = mainFrame.searchBtn;
		this.scrollPane = mainFrame.scrollPane;
		this.centerPanel = mainFrame.centerPanel;
		this.reservation = mainFrame.reservation;
	}
}
