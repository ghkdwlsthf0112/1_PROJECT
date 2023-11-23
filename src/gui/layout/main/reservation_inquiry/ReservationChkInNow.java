package gui.layout.main.reservation_inquiry;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.reservation_inquiry.actions.ChkReservIsExistActionListener;
import gui.layout.main.reservation_inquiry.actions.NumberBtnActionListener;
import gui.layout.main.reservation_inquiry.buttons.NumericBtn;
import gui.layout.main.reservation_inquiry.buttons.ReservationOkBtn;
import image.getImages;

public class ReservationChkInNow extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/ReservationInquiryLayout.png");
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
	static ImageIcon checkImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");

	
	
	public JTextField displayField;
	public JLabel infoLabel;

	public JButton b1 = new HomeBtn(homeBtnImage);
	ActionListener HomeBtnActionListener;
	public JButton b2 = new PrevBtn(backImage);
	ActionListener PrevBtnActionListener;
	public JButton b3 = new ReservationOkBtn(checkImage);
	ActionListener ChkReservationIsExistActionListener;

	public JButton btn1 = new NumericBtn(btn1Image);
	public JButton btn2 = new NumericBtn(btn2Image);
	public JButton btn3 = new NumericBtn(btn3Image);
	public JButton btn4 = new NumericBtn(btn4Image);
	public JButton btn5 = new NumericBtn(btn5Image);
	public JButton btn6 = new NumericBtn(btn6Image);
	public JButton btn7 = new NumericBtn(btn7Image);
	public JButton btn8 = new NumericBtn(btn8Image);
	public JButton btn9 = new NumericBtn(btn9Image);
	public JButton btnBack = new NumericBtn(btnBackImage);
	public JButton btn0 = new NumericBtn(btn0Image);
	public JButton btnClear = new NumericBtn(btnClearImage);
	
	
	ActionListener NumberBtnActionListener;
	public ReservationChkInNow() {
		setTitle("예약체크인");
		setLayout(null);
		
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 768, 1024);
		imageLabel.setIcon(mainImage);
		
		// 입력 숫자들 표시화면
		displayField = new JTextField(20);
		displayField.setEnabled(false);
		displayField.setForeground(Color.black);
		displayField.setBackground(Color.white);
		displayField.setBounds(40, 320, 300, 150);
		displayField.setFont(new Font("굴림", Font.BOLD, 80));	
//		displayField.setBackground(new Color(0,0,0,0));
		add(displayField);
		
		// 숫자패드 버튼들
		btn1.setBounds(0+400, 0+300, 100, 100);
		btn1.addActionListener(new NumberBtnActionListener(this));
		add(btn1);
		
		btn2.setBounds(100+400, 0+300, 100, 100);
		btn2.addActionListener(new NumberBtnActionListener(this));
		add(btn2);

		btn3.setBounds(200+400, 0+300, 100, 100);
		btn3.addActionListener(new NumberBtnActionListener(this));
		add(btn3);

		btn4.setBounds(0+400, 100+300, 100, 100);
		btn4.addActionListener(new NumberBtnActionListener(this));
		add(btn4);

		btn5.setBounds(100+400, 100+300, 100, 100);
		btn5.addActionListener(new NumberBtnActionListener(this));
		add(btn5);

		btn6.setBounds(200+400, 100+300, 100, 100);
		btn6.addActionListener(new NumberBtnActionListener(this));
		add(btn6);

		btn7.setBounds(0+400, 200+300, 100, 100);
		btn7.addActionListener(new NumberBtnActionListener(this));
		add(btn7);

		btn8.setBounds(100+400, 200+300, 100, 100);
		btn8.addActionListener(new NumberBtnActionListener(this));
		add(btn8);

		btn9.setBounds(200+400, 200+300, 100, 100);
		btn9.addActionListener(new NumberBtnActionListener(this));
		add(btn9);

		btnBack.setBounds(0+400, 300+300, 100, 100);
		btnBack.addActionListener(new NumberBtnActionListener(this));
		add(btnBack);

		btn0.setBounds(100+400, 300+300, 100, 100);
		btn0.addActionListener(new NumberBtnActionListener(this));
		add(btn0);

		btnClear.setBounds(200+400, 300+300, 100, 100);
		btnClear.addActionListener(new NumberBtnActionListener(this));
		add(btnClear);
		
				
		
		b1.addActionListener(new HomeBtnActionListener(this));
		add(b1);
		
		b2.addActionListener(new PrevBtnActionListener(this));
		add(b2);
		
		b3.addActionListener(new ChkReservIsExistActionListener(this));
		b3.setBounds(85, 600, 200, 80);
		b3.setEnabled(false);
		add(b3);
		
		add(imageLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		new ReservationChkInNow();
	}
}
