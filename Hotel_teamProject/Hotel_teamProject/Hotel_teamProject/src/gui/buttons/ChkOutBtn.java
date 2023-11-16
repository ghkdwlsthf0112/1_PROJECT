package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class ChkOutBtn extends JButton{
//	setBounds(15, 655, 365, 170);
	public ChkOutBtn() {

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
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
}
