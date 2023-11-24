package gui.layout.main.hotel_main.buttons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ChkInBtn extends JButton{
	final protected static ImageIcon checkInImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/checkIn.png");

	public ChkInBtn() {
		decorate();
	}
    
    public ChkInBtn(String text) {
        super(text);
        decorate();
    }

    public ChkInBtn(Action action) {
        super(action);
        decorate();
    }
    
    public ChkInBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }
    
    

    public ChkInBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(checkInImage);
    	setPressedIcon(checkInImage);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
}
