package gui.layout.login.member_login_window;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class MemberLoginLayout extends JFrame {
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	
	public JButton b1 = new PrevBtn(backImage);
	ActionListener PrevBtnActionListener;
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new FloorGuideBtn(guideImage);
	ActionListener FloorGuideBtnActionListener;
	
	public MemberLoginLayout() {
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
		
		// 안내 버튼
		b3.addActionListener(new FloorGuideBtnActionListener(this));
		b3.setBorderPainted(false);
		Label.add(b3);
		
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new MemberLoginLayout();
	}
}
