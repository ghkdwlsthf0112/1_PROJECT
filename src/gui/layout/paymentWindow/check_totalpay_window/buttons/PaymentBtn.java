package gui.layout.paymentWindow.check_totalpay_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class PaymentBtn extends JButton{
	final static ImageIcon iconImage = new getImages().getImageIcon(250, 50, "src/image/icon_image/btn/결제진행.png");
	final static ImageIcon pressedIconImage = new getImages().getImageIcon(250, 50, "src/image/icon_image/btn/결제P.png");

	public PaymentBtn() {
		decorate();
	}
    
    public PaymentBtn(String text) {
        super(text);
        decorate();
    }

    public PaymentBtn(Action action) {
        super(action);
        decorate();
    }
    
    public PaymentBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public PaymentBtn(String text, Icon icon) {
        super(text, icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(iconImage);
    	setPressedIcon(pressedIconImage);
    	setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
        setBounds(124,450,250,50);
        setBackground(new Color(0,0,0,0));
    }
}
