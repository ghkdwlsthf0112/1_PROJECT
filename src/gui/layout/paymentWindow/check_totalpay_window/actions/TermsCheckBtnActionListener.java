package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import gui.layout.paymentWindow.check_totalpay_window.AgreePopupLayout;

public class TermsCheckBtnActionListener implements ActionListener{
	JScrollPane jscp1;
	JButton paymentBtn;
	JCheckBox chbox;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==chbox) {
			if(chbox.isSelected()==true) {
				paymentBtn.setEnabled(true);
			} else if (chbox.isSelected()==false) {
				paymentBtn.setEnabled(false);
			}
		}
		
	}
	
	public TermsCheckBtnActionListener(AgreePopupLayout mainFrame) {
		this.jscp1 = mainFrame.jscp1;
		this.paymentBtn = mainFrame.paymentBtn;
		this.chbox = mainFrame.chbox;
	}
}
