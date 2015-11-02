package eg.edu.alexu.csd.oop.calculator;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Engine implements Calculator {
	Operations o = new Operations();
	PrevNext p = PrevNext.getInstance();
	SaveLoad s = new SaveLoad();
	Calculation c = new Calculation();
	private double result;
	private boolean thisPrevious, thisNext, thisCurrent;
	 

	private static Engine firstInstance = null;

	private Engine() {
		PrevNext.getInstance().destoryInstance();
	}

	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		o.parseInput(s);
		if (!Jframe.pr && !Jframe.nx && !Jframe.cu && !thisCurrent && !thisNext
				&& !thisPrevious) {
			p.track(s);
			System.out.println(s);
		}

		thisCurrent = thisNext = thisPrevious = false;
		// System.out.println("here");

	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		String res;
		try {
			result = c.calculate(o.getFirst(), o.getSecond(), o.getOperator());
			// System.out.println("00");
		} catch (Exception e) {
			// TODO: handle exception

			throw new RuntimeException();
		}

		res = String.valueOf(result);

		return res;
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub

		String cur;
		cur = p.current();
System.out.println(cur+"000");
		if (cur != null) {
			thisCurrent = true;
			input(cur);
		}
		return cur;
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		String pre;

		pre = p.getPrev();

		if (pre != null) {
			thisPrevious = true;
			input(pre);
		}
		return pre;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		String nx;

		nx = p.getNext();

		if (nx != null) {
			thisNext = true;
			input(nx);
		}
		return nx;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

		s.save();

	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		s.load();

	}

	public static Engine getInstance() {

		if (firstInstance == null) {

			// This is here to test what happens if threads try
			// to create instances of this class
			firstInstance = new Engine();

		}
		return firstInstance;
	}
	 public static void destoryInstance(){
		 firstInstance = null;
	   }

}
