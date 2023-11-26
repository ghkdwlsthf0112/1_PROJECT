package gui.layout.login.create_id_window.buttons;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import image.getImages;

public class ExitBtn extends JButton{
	final static ImageIcon cencelImage = new getImages().getImageIcon(30, 30, "src/image/icon_image/btn/XP.png");
	final static ImageIcon cencelCImage = new getImages().getImageIcon(30, 30, "src/image/icon_image/btn/X.png");

	public ExitBtn() {
		decorate();
	}
    
    public ExitBtn(String text) {
        super(text);
        decorate();
    }

    public ExitBtn(Action action) {
        super(action);
        decorate();
    }
    
    public ExitBtn(Icon icon) {
        super(icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    public ExitBtn(String text, Icon icon) {
        super(text, icon);
        setPressedIcon(icon);
        setRolloverSelectedIcon(icon);
        decorate();
    }

    protected void decorate() {
    	setIcon(cencelImage);
    	setPressedIcon(cencelCImage);
    	setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
		setBounds(620, 30, 30, 30);
        setBackground(new Color(0,0,0,0));
    }
}
