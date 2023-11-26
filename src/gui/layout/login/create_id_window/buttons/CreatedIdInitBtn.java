package gui.layout.login.create_id_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class CreatedIdInitBtn extends JButton{
	static ImageIcon loginBtnImage = new getImages().getImageIcon(500, 80, "src/image/icon_image/btn/회원가입입력완료.png");
	static ImageIcon loginBtnImageP = new getImages().getImageIcon(500, 80, "src/image/icon_image/btn/회원가입입력완료P.png");

	public CreatedIdInitBtn() {
		decorate();
	}

	public CreatedIdInitBtn(String text) {
		super(text);
		decorate();
	}

	public CreatedIdInitBtn(Action action) {
		super(action);
		decorate();
	}

	public CreatedIdInitBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public CreatedIdInitBtn(String text, Icon icon) {
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
