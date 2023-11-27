package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class OkBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/checkP.png");

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
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(270, 650, 200, 80);
		setBackground(new Color(0, 0, 0, 0));
	}
}
