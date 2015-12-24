package eg.edu.alexu.csd.oop.game;

public class MoveInX implements IStates{
	public static MoveInX newInstance=null;
	
	public static MoveInX getInstance(){	//Singelton Pattern 
		if(newInstance==null){
			newInstance=new MoveInX();
			
		}
		newInstance.run();
		return newInstance;
	}
	public void run(){
		updateObject();
		
	}
	private int j;
	WorldImplementation world = new WorldImplementation().getInstance(0,0);
	
	Shape currentConstant ;
	Shape currentMoving ;
	
	public void updateObject(){
		currentConstant = world.getCurrentConstantObject();
		currentMoving = world.getCurrentMovingObject();
		if(!currentConstant.isLeft()){j=-1;}else j=1;
		currentMoving.setX(currentMoving.getX()+j*2);
		setCurrentMovingObject();
	}
	public void setCurrentMovingObject(){
		world.setCurrentMovingObject(currentMoving);
		
	}
	
	

}
