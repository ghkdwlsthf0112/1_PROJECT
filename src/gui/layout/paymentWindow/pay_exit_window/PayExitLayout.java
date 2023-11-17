package gui.layout.paymentWindow.pay_exit_window;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.HomeBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class PayExitLayout extends JFrame {
	
	
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	
	JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	
	public PayExitLayout() {
		super("델루나호텔");
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		
		// 뒤로가키 버튼
		b1.setBounds(20, 920, 40, 40);
		b1.setBackground(new Color(0,0,0,0));
		b1.setBorderPainted(false);
		Label.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		b2.setBounds(80, 920, 40, 40);
		b2.setBackground(new Color(0,0,0,0));
		b2.setBorderPainted(false);
		Label.add(b2);
		
		add(Label);
		
		setBounds(new Rectangle(200, 200, 500, 400));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}

	
	public static void main(String[] args) {
		new PayExitLayout();
	}

}
