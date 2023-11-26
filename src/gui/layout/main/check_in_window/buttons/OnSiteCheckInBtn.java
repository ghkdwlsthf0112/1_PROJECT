package gui.layout.main.check_in_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class OnSiteCheckInBtn extends JButton{
	final protected static ImageIcon CheckInReservation = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/CheckInReservation.png");

	
	public OnSiteCheckInBtn() {
		decorate();
	}
    
    public OnSiteCheckInBtn(String text) {
        super(text);
        decorate();
    }

    public OnSiteCheckInBtn(Action action) {
        super(action);
        decorate();
    }
    
    public OnSiteCheckInBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }
    
    

    public OnSiteCheckInBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(CheckInReservation);
    	setPressedIcon(CheckInReservation);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setBounds(25, 440, 700, 170);
        setBackground(new Color(0,0,0,0));
    }
}
