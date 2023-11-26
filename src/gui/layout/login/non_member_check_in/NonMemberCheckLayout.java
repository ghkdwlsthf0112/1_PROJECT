package gui.layout.login.non_member_check_in;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.login.non_member_check_in.actions.CreatIdBtnActionListener;
import gui.layout.login.non_member_check_in.actions.NonMemberOkBtnActionListener;
import gui.layout.login.non_member_check_in.buttons.CreateIDBtn;
import gui.layout.login.non_member_check_in.buttons.NonMemberOkBtn;
import image.getImages;

public class NonMemberCheckLayout extends JFrame {
	
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background6.png");



	public JButton b1 = new PrevBtn();
	public JButton b2 = new HomeBtn();
	public JButton b3 = new FloorGuideBtn();
	public JButton b4 = new NonMemberOkBtn();
	public JButton b5 = new CreateIDBtn();

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
		name.setLocation(270,330);
		Label.add(name); 
		
		// 전화번호 입력
		phoneNum.setLocation(270,428);
		Label.add(phoneNum);
	
		// 이메일 입력
		email.setLocation(270,525);
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
		
		b4.addActionListener(new NonMemberOkBtnActionListener(this));
		Label.add(b4);
		
		b5.setBounds(330, 620, 110, 20);
		// 회원가입 창으로 ->
		b5.addActionListener(new CreatIdBtnActionListener(this));
		Label.add(b5);
		
		add(Label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new NonMemberCheckLayout();
	}
}
