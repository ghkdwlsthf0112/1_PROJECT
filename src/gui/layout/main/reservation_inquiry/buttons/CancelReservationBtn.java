package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class CancelReservationBtn extends JButton{
	final static ImageIcon cancelImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/CancelReservation.png");

	
	public CancelReservationBtn() {
		decorate();
	}

	public CancelReservationBtn(String text) {
		super(text);
		decorate();
	}

	public CancelReservationBtn(Action action) {
		super(action);
		decorate();
	}

	public CancelReservationBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public CancelReservationBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(cancelImage);
		setPressedIcon(cancelImage);
		setBorderPainted(false);
        setFocusPainted(false);
		setOpaque(false);
        setFocusPainted(false);
        setBounds(165, 650, 200, 80);
		setBackground(new Color(0, 0, 0, 0));
	}
}
