package gui.layout.main.admin_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class AdminChkHistory extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자결제환불.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자결제환불P.png");

	public AdminChkHistory() {
		decorate();
	}

	public AdminChkHistory(String text) {
		super(text);
		decorate();
	}

	public AdminChkHistory(Action action) {
		super(action);
		decorate();
	}

	public AdminChkHistory(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public AdminChkHistory(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(180, 640, 400, 80);
		setBackground(new Color(0, 0, 0, 0));
	}

}
