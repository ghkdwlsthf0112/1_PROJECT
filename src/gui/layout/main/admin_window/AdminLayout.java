package gui.layout.main.admin_window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.AdminDao;
import database.reservation.Reservation;
import image.getImages;

public class AdminLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	List<Reservation> list = new ArrayList<>();
	
	public AdminLayout() {
		setTitle("관리자페이지");
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		add(Label);
		
		list = new AdminDao().getReservstion();
		
		JLabel reservationInfo = new JLabel();
		reservationInfo.setLayout(new GridLayout(15, 0));
		for(int i = 0 ; i < list.size() ; i++) {
			JLabel info = new JLabel(list.get(i).toString());
			info.setFont(new Font("굴림", Font.BOLD, 15));
			info.setBackground(Color.white);
			reservationInfo.add(info);
		}
		reservationInfo.setBounds(50, 300, 650, 470);
		Label.add(reservationInfo);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new AdminLayout();
	}
}
