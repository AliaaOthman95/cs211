package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;

public class GameObjectImpl implements GameObject, Shape, Externalizable {
	public static final int SPRITE_WIDTH = 40;
	private static final int MAX_MSTATE = 1;
	WorldImplementation world = WorldImplementation.getInstance(0, 0);
	List<GameObject> control;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int posX, posY, width, height;
	boolean visible = true, isHorizontal = false, isLeft, isClown;
	private String path;

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		// System.out.println(control.size()+"Size");
		// System.out.println(x+"SHEHAB");

		this.posX = x;

	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub

		return posY;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		if (isHorizontal)
			return;

		else
			this.posY = y;
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth() {
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

	@Override
	public void setVisible(boolean x) {
		this.visible = x;
	}

	@Override
	public void setHorizontal(boolean x) {
		this.isHorizontal = x;
	}

	@Override
	public String getName() {
		return "BotatosObject";
	}

	@Override
	public boolean isLeft() {
		// TODO Auto-generated method stub
		return isLeft;
	}

	@Override
	public void setLeft(boolean left) {
		// TODO Auto-generated method stub
		this.isLeft = left;

	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		this.width = width;

	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		this.height = height;

	}

	@Override
	public void setSpiriteImages(BufferedImage[] spriteImages) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isClown() {
		// TODO Auto-generated method stub
		return isClown;
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
	public void setClown(boolean clown) {
		// TODO Auto-generated method stub
		this.isClown = clown;

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		this.setX(in.readInt());
		this.setY(in.readInt());
		this.setHeight(in.readInt());
		this.setWidth(in.readInt());
		this.setPath(in.readLine());
		// System.out.println(this.getPath());
		spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(
				this.getPath()));
		this.setSpiriteImages(spriteImages);
		if (this.getPath().equals("/collector.png")) {
			this.setClown(true);
			this.setHorizontal(true);
			this.setRightHand((Stack) in.readObject());
			this.setLeftHand((Stack) in.readObject());
			System.out.println(this.getRightHand().size() + "+"
					+ this.getLeftHand().size());

		}
		// System.out.println(this.getRightHand().size()+"+"+this.getLeftHand().size());
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(posX);
		out.writeInt(posY);
		out.writeInt(this.getHeight());
		out.writeInt(this.getWidth());
		out.writeBytes(this.getPath());

		if (this.getPath().equals("/collector.png")) {

			out.writeObject(this.getRightHand());
			out.writeObject(this.getLeftHand());
		}

	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}

	@Override
	public void setPath(String path) {
		// TODO Auto-generated method stub
		this.path = path;
	}

	// public void setSpiriteImages(BufferedImage[] spriteImages) {
	// // TODO Auto-generated method stub
	// this.spriteImages=spriteImages;
	//
	// }
}
