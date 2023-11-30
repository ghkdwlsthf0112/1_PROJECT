package gui.layout.main.admin_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class EndBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(60, 60, "src/image/icon_image/btn/X.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(60, 60, "src/image/icon_image/btn/XP.png");

	public EndBtn() {
		decorate();
	}

	public EndBtn(String text) {
		super(text);
		decorate();
	}

	public EndBtn(Action action) {
		super(action);
		decorate();
	}

	public EndBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public EndBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(660, 850, 60, 60);
		setBackground(new Color(0, 0, 0, 0));
	}
}
