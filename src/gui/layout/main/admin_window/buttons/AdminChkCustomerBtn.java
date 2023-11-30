package gui.layout.main.admin_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class AdminChkCustomerBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자회원.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(400, 80, "src/image/icon_image/btn/관리자회원P.png");

	public AdminChkCustomerBtn() {
		decorate();
	}

	public AdminChkCustomerBtn(String text) {
		super(text);
		decorate();
	}

	public AdminChkCustomerBtn(Action action) {
		super(action);
		decorate();
	}

	public AdminChkCustomerBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public AdminChkCustomerBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(180, 520, 400, 80);
		setBackground(new Color(0, 0, 0, 0));
	}

}
