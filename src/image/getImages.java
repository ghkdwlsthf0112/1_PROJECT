package image;

import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class getImages extends Label{
	/**
	 * 
	 * @param x 사진 가로사이즈 
	 * @param y 사진 세로사이즈
	 * @param imageRoute = ex) "src/image/hotel_logo/delunaHotelLogo_black.png"
	 */
	public ImageIcon getImageIcon(int x , int y, String imageRoute) {
		try {
			// 1. 이미지의 크기를 수정하기위해 불러온다
			BufferedImage bufferedImage =
					ImageIO.read(new File(imageRoute));
			
			// 2. 불러온 이미지로부터 사이즈 조절된 새로운 인스턴스를 받을 수 있다
			Image scaledImage =
					bufferedImage.getScaledInstance(x, y, Image.SCALE_SMOOTH);
			// 3. 크기 조절된 이미지를 라벨에 붙인다
			ImageIcon image = new ImageIcon(scaledImage);
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 사진 크기 조정이 필요없다면...
	public ImageIcon getImageIcon(String imageRoute) {
		try {
			// 1. 이미지의 크기를 수정하기위해 불러온다
			BufferedImage bufferedImage =
					ImageIO.read(new File(imageRoute));
			
			// 2. 크기 조절된 이미지를 라벨에 붙인다
			ImageIcon image = new ImageIcon(bufferedImage);
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
