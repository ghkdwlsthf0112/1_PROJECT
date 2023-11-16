package gui.buttons.numeric_keypad;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.NumberBtnActionListener;
import image.getImages;

public class NumericKeypad extends JPanel{
	static ImageIcon btn1Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_1.png");
	static ImageIcon btn2Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_2.png");
	static ImageIcon btn3Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_3.png");
	static ImageIcon btn4Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_4.png");
	static ImageIcon btn5Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_5.png");
	static ImageIcon btn6Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_6.png");
	static ImageIcon btn7Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_7.png");
	static ImageIcon btn8Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_8.png");
	static ImageIcon btn9Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_9.png");
	static ImageIcon btnBackImage = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnBack.png");
	static ImageIcon btn0Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_0.png");
	static ImageIcon btnClearImage = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnAllDel.png");
	
	
	public NumericKeypad() {
		setLayout(null);
		JButton btn1 = new NumericBtn(btn1Image);
		btn1.setBounds(0, 0, 100, 100);
		add(btn1);
		
		JButton btn2 = new NumericBtn(btn2Image);
		btn2.setBounds(100, 0, 100, 100);
		add(btn2);

		JButton btn3 = new NumericBtn(btn3Image);
		btn3.setBounds(200, 0, 100, 100);
		add(btn3);

		JButton btn4 = new NumericBtn(btn4Image);
		btn4.setBounds(0, 100, 100, 100);
		add(btn4);

		JButton btn5 = new NumericBtn(btn5Image);
		btn5.setBounds(100, 100, 100, 100);
		add(btn5);

		JButton btn6 = new NumericBtn(btn6Image);
		btn6.setBounds(200, 100, 100, 100);
		add(btn6);

		JButton btn7 = new NumericBtn(btn7Image);
		btn7.setBounds(0, 200, 100, 100);
		add(btn7);

		JButton btn8 = new NumericBtn(btn8Image);
		btn8.setBounds(100, 200, 100, 100);
		add(btn8);

		JButton btn9 = new NumericBtn(btn9Image);
		btn9.setBounds(200, 200, 100, 100);
		add(btn9);

		JButton btnBack = new NumericBtn(btnBackImage);
		btnBack.setBounds(0, 300, 100, 100);
		add(btnBack);

		JButton btn0 = new NumericBtn(btn0Image);
		btn0.setBounds(100, 300, 100, 100);
		add(btn0);

		JButton btnClear = new NumericBtn(btnClearImage);
		btnClear.setBounds(200, 300, 100, 100);
		add(btnClear);

		setBounds(380, 300, 300, 400);
		setBackground(new Color(0,0,0,0));
	}
	
}
