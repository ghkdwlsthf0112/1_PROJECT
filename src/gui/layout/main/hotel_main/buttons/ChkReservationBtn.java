package gui.layout.main.hotel_main.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ChkReservationBtn extends JButton {
	final protected static ImageIcon chkResvImage = new getImages().getImageIcon(340, 170,
			"src/image/icon_image/btn/ConfirmationOfReservation.png");
//	setBounds(388, 655, 365, 170);

	public ChkReservationBtn() {
		decorate();
	}

	public ChkReservationBtn(String text) {
		super(text);
		decorate();
	}

	public ChkReservationBtn(Action action) {
		super(action);
		decorate();
	}

	public ChkReservationBtn(Icon icon) {
		super(icon);
		setPressedIcon(icon);
		setRolloverSelectedIcon(icon);
		decorate();
	}

	public ChkReservationBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setIcon(chkResvImage);
		setPressedIcon(chkResvImage);
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0));
		setBounds(380, 615, 340, 170);
	}
}
