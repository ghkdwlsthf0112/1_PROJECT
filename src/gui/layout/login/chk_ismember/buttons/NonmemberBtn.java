package gui.layout.login.chk_ismember.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class NonmemberBtn extends JButton{
	
	public NonmemberBtn() {
		decorate();
		}
	    
	public NonmemberBtn(String text) {
	    super(text);
	    decorate();
	    }

	public NonmemberBtn(Action action) {
	    super(action);
	    decorate();
	    }
	    
	public NonmemberBtn(Icon icon) {
	    super(icon);
	    setPressedIcon(icon);
	    setRolloverSelectedIcon(icon);
	    decorate();
	    }
	    
	    

	public NonmemberBtn(String text, Icon icon) {
	    super(text, icon);
	    decorate();
	    }

	protected void decorate() {
	    setBorderPainted(false);
	    setOpaque(false);
	    setBackground(new Color(0,0,0,0));
    }
}
