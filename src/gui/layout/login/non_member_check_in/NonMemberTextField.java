package gui.layout.login.non_member_check_in;

import java.awt.Font;

import javax.swing.JTextField;

public class NonMemberTextField extends JTextField {
	public NonMemberTextField() {
		decorate();
	}

	public NonMemberTextField(String text, int columns) {
		super(text, columns);
		decorate();
	}

	public NonMemberTextField(int columns) {
		super(null, null, columns);
		decorate();
	}

	public NonMemberTextField(String text) {
		super(null, text, 0);
		decorate();
	} 
	
	private void decorate() {
		setSize(320,50);
        setBorder(null);
//		setOpaque(false);
        setFont(new Font("나눔고딕", Font.BOLD, 22));
	}
}
