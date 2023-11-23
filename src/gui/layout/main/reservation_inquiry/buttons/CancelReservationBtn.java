package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CancelReservationBtn extends JButton{
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
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
	}
}
