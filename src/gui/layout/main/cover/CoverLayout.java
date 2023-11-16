package gui.layout.main.cover;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoverLayout extends JFrame {
	public CoverLayout() {
		super("델루나호텔");
		setLayout(new BorderLayout());
		
		JLabel mainLabel = new JLabel();
		JLabel logoLabel = new JLabel();
		
		try {
			BufferedImage Image1 = 
					ImageIO.read(new File("src/image/hotel_image/델루나 메인.png"));
			BufferedImage Image2 = 
					ImageIO.read(new File("src/image/hotel_logo/delunaHotelLogo_white.png"));

			//bg = new ImageIcon("델루나 메인.png");
					
			 Image scaledImage1 =
						Image1.getScaledInstance(768, 1024, Image.SCALE_SMOOTH);
			 Image scaledImage2 =
						Image2.getScaledInstance(768, 400, Image.SCALE_SMOOTH);
			 
			 mainLabel.setIcon(new ImageIcon(scaledImage1));
			 logoLabel.setIcon(new ImageIcon(scaledImage2));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setSize(768,400);
		panel.setBackground(new Color(0,0,0,0));
		add(panel);
		panel.add(logoLabel);
		
		add(mainLabel, "Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CoverLayout();
	}
}
