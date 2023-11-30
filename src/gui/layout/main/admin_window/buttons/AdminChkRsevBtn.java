package gui.layout.main.admin_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class AdminChkRsevBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(60, 60, "src/image/icon_image/btn/X.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(60, 60, "src/image/icon_image/btn/XP.png");

	public AdminChkRsevBtn() {
		decorate();
	}

	public AdminChkRsevBtn(String text) {
		super(text);
		decorate();
	}

	public AdminChkRsevBtn(Action action) {
		super(action);
		decorate();
	}

	public AdminChkRsevBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public AdminChkRsevBtn(String text, Icon icon) {
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
