package gui.layout.login.chk_ismember;

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
import gui.layout.login.chk_ismember.actions.MemberBtnActionListener;
import gui.layout.login.chk_ismember.actions.NonMemberBtnActionListener;
import gui.layout.login.chk_ismember.buttons.MemberBtn;
import gui.layout.login.chk_ismember.buttons.NonmemberBtn;
import image.getImages;

public class LoginChkLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon memberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/MemberCustomers.png");
	static ImageIcon nonmemberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/NonMemberCustomers.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	

	public JButton b1 = new MemberBtn (memberImage);
	public JButton b2 = new NonmemberBtn (nonmemberImage);
	public JButton b3 = new PrevBtn(backImage);
	public JButton b4 = new HomeBtn(homeImage);
	public JButton b5 = new FloorGuideBtn(guideImage);

	 
	public LoginChkLayout() {
		super();
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 회원고객 버튼
		b1.addActionListener(new MemberBtnActionListener(this));
		b1.setBounds(25, 440, 700, 170);
		Label.add(b1);
		
		// 비회원고객 버튼
		b2.addActionListener(new NonMemberBtnActionListener(this));
		b2.setBounds(25, 615, 700, 170);
		Label.add(b2);
		
		// 뒤로가기 버튼
		b3.addActionListener(new PrevBtnActionListener(this));
		Label.add(b3);
		
		// 홈 버튼
		b4.addActionListener(new HomeBtnActionListener(this));
		Label.add(b4);
		
		// 안내 버튼
		b5.addActionListener(new FloorGuideBtnActionListener(this));
		Label.add(b5);
		
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
   
}
