package gui.layout.main.reservation_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class SelectBtn extends JButton{
	final static ImageIcon okImage = new getImages().getImageIcon(120, 120, "src/image/icon_image/btn/roomselect.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(120, 120, "src/image/icon_image/btn/roomselectP.png");

	public SelectBtn() {
		decorate();
	}

	public SelectBtn(String text) {
		super(text);
		decorate();
	}

	public SelectBtn(Action action) {
		super(action);
		decorate();
	}

	public SelectBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public SelectBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(okImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
