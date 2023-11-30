package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.calendar.ReservationCalendar;
import gui.layout.main.reservation_window.ReservationLayout;


public class CalendarBtnActionListener implements ActionListener {

	ReservationLayout mainFrame;
	JButton CalendarBtn;
	// 달력 창 1개 이상 못 열게 제한
	int calendarWindowTest = 0;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == CalendarBtn) {
			if (calendarWindowTest == 0) {
				new ReservationCalendar(mainFrame);
//				calendarWindowTest = 1;
			}
		}
	}
	
	
	public CalendarBtnActionListener(ReservationLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.CalendarBtn = mainFrame.calendarBtn1;
	}
	
}
