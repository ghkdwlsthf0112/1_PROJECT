package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class FloorGuideBtn extends JButton{

	
	public FloorGuideBtn() {
		decorate();
	}

	public FloorGuideBtn(String text) {
		super(text);
		decorate();
	}

	public FloorGuideBtn(Action action) {
		super(action);
		decorate();
	}

	public FloorGuideBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public FloorGuideBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(130, 920, 80, 40);
	}
}
