package eg.edu.alexu.csd.oop.draw;

 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	new GuiPaint();
		  GuiPaint theView = new GuiPaint();
 
		  Engine theModel = Engine.getInstance();
		 
		  EngineController theController = new EngineController(theModel,theView);
		 
		 
	}

}
