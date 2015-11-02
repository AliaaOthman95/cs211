package eg.edu.alexu.csd.oop.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class SaveLoad {
	PrevNext p = PrevNext.getInstance();

	private String[] array;
	private Stack<String> his = new Stack<String>();

	public void save() {
		BufferedWriter output = null;
		int i = 0;
		try {
			File file = new File("calculator.txt");
			output = new BufferedWriter(new FileWriter(file));
			his = p.getHistory();
			while (i < 5 && !his.isEmpty()) {
				output.write(his.pop());
				output.write("\n");
				i++;
				//System.out.println("****");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception ex) {
			}
		}
	}

	public void load() {
		// TODO Auto-generated method stub
		String[] content = new String[6];
		int i = 0;
		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader(
					"calculator.txt")));
			while (scanner.hasNext()) {
				content[i] = scanner.next();
				System.out.println(content[i]);
				i++;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		p.upload(content);

	}
}
