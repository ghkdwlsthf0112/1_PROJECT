package gui.layout.main.hotel_main.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class AdminBtn extends JButton{
//	
	public AdminBtn() {
		decorate();
	}
	
	public AdminBtn(String text) {
        super(text);
        decorate();
    }

    public AdminBtn(Action action) {
        super(action);
        decorate();
    }

    public AdminBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public AdminBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setBorderPainted(false);
        setFocusPainted(false);      
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        setBounds(738, 10, 20, 20);
    }
}
