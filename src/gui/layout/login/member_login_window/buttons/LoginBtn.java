package gui.layout.login.member_login_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class LoginBtn extends JButton{
	public LoginBtn() {
		decorate();
	}

	public LoginBtn(String text) {
		super(text);
		decorate();
	}

	public LoginBtn(Action action) {
		super(action);
		decorate();
	}

	public LoginBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public LoginBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
