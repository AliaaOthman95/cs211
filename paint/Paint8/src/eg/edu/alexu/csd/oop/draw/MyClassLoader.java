 package eg.edu.alexu.csd.oop.draw;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class MyClassLoader {
	
	@SuppressWarnings("unused")
	private static URLClassLoader cl;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List <Class<? extends Shape>> classLoader(){
		  List<Class<? extends Shape>> classes = new ArrayList<Class<? extends Shape>>();
		  LinkedList<JarFile> jarList = new LinkedList<JarFile>();
		  String string = System.getProperty("java.class.path");
		  String[] strar = string.split(File.pathSeparator);
		  
		  for (int i = 1; i < strar.length; i++) {	  
			try {
				jarList.add(new JarFile(strar[i]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		}
	      
		URL myJarFile = null;
		try {
			 myJarFile = new URL("jar:file:" + System.getProperty("java.class.path")+ "!/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int j = 0 ; j < jarList.size() ; j++){
		Enumeration e = jarList.get(j).entries();
		cl = URLClassLoader.newInstance(new URL[] {myJarFile});
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
			if(Shape.class.isAssignableFrom(cls))
			{
				classes.add((Class<? extends Shape>) cls);
				//System.out.println(cls.getName());
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

	public static Shape reflectionShape(String s){
		
		Shape reflectionShape = null;
		
		for (int i = 0; i < classLoader().size(); i++) {
			
			try {
				if(classLoader().get(i) == Class.forName("eg.edu.alexu.csd.oop.draw." + s)){
					 reflectionShape = (Shape) classLoader().get(i).newInstance();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return reflectionShape;
		
	}

}

