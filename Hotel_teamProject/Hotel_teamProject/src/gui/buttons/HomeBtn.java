package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class HomeBtn extends JButton{

	
	
	public HomeBtn() {
		decorate();
	}

	public HomeBtn(String text) {
		super(text);
		decorate();
	}

	public HomeBtn(Action action) {
		super(action);
		decorate();
	}

	public HomeBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public HomeBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
