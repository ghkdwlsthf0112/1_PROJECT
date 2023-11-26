package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ResChkOkBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/checkP.png");

	public ResChkOkBtn() {
		decorate();
	}

	public ResChkOkBtn(String text) {
		super(text);
		decorate();
	}

	public ResChkOkBtn(Action action) {
		super(action);
		decorate();
	}

	public ResChkOkBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public ResChkOkBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(405, 650, 200, 80);
		setBackground(new Color(0, 0, 0, 0));
	}
}
