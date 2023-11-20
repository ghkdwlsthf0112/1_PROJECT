package gui.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class OkBtn extends JButton{
	public OkBtn() {
		decorate();
	}

	public OkBtn(String text) {
		super(text);
		decorate();
	}

	public OkBtn(Action action) {
		super(action);
		decorate();
	}

	public OkBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public OkBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
