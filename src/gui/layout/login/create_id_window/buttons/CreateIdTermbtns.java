package gui.layout.login.create_id_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class CreateIdTermbtns extends JButton{
	static ImageIcon loginBtnImage = new getImages().getImageIcon(500, 80, "src/image/icon_image/btn/회원가입약관동의.png");
	static ImageIcon loginBtnImageP = new getImages().getImageIcon(500, 80, "src/image/icon_image/btn/회원가입약관동의P.png");

	public CreateIdTermbtns() {
		decorate();
	}

	public CreateIdTermbtns(String text) {
		super(text);
		decorate();
	}

	public CreateIdTermbtns(Action action) {
		super(action);
		decorate();
	}

	public CreateIdTermbtns(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public CreateIdTermbtns(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(loginBtnImage);
		setPressedIcon(loginBtnImageP);
		setBorderPainted(false);
		setOpaque(false);
		setFocusPainted(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
