package eg.edu.alexu.csd.oop.game;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackGroundHard  extends GameObjectImpl implements IPic{
	private BufferedImage[] spriteImages= getSpriteImages();

	public BackGroundHard(){

		try {
			Image img  = ImageIO.read(getClass().getResourceAsStream("/back3.png"));
			img = img.getScaledInstance(1400,900,Image.SCALE_SMOOTH) ;
			spriteImages[0]  = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics = spriteImages[0] .createGraphics();
		    graphics.drawImage(img, 0, 0, null);
		    graphics.setStroke(new BasicStroke()) ;
			graphics.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw() {
			
				setClown(false);
				this.setHeight(spriteImages[0].getHeight());
				this.setWidth(spriteImages[0].getWidth());
				this.setX(0);
				this.setY(0);
		
	}
	
}
