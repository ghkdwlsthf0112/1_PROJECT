package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class chkInBtn extends JButton{
	public chkInBtn() {
		super("체  크  인");
		setFont(new Font("나눔고딕", Font.BOLD, 55));
		setBounds(15, 480, 738, 170);
		setBackground(new Color(0,0,0,0));

	}
}
