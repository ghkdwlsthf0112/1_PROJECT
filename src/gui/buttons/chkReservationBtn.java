package gui.buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class chkReservationBtn extends JButton{
	public chkReservationBtn() {
		super("예약확인");
		setFont(new Font("나눔고딕", Font.BOLD, 40));
		setBounds(388, 655, 365, 170);
		setBackground(new Color(0,0,0,0));

	}
}
