package gui.layout.main.admin_window.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.layout.main.admin_window.AdminLayout;

public class ExitProgramActionListiner implements ActionListener{
	JFrame mainFrame;
	JButton exitBtn;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitBtn) {
			mainFrame.dispose();
		}
		
	}
	public ExitProgramActionListiner(AdminLayout mainFrame) {
		this.mainFrame = mainFrame;
		this.exitBtn = mainFrame.b3;
	}
}
