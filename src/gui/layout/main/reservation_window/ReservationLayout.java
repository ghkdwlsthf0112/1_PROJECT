package gui.layout.main.reservation_window;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.CalendarBtnActionListener;
import gui.buttons.CalendarBtn;
import image.getImages;

public class ReservationLayout extends JFrame  {
	
	static ImageIcon calendarImage = new getImages().getImageIcon(40, 40, "src/image/calendar/calendar1.png");
	
	static JTextField dateTextField;
	ActionListener CalendarBtnActionListener;
	public JButton calendarBtn = new CalendarBtn(calendarImage);
	
	public ReservationLayout() {
		
		setLayout(null);
//		JLabel imageLabel = new JLabel();
		JLabel chkInLabel = new JLabel("입실날짜");
		
		dateTextField = new JTextField(20);
		dateTextField.setHorizontalAlignment(chkInLabel.CENTER);
		dateTextField.setBounds(50, 100, 200, 80);
		dateTextField.setEnabled(false);
		
		calendarBtn.setBounds(500, 100, 40, 40);
		calendarBtn.addActionListener(new CalendarBtnActionListener(this));
		
		add(chkInLabel);
		add(dateTextField);
		add(calendarBtn);
		
		
		setTitle("객실 선택창");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}
	
//	public static void setDateTextField(String date) {
//		dateTextField.setText(date);
//	}
	
	
	
	public static void main(String[] args) {
		new ReservationLayout();
	}
	
	
}





















