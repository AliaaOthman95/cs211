package eg.edu.alexu.csd.oop.game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class LevelsPlugin {
	
	@SuppressWarnings("unchecked")
	public List <Class < ? extends Levels>> loadLevels() {
		 
		  List<Class < ? extends Levels>> classes = new ArrayList<Class < ? extends Levels>>();
		  LinkedList<JarFile> jarList = new LinkedList<JarFile>();
		  String string = System.getProperty("java.class.path");
		  String[] strar = string.split(File.pathSeparator);
		  
		  for (int i = 1; i < strar.length; i++) {	  
			  if(strar[i].contains(".jar")){
			try {
				jarList.add(new JarFile(strar[i]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  }
			  
		}
	 
		for(int j = 0 ; j < jarList.size() ; j++){
		Enumeration<?> e = jarList.get(j).entries();
		while (e.hasMoreElements()) {
	        JarEntry je = (JarEntry) e.nextElement();
	        if(je.isDirectory() || !je.getName().endsWith(".class")){
	            continue;
	        }
	    // -6 because of .class
	    String className = je.getName().substring(0,je.getName().length()-6);
	    className = className.replace('/', '.');
	    try {
			Class<?> cls = Class.forName(className);
			if(Levels.class.isAssignableFrom(cls))
			{
				classes.add((Class<? extends Levels>) cls);
				System.out.println(cls.getName());
			}
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		} 
		 try {
			 jarList.get(j).close();
	        } catch (IOException e2) {
	            // TODO Auto-generated catch block
	            e2.printStackTrace();
	        }
		
		}
		
		return classes;
	}

}
