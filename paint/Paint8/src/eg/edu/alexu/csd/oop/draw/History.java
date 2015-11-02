package eg.edu.alexu.csd.oop.draw;

import java.util.ArrayList;
import java.util.Stack;

public class History {

	private Stack<ArrayList<Shape>> history1 = new Stack<ArrayList<Shape>>();
	private Stack<ArrayList<Shape>> history2 = new Stack<ArrayList<Shape>>();
	private Stack<ArrayList<Shape>> history3 = new Stack<ArrayList<Shape>>();
	private ArrayList<Shape> shape = new ArrayList<Shape>();
    private static History firstInstance = null;
 
	 
	private History() {
	}

	@SuppressWarnings("unchecked")
	public void track(ArrayList<Shape> shapes) {
		 shape=(ArrayList<Shape>) shapes.clone();
		history1.push(shape);
		 System.out.println(history1+"history1");
		 
		if (history1.size() > 20) {
			for (int i = 0; i < 20 && !history1.isEmpty(); i++) {
				history3.push(history1.pop());
			}
			history1.clear();
			for (int i = 0; i < 20 && !history3.isEmpty(); i++) {
				history1.push(history3.pop());
			}

		}

	}
	public ArrayList<Shape>  getPrev() {
		ArrayList<Shape> peek = new ArrayList<Shape>();
		 
		try {
			 
 
 
			history2.push(history1.pop());
			peek = history1.peek();
			System.out.println(peek+"peek");

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

		return peek;
	}
	public ArrayList<Shape> getNext() {
		ArrayList<Shape> peek = new ArrayList<Shape>();
		try {
			 
	 
			history1.push(history2.pop());

			peek = history1.peek();
		} catch (Exception e) {
			// TODO: handle exception
		throw new RuntimeException();
		}
		return peek;
	}
	@SuppressWarnings("unchecked")
	public void deleteHistory(ArrayList<Shape> shapes)
	{
		history1.clear();
		history2.clear();
		history3.clear();
		shape=(ArrayList<Shape>) shapes.clone();
		history1.push(shape);
	}

	public static History getInstance() {

		if (firstInstance == null) {

			// This is here to test what happens if threads try
			// to create instances of this class
			firstInstance = new History();

		}
		return firstInstance;
	}

	public static void destoryInstance() {
		firstInstance = null;
	}

}
