package gui.layout.main.admin_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class AdminChkResBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자예약.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자예약P.png");

	public AdminChkResBtn() {
		decorate();
	}

	public AdminChkResBtn(String text) {
		super(text);
		decorate();
	}

	public AdminChkResBtn(Action action) {
		super(action);
		decorate();
	}

	public AdminChkResBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public AdminChkResBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(180, 400, 400, 80);
		setBackground(new Color(0, 0, 0, 0));
	}
}
