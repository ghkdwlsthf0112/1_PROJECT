package gui.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MemberBtn extends JButton{
	
	public MemberBtn() {
		decorate();
	}
    
    public MemberBtn(String text) {
        super(text);
        decorate();
    }

    public MemberBtn(Action action) {
        super(action);
        decorate();
    }
    
    public MemberBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }
    
    

    public MemberBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
}

