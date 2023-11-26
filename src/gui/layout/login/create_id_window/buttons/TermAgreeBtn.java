package gui.layout.login.create_id_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class TermAgreeBtn extends JButton{
	final static ImageIcon iconImage = new getImages().getImageIcon(275, 50, "src/image/icon_image/btn/동의완료.png");
	final static ImageIcon pressedIconImage = new getImages().getImageIcon(275, 50, "src/image/icon_image/btn/동의완료P.png");

	public TermAgreeBtn() {
		decorate();
	}
    
    public TermAgreeBtn(String text) {
        super(text);
        decorate();
    }

    public TermAgreeBtn(Action action) {
        super(action);
        decorate();
    }
    
    public TermAgreeBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public TermAgreeBtn(String text, Icon icon) {
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
		setBounds(200, 480, 275, 50);
        setBackground(new Color(0,0,0,0));
    }
}
