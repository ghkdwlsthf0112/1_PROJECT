package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class HomeBtn extends JButton{
	final protected static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");

	
	
	public HomeBtn() {
		decorate();
	}

	public HomeBtn(String text) {
		super(text);
		decorate();
	}

	public HomeBtn(Action action) {
		super(action);
		decorate();
	}

	public HomeBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public HomeBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(homeBtnImage);
		setPressedIcon(homeBtnImage);
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		setBounds(80, 920, 40, 40);
	}
}
