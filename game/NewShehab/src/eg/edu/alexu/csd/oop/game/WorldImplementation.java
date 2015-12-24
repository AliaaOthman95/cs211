package eg.edu.alexu.csd.oop.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.imageio.ImageIO;
/*******************************************************************************
 * 
 * @author shehab
 * this is a simple run works only on easy strategy till now
 * it contains only three shapes and a clown
 * 
 *
 ***********************************************************************************/


public class WorldImplementation implements World{
	private static int MAX_TIME = 1 * 60 * 9000;	// 1 minute

	private long endTime, startTime = System.currentTimeMillis();
	private int width,score;
	private int height,imageHeight=30;
	private  List<GameObject> constant = new LinkedList<GameObject>();
	
	private List<GameObject> moving = new LinkedList<GameObject>();
	private  List<GameObject> control = new LinkedList<GameObject>();
	private Stack collectedElements = new Stack();
	public static WorldImplementation newImplementation =null;
	private LinkedList<String>shapes =new LinkedList<String>();
	private Factory factory =new Factory().getInstance();
	private int speed,controlSpeed,i,j=1,controlSize=1;
	boolean f;
	private Score calculateScore = new Score ();
	private int CONSTANTX=50,CONSTANTY=50;
	private boolean Lflag=false,Rflag=false;
	private Shape currentMoving,currentConstant ;
	private ShapesStates state = new ShapesStates();
	private Map <String,BufferedImage>images =new HashMap<String,BufferedImage>();
/***********************************************************************/
	public static WorldImplementation getInstance(int screenWidth,int screenHeight){	//Singelton Pattern 
		if(newImplementation==null){
			newImplementation=new WorldImplementation();
			newImplementation.setParameters(screenWidth, screenHeight);
			
		}
		return newImplementation;
	}
	
	
/*****************************************************************/
	//400 700
	private void setParameters(int screenWidth, int screenHeight) {
		this.width = screenWidth;
		this.height = screenHeight;
		//this is list of shapes names instead of getting it from plugin class i created it manual
		
		ShapesPlugin plugin = new ShapesPlugin();
		List<Class < ? extends GameObjectImpl>> pluginShapes = new ArrayList<Class < ? extends GameObjectImpl>>();
		pluginShapes = plugin.loadShapes();
		Factory shapesFactory = new Factory();
		for (int i = 0; i < pluginShapes.size(); i++) {
			shapes.add(pluginShapes.get(i).getName().substring(26));
			//System.out.println(pluginShapes.get(i).getName().substring(26));
		}
		//shapes.add("IBlueCake");
		//shapes.add("Botatos");
		//shapes.add("ICocacola");
//		shapes.add("Fanta");
//		shapes.add("BlueIce");
//		shapes.add("BrownIce");
//		shapes.add("Burger");
//		shapes.add("GreenCake");
//		shapes.add("HappyMeal");
//		shapes.add("MoveIce");
//		shapes.add("PinkIce");
//		shapes.add("RedCake");
//		shapes.add("Sprite");
		
		
		Levels l=new Levels().getInstance();
		l.notifyObserver(score);
		

	}
	
	private boolean intersect1(Shape o1, Shape o2){
		return (Math.abs((o1.getX()+o1.getWidth()/2) - (o2.getX()+o2.getWidth()/2)) <= o1.getWidth()) && (Math.abs((o1.getY()+o1.getHeight()/2) - (o2.getY()+o2.getHeight()/2)) <= o1.getHeight());
	}
	
	private boolean intersect(Shape o1, Shape o2){

		return (((o1.getX())>=o2.getX()&&(o1.getX())<=o2.getWidth()+o2.getX())&&
				((o1.getY()+o1.getHeight())>=o2.getY()&&(o1.getY())<=o2.getHeight()+o2.getY()))||
				(((o2.getX())>=o1.getX()&&(o2.getX())<=o1.getWidth()+o1.getX())&&
				((o2.getY()+o2.getHeight())>=o1.getY()&&(o2.getY())<=o1.getHeight()+o1.getY()))
				;
	}
private boolean Rintersect(Shape o1, Shape o2){
		//o1 m o2 c
		
		if((o1.getX()>=o2.getX()+o2.getWidth()-CONSTANTX)&&o1.getX()<=o2.getX()+o2.getWidth()){
			/*for(int i=control.size()-1;i>=0;i--){
				Shape g=(Shape)control.get(i);
				if(!g.isClown()&&!g.isLeft()){if(intersect1(o1,g)||intersect1(g,o1)){return true;}}//else{ break;}
			}*/
			for(GameObject g:control){
				if(((Shape)g).isClown())
					if(((Shape)g).getRightHand().size()!=0){
						if(intersect1(o1,(Shape)((Shape)g).getRightHand().peek())||intersect1((Shape)((Shape)g).getRightHand().peek(),o1))return true;
						}
					
				
			}
			//if(intersect1(o1,(Shape)o2.getRightHand().peek())||intersect1((Shape)o2.,o1)){return true;
			//if(!Rflag)
			if(o1.getY()+o1.getHeight()>=o2.getY()+CONSTANTY&&o1.getY()+o1.getHeight()<=o2.getY()+CONSTANTY+20){Rflag=true;return true;}
		}
		return false;
		
	}
private boolean Lintersect(Shape o1, Shape o2){
	//o1 m o2 c
	if((o1.getX()>=o2.getX())&&o1.getX()<=o2.getX()+CONSTANTX){
//		for(int i=control.size()-1;i>=0;i--){
//			Shape g= (Shape) control.get(i);
//			if(!g.isClown()&&g.isLeft())if(intersect1(o1,g)||intersect1(g,o1)){return true;}//else break;
//		}
		for(GameObject g:control){
			if(((Shape)g).isClown()&&((Shape)g).getLeftHand().size()!=0)
				
				if(intersect1(o1,(Shape)((Shape)g).getLeftHand().peek())||intersect1((Shape)((Shape)g).getLeftHand().peek(),o1))return true;
			
		}
		//if(!Lflag)
		if(o1.getY()+o1.getHeight()>=o2.getY()+CONSTANTY&&o1.getY()+o1.getHeight()<=o2.getY()+CONSTANTY+20){Lflag=true;return true;}
		
	}
	return false;
	
}
	@Override
	public List<GameObject> getConstantObjects() {
		// TODO Auto-generated method stub
		return constant;
	}

	@Override
	public List<GameObject> getMovableObjects() {
		// TODO Auto-generated method stub
		return moving;
	}

	@Override
	public List<GameObject> getControlableObjects() {
		// TODO Auto-generated method stub
		return control;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public boolean refresh() {
		// TODO Auto-generated method stub
		
		for(int i =moving.size()-1;i>-1;i--){
			Shape m = (Shape) moving.get(i);	
			for(int j=control.size()-1;j>-1;j--){
				Shape c =(Shape) control.get(j);
				if(c.isClown()){
				if(Rintersect(m,c)){
					m.setHorizontal(true);
					m.setLeft(false);
					control.add(m);
					c.addRight(m);
					moving.remove(m);	
					IPic x=(IPic)factory.buildShape(getClassName(m), -100, -100);
					x.draw();
					moving.add((Shape)x);
					score =calculateScore.getScore(score,c,m,true);
					break;
				}else if(Lintersect(m,c)){
					m.setHorizontal(true);
					m.setLeft(true);
					control.add(m);
					c.addLeft(m);
					moving.remove(m);
					IPic x=(IPic)factory.buildShape(getClassName(m), -100, -100);
					x.draw();
					moving.add((Shape)x);
					score =calculateScore.getScore(score,c,m,false);
					break;
				}
				}
			}
		}
		
		for(GameObject b:moving){
			if(b.getX()==-100&&b.getY()==-100){
			if(i==constant.size())i=0;
			Shape a=(Shape) constant.get(i++);
			if(!a.isLeft()){
				b.setX(a.getX()+a.getWidth());
			}
			else b.setX(a.getX());
			b.setY(a.getY()-imageHeight);
			}
		}
		
		for(GameObject t : moving){
			currentMoving=(Shape)t;
			f=false;
			for(GameObject r:constant){
				currentConstant =(Shape)r;
				
				if(intersect((Shape)t,(Shape)r)){
					state.chooseJob(true);
					f=true;
					break;
					
				}
			}
			if(!f){
				state.chooseJob(false);
			}
			
			
		}
			
	
		return true;
	}

	@Override
	public String getStatus() {
		// TODO Auto-generated method stub
		return String.valueOf(score);
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public int getControlSpeed() {
		// TODO Auto-generated method stub
		return controlSpeed;
	}
	
	public void setSpeed(int x){
		this.speed=x;
	}
	
	
	public void setControlSpeed(int x){
		this.controlSpeed=x;
	}
	
	public void setMovableObjects( List<GameObject> x){
	
		moving=x;
	}
	
	public void setContrlableObjects(List<GameObject> x){
		control =x;
	}
	public LinkedList<String> getShapes(){
		return shapes;
	}
	public String getClassName(Shape tempShape){
		String className = tempShape.getClass().getSimpleName();
		return className;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	public Shape getCurrentConstantObject(){
		return currentConstant;
	}
	public Shape getCurrentMovingObject(){
		return currentMoving;
	}
	public void setCurrentMovingObject(Shape currentMoving){
		this.currentMoving=currentMoving;
		
	}
	public Map getImages(){
		return images;
	}
	
	
	

}