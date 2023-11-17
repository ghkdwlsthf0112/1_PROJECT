package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton) e.getSource();
		if(e.getSource()== btn0) {
			source.setText("0");
		} else if(e.getSource()== btn1) {
			source.setText("1");
		} else if(e.getSource()== btn2) {
			source.setText("2");
		} else if(e.getSource()== btn3) {
			source.setText("3");
		} else if(e.getSource()== btn4) {
			source.setText("4");
		} else if(e.getSource()== btn5) {
			source.setText("5");
		} else if(e.getSource()== btn6) {
			source.setText("6");
		} else if(e.getSource()== btn7) {
			source.setText("7");
		} else if(e.getSource()== btn8) {
			source.setText("8");
		} else if(e.getSource()== btn9) {
			source.setText("9");
		}
		String currentText = displayField.getText();
		if (e.getSource()== btnClear) {
			displayField.setText("");
		} else if (e.getSource()== btnBack) {
			if (currentText.length() > 0) {
				displayField.setText(currentText.substring(0, currentText.length() - 1));
			}
		} else {
			if (currentText.length() < 6) {
				displayField.setText(currentText + source.getText());
			}
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

	}
	

}
