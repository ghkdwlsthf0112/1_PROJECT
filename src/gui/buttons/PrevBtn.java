package gui.buttons;

import java.awt.Color;


import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;


public class PrevBtn extends JButton{
	final protected static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");

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
		setIcon(backImage);
		setPressedIcon(backImage);
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(30, 920, 40, 40);
	}
	
}
