package gui.buttons;

import java.awt.Color;


import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


public class CalendarBtn extends JButton{
	
	public CalendarBtn() {
		decorate();
	}

	public CalendarBtn(String text) {
		super(text);
		decorate();
	}

	public CalendarBtn(Action action) {
		super(action);
		decorate();
	}

	public CalendarBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public CalendarBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(30, 920, 40, 40);
	}
	
}
