package gui.layout.login.member_login_window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.login.member_login_window.actions.LoginBtnActionListener;
import gui.layout.login.member_login_window.buttons.FindIDBtn;
import gui.layout.login.member_login_window.buttons.LoginBtn;
import gui.layout.login.non_member_check_in.NonMemberTextField;
import gui.layout.login.non_member_check_in.buttons.CreateIDBtn;
import image.getImages;

public class MemberLoginLayout extends JFrame {
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background7.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon guideImage = new getImages().getImageIcon(80, 40, "src/image/icon_image/btn/RoomInfomationMap_white.png");
	static ImageIcon loginBtnImage = new getImages().getImageIcon(220, 100, "src/image/icon_image/btn/check.png");

	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	public JButton b3 = new FloorGuideBtn(guideImage);
	public JButton b4 = new LoginBtn(loginBtnImage);
	public JButton b5 = new FindIDBtn("아이디 찾기");
	public JButton b6 = new CreateIDBtn("아이디 만들기");

	public JTextField eamil = new NonMemberTextField();
	public JPasswordField password = new MemberPasswordField();

	public MemberLoginLayout() {
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 이메일 입력
		eamil.setLocation(370,360);
		Label.add(eamil); 
		
		// 비밀번호 입력
		password.setLocation(370,440);
		Label.add(password);
		
		
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
		
		
		b4.setBounds(260, 630, 220, 100);
		b4.addActionListener(new LoginBtnActionListener(this));
		Label.add(b4);
		
		
		b5.setBounds(260, 730, 110, 20);
		// 아이디 비밀번호 찾기 ->
		b5.addActionListener(null);
		Label.add(b5);
		
		b6.setBounds(370, 730, 110, 20);
		// 회원가입 창으로 ->
		b6.addActionListener(null);
		Label.add(b6);
		
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
