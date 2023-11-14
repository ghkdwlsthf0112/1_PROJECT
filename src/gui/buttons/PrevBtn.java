package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class PrevBtn extends JButton{
	public PrevBtn() {
		super("뒤로가기");
		setFont(new Font("나눔고딕", Font.BOLD, 10));
//		setBounds(10, 999, 30, 15);
		setBackground(new Color(0,0,0,0));	
	}
	
}
