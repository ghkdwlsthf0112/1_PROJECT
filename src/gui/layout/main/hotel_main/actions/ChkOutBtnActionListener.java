package gui.layout.main.hotel_main.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.check_out_window.CheckOut;
import gui.layout.main.hotel_main.HotelMainLayout;

public class ChkOutBtnActionListener implements ActionListener {
	JFrame mainFrame;
	JButton ChkOutBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ChkOutBtn) {
			new CheckOut();
			mainFrame.dispose();
		}
	}
	
	public ChkOutBtnActionListener(HotelMainLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.ChkOutBtn = mainFrame.b2;
	}
}
