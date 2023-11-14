package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class chkOutBtn extends JButton{
	public chkOutBtn() {
		super("체크아웃");
		setFont(new Font("나눔고딕", Font.BOLD, 40));
		setBounds(15, 655, 365, 170);
		setBackground(new Color(0,0,0,0));

	}
}
