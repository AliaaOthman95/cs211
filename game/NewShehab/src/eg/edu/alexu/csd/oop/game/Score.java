package eg.edu.alexu.csd.oop.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Score {
	private int currentScore ;

	 List<Observer> Observers = new LinkedList <Observer >();
	private  List<GameObject> control = new LinkedList<GameObject>();
	private Stack currentHand= new Stack ();
	GameObject x1,x2,x3;
	
	Score (){
		
		Observers.add(Levels.getInstance());
	}
	//flag 0 for right  1  for left
	int getScore(int x , Shape clown,Shape plate,boolean flag){
		if(flag){
			currentHand=clown.getRightHand();
		}else{
			currentHand=clown.getLeftHand();

		}
		currentScore=x;		
		if(currentHand.size()>=3){
			int sizeOfStack = currentHand.size();
			x1=(GameObject) currentHand.get(sizeOfStack-1);
			x2=(GameObject) currentHand.get(sizeOfStack-2);
			x3=(GameObject) currentHand.get(sizeOfStack-3);
			if(x1.getClass().equals(x2.getClass())&&x2.getClass().equals(x3.getClass())&&x1.getClass().equals(x3.getClass())){
				currentHand.pop();currentHand.pop();currentHand.pop();
				if(flag){
					clown.setRightHand(currentHand);
				}else{
					clown.setLeftHand(currentHand);

				}
				control=WorldImplementation.getInstance(0, 0).getControlableObjects();
				control.remove(x1);control.remove(x2);control.remove(x3);
				WorldImplementation.getInstance(0, 0).setContrlableObjects(control);	
				currentScore=currentScore+1;
				notifyAllObservers();
					
			}			
		}
		return currentScore;

	}
	
	void notifyAllObservers(){
		
		for(int i =0;i<Observers.size();i++){
			Observer temp = Observers.get(i);
			temp.notifyObserver(currentScore);
		}
		
	}
	
	void addObserver (Observer x ){
		Observers.add(x);
	}
	
	void deleteObserver(Observer x){
		Observers.remove(x);
	}

}
