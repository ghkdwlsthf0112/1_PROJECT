package gui.layout.main.check_in_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class OnSiteCheckInBtn extends JButton{
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
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
}
