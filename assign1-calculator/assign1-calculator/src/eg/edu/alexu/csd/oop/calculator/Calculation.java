package eg.edu.alexu.csd.oop.calculator;

public class Calculation {

	private double result;

	public double calculate(double f, double s, String o) {
		if (o == "+") {
			result = f + s;
		}
		if (o == "-") {
			result = f - s;
		}
		if (o == "*") {
			result = f * s;
		}
		if (o == "/") {
			if (s == 0) {
				throw new RuntimeException();
			}
			result = f / s;

			// TODO: handle exception

		}
		return result;

	}

}
