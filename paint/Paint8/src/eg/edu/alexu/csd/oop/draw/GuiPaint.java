package eg.edu.alexu.csd.oop.draw;

//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
//import javax.swing.event.MouseInputAdapter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.geom.*;
//import java.util.HashMap;
import java.util.LinkedList;
//import java.util.Map;
//import java.util.Set;
//import java.util.Timer;

public class GuiPaint extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Engine e = Engine.getInstance();
	Graphics g ;
	private JMenuBar menubar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu edit = new JMenu("Edit");
	private JMenu help = new JMenu("Help");
	private JMenuItem newDraw = new JMenuItem("New");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem load = new JMenuItem("Load");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem undo = new JMenuItem("Undo");
	private JMenuItem redo = new JMenuItem("Redo");
	private JMenuItem copy = new JMenuItem("Copy");
	private JMenuItem paste = new JMenuItem("Paste");
	private JMenuItem move = new JMenuItem("Move");
	private JMenuItem resize = new JMenuItem("Resize");
	private JMenuItem delete = new JMenuItem("Delete");
	private JMenuItem rotate = new JMenuItem("Rotate");
	private JMenuItem about = new JMenuItem("About");
	private JToolBar toolbarShapes = new JToolBar();
	private JToolBar toolbarEdit = new JToolBar();
	private JButton newB, saveB, loadB, undoB, redoB, copyB, pasteB, moveB, resizeB, deleteB, rotateB, refresh,
			fillColor, boundaryColor, drawColorB, b1, b2, b3, b , circle , ellipse , lineSeg , triangle , rectangle , square , select;
	Color trans = new Color(0, 0, 0, 0);
	private Color inColor = trans;
	private Color outColor = (Color.BLACK);
	private Color drawColor = (Color.BLACK);
	private Shape selectedShape;
	private int x, y;

	private int currentX = 0, currentY = 0;
	private JPanel mousePanel;
	private JLabel statusBar;
	private LinkedList<Point> points = new LinkedList<Point>();
	private LinkedList<Point> ovals = new LinkedList<Point>();
	private String[] lineSize = { "1", "5", "10", "50", "100" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox JcSize = new JComboBox(lineSize);
	private FlowLayout FL = new FlowLayout();
	private char brushType = 'A';
	private int brushSize;

	private JFileChooser chooser = new JFileChooser();

	private FileNameExtensionFilter filterXML = new FileNameExtensionFilter("xml files (*.xml)", "xml");
	private FileNameExtensionFilter filterJSON = new FileNameExtensionFilter("JSON", "json");

	public GuiPaint() {

		this.setSize(850, 700);
		this.setTitle("Paint");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Paint");
		this.setJMenuBar(menubar);
		menubar.add(file);
		file.add(newDraw);
		file.addSeparator();
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(exit);
		menubar.add(edit);
		edit.add(undo);
		edit.add(redo);
		edit.addSeparator();
		edit.add(copy);
		edit.add(paste);
		edit.addSeparator();
		edit.add(move);
		edit.add(resize);
		edit.add(delete);
		edit.add(rotate);
		menubar.add(help);
		help.add(about);

		this.add(toolbarShapes, BorderLayout.SOUTH);
		toolbarShapes.setBackground(Color.lightGray);
		for (int i = 0; i < e.getSupportedShapes().size(); i++) {
			String s = e.getSupportedShapes().get(i).getName().substring(26);
			System.out.println(s);
			if (s.equals("Circle")) {
				circle = new JButton();
				circle.setName("Circle");
				circle.setToolTipText("Circle");
				circle.setIcon(new ImageIcon("circle.png"));
				toolbarShapes.add(circle);
			}

			else if (s.equals("Ellipse")) {
				ellipse = new JButton();
				ellipse.setName("Ellipse");
				ellipse.setToolTipText("Ellipse");
				ellipse.setIcon(new ImageIcon("ellipse.png"));
				toolbarShapes.add(ellipse);
			}

			else if (s.equals("Square")) {
				square = new JButton();
				square.setName("Square");
				square.setToolTipText("Square");
				square.setIcon(new ImageIcon("square.png"));
				toolbarShapes.add(square);
			}

			else if (s.equals("Rectangle")) {
				rectangle = new JButton();
				rectangle.setName("Rectangle");
				rectangle.setToolTipText("Rectangle");
				rectangle.setIcon(new ImageIcon("rectangle.png"));
				toolbarShapes.add(rectangle);
			}

			else if (s.equals("LineSegment")) {
				lineSeg = new JButton();
				lineSeg.setName("LineSegment");
				lineSeg.setToolTipText("Line Segment");
				lineSeg.setIcon(new ImageIcon("line.png"));
				toolbarShapes.add(lineSeg);
			}

			else if (s.equals("Triangle")) {
				triangle = new JButton();
				triangle.setName("Triangle");
				triangle.setToolTipText("Triangle");
				triangle.setIcon(new ImageIcon("triangle.png"));
				toolbarShapes.add(triangle);
			}

			else {
			    b = new JButton(s);
				b.setName(s);
				b.setToolTipText(s);
				toolbarShapes.add(b);
			}
	
		}

		newB = new JButton();
		copyB = new JButton();
		pasteB = new JButton();
		undoB = new JButton();
		redoB = new JButton();
		moveB = new JButton();
		rotateB = new JButton();
		resizeB = new JButton();
		deleteB = new JButton();
		refresh = new JButton();
		saveB = new JButton();
		loadB = new JButton();
		fillColor = new JButton();
		boundaryColor = new JButton();
		drawColorB = new JButton();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();

		newB.setToolTipText("New");
		copyB.setToolTipText("Copy");
		pasteB.setToolTipText("Paste");
		undoB.setToolTipText("Undo");
		redoB.setToolTipText("Redo");
		moveB.setToolTipText("Move");
		rotateB.setToolTipText("Rotate");
		resizeB.setToolTipText("Resize");
		deleteB.setToolTipText("Delete");
		refresh.setToolTipText("refresh");
		saveB.setToolTipText("Save");
		loadB.setToolTipText("Load");
		fillColor.setToolTipText("Fill Color");
		boundaryColor.setToolTipText("Boundary Color");
		drawColorB.setToolTipText("Brush Color");
		JcSize.setToolTipText("Font size");

		newB.setIcon(new ImageIcon("new.png"));
		copyB.setIcon(new ImageIcon("copy.png"));
		pasteB.setIcon(new ImageIcon("paste.png"));
		undoB.setIcon(new ImageIcon("undo.png"));
		redoB.setIcon(new ImageIcon("redo.png"));
		moveB.setIcon(new ImageIcon("move.png"));
		rotateB.setIcon(new ImageIcon("rotate.png"));
		resizeB.setIcon(new ImageIcon("resize.png"));
		deleteB.setIcon(new ImageIcon("delete.png"));
		refresh.setIcon(new ImageIcon("refresh.png"));
		saveB.setIcon(new ImageIcon("save.png"));
		loadB.setIcon(new ImageIcon("load.png"));
		fillColor.setIcon(new ImageIcon("fill.png"));
		boundaryColor.setIcon(new ImageIcon("border.png"));
		drawColorB.setIcon(new ImageIcon("Paint.png"));
		b1.setIcon(new ImageIcon("1.png"));
		b2.setIcon(new ImageIcon("2.png"));
		b3.setIcon(new ImageIcon("3.png"));
		statusBar = new JLabel("Mouse Motion");
		statusBar.setForeground(Color.BLUE);
		toolbarShapes.add(statusBar);
		select = new JButton();
		select.setIcon(new ImageIcon("select.png"));

		this.add(toolbarEdit, BorderLayout.NORTH);
		toolbarEdit.setBackground(Color.lightGray);
		toolbarEdit.setLayout(FL);
		FL.setAlignment(FlowLayout.LEFT);
		toolbarEdit.add(newB);
		toolbarEdit.add(saveB);
		toolbarEdit.add(loadB);
		toolbarEdit.add(copyB);
		toolbarEdit.add(pasteB);
		toolbarEdit.add(moveB);
		toolbarEdit.add(rotateB);
		toolbarEdit.add(resizeB);
		toolbarEdit.add(undoB);
		toolbarEdit.add(redoB);
		toolbarEdit.add(deleteB);
		toolbarEdit.add(fillColor);
		toolbarEdit.add(boundaryColor);
		toolbarEdit.add(drawColorB);
		toolbarEdit.add(b1);
		toolbarEdit.add(b2);
		toolbarEdit.add(b3);
		toolbarEdit.add(JcSize);
		toolbarEdit.add(select);
		toolbarEdit.add(refresh);
	
		Colors c = new Colors();
		fillColor.addActionListener(c);
		boundaryColor.addActionListener(c);
		drawColorB.addActionListener(c);

		mousePanel = new MyPanel();
		mousePanel.setBackground(Color.white);
		this.add(mousePanel, BorderLayout.CENTER);

		HandlerClass handler = new HandlerClass();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
		Brushes brush = new Brushes();
		b1.addActionListener(brush);
		b2.addActionListener(brush);
		b3.addActionListener(brush);
		JcSize.addActionListener(brush);
		validate();
	}

	public JPanel getMousePanel() {
		return mousePanel;
	}

	private class Colors implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JButton src = (JButton) event.getSource();

			if (src.equals(fillColor)) {
				inColor = JColorChooser.showDialog(null, "Pick your fill color", inColor);
				System.out.println(inColor);
				if (inColor == null) {
					inColor = Color.WHITE;
				}

			}

			if (src.equals(boundaryColor)) {
				outColor = JColorChooser.showDialog(null, "Pick your boundary color", outColor);
				if (outColor == null) {
					inColor = Color.BLACK;
				}
			}

			if (src.equals(drawColorB)) {
				drawColor = JColorChooser.showDialog(null, "Pick your boundary color", drawColor);
				if (drawColor == null) {
					drawColor = Color.BLACK;
				}
			}

		}

	}

	
	private class Brushes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JComponent src = (JComponent) event.getSource();
			if (src.equals(b1)) {
				brushType = 'A';
			}
			if (src.equals(b2)) {
				brushType = 'B';
			}
			if (src.equals(b3)) {
				brushType = 'C';
			}
			if (src.equals(JcSize)) {
				brushSize = Integer.parseInt(JcSize.getSelectedItem().toString());
			}

		}
	}

	private class HandlerClass implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent event) { // useInMove
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Dragged at : %d , %d", event.getX(), event.getY()));
			currentX = event.getX();
			currentY = event.getY();
			ovals.add(new Point(currentX, currentY));
			// event.getComponent().repaint();
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Dim : %d , %d", event.getX(), event.getY()));

		}

		@Override
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			x = event.getX();
			y = event.getY();
			points.add(new Point(x, y));
			statusBar.setText(String.format("Clicked at : %d , %d", x, y));
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub

			statusBar.setText("Mouse Entered");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusBar.setText("Mouse Exited");
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub

			statusBar.setText(String.format("Pressed at : %d , %d", event.getX(), event.getY()));
			// event.getComponent().repaint();
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			statusBar.setText(String.format("Released at : %d , %d", event.getX(), event.getY()));
		}

	}

	@SuppressWarnings("serial")
	public class MyPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			e.refresh(g);

			// Draw Text
			 
		}
	}

	void addDrawingListener(ActionListener listen) {
        if(b != null){
		b.addActionListener(listen);}
		circle.addActionListener(listen);
		triangle.addActionListener(listen);
		lineSeg.addActionListener(listen);
		square.addActionListener(listen);
		rectangle.addActionListener(listen);
		ellipse.addActionListener(listen);
		points.clear();

	}

	void addHistoryListener(ActionListener listen) {

		undo.addActionListener(listen);
		undoB.addActionListener(listen);
		redo.addActionListener(listen);
		redoB.addActionListener(listen);

	}

	void addUpdateListener(ActionListener listen) {
        select.addActionListener(listen);
		resize.addActionListener(listen);
		resizeB.addActionListener(listen);
		move.addActionListener(listen);
		moveB.addActionListener(listen);
		delete.addActionListener(listen);
		deleteB.addActionListener(listen);

	}

	void addSaveLoadListener(ActionListener listen) {
		save.addActionListener(listen);
		saveB.addActionListener(listen);
		load.addActionListener(listen);
		loadB.addActionListener(listen);

	}

	public LinkedList<Point> getPoints() {
		return points;

	}

	public Point getPos() {
		return new Point(x, y);

	}

	public Color getOutColor() {
		return outColor;
	}

	public Color getInColor() {
		return inColor;
	}

	public JMenuItem getUndo() {
		return undo;
	}

	public JMenuItem getRedo() {
		return redo;
	}

	public JButton getUndoB() {
		return undoB;
	}

	public JButton getRedoB() {
		return redoB;
	}

	public JMenuItem getMove() {
		return move;
	}

	public JMenuItem getResize() {
		return resize;
	}

	public JButton getMoveB() {
		return moveB;
	}

	public JMenuItem getDelete() {
		return delete;
	}

	public JMenuItem getSave() {
		return save;
	}

	public JMenuItem getLoad() {
		return load;
	}

	public JButton getSaveB() {
		return saveB;
	}

	public JButton getLoadB() {
		return loadB;
	}

	public JButton getDeleteB() {
		return deleteB;
	}

	public JButton getResizeB() {
		return resizeB;
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public FileNameExtensionFilter getFilterXML() {
		return filterXML;
	}

	public FileNameExtensionFilter getFilterJSON() {
		return filterJSON;
	}

	public JButton getSelect() {
		// TODO Auto-generated method stub
		return select;
	}

}
