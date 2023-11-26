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
	final protected static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/회원비회원선택화면.png");
	

	public JButton b1 = new MemberBtn();
	public JButton b2 = new NonmemberBtn();
	public JButton b3 = new PrevBtn();
	public JButton b4 = new HomeBtn();
	public JButton b5 = new FloorGuideBtn();

	 
	public LoginChkLayout() {
		super();
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		// 회원고객 버튼
		b1.addActionListener(new MemberBtnActionListener(this));
		Label.add(b1);
		
		// 비회원고객 버튼
		b2.addActionListener(new NonMemberBtnActionListener(this));
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
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
   
}
