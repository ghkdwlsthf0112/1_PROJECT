package gui.layout.login.member_login_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class FindIDBtn extends JButton{
	public FindIDBtn() {
		decorate();
	}

	public FindIDBtn(String text) {
		super(text);
		decorate();
	}

	public FindIDBtn(Action action) {
		super(action);
		decorate();
	}

	public FindIDBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public FindIDBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
