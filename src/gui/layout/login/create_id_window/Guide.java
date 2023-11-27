package gui.layout.login.create_id_window;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JComponent;
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
	JLabel pwdChkGuide0;
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
        setOpaque(false);
	}
	 
	private void init() {
		emailGuide0 = new JLabel("이메일을 입력하세요.");
		emailGuide1 = new JLabel("입력된 이메일은 잘못된 형식입니다.");
		emailGuide2 = new JLabel("현재 사용중인 이메일입니다.");
		emailGuide3 = new JLabel("사용가능한 이메일입니다.");
		domainGuide1 = new JLabel("도메인을 다시 선택하거나 입력해주세요.");
		domainGuide2 = new JLabel("중복 버튼을 눌러주세요.");
		pwdGuide0 = new JLabel("비밀번호를 입력하세요.");
		pwdGuide1 = new JLabel("입력된 비밀번호는 잘못된 형식입니다.");
		pwdGuide2 = new JLabel("사용가능한 비밀번호입니다.");
		pwdChkGuide0 = new JLabel("비밀번호 일치여부를 파악합니다.");
		pwdChkGuide1 = new JLabel("비밀번호가 일치하지 않습니다.");
		pwdChkGuide2 = new JLabel("비밀번호가 일치합니다.");
		nameGuide0 = new JLabel("이름을 입력하세요");
		nameGuide1 = new JLabel("영문 혹은 한글만 입력해주세요.");
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
        setLabelProperties(pwdChkGuide0);
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
        label.setForeground(Color.RED);
        label.setVisible(true);
        label.setBorder(null);
        label.setVisible(false);
    }
	
	public void setComponentBounds(JComponent component, int x, int y, int width, int height) {
		component.setBounds(x, y, width, height);
	}
	
	// 컴포넌트 위치 x, y 설정가능 
	// 컴포넌트 크기 width, height 설정가능
	// 간격도 설정가능 현재 65
	public void componentLayout() {
		int x = 20; // 컴포넌트 위치 가로
		int y = 335; // 컴포넌트 위치 세로
		int width = 270; // 가로 크기
		int height = 20; // 세로 크기
		int interval = 73; // 간격
		// y는 가이드 카테고리마다 70씩 차이가 난다
		setComponentBounds(emailGuide0, x, y, width, height);
		setComponentBounds(emailGuide1, x, y, width, height);
		setComponentBounds(emailGuide2, x, y, width, height);
		setComponentBounds(emailGuide3, x, y, width, height);
		setComponentBounds(domainGuide1, x, y, width, height);
		setComponentBounds(domainGuide2, x, y, width, height);
		y += interval;
		setComponentBounds(pwdGuide0, x, y, width, height);
		setComponentBounds(pwdGuide1, x, y, width, height);
		setComponentBounds(pwdGuide2, x, y, width, height);
		y += interval;
		setComponentBounds(pwdChkGuide0, x, y, width, height);
		setComponentBounds(pwdChkGuide1, x, y, width, height);
		setComponentBounds(pwdChkGuide2, x, y, width, height);
		y += interval;
		setComponentBounds(	nameGuide0, x, y, width, height);
		setComponentBounds(nameGuide1, x, y, width, height);
		setComponentBounds(nameGuide2, x, y, width, height);
		y += interval;
		setComponentBounds(	phoneNumGuide0, x, y, width, height);
		setComponentBounds(	phoneNumGuide1, x, y, width, height);
		setComponentBounds(phoneNumGuide2, x, y, width, height);
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
		add(pwdChkGuide0);
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