package gui.layout.main.reservation_inquiry;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.HomeBtnActionListener;
import actions.NumberBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.buttons.numeric_keypad.NumericBtn;
import gui.buttons.numeric_keypad.NumericKeypad;
import image.getImages;

public class ReservationInquiryLayout extends JFrame {
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	
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

	
	
	public JTextField displayField;
	public JLabel infoLabel;

	public JButton b1 = new HomeBtn(homeBtnImage);
	ActionListener HomeBtnActionListener;
	public JButton b2 = new PrevBtn(backImage);
	ActionListener PrevBtnActionListener;
	
	ActionListener NumberBtnActionListener;
	public ReservationInquiryLayout() {
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		displayField = new JTextField(20);
		displayField.setEnabled(false);
		displayField.setBackground(Color.black);
		displayField.setHorizontalAlignment(JTextField.CENTER);
		infoLabel = new JLabel("<html>문자 또는 숙박업소에서 안내받은 <br>예약번호를 입력해주세요.<html>");
		infoLabel.setHorizontalAlignment(JTextField.CENTER);
		JPanel btnPanel = new JPanel(new GridLayout(4, 3));
		String[] btnLabel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", "0", "Clear" };
		for (String label : btnLabel) {
			JButton putBtn = new JButton(label);
			putBtn.addActionListener(new NumberBtnActionListener(this));
			btnPanel.add(putBtn);
		}
		JButton confirmBtn = new JButton("확 인");
		setLayout(null);
		displayField.setBounds(10, 10, 200, 100);
		displayField.setFont(new Font("굴림", Font.BOLD, 40));
		infoLabel.setBounds(10, 600, 300, 100);
		infoLabel.setFont(new Font("굴림", Font.BOLD, 15));
		// 버튼
		btnPanel.setBounds(380, 300, 300, 400);
		add(displayField);
//		add(btnPanel);
		
		JButton btn1 = new NumericBtn(btn1Image);
		btn1.setBounds(0+380, 0+300, 100, 100);
		btn1.setText("1");
		btn1.addActionListener(new NumberBtnActionListener(this));
		add(btn1);
		
		JButton btn2 = new NumericBtn(btn2Image);
		btn2.setBounds(100+380, 0+300, 100, 100);
		btn2.setText("2");
		btn2.addActionListener(new NumberBtnActionListener(this));
		add(btn2);

		JButton btn3 = new NumericBtn(btn3Image);
		btn3.setBounds(200+380, 0+300, 100, 100);
		btn3.setText("3");
		btn3.addActionListener(new NumberBtnActionListener(this));
		add(btn3);

		JButton btn4 = new NumericBtn(btn4Image);
		btn4.setBounds(0+380, 100+300, 100, 100);
		btn4.setText("4");
		btn4.addActionListener(new NumberBtnActionListener(this));
		add(btn4);

		JButton btn5 = new NumericBtn(btn5Image);
		btn5.setBounds(100+380, 100+300, 100, 100);
		btn5.setText("5");
		btn5.addActionListener(new NumberBtnActionListener(this));
		add(btn5);

		JButton btn6 = new NumericBtn(btn6Image);
		btn6.setBounds(200+380, 100+300, 100, 100);
		btn6.addActionListener(new NumberBtnActionListener(this));
		add(btn6);

		JButton btn7 = new NumericBtn(btn7Image);
		btn7.setBounds(0+380, 200+300, 100, 100);
		btn7.setText("7");
		btn7.addActionListener(new NumberBtnActionListener(this));
		add(btn7);

		JButton btn8 = new NumericBtn(btn8Image);
		btn8.setBounds(100+380, 200+300, 100, 100);
		btn8.setText("8");
		btn8.addActionListener(new NumberBtnActionListener(this));
		add(btn8);

		JButton btn9 = new NumericBtn(btn9Image);
		btn9.setBounds(200+380, 200+300, 100, 100);
		btn9.setText("9");
		btn9.addActionListener(new NumberBtnActionListener(this));
		add(btn9);

		JButton btnBack = new NumericBtn(btnBackImage);
		btnBack.setBounds(0+380, 300+300, 100, 100);
		btnBack.setText("<");
		btnBack.addActionListener(new NumberBtnActionListener(this));
		add(btnBack);

		JButton btn0 = new NumericBtn(btn0Image);
		btn0.setBounds(100+380, 300+300, 100, 100);
		btn0.setText("0");
		btn0.addActionListener(new NumberBtnActionListener(this));
		add(btn0);

		JButton btnClear = new NumericBtn(btnClearImage);
		btnClear.setBounds(200+380, 300+300, 100, 100);
		btnClear.setText("Clear");
		btnClear.addActionListener(new NumberBtnActionListener(this));
		add(btnClear);
		
		
//		add(new NumericKeypad());
		add(infoLabel);
		setTitle("예약 조회");
		
		
		b1.addActionListener(new HomeBtnActionListener(this));
		add(b1);
		
		b2.addActionListener(new PrevBtnActionListener(this));
		imageLabel.add(b2);
		
		add(imageLabel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ReservationInquiryLayout();
	}
}
