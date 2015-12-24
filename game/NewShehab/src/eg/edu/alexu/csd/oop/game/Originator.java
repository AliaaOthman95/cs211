package eg.edu.alexu.csd.oop.game;

public class Originator {
	private SnapShot state;

	public void setState(SnapShot state) {
		this.state = state;
	}

	public SnapShot getState() {
		return state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	public void getStateFromMemento(Memento Memento) {
		state = Memento.getState();
	}
}