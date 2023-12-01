package gui.layout.main.cover;

import java.awt.Image;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import gui.layout.main.cover.actions.CoverBtnActionListener;
import gui.layout.main.cover.buttons.CoverBtn;
import image.getImages;

public class CoverLayout extends JFrame {
   public static ImageIcon mainImage1 = new getImages().getImageIcon(768, 1024,
         "src/image/background_image/background1.png");
   public static ImageIcon mainImage2 = new getImages().getImageIcon(768, 1024,
         "src/image/background_image/background2.png");
   public JButton coverBtn = new CoverBtn(mainImage1);
   int currentImgIndex = 0;
   public final String[] btn = { "src/image/background_image/background1.png",
         "src/image/background_image/background2.png" };

   public CoverLayout() {
      setLayout(null);

      coverBtn.setBounds(0, 0, 768, 1024);
      coverBtn.addActionListener(new CoverBtnActionListener(this));
      add(coverBtn);

      Timer changeImg = new Timer(3000, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {

            updateImg(coverBtn);
            currentImgIndex = (currentImgIndex + 1) % btn.length;

         }
      });
      changeImg.start();

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(550, 10);
      setSize(768, 1024);
      setUndecorated(true);
      setVisible(true);
      setResizable(false);
   }

   public void updateImg(JButton coverBtn2) {
      try {
         BufferedImage image = ImageIO.read(new File(btn[currentImgIndex]));
         Image scaledImage = image.getScaledInstance(768, 1024, Image.SCALE_SMOOTH);
         coverBtn.setIcon(new ImageIcon(scaledImage));

      } catch (IOException e) {
         System.out.println("이미지오류");
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new CoverLayout();
   }
}