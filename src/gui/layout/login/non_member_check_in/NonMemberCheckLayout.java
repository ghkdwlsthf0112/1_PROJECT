package gui.layout.login.non_member_check_in;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.dbObjects.Customer;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.login.non_member_check_in.actions.NonMemberOkBtnActionListener;
import gui.layout.login.non_member_check_in.buttons.nonMemberOkBtn;
import image.getImages;

public class NonMemberCheckLayout extends JFrame {
	
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background6.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	static ImageIcon okImage = new getImages().getImageIcon(220, 100, "src/image/icon_image/btn/Input.png");



	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new FloorGuideBtn(guideImage);
	public JButton b4 = new nonMemberOkBtn(okImage);

	public JTextField name = new NonMemberTextField();
	public JTextField phoneNum = new NonMemberTextField();
	public JTextField email = new NonMemberTextField();
	 
	public NonMemberCheckLayout() {
		super("비회원정보입력");
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 이름 입력
		name.setLocation(370,360);
		Label.add(name); 
		
		// 전화번호 입력
		phoneNum.setLocation(370,440);
		Label.add(phoneNum);
	
		// 이메일 입력
		email.setLocation(370,520);
		Label.add(email);
		
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
		
		// 안내 버튼
		b3.addActionListener(new FloorGuideBtnActionListener(this));
		Label.add(b3);
		
		b4.setBounds(270, 650, 220, 100);
		b4.addActionListener(new NonMemberOkBtnActionListener(this));
		Label.add(b4);
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new NonMemberCheckLayout();
	}
}
