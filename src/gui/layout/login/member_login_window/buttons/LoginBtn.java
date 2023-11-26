package gui.layout.login.member_login_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class LoginBtn extends JButton{
	static ImageIcon loginBtnImage = new getImages().getImageIcon(460, 70, "src/image/icon_image/btn/login.png");
	static ImageIcon loginBtnImageP = new getImages().getImageIcon(460, 70, "src/image/icon_image/btn/login2.png");

	public LoginBtn() {
		decorate();
	}

	public LoginBtn(String text) {
		super(text);
		decorate();
	}

	public LoginBtn(Action action) {
		super(action);
		decorate();
	}

	public LoginBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public LoginBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(loginBtnImage);
		setPressedIcon(loginBtnImageP);
		setBorderPainted(false);
		setOpaque(false);
		setFocusPainted(false);
		setBounds(152, 650, 460, 70);
		setBackground(new Color(0, 0, 0, 0));
	}
}
