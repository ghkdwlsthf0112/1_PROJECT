package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ReservationOkBtn extends JButton{
	final static ImageIcon checkImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");
	final static ImageIcon okPImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/checkP.png");

	
	public ReservationOkBtn() {
		decorate();
	}

	public ReservationOkBtn(String text) {
		super(text);
		decorate();
	}

	public ReservationOkBtn(Action action) {
		super(action);
		decorate();
	}

	public ReservationOkBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public ReservationOkBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(checkImage);
		setPressedIcon(okPImage);
		setBorderPainted(false);
        setFocusPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0));
		setBounds(85, 600, 200, 80);
//		setEnabled(false);
	}
}
