package gui.layout.login.non_member_check_in;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.buttons.ChkInBtn;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class NonMemberCheckLayout extends JFrame {
	ActionListener MemberBtnActionLister;
	ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	ImageIcon memberImage = new getImages().getImageIcon(700, 180, "src/image/icon_image/btn/MemberCustomers.png");
	ImageIcon nonmemberImage = new getImages().getImageIcon(700, 180, "src/image/icon_image/btn/NonMemberCustomers.png");
	ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	
	JButton b1 = new ChkInBtn (memberImage);
	JButton b2 = new ChkInBtn (nonmemberImage);
	JButton b3 = new PrevBtn(backImage);
	JButton b4 = new HomeBtn(homeImage);
	JButton b5 = new FloorGuideBtn(guideImage);
	
	//JButton 
 
	public NonMemberCheckLayout() {
		super("델루나호텔");
		setLayout(null);
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 회원고객 버튼
		b1.setBounds(25, 450, 700, 180);
		b1.setBackground(new Color(0,0,0,0));
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		Label.add(b1);
		
		// 비회원고객 버튼
		b2.setBounds(25, 700, 700, 180);
		b2.setBackground(new Color(0,0,0,0));
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		Label.add(b2);
		
		// 뒤로가기 버튼
		b3.setBounds(20, 920, 40, 40);
		b3.setBackground(new Color(0,0,0,0));
		b3.setBorderPainted(false);
		Label.add(b3);
		
		// 홈 버튼
		b4.setBounds(80, 920, 40, 40);
		b4.setBackground(new Color(0,0,0,0));
		b4.setBorderPainted(false);
		Label.add(b4);
		
		// 안내 버튼
		b5.setBounds(140, 920, 80, 40);
		b5.setBackground(new Color(0,0,0,0));
		b5.setBorderPainted(false);
		Label.add(b5);
		
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(true);
	}
	public static void main(String[] args) {
		new NonMemberCheckLayout();
	}
}
