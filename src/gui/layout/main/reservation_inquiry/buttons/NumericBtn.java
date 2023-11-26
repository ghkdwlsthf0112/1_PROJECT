package gui.layout.main.reservation_inquiry.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;

import gui.layout.main.reservation_inquiry.actions.NumberBtnActionListener;

public class NumericBtn extends JButton{

	public NumericBtn() {
	}
    
    public NumericBtn(String text) {
        super(text);
        decorate();
    }

    public NumericBtn(Action action) {
        super(action);
        decorate();
    }
    
    public NumericBtn(Icon icon,Icon iconP) {
        super(icon);
        setPressedIcon(iconP);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public NumericBtn(String text, Icon icon) {
        super(text, icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
        setFocusPainted(false);
        setBackground(new Color(0,0,0,0));
    }
}
