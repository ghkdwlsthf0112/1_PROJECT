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
import image.getImages;

public class ReservationInquiryLayout extends JFrame {
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/background4.png");
	static ImageIcon homeBtnImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	
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
		infoLabel.setBounds(10, 100, 300, 100);
		infoLabel.setFont(new Font("굴림", Font.BOLD, 15));
		btnPanel.setBounds(350, 50, 400, 400);
		add(displayField);
		add(btnPanel);
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
