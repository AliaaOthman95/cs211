  package eg.edu.alexu.csd.oop.game;

import java.io.Serializable;
import java.util.List;
import java.util.Stack;

public class SnapShot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private List<GameObject> control ;

	public SnapShot(int score,List<GameObject> control) {
 		this.score = score;
		this.control = control;
	}

	 

	public int getScore() {
		return score;
	}



	public List<GameObject> getControl() {
		return control;
	}

	 
}
