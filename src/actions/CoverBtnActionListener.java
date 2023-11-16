package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.cover.CoverLayout;
import gui.layout.main.hotel_main.HotelMainLayout;


public class CoverBtnActionListener implements ActionListener {
	JButton coverBtn;
	ImageIcon mainImage1;
	ImageIcon mainImage2;
	JFrame mainFrame;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == coverBtn) {
			new HotelMainLayout();
			mainFrame.dispose();			
		}
	}
	public CoverBtnActionListener(CoverLayout mainFrame) {
		this.mainImage1 = mainFrame.mainImage1;
		this.mainImage2 = mainFrame.mainImage2;
		this.coverBtn = mainFrame.coverBtn;
		this.mainFrame = mainFrame;
		
	}

}
