package gui.layout.login.chk_ismember.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class MemberBtn extends JButton{
	final static ImageIcon memberImage = new getImages().getImageIcon(710, 170, "src/image/icon_image/btn/MemberCustomers.png");

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
    	setIcon(memberImage);
    	setPressedIcon(memberImage);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setBounds(25, 440, 700, 170);
        setBackground(new Color(0,0,0,0));
    }
}

