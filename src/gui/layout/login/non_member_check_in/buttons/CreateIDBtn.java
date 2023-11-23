package gui.layout.login.non_member_check_in.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CreateIDBtn extends JButton{
	public CreateIDBtn() {
		decorate();
	}

	public CreateIDBtn(String text) {
		super(text);
		decorate();
	}

	public CreateIDBtn(Action action) {
		super(action);
		decorate();
	}

	public CreateIDBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public CreateIDBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
