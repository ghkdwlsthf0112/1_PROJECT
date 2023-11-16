package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.buttons.numeric_keypad.NumericKeypad;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class NumberBtnActionListener implements ActionListener{
	JTextField displayField;
	JLabel infoLabel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		String currentText = displayField.getText();
		if (source.getText().equals("Clear")) {
			displayField.setText("");
		} else if (source.getText().equals("<")) {
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
		this.infoLabel = mainFrame.infoLabel;
	}
	

}
