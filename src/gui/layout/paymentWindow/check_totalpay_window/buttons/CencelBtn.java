package gui.layout.paymentWindow.check_totalpay_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class CencelBtn extends JButton{
	final static ImageIcon cencelImage = new getImages().getImageIcon(100, 50, "src/image/icon_image/btn/paycencel.png");
	final static ImageIcon cencelCImage = new getImages().getImageIcon(100, 50, "src/image/icon_image/btn/paycencel_c.png");

	public CencelBtn() {
		decorate();
	}
    
    public CencelBtn(String text) {
        super(text);
        decorate();
    }

    public CencelBtn(Action action) {
        super(action);
        decorate();
    }
    
    public CencelBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public CencelBtn(String text, Icon icon) {
        super(text, icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(cencelImage);
    	setPressedIcon(cencelCImage);
    	setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
        setBounds(10, 450, 100, 50);
        setBackground(new Color(0,0,0,0));
    }
}
