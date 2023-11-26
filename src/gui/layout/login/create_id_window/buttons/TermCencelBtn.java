package gui.layout.login.create_id_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class TermCencelBtn extends JButton{
	final static ImageIcon iconImage = new getImages().getImageIcon(100, 50, "src/image/icon_image/btn/회원가입취소.png");
	final static ImageIcon pressedIconImage = new getImages().getImageIcon(100, 50, "src/image/icon_image/btn/회원가입취소P.png");

	public TermCencelBtn() {
		decorate();
	}
    
    public TermCencelBtn(String text) {
        super(text);
        decorate();
    }

    public TermCencelBtn(Action action) {
        super(action);
        decorate();
    }
    
    public TermCencelBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public TermCencelBtn(String text, Icon icon) {
        super(text, icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(iconImage);
    	setPressedIcon(pressedIconImage);
    	setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(75, 480, 100, 50);
        setBackground(new Color(0,0,0,0));
    }

}
