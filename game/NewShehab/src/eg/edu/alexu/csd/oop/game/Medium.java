package eg.edu.alexu.csd.oop.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Medium extends Levels{
	WorldImplementation world = new WorldImplementation().getInstance(0,0);
	private int width,height ;
	private IPic temp;
	private BufferedImage[] spriteImages = null;
	private Factory factory =new Factory().getInstance();
	public Medium() {
		this.width=world.getWidth();
		this.height=world.getHeight();
		clear();
		setSpeed();
		setControlSpeed();
		setMovableObjects();
		setConstantObjects();
		setControlableObjects();
		// TODO Auto-generated constructor stub
	}
	
	public void setSpeed (){
		
		world.setSpeed(5);
	}
	public void setControlSpeed (){
		world.setControlSpeed(10);
	}
	List<GameObject> moving = world.getMovableObjects();
	LinkedList<String>shapes=world.getShapes();
	public void setMovableObjects(){
		moving.clear();
		//for(String shapeName:shapes){
		for(int i=0;i<2*shapes.size()/3;i++){
			String shapeName=shapes.get(i);
		IPic a=(IPic) factory.buildShape(shapeName, -100,-100);
		//System.out.println(factory.getClassName(a));
		a.draw();
		
		moving.add( (Shape)a);
		}
		
	}	
	List<GameObject> control = world.getControlableObjects();
	
	public void setControlableObjects(){
		control.clear();
		
		
		spriteImages = new BufferedImage[1];
		MyLinkedList x = new MyLinkedList();
		x.add(0);
		x.add(1);
		x.add(2);
		IteratorImplementation itr = new IteratorImplementation(x);
		//for(int i=7; i>6; i--){			// bar object (hero)
		while(itr.hasNext()){
			IPic temp=(IPic) factory.buildShape("Collector",(width/4)*(int)itr.next(), (int)(height*0.55));
			temp.draw();
			((Shape) temp).setHorizontal(true);
			
			
			control.add((Shape)temp);
			
		}
	}
	List<GameObject> constant = world.getConstantObjects();
	
	//private static final HashMap <String , HashMap <String , GameObject>> MAP = new HashMap <String , HashMap <String , GameObject>>();
	final Color []s={Color.red,Color.green};
	public void setConstantObjects(){
		
			constant.clear();
			constant.add(new BackGroundMedium());
			System.out.println(width+"Width");
			for(int i=width/3,h=height/10;i>(width/9);i-=width/9,h+=height/10){
				for(int j=-1;j<=1;j+=2){
					
				spriteImages = new BufferedImage[1];
				//Shape temp=(Shape)factory.buildShape("GameObjectImplementation",,h);//(width*i/11, j, 15, true, Color.GREEN
				Shape temp=new GameObjectImplementation();
				temp.setX(i*j>0?0: width+j*i);
				temp.setY(h);
				spriteImages[0] = new BufferedImage( i, 5,	BufferedImage.TYPE_INT_ARGB);
				int x=s.length+1;
				while(x>=s.length){
					x=(int)(Math.random() * s.length);
				}
				
				Graphics2D g2 = spriteImages[0].createGraphics();
				g2.setColor(s[x]);
				g2.setBackground(s[x]);
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setStroke(new BasicStroke(20));
				g2.drawLine(0, 0, width, 0);
				g2.dispose();
				temp.setSpiriteImages(spriteImages);
				temp.setWidth(i);
				temp.setHeight(5);
				if(j>0)temp.setLeft(true);
				constant.add(temp);	
				System.out.println(constant.size()+"YATAB");
				}
				
			}
			System.out.println(constant.size()+"Constantize");
				
		
			
	}
	void clear(){
		moving.clear();
		constant.clear();
		control.clear();
	}
	

	
}
