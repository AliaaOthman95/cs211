package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameObjectImplementation implements Shape{
	
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int posX,posY,width,height;
	private boolean left=false,top;
	private Color color;
	boolean visible=true,isClown;
	

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.posX=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return posY;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.posY=y;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public void setHeight(int height){
		this.height=height;
	}

	public void setSpiriteImages(BufferedImage[] spriteImages) {
		// TODO Auto-generated method stub
		this.spriteImages=spriteImages;
		
	}

	@Override
	public void setVisible(boolean x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHorizontal(boolean x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClown() {
		// TODO Auto-generated method stub
		return isClown;
	}
	public void setClown(boolean clown){
		this.isClown=clown;
	}
	@Override
	public void setRightHand(Stack x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLeftHand(Stack x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stack getRightHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stack getLeftHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRight(GameObject x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLeft(GameObject x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub
		
	}
}
