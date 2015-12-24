 package eg.edu.alexu.csd.oop.game;

 

public class Memento  {
	 
	private SnapShot state;

	public Memento(SnapShot state2) {
		this.state = state2;
	}

	public SnapShot getState() {
		return state;
	}
}
