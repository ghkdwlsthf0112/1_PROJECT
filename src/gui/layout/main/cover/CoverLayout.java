package gui.layout.main.cover;


import java.awt.event.ActionListener;



import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.CoverBtnActionListener;
import gui.buttons.CoverBtn;
import image.getImages;

public class CoverLayout extends JFrame {
	ActionListener CoverBtnActionListener; 
	public static ImageIcon mainImage1 = new getImages().getImageIcon(768, 1024, "src/image/background_image/background1.png");
	public static ImageIcon mainImage2 = new getImages().getImageIcon(768, 1024, "src/image/background_image/background2.png");
	public JButton coverBtn = new CoverBtn(mainImage1);
	
	public CoverLayout() {
		setLayout(null);

		
		coverBtn.setBounds(0, 0, 768, 1024);
		
		coverBtn.addActionListener(new CoverBtnActionListener(this));
		add(coverBtn);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		
		new CoverLayout();
	}
}
