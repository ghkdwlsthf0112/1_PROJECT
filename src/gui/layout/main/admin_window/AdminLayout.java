package gui.layout.main.admin_window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.admin_window.actions.AdminChkCustomerBtnActionListiner;
import gui.layout.main.admin_window.actions.AdminChkHistoryBtnActionListiner;
import gui.layout.main.admin_window.actions.AdminChkResActionListiner;
import gui.layout.main.admin_window.actions.ExitProgramActionListiner;
import gui.layout.main.admin_window.buttons.AdminChkCustomerBtn;
import gui.layout.main.admin_window.buttons.AdminChkHistory;
import gui.layout.main.admin_window.buttons.AdminChkResBtn;
import gui.layout.main.admin_window.buttons.EndBtn;
import image.getImages;

public class AdminLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	
	
	public JButton b1 = new PrevBtn();
	public JButton b2 = new HomeBtn();
	public JButton b3 = new EndBtn();
	
	public JButton b4 = new AdminChkResBtn();
	public JButton b5 = new AdminChkCustomerBtn();
	public JButton b6 = new AdminChkHistory();

	public AdminLayout() {
		setTitle("관리자페이지");
		setLayout(null);
		
		JLabel label = new JLabel();
		label.setBounds(0, 0, 768, 1024);
		label.setIcon(mainImage);
		add(label);
		
		// 예약내역 확인
		label.add(b4);
		b4.addActionListener(new AdminChkResActionListiner(this));
		
		// 사용자 관리
		label.add(b5);
		b5.addActionListener(new AdminChkCustomerBtnActionListiner(this));
		
		// history 보기
		label.add(b6);
		b6.addActionListener(new AdminChkHistoryBtnActionListiner(this));
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		label.add(b1);
				
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		label.add(b2);
				
		// 종료 버튼
		b3.addActionListener(new ExitProgramActionListiner(this));
		label.add(b3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
	
	
	public static void main(String[] args) {
		new AdminLayout();
	}
}


