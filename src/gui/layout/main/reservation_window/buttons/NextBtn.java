package gui.layout.main.reservation_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class NextBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/checkP.png");

	public NextBtn() {
		decorate();
	}

	public NextBtn(String text) {
		super(text);
		decorate();
	}

	public NextBtn(Action action) {
		super(action);
		decorate();
	}

	public NextBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public NextBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(300, 850, 200, 80);
		setBackground(new Color(0, 0, 0, 0));
	}
}
