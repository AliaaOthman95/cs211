package eg.edu.alexu.csd.oop.calculator;

public class Operations {
	Calculation c = new Calculation();
	private static String operator;
	private String[] array;
	private double first, second;
	private boolean excep;

	public static void setOperator(String inp) {
		operator = inp;
	}

	public String getOperator() {
		return operator;
	}

	public void parseInput(String s) {
		// System.out.println(operator);
		// System.out.println(s);
		if(s.contains("+"))
		{
			setOperator("+");
		}
		else if(s.contains("-"))
		{
			setOperator("-");
		}else if(s.contains("*"))
		{
			setOperator("*");
		}else if (s.contains("/"))
		{
			setOperator("/");
		}
		array = s.split("[-+*/]");

		first = Double.parseDouble(array[0]);
		second = Double.parseDouble(array[1]);
		if (second == 0 && operator.equals("/")) {
			excep = true;
		}
		System.out.println("parse"+s);

	}

	public double getFirst() {
		return first;
	}

	public double getSecond() {
		return second;
	}

	public boolean check_Exceptions() {

		return excep;
	}
}
