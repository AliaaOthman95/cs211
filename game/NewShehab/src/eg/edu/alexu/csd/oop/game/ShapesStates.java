 package eg.edu.alexu.csd.oop.game;


public class ShapesStates {
	
	
	IStates state ;
	public void chooseJob(boolean movingHorizontal){
		if(movingHorizontal){
			state= new MoveInX().getInstance();
		}else {
			state= new MoveInY().getInstance();

		}
	}

}
