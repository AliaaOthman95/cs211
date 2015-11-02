package eg.edu.alexu.csd.oop.calculator;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.*;

public class Jframe extends JFrame implements ActionListener {
	Engine e =  Engine.getInstance();
	Operations o = new Operations();
	PrevNext p = PrevNext.getInstance();
	public static boolean check_prev, pr, nx, cu;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero,
			add, sub, multi, div, dot, prev, next, save, load, current, equal;
	private JTextField in;
	private JLabel input, output;
	private String Textin, eq1, eq2, checkEq;
	private boolean plus, minus, by, over, num1, num2, opchoose;

	private String operation;
	private Font font = new Font(Font.SERIF, Font.BOLD, 20);
	private Color col  = new Color(0x6495ed);
	private class operators implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton source = null;
			if (!opchoose) {
				 source  = (JButton) e.getSource(); 
				in.replaceSelection(source.getActionCommand());
				opchoose = true;
				num1 = true;

			}
			 String o = source.getText();
			 operation = o;
				Operations.setOperator(operation);
		}
		
	}
	operators r = new operators();
	 

	public Jframe() {

		this.setTitle("Calculator");
		this.setSize(450, 370);
		// x.add(new Game(startP.x, 0, widthP, endP.x));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(col);
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		add = new JButton("+");
		sub = new JButton("-");
		multi = new JButton("*");
		div = new JButton("/");
		dot = new JButton(".");
		prev = new JButton("prev");
		next = new JButton("next");
		save = new JButton("save");
		load = new JButton("load");
		current = new JButton("current");
		equal = new JButton("=");
		input = new JLabel("Enter the Formula :");
		output = new JLabel("");
		in = new JTextField("");
		this.add(input);
		this.add(output);
		this.setLayout(null);
		this.add(one);
		this.add(two);
		this.add(three);
		this.add(four);
		this.add(five);
		this.add(six);
		this.add(seven);
		this.add(eight);
		this.add(nine);
		this.add(zero);
		this.add(add);
		this.add(sub);
		this.add(multi);
		this.add(div);
		this.add(prev);
		this.add(next);
		this.add(save);
		this.add(load);
		this.add(dot);
		this.add(current);
		this.add(in);
		this.add(equal);
		in.setBounds(10, 50, 420, 50);
		input.setBounds(130, 15, 200, 15);
		output.setBounds(15, 100, 200, 50);
		one.setBounds(20, 150, 50, 50);
		two.setBounds(70, 150, 50, 50);
		three.setBounds(120, 150, 50, 50);
		four.setBounds(20, 200, 50, 50);
		five.setBounds(70, 200, 50, 50);
		six.setBounds(120, 200, 50, 50);
		seven.setBounds(20, 250, 50, 50);
		eight.setBounds(70, 250, 50, 50);
		nine.setBounds(120, 250, 50, 50);
		zero.setBounds(170, 200, 50, 50);
		dot.setBounds(170, 150, 50, 50);

		add.setBounds(220, 150, 50, 50);
		sub.setBounds(220, 200, 50, 50);
		multi.setBounds(220, 250, 50, 50);
		div.setBounds(170, 250, 50, 50);
		equal.setBounds(270, 150, 70, 50);
		prev.setBounds(270, 200, 70,50);
		next.setBounds(270, 250, 70, 50);
		save.setBounds(340, 150, 80, 50);
		load.setBounds(340, 200, 80, 50);
		current.setBounds(340, 250, 80, 50);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		dot.addActionListener(this);
		add.addActionListener(r);
		sub.addActionListener(r);
		multi.addActionListener(r);
		div.addActionListener(r);
		prev.addActionListener(this);
		next.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		current.addActionListener(this);
		equal.addActionListener(this);
		input.setFont(font);
		output.setFont(font);

	}

	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		String res = null;
		if (a.getSource() == one || a.getSource() == two
				|| a.getSource() == three || a.getSource() == four
				|| a.getSource() == five || a.getSource() == six
				|| a.getSource() == seven || a.getSource() == eight
				|| a.getSource() == nine || a.getSource() == zero
				|| a.getSource() == dot) {
			pr = false;
			nx = false;
			cu = false;
			if (num1 && num2) {
				in.setText("");
				num1 = true;
				num2 = false;
				opchoose = false;

				output.setText("");
			}
			JButton source = (JButton) a.getSource();
			in.replaceSelection(source.getActionCommand());
		}
	/*	if (a.getSource() == add || a.getSource() == sub
				|| a.getSource() == multi || a.getSource() == div) {
			if (!opchoose) {
				JButton source = (JButton) a.getSource();
				in.replaceSelection(source.getActionCommand());
				opchoose = true;
				num1 = true;

			}
		}

		/*if (a.getSource() == add) {
			operation = "+";
			Operations.setOperator(operation);
			//System.out.println(operation);

		}
		if (a.getSource() == sub) {
			operation = "-";
			Operations.setOperator(operation);
		}
		if (a.getSource() == div) {
			operation = "/";
			Operations.setOperator(operation);
		}
		if (a.getSource() == multi) {
			operation = "*";
			Operations.setOperator(operation);
		}*/
 

		if (a.getSource() == equal) {
			Textin = in.getText();

			e.input(Textin);
			pr = false;
			nx = false;
		    cu = false;
			// System.out.println("equal");
			try {
				res = e.getResult();

			} catch (Exception e) {
				// TODO: handle exception
				res = "Math Error";

			}
			output.setText(res);
			num2 = true;

		}
		if (a.getSource() == prev) {
			pr = true;
			check_prev = true;

			eq1 = e.prev();
			checkNull(eq1);

		}
		if (a.getSource() == next) {
			nx = true;

			eq2 = e.next();
			checkNull(eq2);


		}
		if (a.getSource() == current) {
			cu = true;
			
			eq2 = e.current();
			checkNull(eq2);

		}
		if (a.getSource() == save) {

			//System.out.println("**");
			e.save();

		}
		if (a.getSource() == load) {
			cu = true;
			try {
				e.load();
				eq2 = e.current();
				in.setText(eq2);
				output.setText("");
				if (eq2 != null) {
					checkOperator(eq2);
				}
			} catch (Exception e) {
				// TODO: handle exception
				in.setText("");
				output.setText("File is Empty");
			}
		
		//	System.out.println("*0*");
			

		}

	}

	public void checkOperator(String equation) {
		if (equation.contains("+")) {
			operation = "+";
			Operations.setOperator(operation);
		}
		if (equation.contains("-")) {
			operation = "-";
			Operations.setOperator(operation);
		}
		if (equation.contains("*")) {
			operation = "*";
			Operations.setOperator(operation);
		}
		if (equation.contains("/")) {
			operation = "/";
			Operations.setOperator(operation);
		}
	}
	public void checkNull(String equation) {
		if(equation==null){
			in.setText("");
			output.setText("Not valid");
			pr = false;
			nx = false;
		    cu = false;
		}
		else{
		in.setText(equation);
		output.setText("");
	 
			checkOperator(equation);
		
		}
	}
	

}
