package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class FloorGuideBtn extends JButton{
	
	public FloorGuideBtn() {
		super("층별안내도");
		setFont(new Font("나눔고딕", Font.BOLD, 10));
//		setBounds(80, 999, 30, 15);
		setBackground(new Color(0,0,0,0));	
	}
}
