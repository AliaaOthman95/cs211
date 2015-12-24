 package eg.edu.alexu.csd.oop.game;

import java.util.Stack;

public class SavingStrategy {

	 private FileSerialization fileSerialization = new FileSerialization();
	 private SnapShot shot ;
	 private WorldImplementation w = WorldImplementation.getInstance(1400, 900);
	
	 
	public void Save ()
	{
		
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
	   //get score , level ,stack and pass it to shot
   	 shot = new SnapShot(w.getScore(),w.getControlableObjects());
		originator.setState(shot);
		careTaker.add(originator.saveStateToMemento());
		originator.getStateFromMemento(careTaker.get(0));
		fileSerialization.serialize(originator.getState());
		
	}
	public SnapShot load()
	{
		 
		shot = fileSerialization.deserialize();
		return shot ;
		
	}
}
