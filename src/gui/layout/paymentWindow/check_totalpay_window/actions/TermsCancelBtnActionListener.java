package gui.layout.paymentWindow.check_totalpay_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.login.create_id_window.MemberTerms;
import gui.layout.paymentWindow.check_totalpay_window.AgreePopupLayout;

public class TermsCancelBtnActionListener implements ActionListener{
	JButton cencelBtn;
	JFrame mainFrame;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cencelBtn) {
			mainFrame.dispose();
		}
		
	}
	 
	public TermsCancelBtnActionListener(AgreePopupLayout mainFrame) {
		this.cencelBtn = mainFrame.cencelBtn;
		this.mainFrame = mainFrame;
	}
	
	public TermsCancelBtnActionListener(MemberTerms mainFrame) {
		this.cencelBtn = mainFrame.cencelBtn;
		this.mainFrame = mainFrame;
	}
}
