package eg.edu.alexu.csd.oop.calculator;

import java.util.*;

import javax.management.RuntimeErrorException;

public class PrevNext {

	private Stack<String> history1 = new Stack<String>();
	 private Stack<String> history2 = new Stack<String>();
	 private Stack<String> history3 = new Stack<String>();
	private String equation;
	private static PrevNext firstInstance = null;

	private PrevNext() {
	}
	public void track(String s) {
		if (history1.empty()&&!history2.empty()) {
			 
			history2.clear();
			System.out.println("cleared");

		}
		history1.push(s);
		if(history1.size()>5)
		{
			for (int i = 0; i <5&&!history1.isEmpty(); i++) {
				history3.push(history1.pop());
			}
			history1.clear();
			for (int i = 0; i <5&&!history3.isEmpty(); i++) {
				history1.push(history3.pop());
			}

		}
		if (Jframe.check_prev) {
			Jframe.check_prev = false;
			history2.clear();
			System.out.println("cleared");

		}
		
		// System.out.println(s);

	}

	public String getPrev() {
		String peek;
		try {
			 
			equation = history1.pop();
			history2.push(equation);
			peek = history1.peek();
			

		} catch (Exception e) {
			// TODO: handle exception
			peek = null;
		}

		return peek;
	}

	public String getNext() {
		String peek;
		try {
			if(history1.isEmpty()&&!history2.isEmpty())
			{
				equation = history2.pop();
				history1.push(equation);
			}
			equation = history2.pop();
			history1.push(equation);

			peek = history1.peek();
		} catch (Exception e) {
			// TODO: handle exception
			peek = null;
		}
		return peek;
	}

	public String current() {
		String peek;
		try {
			if(history1.isEmpty()&&!history2.isEmpty())
			{
				equation = history2.pop();
				history1.push(equation);
			}
			peek = history1.peek();
			
		} catch (Exception e) {
			// TODO: handle exception
			peek=null;
		};
	
		
		return peek;
	}

	@SuppressWarnings("unchecked")
	public Stack<String> getHistory() {
		Stack<String> his = new Stack<String>();
		if(history1.isEmpty()&&!history2.isEmpty())
		{
			history1.push(history2.pop());
		}
		his = (Stack<String>) history1.clone();
		//System.out.println(his.peek());
		return his;

	}

	public void upload(String[] array) {
		// TODO Auto-generated method stub

		history1.clear();
		history2.clear();
		for (int i = 4; i >= 0; i--) {
			history1.push(array[i]);
System.out.println(history1.peek()+"****");
		}
	}
	public static PrevNext getInstance() {

		if (firstInstance == null) {

			// This is here to test what happens if threads try
			// to create instances of this class
			firstInstance = new PrevNext();

		}
		return firstInstance;
	}
	 public static void destoryInstance(){
		 firstInstance = null;
	   }


}
