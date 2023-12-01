package gui.layout.main.reservation_window.actions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.ReservationDao;
import database.RoomDao;
import database.RoomImageDao;
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

	ReservationDao adminDao = new ReservationDao();
	JOptionPane info = new JOptionPane();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SearchBtn) {
			centerPanel.removeAll();

			// 지정기간에 사용중인 방 검색
			List<Room> resRooms = adminDao.getReservationRoom(mainFrame.chkInDateTextField.getText(),
					mainFrame.chkOutDateTextField.getText());
			
			// 방 전체 가져오기
			Map<Integer, Room> rooms = new RoomDao().getRoomsMap();
			// 예약 내용에 있는 방에서 지정기간 사용중인 방 삭제
//			Map<Integer, Room> rooms = new RoomDao().getRooms();
			for (Room room : resRooms) {
				rooms.remove(room.getRoom_number());
			}
			
				
			List<Room> availableRooms = rooms.values().stream().collect(Collectors.toCollection(ArrayList::new));	
			Collections.sort(availableRooms);	
			


			// 정렬
		    System.out.println(availableRooms.toString());
			reservation.setReservation_start(mainFrame.chkInDateTextField.getText());
			reservation.setReservation_end(mainFrame.chkOutDateTextField.getText());
			if (availableRooms != null && !availableRooms.isEmpty()) {
				System.out.println("체크인 가능한 방 목록");
				for (Room room : availableRooms) {
					
					JPanel addRoom = new JPanel(new GridLayout(1, 0, 2, 2));
					addRoom.setBackground(Color.white);
					JLabel roomImage = new JLabel();
					addRoom.setPreferredSize(new Dimension(600, 120));

//					ImageIcon Image;
//					if(room.getRoom_type().equals("럭셔리")) {
//						Image = new getImages().getImageIcon(200, 130, "src/image/hotel_image/럭셔리.jpg");
//					} else if(room.getRoom_type().equals("더블")) {
//						Image = new getImages().getImageIcon(200, 130, "src/image/hotel_image/더블.jpg");
//					} else {
//						Image = new getImages().getImageIcon(200, 130, "src/image/hotel_image/싱글.jpg");
//					}
					
					ImageIcon Image = new getImages().getImageIcon(200, 130, new RoomImageDao().getRoomImageRute(room.getRoom_number()).toString());
					roomImage.setIcon(Image);
					addRoom.add(roomImage);

					StringBuilder info = new StringBuilder();
					info.append("<html>" + room.getRoom_number().toString() + "호<br>");
					info.append(room.getRoom_type().toString() + "<br>");
					JLabel roomNum = new JLabel(info.toString());
					roomNum.setFont(new Font("굴림", Font.BOLD, 25));
					roomNum.setHorizontalAlignment(JLabel.CENTER);
					addRoom.add(roomNum);

					JLabel roomfare = new JLabel(room.getRoom_fare().toString() + "원");
					roomfare.setFont(new Font("굴림", Font.BOLD, 25));
					roomfare.setHorizontalAlignment(JLabel.RIGHT);

					addRoom.add(roomfare);

					JButton selectBtn = new SelectBtn();
					selectBtn.addActionListener(new AddRoomActionListener(mainFrame, room, selectBtn, addRoom));
					addRoom.add(selectBtn);
					centerPanel.add(addRoom);

				}
			} else {
				centerPanel.removeAll();
				info.showMessageDialog(mainFrame, "선택가능한 방이 없습니다", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
			scrollPane.setViewportView(centerPanel);
//			availableRooms.removeAll(availableRooms);
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
