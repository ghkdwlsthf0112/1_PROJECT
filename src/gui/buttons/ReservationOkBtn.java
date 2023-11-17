package gui.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class ReservationOkBtn extends JButton{
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
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0));
	}
}
