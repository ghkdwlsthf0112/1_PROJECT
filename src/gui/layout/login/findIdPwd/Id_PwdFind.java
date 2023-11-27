package gui.layout.login.findIdPwd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import actions.EmailSend;
import database.CustomerDao;
import database.dbObjects.Customer;

public class Id_PwdFind extends JDialog implements ActionListener {

	private JPanel pan01 = new JPanel(new GridLayout(3, 1));
	private JPanel pan02 = new JPanel(new FlowLayout());
	private JPanel pan03 = new JPanel(new BorderLayout(70, 10));
	private JPanel pan04 = new JPanel(new GridLayout(3, 2));
	private JPanel pan04_Grid1 = new JPanel(new FlowLayout());
	private JPanel pan04_Grid2 = new JPanel(new FlowLayout());
	private JPanel pan05 = new JPanel(new FlowLayout());

	private JTabbedPane jtab = new JTabbedPane();

	private JPanel pan01_01 = new JPanel(new GridLayout(3, 1));
	private JPanel pan02_01 = new JPanel(new FlowLayout());
	private JPanel pan03_01 = new JPanel(new BorderLayout(70, 10));
	private JPanel pan04_01 = new JPanel(new GridLayout(3, 2));
	private JPanel pan04_01_Grid1 = new JPanel(new FlowLayout());
	private JPanel pan04_01_Grid2 = new JPanel(new FlowLayout());
	private JPanel pan05_01 = new JPanel(new FlowLayout());

	private JPanel pan01_02 = new JPanel(new BorderLayout());
	private JPanel pan02_02 = new JPanel(new FlowLayout());
	private JPanel pan03_02 = new JPanel(new BorderLayout(70, 100));
	private JPanel pan04_02 = new JPanel(new GridLayout(8,1));
	private JPanel pan04_02_Grid1 = new JPanel(new FlowLayout());
	private JPanel pan04_02_Grid2 = new JPanel(new FlowLayout());
	private JPanel pan04_02_Grid3 = new JPanel(new FlowLayout());
	private JPanel pan04_02_Grid4 = new JPanel(new FlowLayout());
	private JPanel pan04_02_Grid5 = new JPanel(new FlowLayout());
	private JPanel pan04_02_Grid6 = new JPanel(new FlowLayout());
	private JPanel pan05_02 = new JPanel(new FlowLayout());

	private JButton findbtn = new JButton("아이디(이메일)찾기"); //아이디(이메일)찾기 버튼
	private JButton findbtn_01 = new JButton("비밀번호 찾기"); //비밀번호 찾기 버튼
	private JButton changePwdbtn = new JButton("비밀번호 변경"); //비밀번호 변경 버튼

	
	// 아이디 찾기에 사용되는 라벨, 텍스트필드, 콤보박스
	
	private JLabel infoname1 = new JLabel("이름");
	private JTextField txname1 = new JTextField(15);
	private JLabel infophone = new JLabel("전화번호");
	String[] phoneNum = { "010", "011", "016", "017", "018", "019" };
	private JComboBox phoneNum1 = new JComboBox(phoneNum); // 전화번호 앞자리
	private JLabel phonedash = new JLabel("-"); // -
	private JLabel phonedash1 = new JLabel("-"); // -
	private JTextField phoneNum2 = new JTextField(5); // 전화번호 가운데 자리
	private JTextField phoneNum3 = new JTextField(5); // 전화번호 마지막 자리

	// 비밀번호 찾기에 사용되는 라벨, 텍스트필드, 콤보박스
	
	private JLabel infoname = new JLabel("이름");
	
	private JTextField txname = new JTextField(15);
	String[] emailDomain = { "직접입력", "naver.com", "daum.net", "gmail.com", "yahoo.com", "kakao.com" };
	private JComboBox emailBox = new JComboBox(emailDomain);
	
	// 비밀번호 찾기에 사용되는 라벨, 텍스트필드, 콤보박스
	private JLabel infoemail_01 = new JLabel("이메일");
	private JLabel infoid = new JLabel("이메일");

	private JTextField txemail_01 = new JTextField(10); // 비밀번호 찾기
	private JLabel emaildash = new JLabel("@"); // @
	private JLabel nolabel = new JLabel("                          ");
	
	
	//비밀번호 변경에 사용되는 라벨, 텍스트필드, 콤보박스
	private JLabel infoEmail1 = new JLabel("이메일");
	private JTextField txemail_02 = new JTextField(10);
	private JLabel emaildash_pwchange = new JLabel("@");
	String[] emailDomain_pwdChange = { "", "naver.com", "daum.net", "gmail.com", "yahoo.com", "kakao.com" };
	private JComboBox emailBox_change = new JComboBox(emailDomain_pwdChange);
	private JLabel nowPwd = new JLabel("현재 비밀번호");
	private JTextField txnowPwd = new JTextField(15);
	private JLabel changePwd = new JLabel("변경할 비밀번호");
	private JTextField txchangePwd = new JTextField(15);
	private JLabel changePwdchk = new JLabel("비밀번호 확인");
	private JTextField txchangePwdchk = new JTextField(15);

	
	
	CustomerDao cdao = new CustomerDao();
	Customer custom = new Customer();
	EmailSend ne = new EmailSend();

	public Id_PwdFind() {
		panelInfoSet();
		eventInfoSet();
		setTitle("아이디 / 비밀번호찾기 / 비밀번호 변경");

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("h_icon.jpg");
		setIconImage(img);

		setSize(500, 400);
		setVisible(true);
		setResizable(false);
		Dimension tsc = Toolkit.getDefaultToolkit().getScreenSize();// 화면 사이즈
		Dimension mySize = getSize();// 띄우는 창 사이즈
		setLocation(tsc.width / 2 - mySize.width / 2, tsc.height / 2 - mySize.height / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 아이디 찾기 버튼 클릭시 이벤트 발생
		if (e.getSource() == findbtn) {
			String name = txname1.getText();
			String phone01 = (String) phoneNum1.getSelectedItem();
			System.out.println(phone01);
			String phoneNum = phone01 + "-" + phoneNum2.getText() + "-" + phoneNum3.getText(); // 입력한 값 저장
			System.out.println(phoneNum);
			boolean gaind_id = cdao.getFindemail(name, phoneNum);
			System.out.println(gaind_id);
			if (gaind_id == false) {
				JOptionPane.showMessageDialog(this, "입력하신 정보를 찾을 수 없습니다!", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				List<String> getlist = cdao.getIdList(name, phoneNum);
				String sc = "";
				if (getlist.size() > 0) {
					for (int i = 0; i < getlist.size(); i++) {
						sc += (String) getlist.get(i) + " ";
					}
					JOptionPane.showMessageDialog(this, "회원님의 아이디는" + sc + "입니다", "이메일(아이디) 찾기",
							JOptionPane.INFORMATION_MESSAGE);
				}
				ne.EmailSend(name, phoneNum);
				JOptionPane.showMessageDialog(this, "이메일이 발송 되었습니다.");
			} // if~else
		} // if findbtn 아이디 찾기

		
		// 비밀번호 찾기 이벤트 발생시
		if (e.getSource() == findbtn_01) {
			String email = txemail_01.getText() + "@" + (String) emailBox.getSelectedItem();// 입력한 값 저장
			String name = txname.getText();
			System.out.println(email + "     " + name);
			boolean gaind_pwd = cdao.getFindpwd(name, email);
			if (gaind_pwd == false) {
				JOptionPane.showMessageDialog(this, "입력하신 정보를 찾을 수 없습니다!", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				String randPwd = cdao.randomPWD();// 임시 비번 저장
				custom.setCustomer_password(randPwd);
				custom.setCustomer_email(email);
				int re = cdao.getUpdatePWD(custom);// 임시 비번 암호화 수정
				if (re == 1) {
					ne.pwd_Email(name, email, randPwd);
					JOptionPane.showMessageDialog(this, "이메일이 발송 되었습니다.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "이메일이 발송이 실패하였습니다.");
				}
			}
		} // 비밀번호 찾기
		
		if (e.getSource() == changePwdbtn) {
			String email = txemail_02.getText() + "@" + (String) emailBox_change.getSelectedItem();// 입력한 값 저장
			String nowPassword = txname.getText();
			//System.out.println(email + "     " + name);
			boolean gaind_pwd = cdao.pwdCheck(email,nowPassword);
			if (gaind_pwd == false) {
				JOptionPane.showMessageDialog(this, "입력하신 정보를 찾을 수 없습니다!", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				String randPwd = cdao.randomPWD();// 임시 비번 저장
				custom.setCustomer_password(randPwd);
				custom.setCustomer_email(email);
				int re = cdao.getUpdatePWD(custom);// 임시 비번 암호화 수정
				if (re == 1) {
					JOptionPane.showMessageDialog(this, "이메일이 발송 되었습니다.");
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "이메일이 발송이 실패하였습니다.");
				}
			}
		} // 비밀번호 변경b
		
		
	}

	
	public void eventInfoSet() {
		findbtn.addActionListener(this);
		findbtn_01.addActionListener(this);
		changePwdbtn.addActionListener(this);
	}

	public void panelInfoSet() {
		jtab.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		jtab.add("아이디 찾기", pan01);// 첫번째 탭
		jtab.setBackground(Color.WHITE);

		pan01.setBackground(Color.white);
		pan02.setBackground(Color.white);
		pan03.setBackground(Color.white);
		pan04.setBackground(Color.white);
		pan04_Grid1.setBackground(Color.white);
		pan04_Grid2.setBackground(Color.white);
		pan05.setBackground(Color.white);
		pan01.add(pan02);
		pan01.add(pan03);
		pan03.add("Center", pan04);
		pan03.add("East", new Label());
		pan03.add("West", new Label());
		pan04.add(pan04_Grid1);
		pan04.add(pan04_Grid2);
		
		pan04_Grid1.add(infoname1);
		infoname1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_Grid1.add(txname1);

		pan04_Grid2.add(infophone);
		infophone.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_Grid2.add(phoneNum1);
		pan04_Grid2.add(phonedash1);
		pan04_Grid2.add(phoneNum2);
		pan04_Grid2.add(phonedash);
		pan04_Grid2.add(phoneNum3);

		pan01.add(pan05);
		pan05.add(findbtn);
		findbtn.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		findbtn.setBackground(Color.gray);
		findbtn.setForeground(Color.WHITE);

		// 비밀번호 찾기 탭페이지 설정
		jtab.add("비밀번호 찾기", pan01_01);// 두번째 탭
		pan01_01.setBackground(Color.white);
		pan02_01.setBackground(Color.white);
		pan03_01.setBackground(Color.white);
		pan04_01.setBackground(Color.white);
		pan04_01_Grid1.setBackground(Color.white);
		pan04_01_Grid2.setBackground(Color.white);
		pan05_01.setBackground(Color.white);
		
		pan01_01.add(pan02_01);
		pan02_01.add(new Label());
		pan01_01.add(pan03_01);
		pan03_01.add("Center", pan04_01);
		pan03_01.add("East", new Label());
		pan03_01.add("West", new Label());
		pan04_01.add(pan04_01_Grid1);
		pan04_01.add(pan04_01_Grid2);

		pan04_01_Grid1.add(infoid);
		infoid.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_01_Grid1.add(txemail_01);
		pan04_01_Grid1.add(emaildash);
		pan04_01_Grid1.add(emailBox);
		infoemail_01.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_01_Grid2.add(infoname);
		infoname.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_01_Grid2.add(txname);
		pan04_01_Grid2.add(nolabel);
		pan01_01.add(pan05_01);
		pan05_01.add(findbtn_01);
		findbtn_01.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		findbtn_01.setBackground(Color.gray);
		findbtn_01.setForeground(Color.WHITE);

		
		
		// 비밀번호 변경 탭페이지 설정
		jtab.add("비밀번호 변경", pan01_02);// 세번째 탭
		
		pan01_02.setBackground(Color.white);
		pan02_02.setBackground(Color.white);
		pan03_02.setBackground(Color.white);
		pan04_02.setBackground(Color.white);
		pan04_02_Grid1.setBackground(Color.white);
		pan04_02_Grid2.setBackground(Color.white);
		pan04_02_Grid3.setBackground(Color.white);
		pan04_02_Grid4.setBackground(Color.white);
		pan04_02_Grid5.setBackground(Color.white);
		pan04_02_Grid6.setBackground(Color.white);
		pan05_02.setBackground(Color.white);
		
		pan01_02.add(pan02_02);
		//pan02_02.add(new Label());
		pan01_02.add(pan03_02);
		pan03_02.add("Center", pan04_02);
		pan03_02.add("East", new Label());
		pan03_02.add("West", new Label());
		
		pan04_02.add(pan04_02_Grid1);
		pan04_02.add(pan04_02_Grid2);
		pan04_02_Grid2.add(infoEmail1);
		infoEmail1.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_02_Grid2.add(txemail_02);
		pan04_02_Grid2.add(emaildash_pwchange);
		pan04_02_Grid2.add(emailBox_change);
		pan04_02.add(pan04_02_Grid3);
		pan04_02_Grid3.add(nowPwd);
		nowPwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_02_Grid3.add(txnowPwd);
		pan04_02.add(pan04_02_Grid4);
		pan04_02_Grid4.add(changePwd);
		changePwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_02_Grid4.add(txchangePwd);
		pan04_02.add(pan04_02_Grid5);
		pan04_02_Grid5.add(changePwdchk);
		changePwdchk.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		pan04_02_Grid5.add(txchangePwdchk);
		pan04_02.add(pan04_02_Grid6);
		pan04_02_Grid6.add(changePwdbtn);
		changePwdbtn.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		changePwdbtn.setBackground(Color.gray);
		changePwdbtn.setForeground(Color.WHITE);

		add(jtab);
	}

	public static void main(String[] args) {
		new Id_PwdFind();
	}
}