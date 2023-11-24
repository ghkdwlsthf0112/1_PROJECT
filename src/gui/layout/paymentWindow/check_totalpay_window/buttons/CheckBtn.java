package gui.layout.paymentWindow.check_totalpay_window.buttons;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class CheckBtn extends JCheckBox {
	public CheckBtn() {
		super();
		decorate();
	}

	public CheckBtn(Icon icon) {
		super(icon);
		decorate();
	}

	public CheckBtn(Icon icon, boolean selected) {
		super(icon, selected);
		decorate();
	}

	public CheckBtn(String text) {
		super(text);
		decorate();
	}

	public CheckBtn(Action a) {
		super();
		setAction(a);
		decorate();
	}

	public CheckBtn(String text, boolean selected) {
		super(text, selected);
		decorate();
	}

	public CheckBtn(String text, Icon icon) {
		super(text, icon);
		decorate();
	}
	
	public void decorate() {
		setBounds(330,360,20,20);
	}
}
