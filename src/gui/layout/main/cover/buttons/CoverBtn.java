package gui.layout.main.cover.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class CoverBtn extends JButton{
	
	public CoverBtn() {

	}
    
    public CoverBtn(String text) {
        super(text);
        decorate();
    }

    public CoverBtn(Action action) {
        super(action);
        decorate();
    }
    
    public CoverBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public CoverBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
    	setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
}
