package gui.layout.login.chk_ismember.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class NonmemberBtn extends JButton{
	final static ImageIcon nonmemberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/NonMemberCustomers.png");

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
		setIcon(nonmemberImage);
    	setPressedIcon(nonmemberImage);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setBounds(25, 615, 700, 170);
	    setBackground(new Color(0,0,0,0));
    }
}
