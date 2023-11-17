package gui.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationCalendar extends JFrame implements ActionListener {
	Container container = getContentPane();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton prevBtn = new JButton("<");
	JButton nextBtn = new JButton(">");
	
	JLabel label = new JLabel("0월 00년");
	
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	
	private JLabel selectDateLabel = new JLabel("선택한 날짜");
	private JTextField selectDateTextField = new JTextField(10);
	
	CalendarFunction cf = new CalendarFunction();
	
	public ReservationCalendar() {
		setTitle("체크인 체크아웃 날짜");
		setSize(500, 400);
		setLocation(400, 400);
		init();
		start();
		setVisible(true);
		
		panel1.add(selectDateLabel);
		panel1.add(selectDateTextField);
		
		for (int i = 7; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}
	
	private void init() {
		 container.setLayout(new BorderLayout());
		 container.add("North", panel1);
		 container.add("Center", panel2);
		 
		 panel1.setLayout(new FlowLayout());
		 
		 panel1.add(prevBtn);
		 panel1.add(label);
		 panel1.add(nextBtn);
		 
		 Font font = new Font("SansSerif", Font.BOLD, 20);
		 nextBtn.setFont(font);
		 prevBtn.setFont(font);
		 label.setFont(font);
		 
//		 prevBtn.setEnabled(false);
		 
		 label.setText(cf.getCalText());
		 
		 panel2.setLayout(new GridLayout(7, 7, 5, 5));
		
		 for(int i = 0; i < buttons.length; i++) {
			 buttons[i] = new JButton();
			 panel2.add(buttons[i]);
			 
			 buttons[i].setForeground(new Color(0, 0, 0));
			 buttons[i].setBackground(new Color(255, 255, 255));
			 
			 buttons[i].setFont(new Font("SansSerif", Font.BOLD, 12));
			 
			 // 요일 클릭 안되게
			 if (i < 7) {
				 buttons[i].setText(dayNames[i]);
				 buttons[i].setEnabled(false);
			 }
			 
			 // 일요일 빨간색 
			 if (i % 7 == 0) {
				 buttons[i].setForeground(Color.RED);
			 }
			 
			 // 토요일 파란색
			 if (i % 7 == 6) {
				 buttons[i].setForeground(Color.BLUE);
			 }
		 }
		 
		 cf.setButtons(buttons);
		 cf.calSet();
	}
	
	// 이벤트 시작 메서드
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		nextBtn.addActionListener(this);
		prevBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 7; i < buttons.length; i++) {
			if (e.getSource() == buttons[i]) {
				String selectDate = buttons[i].getText();
				selectDateTextField.setText(selectDate);
			}
		}
		
		int gap = 0;
		if (e.getSource() == nextBtn) { // 다음 버튼 클릭
			gap = 1;
		} else if (e.getSource() == prevBtn ) { // 이전 버튼 클릭
			gap = -1;
		}
		
		cf.init(gap); // CalendarFunction의 init메서드를 호출해서 달력 업데이트
		label.setText(cf.getCalText());	 // 년월 표시 라벨 갱신
		
	}
	
	
	public static void main(String[] args) {
		new ReservationCalendar();
	}
}
