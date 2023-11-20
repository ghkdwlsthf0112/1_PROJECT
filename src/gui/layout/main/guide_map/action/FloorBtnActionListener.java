package gui.layout.main.guide_map.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import gui.layout.main.guide_map.GuideMapLayout;
import image.getImages;

public class FloorBtnActionListener implements ActionListener{
	JLabel floorLabel;
	int numImages;
	JButton f1;
	JButton f2;
	JButton f3;
	JButton f4;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon[] imagesLabel = new ImageIcon[numImages];
		for (int i = 0; i < numImages; i++) {
			imagesLabel[i] = new getImages().getImageIcon
					(650, 470, "src/image/guide_map/가이드맵예시" + (i + 1) + ".jpg");
		}
		if(e.getSource()== f1) {
			floorLabel.setIcon(imagesLabel[0]);
		} else if(e.getSource()== f2) {
			floorLabel.setIcon(imagesLabel[1]);
		} else if(e.getSource()== f3) {
			floorLabel.setIcon(imagesLabel[2]);
		} else if(e.getSource()== f4) {
			floorLabel.setIcon(imagesLabel[3]);
		} 
	}
	
	public FloorBtnActionListener(GuideMapLayout mainFrame) {
		this.floorLabel = mainFrame.floorLabel;
		this.numImages = mainFrame.numImages;
		this.f1 = mainFrame.f1;
		this.f2 = mainFrame.f2;
		this.f3 = mainFrame.f3;
		this.f4 = mainFrame.f4;
		
	}
	

}
