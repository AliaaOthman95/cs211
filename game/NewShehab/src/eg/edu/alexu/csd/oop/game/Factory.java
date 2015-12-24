package eg.edu.alexu.csd.oop.game;


import java.util.HashMap;


public class Factory {
	
	
	private Shape tempShape;
	
	 static final HashMap <String , Shape> MAP = new HashMap <String , Shape> ();
	
	public static Factory newInstance =null;
	 public static Factory getInstance(){	//Singelton Pattern 
			if(newInstance==null){
				newInstance=new Factory();
				
				
			}
			return newInstance;
		}
	
	
	public Shape buildShape(String shapeName,int posX,int posY){
		try {
			tempShape=createShape(shapeName);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		tempShape.setX(posX);
		tempShape.setY(posY);
		//System.out.println();
		
		return tempShape;
	}
	
	public Shape createShape(String shapeName) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> c = Class.forName("eg.edu.alexu.csd.oop.game."+shapeName);
				
		//if(MAP.get(shapeName)!=null)
			//return tempShape;
		tempShape = (Shape)c.newInstance();
		//MAP.put(shapeName, tempShape);
		return tempShape;
		
	}
	public String getClassName(GameObject tempShape){
		String className = tempShape.getClass().getSimpleName();
		return className;
	}
	
}
