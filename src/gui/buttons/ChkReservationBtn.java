package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class ChkReservationBtn extends JButton {
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
		setBorderPainted(false);
		setOpaque(false);
		setBackground(new Color(0, 0, 0));
		setBounds(380, 615, 340, 170);
	}
}
