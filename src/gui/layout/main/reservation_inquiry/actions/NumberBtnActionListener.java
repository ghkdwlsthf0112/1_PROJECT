package gui.layout.main.reservation_inquiry.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import gui.layout.main.check_out_window.CheckOut;
import gui.layout.main.reservation_inquiry.ReservationChkInNow;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class NumberBtnActionListener implements ActionListener{
	JTextField displayField;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JButton btnBack;
	JButton btn0;
	JButton btnClear;
	
	JButton ReservationOkBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 스트링 빌더로 화면에 띄워줄 인스턴스 생성
		StringBuilder source = new StringBuilder();
		
		// 버튼별 입력시 들어갈 char값 설정
		if(e.getSource()== btn0) {
			source.append('0');
		} else if(e.getSource()== btn1) {
			source.append("1");
		} else if(e.getSource()== btn2) {
			source.append("2");
		} else if(e.getSource()== btn3) {
			source.append("3");
		} else if(e.getSource()== btn4) {
			source.append("4");
		} else if(e.getSource()== btn5) {
			source.append("5");
		} else if(e.getSource()== btn6) {
			source.append("6");
		} else if(e.getSource()== btn7) {
			source.append("7");
		} else if(e.getSource()== btn8) {
			source.append("8");
		} else if(e.getSource()== btn9) {
			source.append("9");
		}
		
		// 밑에서 글자수 제한이랑 디스플레이에서 삭제 밑 클리어 조건 추가
		String currentText = displayField.getText();
		if (e.getSource()== btnClear) {
			displayField.setText("");
		} else if (e.getSource()== btnBack) {
			if (currentText.length() > 0) {
				displayField.setText(currentText.substring(0, currentText.length() - 1));
			}
		} else {
			if (currentText.length() < 6) {
				displayField.setText(currentText + source.toString());
			}
		}		
		
		if(displayField.getText().length()==6) {
			ReservationOkBtn.setEnabled(true);
		} else {
			ReservationOkBtn.setEnabled(false);
		}
	}

	public NumberBtnActionListener(ReservationInquiryLayout mainFrame) {
		this.displayField = mainFrame.displayField;
		this.btn1 = mainFrame.btn1;
		this.btn2 = mainFrame.btn2;
		this.btn3 = mainFrame.btn3;
		this.btn4 = mainFrame.btn4;
		this.btn5 = mainFrame.btn5;
		this.btn6 = mainFrame.btn6;
		this.btn7 = mainFrame.btn7;
		this.btn8 = mainFrame.btn8;
		this.btn9 = mainFrame.btn9;
		this.btnBack = mainFrame.btnBack;
		this.btn0 = mainFrame.btn0;
		this.btnClear = mainFrame.btnClear;
		this.ReservationOkBtn = mainFrame.b3;

	}
	
	public NumberBtnActionListener(ReservationChkInNow mainFrame) {
		this.displayField = mainFrame.displayField;
		this.btn1 = mainFrame.btn1;
		this.btn2 = mainFrame.btn2;
		this.btn3 = mainFrame.btn3;
		this.btn4 = mainFrame.btn4;
		this.btn5 = mainFrame.btn5;
		this.btn6 = mainFrame.btn6;
		this.btn7 = mainFrame.btn7;
		this.btn8 = mainFrame.btn8;
		this.btn9 = mainFrame.btn9;
		this.btnBack = mainFrame.btnBack;
		this.btn0 = mainFrame.btn0;
		this.btnClear = mainFrame.btnClear;
		this.ReservationOkBtn = mainFrame.b3;

	}
	
	public NumberBtnActionListener(CheckOut mainFrame) {
		this.displayField = mainFrame.displayField;
		this.btn1 = mainFrame.btn1;
		this.btn2 = mainFrame.btn2;
		this.btn3 = mainFrame.btn3;
		this.btn4 = mainFrame.btn4;
		this.btn5 = mainFrame.btn5;
		this.btn6 = mainFrame.btn6;
		this.btn7 = mainFrame.btn7;
		this.btn8 = mainFrame.btn8;
		this.btn9 = mainFrame.btn9;
		this.btnBack = mainFrame.btnBack;
		this.btn0 = mainFrame.btn0;
		this.btnClear = mainFrame.btnClear;
		this.ReservationOkBtn = mainFrame.b3;

	}
	

}
