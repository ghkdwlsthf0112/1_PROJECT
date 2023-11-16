package gui.layout.main.check_in_window;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CheckInLayout {
	  public static void main(String[] args) {
	        JFrame frm = new JFrame("CheckIn");
	        frm.setSize(768, 1024);
	        frm.setLocationRelativeTo(null);
	        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frm.getContentPane().setLayout(null);

	        String[] names = {"예약체크인", "현장체크인"};
	        String[] imagePaths = {"src/image/icon_image/btn/CheckInReservation.png",
	                               "src/image/icon_image/btn/FieldCheckIn.png"};

	        for (int i = 0; i < names.length; i++) {
	            JButton button = new JButton(names[i]);
	            ImageIcon icon = new ImageIcon(imagePaths[i]);
	            
	            
	            Image img = icon.getImage().getScaledInstance(648, 150, Image.SCALE_SMOOTH);
	            ImageIcon resizedIcon = new ImageIcon(img);
	            
	            button.setIcon(resizedIcon);
	            button.setSize(648, 150);
	            button.setLocation(50, 450 + 200 * i);

	            frm.add(button);
	        }

	        frm.setVisible(true);
	  }
}
