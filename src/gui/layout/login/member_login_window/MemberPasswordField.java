package gui.layout.login.member_login_window;

import java.awt.Font;

import javax.swing.JPasswordField;

public class MemberPasswordField extends JPasswordField{
	public MemberPasswordField() {
		decorate();
	}

	public MemberPasswordField(String text, int columns) {
		super(text, columns);
		decorate();
	}

	public MemberPasswordField(int columns) {
		super(null, null, columns);
		decorate();
	}

	public MemberPasswordField(String text) {
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
