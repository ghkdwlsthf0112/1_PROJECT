package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class AdminBtn extends JButton{

	public AdminBtn() {
		super("관리자 버튼");
		setFont(new Font("나눔고딕", Font.BOLD, 10));
		setBounds(738, 10, 20, 20);
		setBackground(new Color(0,0,0,0));	
	}
}
