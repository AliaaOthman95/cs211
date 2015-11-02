package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
 
import java.util.ArrayList;
 
 
import java.util.List;

public class Engine implements DrawingEngine{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	History history = History.getInstance();
	private static Engine firstInstance = null;
	 
	 
	private Engine() {
		History.getInstance().destoryInstance();
	}
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
	System.out.println(shapes+"***");
	
		for(Shape s :shapes)
		{
			System.out.println(shapes+"reached");
			System.out.println(s.getProperties()+"reached");
			
			s.draw(canvas);
			//System.out.println("reached");
		}
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		shapes.add(shape);
		//System.out.println(shape.getProperties()+"addshape");
		history.track(shapes);	
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
	//Point pos ;
	boolean flag = false;
 	 
	for (int i = 0; i < shapes.size(); i++) {
		if(shapes.get(i).equals(shape))
		{
			shapes.remove(i);
			
			flag=true;
		}
		 
	}
	history.track(shapes);
	System.out.println(shapes+"remove");
	if(!flag)
	{
		throw new RuntimeException();
	}
		
	
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		//System.out.println(shapes.get(1).getProperties()+"old");
		Shape CloneShape;
		Shape s = new NewShape();
		boolean flag = false;
		System.out.println(newShape.getProperties()+"update");
		 
			//int index =shapes.indexOf(oldShape);
			//CloneShape = (Shape) shapes.get(index).clone();
			shapes.remove(oldShape);
			//s=(Shape) newShape.clone();
			shapes.add(newShape);
			flag=true;
		 
		//System.out.println(shapes.get(1).getProperties()+"new");
		history.track(shapes);
		if(!flag)
		{
			throw new RuntimeException();
		}
			
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		 
		Shape[] array = new Shape[shapes.size()];
		array = shapes.toArray(array);
		//System.out.println(array[0].getProperties()+"000");

		return array;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		MyClassLoader load = new MyClassLoader();
			return load.classLoader();

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		try {
			shapes = new ArrayList<Shape>(history.getPrev());
			 
		} catch (Exception e) {
			// TODO: handle exception
			shapes.clear();
			//throw new RuntimeException();
		}
	
		
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		try {
			shapes = new ArrayList<Shape>(history.getNext());
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	
		 
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		 XmlWrite saveX = new XmlWrite();
		 WriteJson saveJ = new WriteJson();
		 Shape[] array = getShapes();
		 if(path.contains(".xml")){
	     saveX.writeXml(path,array );
		 }else if(path.contains(".json")){
			 saveJ.writeJson(path, array);
		 }
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		XmlRead loadX = new XmlRead();
		ReadJson loadJ = new ReadJson();
		if(path.contains(".xml")){
			System.out.println("hereeee");
			 loadX.readXml(path);
				Shape [] arr = loadX.readXml(path);
				for (int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
			 
			 }else if(path.contains(".json")){
				 
				 
				 
			 }
		
	}

	public static Engine getInstance() {

		if (firstInstance == null) {

			// This is here to test what happens if threads try
			// to create instances of this class
			firstInstance = new Engine();

		}
		return firstInstance;
	}

	public static void destoryInstance() {
		firstInstance = null;
	}

}
