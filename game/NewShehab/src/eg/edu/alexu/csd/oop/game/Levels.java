package eg.edu.alexu.csd.oop.game;

public class Levels implements ILevels , Observer{

	private int score,widthheight;
	
	public static Levels newLevels =null;

	public static Levels getInstance(){	//Singelton Pattern 
		if(newLevels==null){
			newLevels=new Levels();
			

		}
		return newLevels;
	}
	
	
	
	@Override
	public void setSpeed() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setControlSpeed() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setMovableObjects() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setControlableObjects() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConstantObjects() {
		// TODO Auto-generated method stub
		
	}


	
	public void notifyObserver(int score) {
		// TODO Auto-generated method stub
		
		System.out.println("observer "+ score);
		if(score==0){
			//System.out.println("YES");
			Easy level = new Easy ();
		}else if (score==10){
			Medium level = new Medium();
		}else if (score ==1){
			Hard level = new Hard();
		}
	}



	
	
	
	
}
