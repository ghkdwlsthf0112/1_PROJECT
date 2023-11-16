package gui.buttons;

import java.awt.Color;


import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


public class PrevBtn extends JButton{
	
	public PrevBtn() {
		decorate();
	}

	public PrevBtn(String text) {
		super(text);
		decorate();
	}

	public PrevBtn(Action action) {
		super(action);
		decorate();
	}

	public PrevBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public PrevBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
	
}
