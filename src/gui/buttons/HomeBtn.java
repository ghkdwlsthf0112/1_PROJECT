package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class HomeBtn extends JButton{

	public HomeBtn() {
		super("홈버튼");
		setFont(new Font("나눔고딕", Font.BOLD, 10));
//		setBounds(45, 999, 30, 15);
		setBackground(new Color(0,0,0,0));	
	}
}
