package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EngineController {

	private Engine model;
	private GuiPaint view;
	
	 
	private LinkedList<Point> points;
	 
	public EngineController(Engine g, GuiPaint p) {
		this.model = g;
		this.view = p;
		this.points = this.view.getPoints();
		// this.pos=this.view.getPos();
		// this.inColor=this.view.getInColor();
		// this.outColor=this.view.getOutColor();
		this.view.addDrawingListener(new ShapesButtons());
		this.view.addHistoryListener(new UndoAndRedo());
		this.view.addSaveLoadListener(new SaveAndLoad());
		this.view.addUpdateListener(new Update());
	}

	private class ShapesButtons implements ActionListener {

		Map<String, Double> propertiesB;

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String returnOfButton = ((JComponent) event.getSource()).getName();
			//System.out.println(returnOfButton);
			MyClassLoader loadJar = new MyClassLoader();
			Shape s = loadJar.reflectionShape(returnOfButton);
			propertiesB = new HashMap<>();
			Set<String> keys = s.getProperties().keySet();
			//System.out.println(keys.toString());
			for (String S : keys) {
				String str = JOptionPane.showInputDialog(S);
				//System.out.println(S);
				//System.out.println(str);
			//	s.setProperties(properties);
				propertiesB.put(S, Double.valueOf(str));
			}
			
			if (returnOfButton.equals("LineSegment")) {
				s.setPosition(points.get(points.size() - 2));
				propertiesB.put("SecondX", Double.valueOf(points.getLast().x));
				propertiesB.put("SecondY", Double.valueOf(points.getLast().y));

			} else if (returnOfButton.equals("Triangle")) {
				s.setPosition(points.get(view.getPoints().size() - 3));
				propertiesB.put("SecondX", Double.valueOf(points.get(view
						.getPoints().size() - 2).x));
				propertiesB.put("SecondY", Double.valueOf(points.get(view
						.getPoints().size() - 2).y));
				propertiesB.put("ThirdX",
						Double.valueOf(view.getPoints().getLast().x));
				propertiesB.put("ThirdY",
						Double.valueOf(view.getPoints().getLast().y));
			} else {
				s.setPosition(new Point(view.getPos().x, view.getPos().y ));
			}
			s.setProperties(propertiesB);
			//System.out.println("aliaaaaaaaaa" + propertiesB);
			s.setColor(view.getOutColor());
			s.setFillColor(view.getInColor());
			s.draw(view.getMousePanel().getGraphics());
			model.addShape(s);
			view.repaint();
			//model.refresh(view.getMousePanel().getGraphics());
			//System.out.println(s.getProperties()+"entering prop");
			 
		 
			
		}
		

	}
	
	

	private class UndoAndRedo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JComponent src = (JComponent) event.getSource();

			if (src.equals(view.getUndo()) || src.equals(view.getUndoB())) {
				System.out.println("++++");
				try {
					model.undo();
					view.repaint();
				} catch (Exception e) {
					// TODO: handle exception
					view.repaint();
				}
				
				// view.repaint();
				
			 
				 

			}

			if (src.equals(view.getRedo()) || src.equals(view.getRedoB())) {
				model.redo();
				view.repaint();
				 
			}

		}
	}

	private class Update implements ActionListener {
		 Shape selectedShape = null;

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
            
			JComponent src = (JComponent) event.getSource();
			
			if(src.equals(view.getSelect())){
				
				Point selected = new Point(view.getPos().x, view.getPos().y);
				
				Double [] diff = new Double[model.getShapes().length];
				Shape[] arr = model.getShapes();
				for(int i = 0 ; i < arr.length ; i++){
					
					double x = Math.pow(arr[i].getPosition().x - selected.x, 2);
					double y = Math.pow(arr[i].getPosition().y - selected.y, 2);
					double s = Math.sqrt(x + y);
					diff[i] = s;
					
				}
				
				Double min = diff[0];
				int index = 0;
				
				for (int i = 1; i < arr.length; i++) {
					if(diff[i] < min){
						min = diff[i];
						index = i;
					}
				}
				
			    selectedShape = arr[index];
			    selectedShape.setProperties(arr[index].getProperties());
			    selectedShape.setPosition(arr[index].getPosition());
				
				/*for (int i = 0; i < arr.length; i++) {
					System.out.println(diff[i]);
				}
				
				//System.out.println(index);*/
				
			}

			if (src.equals(view.getMove()) || src.equals(view.getMoveB())) {
				Shape old = null;
				Shape New = null;
				try {
					old = (Shape) selectedShape;
					New = (Shape) old.clone();
					
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
				 
				}
				New.setPosition(new Point(view.getPos().x, view.getPos().y));
				model.updateShape(old, New);
				view.repaint();
				 
			}

			if (src.equals(view.getResize()) || src.equals(view.getResizeB())) {
				Map<String, Double> newproperties ;
				Shape old = null;
				Shape New = null;
				 
					
					//System.out.println(selectedShape.getProperties()+"afterclone");
					try {
						old = (Shape)selectedShape;
						New = (Shape) old.clone();
						System.out.println(old+"clone ensurance");
						System.out.println(New+"clone ensurance");
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						 
					}
					newproperties= new HashMap<>();
				Set<String> keys = New.getProperties().keySet();
				for (String S : keys) {
					String str = JOptionPane.showInputDialog(S);
					newproperties.put(S, Double.valueOf(str));
				}
				New.setProperties(newproperties);
				model.updateShape(old, New);
				System.out.println(old.getProperties().get("Radius"));
				System.out.println(New.getProperties().get("Radius"));
				view.repaint();
 			}
			if (src.equals(view.getDelete()) || src.equals(view.getDeleteB())) {
				Shape old = null;
				 
				 
				old = (Shape)selectedShape;
				model.removeShape(old);
				view.repaint();
				 
			}
		}

	}

	private class SaveAndLoad implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			JComponent src = (JComponent) event.getSource();
			String path = null;
			String pathXml = null;
			String pathJson = null;
			String loadPath = null;
			if (src.equals(view.getSave()) || src.equals(view.getSaveB())) {

				view.getChooser().setCurrentDirectory(new java.io.File("."));
				view.getChooser().setFileFilter(view.getFilterXML());
				view.getChooser().setFileFilter(view.getFilterJSON());
				view.getChooser().setDialogTitle("select folder");
				view.getChooser().setFileSelectionMode(
						view.getChooser()/* JFileChooser */.DIRECTORIES_ONLY);
				view.getChooser().setAcceptAllFileFilterUsed(false);
				view.getChooser().showSaveDialog(src);
				path = view.getChooser().getSelectedFile().getAbsolutePath();
				pathXml = path + ".xml"; 
				pathJson = path + ".json";
				if (view.getChooser().getFileFilter() == view.getFilterXML()) {
					
					model.save(pathXml);

				}
				
				if (view.getChooser().getFileFilter() == view.getFilterJSON()) {
				
					model.save(pathJson);

				}
			}

			if (src.equals(view.getLoad()) || src.equals(view.getLoadB())) {
				
				view.getChooser().setCurrentDirectory(new java.io.File("."));
				view.getChooser().setDialogTitle("select folder");
				int result = view.getChooser().showOpenDialog(src);
				if (result == view.getChooser().APPROVE_OPTION) {
				    File selectedFile = view.getChooser().getSelectedFile();
				    loadPath = selectedFile.getAbsolutePath();
				}
				
				System.out.println(loadPath);
				model.load(loadPath);
			
				model.refresh(view.getGraphics());
			}

		}

	}

}
