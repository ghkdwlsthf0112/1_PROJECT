package gui.layout.main.cover;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;



import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import gui.layout.main.cover.actions.CoverBtnActionListener;
import gui.layout.main.cover.buttons.CoverBtn;
import image.getImages;

public class CoverLayout extends JFrame {
	ActionListener CoverBtnActionListener;
	public static ImageIcon mainImage1 = new getImages().getImageIcon(768, 1024,
			"src/image/background_image/background1.png");
	public static ImageIcon mainImage2 = new getImages().getImageIcon(768, 1024,
			"src/image/background_image/background2.png");
	public JButton coverBtn = new CoverBtn(mainImage1);

	public CoverLayout() {
		setLayout(null);

		coverBtn.setBounds(0, 0, 768, 1024);

		coverBtn.addActionListener(new CoverBtnActionListener(this));
		add(coverBtn);

//		File f7 = new File("src/image/background_image/");
//		String[] files = f7.list();
//		for (String f : files) {
//			Timer timer = new Timer(3000, new ActionListener() {
//
//				public void actionPerformed(ActionEvent e)
//
//				{
//
//					mainImage2 = new getImages().getImageIcon(768, 1024, "src/image/background_image/" + f);
//					coverBtn.setIcon(mainImage2);
//					add(coverBtn);
//				}
//
//			});
//			timer.start();
//
//			try {
//
//				Thread.sleep(5000);
//
//			} catch (Exception e) {
//			}
//
//			timer.stop();
//
//		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
}



