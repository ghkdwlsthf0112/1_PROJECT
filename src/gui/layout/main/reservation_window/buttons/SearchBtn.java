package gui.layout.main.reservation_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class SearchBtn extends JButton{
	
	public SearchBtn() {
		decorate();
	}

	public SearchBtn(String text) {
		super(text);
		decorate();
	}

	public SearchBtn(Action action) {
		super(action);
		decorate();
	}

	public SearchBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public SearchBtn(String text, Icon icon) {
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
