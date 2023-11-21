package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.admin_window.AdminLayout;
import gui.layout.main.hotel_main.HotelMainLayout;

public class AdminBtnActionListener implements ActionListener{
	JFrame mainFrame;
	JButton adminBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adminBtn) {
			new AdminLayout();
			mainFrame.dispose();
		}
	}
	
	public AdminBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.adminBtn = mainFrame.b4;
	}
	
}
