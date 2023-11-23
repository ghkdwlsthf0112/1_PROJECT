package gui.layout.login.non_member_check_in.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class nonMemberOkBtn extends JButton{
	
	public nonMemberOkBtn() {
		decorate();
	}

	public nonMemberOkBtn(String text) {
		super(text);
		decorate();
	}

	public nonMemberOkBtn(Action action) {
		super(action);
		decorate();
	}

	public nonMemberOkBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public nonMemberOkBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
