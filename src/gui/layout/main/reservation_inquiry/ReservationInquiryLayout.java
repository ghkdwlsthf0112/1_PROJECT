package gui.layout.main.reservation_inquiry;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationInquiryLayout extends JFrame {
	JTextField displayField;
	JLabel infoLabel;

	public ReservationInquiryLayout() {
		displayField = new JTextField(20);
		displayField.setEnabled(false);
		displayField.setHorizontalAlignment(JTextField.CENTER);
		infoLabel = new JLabel("<html>문자 또는 숙박업소에서 안내받은 <br>예약번호를 입력해주세요.<html>");
		infoLabel.setHorizontalAlignment(JTextField.CENTER);
		JPanel btnPanel = new JPanel(new GridLayout(4, 3));
		String[] btnLabel = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", "0", "Clear" };
		for (String label : btnLabel) {
			JButton putBtn = new JButton(label);
			putBtn.addActionListener(new NumberBtnListener());
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 10, 768, 1024);
		setVisible(true);
	}

	private class NumberBtnListener implements ActionListener {
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
	}

	public static void main(String[] args) {
		new ReservationInquiryLayout();
	}
}
