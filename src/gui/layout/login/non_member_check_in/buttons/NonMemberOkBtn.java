package gui.layout.login.non_member_check_in.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class NonMemberOkBtn extends JButton{
	static ImageIcon loginBtnImage = new getImages().getImageIcon(460, 70, "src/image/icon_image/btn/입력완료.png");
	static ImageIcon loginBtnImageP = new getImages().getImageIcon(460, 70, "src/image/icon_image/btn/입력완료P.png");
	
	public NonMemberOkBtn() {
		decorate();
	}

	public NonMemberOkBtn(String text) {
		super(text);
		decorate();
	}

	public NonMemberOkBtn(Action action) {
		super(action);
		decorate();
	}

	public NonMemberOkBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public NonMemberOkBtn(String text, Icon icon) {
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
