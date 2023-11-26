package gui.layout.main.check_in_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class FieldCheckInBtn extends JButton{
	final static ImageIcon FieldCheckIn = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/FieldCheckIn.png");	

	public FieldCheckInBtn() {
		decorate();
	}
    
    public FieldCheckInBtn(String text) {
        super(text);
        decorate();
    }

    public FieldCheckInBtn(Action action) {
        super(action);
        decorate();
    }
    
    public FieldCheckInBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }
    
    

    public FieldCheckInBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(FieldCheckIn);
    	setPressedIcon(FieldCheckIn);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setBounds(25, 615, 700, 170);
        setBackground(new Color(0,0,0,0));
    }
}
