package gui.layout.main.check_out_window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.check_out_window.actions.ChkOutResvBtnActionListener;
import gui.layout.main.reservation_inquiry.actions.NumberBtnActionListener;
import gui.layout.main.reservation_inquiry.buttons.NumericBtn;
import gui.layout.main.reservation_inquiry.buttons.ReservationOkBtn;
import image.getImages;

public class CheckOut extends JFrame {
	final static ImageIcon mainImage = new getImages().getImageIcon(768, 1024,
			"src/image/background_image/체크아웃화면.png");

	static ImageIcon btn1Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_1.png");
	static ImageIcon btn2Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_2.png");
	static ImageIcon btn3Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_3.png");
	static ImageIcon btn4Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_4.png");
	static ImageIcon btn5Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_5.png");
	static ImageIcon btn6Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_6.png");
	static ImageIcon btn7Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_7.png");
	static ImageIcon btn8Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_8.png");
	static ImageIcon btn9Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_9.png");
	static ImageIcon btnBackImage = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnBackP.png");
	static ImageIcon btn0Image = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/floor_0.png");
	static ImageIcon btnClearImage = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnAllDelW.png");
	static ImageIcon checkImage = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");

	static ImageIcon btn1ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_1.png");
	static ImageIcon btn2ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_2.png");
	static ImageIcon btn3ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_3.png");
	static ImageIcon btn4ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_4.png");
	static ImageIcon btn5ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_5.png");
	static ImageIcon btn6ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_6.png");
	static ImageIcon btn7ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_7.png");
	static ImageIcon btn8ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_8.png");
	static ImageIcon btn9ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_9.png");
	static ImageIcon btnBackImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnBack.png");
	static ImageIcon btn0ImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btn_0.png");
	static ImageIcon btnClearImageP = new getImages().getImageIcon(90, 90, "src/image/icon_image/btn/btnAllDel.png");
	static ImageIcon checkImageP = new getImages().getImageIcon(200, 80, "src/image/icon_image/btn/check.png");

	public JButton btn1 = new NumericBtn(btn1Image,btn1ImageP);
	public JButton btn2 = new NumericBtn(btn2Image,btn2ImageP);
	public JButton btn3 = new NumericBtn(btn3Image,btn3ImageP);
	public JButton btn4 = new NumericBtn(btn4Image,btn4ImageP);
	public JButton btn5 = new NumericBtn(btn5Image,btn5ImageP);
	public JButton btn6 = new NumericBtn(btn6Image,btn6ImageP);
	public JButton btn7 = new NumericBtn(btn7Image,btn7ImageP);
	public JButton btn8 = new NumericBtn(btn8Image,btn8ImageP);
	public JButton btn9 = new NumericBtn(btn9Image,btn9ImageP);
	public JButton btnBack = new NumericBtn(btnBackImage,btnBackImageP);
	public JButton btn0 = new NumericBtn(btn0Image,btn0ImageP);
	public JButton btnClear = new NumericBtn(btnClearImage,btnClearImageP);
	
	public JTextField displayField;
	public JLabel infoLabel;


	public JButton b1 = new PrevBtn();
	public JButton b2 = new HomeBtn();
	public JButton b3 = new ReservationOkBtn();

	public CheckOut() {
		setTitle("체크아웃");
		setLayout(null);
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);

		// 입력 숫자들 표시화면
		displayField = new JTextField(20) {
			@Override
			public void setBorder(Border border) {

			}
		};
		displayField.setForeground(Color.black);
		displayField.setFont(new Font("굴림", Font.BOLD, 80));
		displayField.setEnabled(false);
		displayField.setBackground(Color.white);
		displayField.setOpaque(false);
		displayField.setFocusable(false);

		displayField.setBounds(40, 320, 300, 150);
//				displayField.setBackground(new Color(0,0,0,0));
		add(displayField);

		// 숫자패드 버튼들
		btn1.setBounds(0 + 410, 0 + 320, 100, 100);
		btn1.addActionListener(new NumberBtnActionListener(this));
		add(btn1);

		btn2.setBounds(100 + 410, 0 + 320, 100, 100);
		btn2.addActionListener(new NumberBtnActionListener(this));
		add(btn2);

		btn3.setBounds(200 + 410, 0 + 320, 100, 100);
		btn3.addActionListener(new NumberBtnActionListener(this));
		add(btn3);

		btn4.setBounds(0 + 410, 100 + 320, 100, 100);
		btn4.addActionListener(new NumberBtnActionListener(this));
		add(btn4);

		btn5.setBounds(100 + 410, 100 + 320, 100, 100);
		btn5.addActionListener(new NumberBtnActionListener(this));
		add(btn5);

		btn6.setBounds(200 + 410, 100 + 320, 100, 100);
		btn6.addActionListener(new NumberBtnActionListener(this));
		add(btn6);

		btn7.setBounds(0 + 410, 200 + 320, 100, 100);
		btn7.addActionListener(new NumberBtnActionListener(this));
		add(btn7);

		btn8.setBounds(100 + 410, 200 + 320, 100, 100);
		btn8.addActionListener(new NumberBtnActionListener(this));
		add(btn8);

		btn9.setBounds(200 + 410, 200 + 320, 100, 100);
		btn9.addActionListener(new NumberBtnActionListener(this));
		add(btn9);

		btnBack.setBounds(0 + 410, 300 + 320, 100, 100);
		btnBack.addActionListener(new NumberBtnActionListener(this));
		add(btnBack);

		btn0.setBounds(100 + 410, 300 + 320, 100, 100);
		btn0.addActionListener(new NumberBtnActionListener(this));
		add(btn0);

		btnClear.setBounds(200 + 410, 300 + 320, 100, 100);
		btnClear.addActionListener(new NumberBtnActionListener(this));
		add(btnClear);

		b1.addActionListener(new HomeBtnActionListener(this));
		add(b1);

		b2.addActionListener(new PrevBtnActionListener(this));
		add(b2);

		b3.addActionListener(new ChkOutResvBtnActionListener(this));
		b3.setEnabled(false);
		add(b3);

		add(Label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new CheckOut();
	}
}
