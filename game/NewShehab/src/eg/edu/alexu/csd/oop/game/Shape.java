package eg.edu.alexu.csd.oop.game;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Stack;

public interface Shape extends GameObject {
	void setVisible(boolean x);
	void setHorizontal(boolean x);
	String getName();
	public boolean isLeft() ;
	public boolean isClown();
	public void setClown(boolean clown);
	public void setLeft(boolean left) ;
	public void setWidth(int width);
	public void setHeight(int height);
	public void setSpiriteImages(BufferedImage[] spriteImages) ;
	public void setRightHand(Stack x);
	public void setLeftHand(Stack x);
	public Stack  getRightHand();
	public Stack  getLeftHand();
	public void addRight(GameObject x);
	public void addLeft(GameObject x);
	public void removeRight();
	public void removeLeft();
	public String getPath();
	public void setPath(String path);
//	public void limited();

}
