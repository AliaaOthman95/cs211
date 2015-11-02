package eg.edu.alexu.csd.oop.draw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Reflection {
	
	public static LinkedList<String> classNames(){
		LinkedList<String> classNames = new LinkedList<String>();
		ZipInputStream zip = null;
		try {
			zip = new ZipInputStream(new FileInputStream("C:\\Users\\Radwa\\git\\radwa-adel-ahmed\\Paint"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
			    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
			        // This ZipEntry represents a class. Now, what class does it represent?
			        String className = entry.getName().replace('/', '.'); // including ".class"
			        classNames.add(className.substring(0, className.length() - ".class".length()));
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classNames;
	}
	

}
