package eg.edu.alexu.csd.oop.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;

public class Collector  extends GameObjectImpl implements IPic{
	private BufferedImage[] spriteImages= getSpriteImages();
	private Stack rightHand = new Stack ();
	private Stack leftHand = new Stack ();
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		try {
			this.setPath("/collector.png");
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(this.getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setClown(true);
		this.setHeight(spriteImages[0].getHeight());
		this.setWidth(spriteImages[0].getWidth());
		//System.out.println(getHeight()+" "+getWidth());
		
		
	}
	
	@Override
	public void setRightHand(Stack x) {
		// TODO Auto-generated method stub
		rightHand=x;
	}

	@Override
	public void setLeftHand(Stack x) {
		// TODO Auto-generated method stub
		leftHand=x;
	}

	@Override
	public Stack getRightHand() {
		// TODO Auto-generated method stub
		return rightHand;
	}

	@Override
	public Stack getLeftHand() {
		// TODO Auto-generated method stub
		return leftHand;
	}

	@Override
	public void addRight(GameObject x) {
		// TODO Auto-generated method stub
		rightHand.add(x);
		
	}

	@Override
	public void addLeft(GameObject x) {
		// TODO Auto-generated method stub
		leftHand.add(x);

	}

	@Override
	public void removeRight() {
		// TODO Auto-generated method stub
		rightHand.pop();
	}

	@Override
	public void removeLeft() {
		// TODO Auto-generated method stub
		leftHand.pop();

	}


	

}
