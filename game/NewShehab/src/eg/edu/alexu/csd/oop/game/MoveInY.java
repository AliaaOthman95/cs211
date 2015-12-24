package eg.edu.alexu.csd.oop.game;

public class MoveInY implements IStates{
	public static MoveInY newInstance=null;
	public static MoveInY getInstance(){	//Singelton Pattern 
		if(newInstance==null){
			newInstance=new MoveInY();
			
		}
		newInstance.run();
		return newInstance;
	}
	public void run(){
		updateObject();
		
	}
	WorldImplementation world = new WorldImplementation().getInstance(0,0);
	Shape currentConstant;
	Shape currentMoving ;
	
	public void updateObject(){
		 currentConstant = world.getCurrentConstantObject();
		 currentMoving = world.getCurrentMovingObject();
		currentMoving.setY((currentMoving.getY() + 2));
		if(currentMoving.getY()==world.getHeight()){
			currentMoving.setX(-100);currentMoving.setY(-100);
		  }
		setCurrentMovingObject();
	}
	public void setCurrentMovingObject(){
		world.setCurrentMovingObject(currentMoving);
		
	}
	
	

}
