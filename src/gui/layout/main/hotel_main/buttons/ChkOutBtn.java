package gui.layout.main.hotel_main.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ChkOutBtn extends JButton{
	final protected static ImageIcon checkOutImage = new getImages().getImageIcon(340, 170, "src/image/icon_image/btn/checkOut.png");
//	setBounds(15, 655, 365, 170);
	public ChkOutBtn() {
		decorate();
	}
    
    public ChkOutBtn(String text) {
        super(text);
        decorate();
    }

    public ChkOutBtn(Action action) {
        super(action);
        decorate();
    }

    public ChkOutBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public ChkOutBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(checkOutImage);
    	setPressedIcon(checkOutImage);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        setBounds(25, 615, 340, 170);
    }
}
