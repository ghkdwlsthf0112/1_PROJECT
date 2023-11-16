package gui.buttons.numeric_keypad;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

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
    
    public NumericBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public NumericBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        setBounds(0, 0, 100, 100);
    }
}
