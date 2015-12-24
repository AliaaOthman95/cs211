package eg.edu.alexu.csd.oop.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class Meal  extends GameObjectImpl implements IPic{
	private BufferedImage[] spriteImages= getSpriteImages();
	private WorldImplementation world = WorldImplementation.getInstance(0, 0);
	private Map images=world.getImages();
	@Override
	public void draw() {
		try {
			this.setPath("/meal.png");
			if(images.get("meal")!=null)
				spriteImages[0]=(BufferedImage) images.get("meal");
			else {
				spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(this.getPath()));
				images.put("meal",spriteImages[0] );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setClown(false);
		this.setHeight(spriteImages[0].getHeight());
		this.setWidth(spriteImages[0].getWidth());
		
	}

}