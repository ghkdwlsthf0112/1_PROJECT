package gui.layout.main.guide_map.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class floorBtn extends JButton{
	public floorBtn() {
		decorate();
	}

	public floorBtn(String text) {
		super(text);
		decorate();
	}

	public floorBtn(Action action) {
		super(action);
		decorate();
	}

	public floorBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public floorBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBackground(new Color(0,0,0,0));		
	}
}
