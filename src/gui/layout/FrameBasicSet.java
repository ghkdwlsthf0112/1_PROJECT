package gui.layout;

import javax.swing.JFrame;

public class FrameBasicSet extends JFrame{
	public FrameBasicSet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
}
