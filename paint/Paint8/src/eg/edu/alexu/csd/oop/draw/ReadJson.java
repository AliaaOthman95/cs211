package eg.edu.alexu.csd.oop.draw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadJson {
	
	public Shape[] readJson(String savingPath) {
		File file = new File(savingPath);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		Shape [] shapesLoaded = null;
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sc.nextLine();
		sc.nextLine();
		sc.nextLine();
		sc.nextLine();
		
		
		

		return shapesLoaded;
	}
	
	private Shape readShape(Scanner scan , String className){
		
		Shape s = null;
		
		MyClassLoader loadJar = new MyClassLoader();
		
		
		
		
		
		
		
		
		
		
		return s;
	}
	
	
}
