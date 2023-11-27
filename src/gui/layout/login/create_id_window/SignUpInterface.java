package gui.layout.login.create_id_window;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.layout.login.create_id_window.buttons.CreateIdTermbtns;
import gui.layout.login.create_id_window.buttons.CreatedIdInitBtn;
import gui.layout.login.create_id_window.buttons.ExitBtn;
import image.getImages;

public class SignUpInterface extends JFrame {

	private String email;
	private String pwd;
	private String name;
	private String phoneNum;
	private String domain;
	private JLabel title;
	private JLabel title2;
	private JLabel emailLabel;
	private JLabel emailRule;
	private JLabel domainLabel;
	private JLabel domainRule;
	private JLabel pwdLabel;
	private JLabel pwdRule;
	private JLabel pwdChkLabel;
	private JLabel pwdChkRule;
	private JLabel nameLabel;
	private JLabel nameRule;
	private JLabel phoneNumLabel;
	private JLabel phoneNumRule;
	private JTextField emailField;
	private JPasswordField pwdField;
	private JPasswordField pwdChkField;
	private JTextField nameField;
	private JTextField phoneNumField;
	private JComboBox<String> domainComboBox;
	private JButton dupliBtn;
	private JButton CreateIdTermbtns;
	private JButton CreatedIdInitBtn;
	private Guide guide;
	private JButton exitBtn;
	private boolean agreedToTerms = false;
	String[] domainList = { "", "naver.com", "daum.net", "gmail.com", "yahoo.com", "kakao.com" };
	final int reLocationX = -50;
	final int reLocationY = -100;
	final static int sizeX = 680;
	final static int sizeY = 800;
	final protected static boolean chkfieldView = false;
	
	static ImageIcon mainImage = new getImages().getImageIcon(680, 800, "src/image/background_image/CreateID.png");
 
	
	public SignUpInterface() {
		super("회원가입 화면입니다.");
		JLabel image = new JLabel();
		image.setBounds(0, 0, sizeX, sizeY);
		image.setIcon(mainImage);
		add(image);
		// guide 객체 생성 및 초기화
		guide = new Guide(this);
		guide.setVisible(chkfieldView);
		guide.setBackground(Color.black);

		init();
		componentLayout();
		addComponent(image);
		addActionListeners();

		domainComboBox = new JComboBox<String>();
		domainComboBox.setBounds(300+reLocationX, 296+reLocationY, 250, 30);

//		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setBounds(550, 10, 768, 1024);
		setUndecorated(true);
		setLocation(595, 100);
		setSize(sizeX, sizeY);
		
		setVisible(true);
		
	}

	private void init() {
		// 초기화, 선언
		title = new JLabel("호텔델루나에 오신것을 환영합니다!!");
		title2 = new JLabel("※회원정보를 입력하세요.");
		emailLabel = new JLabel("메일주소");
		domainLabel = new JLabel("@");
		pwdLabel = new JLabel("패스워드");
		pwdChkLabel = new JLabel("패스확인");
		nameLabel = new JLabel("이　　름");
		phoneNumLabel = new JLabel("휴대전화");

		// 정규표현식에 맞게 사용자에게 안내하는 Rule라벨
		emailRule = new JLabel("6~20자, 영문 혹은 숫자 혼합");
		domainRule = new JLabel("직접입력");
		pwdRule = new JLabel("6~15자, 영문 대소문자,숫자,특수문자 조합");
		pwdChkRule = new JLabel("위와 동일한 비밀번호 입력");
		nameRule = new JLabel("2~20자, 영문 혹은 한글 입력");
		phoneNumRule = new JLabel("'-' 생략가능 / 숫자만 입력");

		// 필드
		pwdField = new JPasswordField();
		pwdChkField = new JPasswordField();
		nameField = new JTextField();
		phoneNumField = new JTextField();
		emailField = new JTextField();

		domainComboBox = new JComboBox<>(domainList);
		domainComboBox.setEditable(true);
		// 버튼
		dupliBtn = new JButton("중복확인");
		CreateIdTermbtns = new CreateIdTermbtns();
		CreatedIdInitBtn = new CreatedIdInitBtn();
		exitBtn = new ExitBtn();
	}

	private void componentLayout() {
		

		// 컴포넌트 위치(x, y), 입력상자(가로, 세로)
		// 라벨 높이 간격 65
		title.setBounds(60+reLocationX, 30+reLocationY, 1000, 50);
		title2.setBounds(120+reLocationX, 200+reLocationY, 900, 50);
		emailLabel.setBounds(120+reLocationX, 245+reLocationY, 320, 50);
		domainLabel.setBounds(465+reLocationX, 245+reLocationY, 320, 50);
		pwdLabel.setBounds(120+reLocationX, 310+reLocationY, 320, 50);
		pwdChkLabel.setBounds(120+reLocationX, 375+reLocationY, 320, 50);
		nameLabel.setBounds(120+reLocationX, 440+reLocationY, 320, 50);
		phoneNumLabel.setBounds(120+reLocationX, 505+reLocationY, 320, 50);
		// 텍스트필드 높이 간격 65
		
		emailField.setBounds(240+reLocationX, 252+reLocationY, 220, 36);
		emailField.setBorder(null);
		domainComboBox.setBounds(495+reLocationX, 252+reLocationY, 100, 36);
		domainComboBox.setBorder(null);
		pwdField.setBounds(240+reLocationX, 325+reLocationY, 355, 36);
		pwdField.setBorder(null);
		pwdChkField.setBounds(240+reLocationX, 399+reLocationY, 355, 36);
		pwdChkField.setBorder(null);
		nameField.setBounds(240+reLocationX, 472+reLocationY, 355, 36);
		nameField.setBorder(null);
		phoneNumField.setBounds(240+reLocationX, 545+reLocationY, 355, 36);
		phoneNumField.setBorder(null);
		
		dupliBtn.setBounds(650+reLocationX, 252+reLocationY, 40, 36);
		exitBtn.setBounds(620, 30, 30, 30);
		
		CreateIdTermbtns.setBounds(134+reLocationX, 620+reLocationY, 500, 80);
		CreatedIdInitBtn.setBounds(134+reLocationX, 720+reLocationY, 500, 80);
		
		
		// Rule 컴포넌트 위치(높이 간격 65)
		emailRule.setBounds(250+reLocationX, 258+reLocationY, 190, 25);
		domainRule.setBounds(500+reLocationX, 258+reLocationY, 70, 25);
		pwdRule.setBounds(250+reLocationX, 330+reLocationY, 300, 25);
		pwdChkRule.setBounds(250+reLocationX, 404+reLocationY, 300, 25);
		nameRule.setBounds(250+reLocationX, 477+reLocationY, 300, 25);
		phoneNumRule.setBounds(250+reLocationX, 550+reLocationY, 300, 25);

		// 폰트, 굵기, 글자크기
		title.setFont(new Font("굴림", Font.BOLD, 38));
		title2.setFont(new Font("굴림", Font.BOLD, 20));
		emailLabel.setFont(new Font("굴림", Font.BOLD, 24));
		domainLabel.setFont(new Font("굴림", Font.BOLD, 20));
		pwdLabel.setFont(new Font("굴림", Font.BOLD, 24));
		pwdChkLabel.setFont(new Font("굴림", Font.BOLD, 24));
		nameLabel.setFont(new Font("굴림", Font.BOLD, 24));
		phoneNumLabel.setFont(new Font("굴림", Font.BOLD, 24));

		// 버튼 색상 및 크기
		dupliBtn.setFont(new Font("굴림", Font.PLAIN, 14));
		dupliBtn.setForeground(Color.BLACK);
		CreateIdTermbtns.setFont(new Font("굴림", Font.BOLD, 30));
		CreateIdTermbtns.setForeground(Color.BLUE);
		CreatedIdInitBtn.setFont(new Font("굴림", Font.BOLD, 30));
		CreatedIdInitBtn.setForeground(Color.BLUE);
		// Rule 폰트
		emailRule.setFont(new Font("굴림", Font.PLAIN, 14));
		domainRule.setFont(new Font("굴림", Font.PLAIN, 14));
		pwdRule.setFont(new Font("굴림", Font.PLAIN, 14));
		pwdChkRule.setFont(new Font("굴림", Font.PLAIN, 14));
		nameRule.setFont(new Font("굴림", Font.PLAIN, 14));
		phoneNumRule.setFont(new Font("굴림", Font.PLAIN, 14));
		// Rule 색깔
		emailRule.setForeground(Color.GRAY);
		domainRule.setForeground(Color.GRAY);
		pwdRule.setForeground(Color.GRAY);
		pwdChkRule.setForeground(Color.GRAY);
		nameRule.setForeground(Color.GRAY);
		phoneNumRule.setForeground(Color.GRAY);
	}

	private void addComponent(JLabel j) {
		// 기능추가
		j.add(emailRule);
		j.add(domainRule);
		j.add(nameRule);
		j.add(pwdRule);
		j.add(pwdChkRule);
		j.add(phoneNumRule);
		// 라벨
		j.add(domainLabel);
//		add(title);
//		j.add(title2);
//		j.add(emailLabel);
//		j.add(pwdLabel);
//		j.add(pwdChkLabel);
//		j.add(nameLabel);
//		j.add(phoneNumLabel);
		j.add(emailField);
		j.add(domainComboBox);
		j.add(pwdField);
		j.add(pwdChkField);
		j.add(nameField);
		j.add(phoneNumField);
//		j.add(dupliBtn);
		j.add(CreateIdTermbtns);
		j.add(CreatedIdInitBtn);
		j.add(exitBtn);
		j.add(guide);
		addComponentsWithGuide(j); // 다른 구성 요소들과 함께 패널을 추가
	}

	private void addComponentsWithGuide(JLabel j) {
		// 기능 추가 및 패널 추가
		// (기존 코드와 패널 추가)
		guide.setBounds(200, -100, sizeX, sizeY); // 패널 위치 설정
		guide.setBackground(new Color(0,0,0,0));
		j.add(guide); // 패널 추가
	}

	private String formatEmailDomain(String email, String domain) {
		if (email != null && domain != null) {
			return email + domain;
		}
		return null;
	}

	private void addActionListeners() {
		guide.emailGuide0.setVisible(chkfieldView);
		guide.pwdGuide0.setVisible(chkfieldView);
		guide.nameGuide0.setVisible(chkfieldView);
		guide.phoneNumGuide0.setVisible(chkfieldView);

		domainComboBox.addActionListener(e -> dupliBtn.requestFocusInWindow());
		pwdField.addActionListener(e -> pwdChkField.requestFocusInWindow());
		pwdChkField.addActionListener(e -> nameField.requestFocusInWindow());
		nameField.addActionListener(e -> phoneNumField.requestFocusInWindow());
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== exitBtn) {
					dispose();
				}
				
			}
		});

		emailField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				emailUpdate();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				emailUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				emailUpdate();
			}

			private void emailUpdate() {
				String emailID = emailField.getText();
				String ePattern = "[\\w]{6,20}";

				if (emailID.length() < 6) {
					emailRule.setVisible(false);
					guide.emailGuide0.setVisible(true);
					guide.emailGuide1.setVisible(false);
					guide.emailGuide2.setVisible(false);
					guide.emailGuide3.setVisible(false);
					guide.domainGuide1.setVisible(false);
					guide.domainGuide2.setVisible(false);
				} else if (emailID.length() >= 6) {
					if (Pattern.matches(ePattern, emailID)) {
						email = emailID;
						guide.emailGuide0.setVisible(false);
						guide.emailGuide1.setVisible(false);
						guide.emailGuide2.setVisible(false);
						guide.emailGuide3.setVisible(true);
						guide.domainGuide1.setVisible(false);
						guide.domainGuide2.setVisible(false);
						System.out.println("이메일: " + emailID);
					} else {
						email = null;
						guide.emailGuide0.setVisible(false);
						guide.emailGuide1.setVisible(true);
						guide.emailGuide2.setVisible(false);
						guide.emailGuide3.setVisible(false);
						guide.domainGuide1.setVisible(false);
						guide.domainGuide2.setVisible(false);
						System.out.println("이메일 양식을 확인하세요");
					}
				}
			}
		});

		domainComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String dPattern = "[a-zA-Z0-9]+[.](com|net|co.kr)";
				String selectedDomain = (String) domainComboBox.getSelectedItem();
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
				domain = (String) combo.getSelectedItem();
				// 도메인은 정규표현식에 맞는지 안맞는지만 판단해서 라벨안내
				if (Pattern.matches(dPattern, domain)) {
					domain = "@" + domain;
					domainRule.setVisible(false);
					guide.emailGuide0.setVisible(false);
					guide.emailGuide1.setVisible(false);
					guide.emailGuide2.setVisible(false);
					guide.emailGuide3.setVisible(false);
					guide.domainGuide1.setVisible(false);
					guide.domainGuide2.setVisible(true);
					System.out.println("도메인: " + domain);
				} else {
					domain = null;
					domainRule.setVisible(false); // 도메인 라벨 숨김
					guide.emailGuide0.setVisible(false);
					guide.emailGuide1.setVisible(false);
					guide.emailGuide2.setVisible(false);
					guide.emailGuide3.setVisible(false);
					guide.domainGuide1.setVisible(true);
					guide.domainGuide2.setVisible(false);
					System.out.println("도메인을 입력하거나 선택하세요");
				}
			}
		});

		pwdField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				pwdUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				pwdUpdate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				pwdUpdate();
			}

			public void pwdUpdate() {
				char[] pass = pwdField.getPassword();
				String password = new String(pass);
				String pPattern = "^.*(?=^.{6,15}$)(?=.*\\d)" + "(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=]).*$";
				System.out.println(pass);
				if (pass.length < 6) {
					pwdRule.setVisible(false);
					guide.pwdGuide0.setVisible(true);
					guide.pwdGuide1.setVisible(false);
					guide.pwdGuide2.setVisible(false);
				} else if (pass.length >= 6) {
					pwdRule.setVisible(false);
					guide.pwdGuide0.setVisible(true);
					guide.pwdGuide1.setVisible(false);
					guide.pwdGuide2.setVisible(false);
					if (Pattern.matches(pPattern, password)) {
						pwd = password;
						guide.pwdGuide0.setVisible(false);
						guide.pwdGuide1.setVisible(false);
						guide.pwdGuide2.setVisible(true);
						System.out.println("비밀번호: " + password);
					} else {
						pwd = null;
						guide.pwdGuide0.setVisible(false);
						guide.pwdGuide1.setVisible(true);
						guide.pwdGuide2.setVisible(false);
						System.out.println("비밀번호 양식을 확인하세요");
					}
				}
			}
		});

		pwdChkField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				pwdChkUpdate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				pwdChkUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				pwdChkUpdate();
			}

			public void pwdChkUpdate() {
				String pwdChk = new String(pwdChkField.getPassword());
				String password = new String(pwdField.getPassword());

				if (pwdChk.equals(password)) {
					pwdChkRule.setVisible(false);
					guide.pwdChkGuide1.setVisible(true);
					guide.pwdChkGuide2.setVisible(false);
					System.out.println("비밀번호 재확인: " + pwdChk);
					System.out.println("비밀번호가 일치합니다.");
				} else {
					pwdChkRule.setVisible(false);
					guide.pwdChkGuide1.setVisible(false);
					guide.pwdChkGuide2.setVisible(true);
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}
		});

		nameField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				nameUpdate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				nameUpdate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				nameUpdate();
			}

			public void nameUpdate() {
				String name1 = nameField.getText();
				String nPattern = "^[가-힣]{2,20}|[a-zA-Z]{2,20}$";

				if (name1.length() < 2) {
					nameRule.setVisible(false);
					guide.nameGuide0.setVisible(true);
					guide.nameGuide1.setVisible(false);
					guide.nameGuide2.setVisible(false);
				} else if (name1.length() >= 2) {
					nameRule.setVisible(false);
					guide.nameGuide0.setVisible(true);
					guide.nameGuide1.setVisible(false);
					guide.nameGuide2.setVisible(false);
					if (Pattern.matches(nPattern, name1)) {
						name = name1;
						guide.nameGuide0.setVisible(false);
						guide.nameGuide1.setVisible(false);
						guide.nameGuide2.setVisible(true);
						System.out.println("이름: " + name);
					} else {
						name = null;
						guide.nameGuide0.setVisible(false);
						guide.nameGuide1.setVisible(true);
						guide.nameGuide2.setVisible(false);
						System.out.println("2~20자/한,영 구분해서 입력");
					}
				}
			}
		});

		phoneNumField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				phNumberHypoon();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				phNumberHypoon();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				phNumberHypoon();
			}

			private void phNumberHypoon() {
				String phNumber = phoneNumField.getText().replaceAll("[^0-9]", "");
				String phPattern011 = "^(01(?:1|[6-9]))(\\d{3})(\\d{4})$";
				String phPattern010 = "^(010)(\\d{4})(\\d{4})$";

				if (phNumber.length() < 10) {
					phoneNumRule.setVisible(false);
					guide.phoneNumGuide0.setVisible(true);
					guide.phoneNumGuide1.setVisible(false);
					guide.phoneNumGuide2.setVisible(false);
				} else {
					if (Pattern.matches(phPattern011, phNumber)) {
						phoneNum = phNumber.replaceAll(phPattern011, "$1-$2-$3");
					} else if (Pattern.matches(phPattern010, phNumber)) {
						phoneNum = phNumber.replaceAll(phPattern010, "$1-$2-$3");
					}

					if (phoneNum != null && !phoneNum.isEmpty()) {
						phoneNumRule.setVisible(false);
						guide.phoneNumGuide0.setVisible(false);
						guide.phoneNumGuide1.setVisible(false);
						guide.phoneNumGuide2.setVisible(true);
						System.out.println("유효한 핸드폰 번호입니다.");
						System.out.println(phoneNum);
						// 여기서 phoneNum에 하이픈이 추가된 번호를 확인할 수 있음
					} else {
						phoneNum = null;
						phoneNumRule.setVisible(false);
						guide.phoneNumGuide0.setVisible(false);
						guide.phoneNumGuide1.setVisible(true);
						guide.phoneNumGuide2.setVisible(false);
						System.out.println("입력된 휴대폰번호는 잘못된 형식입니다");
					}
				}
			}
		});

		dupliBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String emailDomain = formatEmailDomain(email, domain);
				if (emailDomain != null) {
					MemberDao.dupliTest(emailDomain);
					boolean duplicateValue = MemberDao.isDuplicateTF();

					guide.emailGuide0.setVisible(false);
					guide.emailGuide1.setVisible(false);
					guide.emailGuide2.setVisible(duplicateValue);
					guide.emailGuide3.setVisible(!duplicateValue);
					guide.domainGuide1.setVisible(false);
					guide.domainGuide2.setVisible(false);
				} else {
					guide.emailGuide0.setVisible(false);
					guide.emailGuide1.setVisible(false);
					guide.emailGuide2.setVisible(false);
					guide.emailGuide3.setVisible(false);
					guide.domainGuide1.setVisible(true);
					guide.domainGuide2.setVisible(false);
					System.out.println("도메인을 선택하거나 입력하세요.");
				}
			}
		});

		CreateIdTermbtns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberTerms();
				agreedToTerms = true;
			}
		});

		CreatedIdInitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String emailDomain = formatEmailDomain(email, domain);
				if (emailDomain != null && pwd != null && phoneNum != null && name != null && agreedToTerms) {
					MemberDao.addMember(emailDomain, pwd, name, phoneNum);
					System.out.println("정보를 보내는데 성공했습니다.");
				} else if (emailDomain == null) {
					JOptionPane.showMessageDialog(SignUpInterface.this, "이메일을 확인해주세요.");
				} else if (pwd == null) {
					JOptionPane.showMessageDialog(SignUpInterface.this, "비밀번호를 확인해주세요.");
				} else if (name == null) {
					JOptionPane.showMessageDialog(SignUpInterface.this, "이름을 확인해주세요.");
				} else if (phoneNum.length() < 10) {
					JOptionPane.showMessageDialog(SignUpInterface.this, "핸드폰 번호를 확인해주세요.");
				} else if (!agreedToTerms) {
					JOptionPane.showMessageDialog(SignUpInterface.this, "약관을 읽고 동의해주세요.");
				} else {
					JOptionPane.showMessageDialog(SignUpInterface.this, "버그입니다. 신고해주세요!");
				}
			}
		});
	}

	@Override
	public String toString() {
		return "SignUpInterface [email=" + email + ", pwd=" + pwd + ", phoneNum=" + phoneNum + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			SignUpInterface signUpInterface = new SignUpInterface();
			new MemberDao();
		});
	}
}
