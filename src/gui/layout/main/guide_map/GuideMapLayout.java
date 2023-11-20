package gui.layout.main.guide_map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.guide_map.action.FloorBtnActionListener;
import gui.layout.main.guide_map.buttons.floorBtn;
import image.getImages;

public class GuideMapLayout extends JFrame {
	public JLabel floorLabel = new JLabel();
	
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/층별안내도.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	
	ImageIcon floor1Image = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/floor_1.png");
	ImageIcon floor2Image = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/floor_2.png");
	ImageIcon floor3Image = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/floor_3.png");
	ImageIcon floor4Image = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/floor_4.png");

	public JButton f1 = new floorBtn(floor1Image);
	public JButton f2 = new floorBtn(floor2Image);
	public JButton f3 = new floorBtn(floor3Image);
	public JButton f4 = new floorBtn(floor4Image);

	// 이미지 개수
	public final int numImages = 4;
		
	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);

	public GuideMapLayout() {
		setTitle("층별 안내도");
		setLayout(null);

		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		add(Label);
	
		
		floorLabel.setIcon(new getImages().getImageIcon(650, 470, "src/image/guide_map/가이드맵예시1.jpg"));
		floorLabel.setBounds(50, 300, 650, 470);
		Label.add(floorLabel);
				
		
		// 층별 버튼 1층 로비 2층 3층 객실 4층 옥상
		f1.setBounds(350, 100, 40, 40);
		f1.addActionListener(new FloorBtnActionListener(this));
		Label.add(f1);
		f2.setBounds(400, 100, 40, 40);
		f2.addActionListener(new FloorBtnActionListener(this));
		Label.add(f2);
		f3.setBounds(450, 100, 40, 40);
		f3.addActionListener(new FloorBtnActionListener(this));
		Label.add(f3);
		f4.setBounds(500, 100, 40, 40);
		f4.addActionListener(new FloorBtnActionListener(this));
		Label.add(f4);

		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
				
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}

	public static void main(String[] args) {
		new GuideMapLayout();
	}
}
