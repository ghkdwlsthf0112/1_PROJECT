package gui.calendar;

import java.util.Calendar;

import javax.swing.JButton;

public class CalendarFunction {
	JButton[] buttons;
	static Calendar cal = Calendar.getInstance();
	int year;
	int month;
	
	
	public CalendarFunction() {
		// 현재 년 가져오기
		year = cal.get(Calendar.YEAR);
		// 현재 월 가져오기
		month = cal.get(Calendar.MONTH) + 1;
	}
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	
	public String getCalText() {
		// 텍스트 
		return month + "월" + " " + year + "년";
	}
	
	
	public void calSet() {
		// 지정한 년월 1일로 객체 생성
		cal.set(year, month -1, 1);
		
		// 해당 월의 첫날 요일
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		
		// 배열 인덱스 조정 (0은 일요일)
		firstDay--;
		
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}
	}
	
	public void init(int gap) {
		
		// 버튼 초기화 (날짜 제거)
		for (int i = 7; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		
		// 달력 월 이동 (다음달 or 이전달)
		month += gap;
		if (month <= 0) {
			year--; // 이전 년도로 이동
			month = 12;
		} else if (month >= 13) {
			year++; // 다음 년도로 이동
			month = 1;
		}
		
		// 초기화 하고 새로운 달력 설정
		calSet();
	}
	
	
}


