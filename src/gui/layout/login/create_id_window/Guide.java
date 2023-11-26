package gui.layout.login.create_id_window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Guide extends JPanel {
	
	JLabel emailGuide0;
	JLabel emailGuide1;
	JLabel emailGuide2;
	JLabel emailGuide3;
	JLabel domainGuide1;
	JLabel domainGuide2;
	JLabel pwdGuide0;
	JLabel pwdGuide1;
	JLabel pwdGuide2;
	JLabel pwdChkGuide1;
	JLabel pwdChkGuide2;
	JLabel nameGuide0;
	JLabel nameGuide1;
	JLabel nameGuide2;
	JLabel phoneNumGuide0;
	JLabel phoneNumGuide1;
	JLabel phoneNumGuide2;
	int reLocationX=0;
	int reLocationY=0;
	int sizeX;
	int sizeY;
	
	
	public Guide(SignUpInterface mainFrame) {
		setLayout(null);
//		this.reLocationX = mainFrame.reLocationX;
//		this.reLocationY = mainFrame.reLocationY;
		this.sizeX = mainFrame.sizeX;
		this.sizeY = mainFrame.sizeY;
		setBackground(Color.WHITE);
		init();
		componentLayout();
		addComponent();		

	}
	 

	private void init() {
		emailGuide0 = new JLabel("이메일을 입력하세요.");
		emailGuide1 = new JLabel("입력된 이메일은 잘못된 형식입니다.");
		emailGuide2 = new JLabel("현재 사용중인 이메일입니다.");
		emailGuide3 = new JLabel("사용가능한 이메일입니다.");
		domainGuide1 = new JLabel("도메인을 입력하거나 선택하세요.");
		domainGuide2 = new JLabel("중복 버튼을 눌러주세요.");
		pwdGuide0 = new JLabel("비밀번호를 입력하세요.");
		pwdGuide1 = new JLabel("입력된 비밀번호는 잘못된 형식입니다.");
		pwdGuide2 = new JLabel("사용가능한 비밀번호입니다.");
		pwdChkGuide1 = new JLabel("비밀번호가 일치합니다.");
		pwdChkGuide2 = new JLabel("비밀번호가 일치하지 않습니다.");
		nameGuide0 = new JLabel("이름을 입력하세요");
		nameGuide1 = new JLabel("이름은 2~20자 이내여야 합니다");
		nameGuide2 = new JLabel("사용가능한 이름입니다");
		phoneNumGuide0 = new JLabel("휴대폰 번호를 입력하세요");
		phoneNumGuide1 = new JLabel("입력된 번호는 잘못된 형식입니다");
		phoneNumGuide2 = new JLabel("사용가능한 번호입니다");
		
		setLabelProperties(emailGuide0);
		setLabelProperties(emailGuide1);
        setLabelProperties(emailGuide2);
        setLabelProperties(emailGuide3);
        setLabelProperties(domainGuide1);
        setLabelProperties(domainGuide2);
        setLabelProperties(pwdGuide0);
        setLabelProperties(pwdGuide1);
        setLabelProperties(pwdGuide2);
        setLabelProperties(pwdChkGuide1);
        setLabelProperties(pwdChkGuide2);
        setLabelProperties(nameGuide0);
        setLabelProperties(nameGuide1);
        setLabelProperties(nameGuide2);
        setLabelProperties(phoneNumGuide0);
        setLabelProperties(phoneNumGuide1);
        setLabelProperties(phoneNumGuide2);
	}
	
	private void setLabelProperties(JLabel label) {
        label.setFont(new Font("굴림", Font.PLAIN, 15));
        label.setBackground(new Color(0,0,0,0));
        label.setForeground(Color.RED);
        label.setBorder(null);
        label.setVisible(false);
    }
	
	public void componentLayout() {
		emailGuide0.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		emailGuide1.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		emailGuide2.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		emailGuide3.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		domainGuide1.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		domainGuide2.setBounds(0+reLocationX, 290+reLocationY, 250, 20);
		pwdGuide0.setBounds(0+reLocationX, 355+reLocationY, 250, 20);
		pwdGuide1.setBounds(0+reLocationX, 355+reLocationY, 250, 20);
		pwdGuide2.setBounds(0+reLocationX, 355+reLocationY, 250, 20);
		pwdChkGuide1.setBounds(0+reLocationX, 420+reLocationY, 250, 20);
		pwdChkGuide2.setBounds(0+reLocationX, 420+reLocationY, 250, 20);
		nameGuide0.setBounds(0+reLocationX, 485+reLocationY, 250, 20);
		nameGuide1.setBounds(0+reLocationX, 485+reLocationY, 250, 20);
		nameGuide2.setBounds(0+reLocationX, 485+reLocationY, 250, 20);
		phoneNumGuide0.setBounds(0+reLocationX, 550+reLocationY, 250, 20);
		phoneNumGuide1.setBounds(0+reLocationX, 550+reLocationY, 250, 20);
		phoneNumGuide2.setBounds(0+reLocationX, 550+reLocationY, 250, 20);
	}
	
	private void addComponent() {
		add(emailGuide0);
		add(emailGuide1);
		add(emailGuide2);
		add(emailGuide3);
		add(domainGuide1);
		add(domainGuide2);
		add(pwdGuide0);
		add(pwdGuide1);
		add(pwdGuide2);
		add(pwdChkGuide1);
		add(pwdChkGuide2);
		add(nameGuide0);
		add(nameGuide1);
		add(nameGuide2);
		add(phoneNumGuide0);
		add(phoneNumGuide1);
		add(phoneNumGuide2);
	}

}


