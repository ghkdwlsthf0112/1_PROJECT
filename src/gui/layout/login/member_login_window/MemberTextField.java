package gui.layout.login.member_login_window;

import java.awt.Font;

import javax.swing.JTextField;

public class MemberTextField extends JTextField{
	public MemberTextField() {
		decorate();
	}

	public MemberTextField(String text, int columns) {
		super(text, columns);
		decorate();
	}

	public MemberTextField(int columns) {
		super(null, null, columns);
		decorate();
	}

	public MemberTextField(String text) {
		super(null, text, 0);
		decorate();
	} 
	
	private void decorate() {
		setSize(250,40);
        setBorder(null);
//		setOpaque(false);
        setFont(new Font("나눔고딕", Font.BOLD, 15));
	}
}
