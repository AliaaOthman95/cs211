package eg.edu.alexu.csd.oop.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.game.GameEngine.GameController;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton newGame, load;
	private final JMenuBar menubar;
	private JMenu about;
	private JMenuItem abt;

	public Gui() {
		this.setVisible(true);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Game");
		menubar = new JMenuBar();
		about = new JMenu("About");
		abt = new JMenuItem("Team Mates");
		this.setJMenuBar(menubar);
		menubar.add(about);
		about.add(abt);
		newGame = new JButton("New Game");
		load = new JButton("Load");
		
		Dimension dim = new Dimension(175, 50);
		newGame.setPreferredSize(dim);
		load.setPreferredSize(dim);
		Font font = new Font("SansSerif", Font.BOLD, 25);
		newGame.setFont(font);
		load.setFont(font);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("backGround.jpg"))));
		setLayout(new FlowLayout());
		add(newGame);
		add(load);
		// Just for refresh :) Not optional!
		setSize(399,399);
		setSize(400,400);
	
		ButtonsListener b = new ButtonsListener();
		abt.addActionListener(b);
		newGame.addActionListener(b);
		load.addActionListener(b);
		validate();

	}

	private class ButtonsListener implements ActionListener {
		
		private SnapShot shot ;
		@Override
		public void actionPerformed(ActionEvent e) {

			JComponent src = (JComponent) e.getSource();

			if (src.equals(newGame)) {

			    WorldImplementation x = WorldImplementation.getInstance(1400, 900);
				MenuBar menu = new MenuBar();
				final GameController gameController = GameEngine.start("Mcdonalds", x, menu.getMenubar(), Color.BLACK);
					menu.getPause().addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
							gameController.pause();
						}
						});
						menu.getResume().addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
							gameController.resume();
							}
						});
			} else if (src.equals(load)) {
				SavingStrategy savingStrategy = new SavingStrategy();
				shot =savingStrategy.load();
				// set level,score,controlled objects to the game before call get instance of world
				WorldImplementation x = WorldImplementation.getInstance(1400, 900);
				x.setContrlableObjects(shot.getControl());
				
				/*for (int i = 0; i < x.getControlableObjects().size(); i++) {
					System.out.println(x.getControlableObjects().get(i).getX());
					System.out.println(x.getControlableObjects().get(i).getY());
					
					System.out.println(x.getControlableObjects().get(i).getHeight());
					System.out.println(x.getControlableObjects().get(i).getHeight());
				if (((Shape) x.getControlableObjects().get(i)).getRightHand() != null) {

						 
	//System.out.println(((Shape) x.getControlableObjects().get(i)).getRightHand().size()+"+"+((Shape) x.getControlableObjects().get(i)).getRightHand().size()+"  0000");
					 
					}
				}*/
				x.setScore(shot.getScore());
				MenuBar menu = new MenuBar();
				GameEngine.start("Game", x, menu.getMenubar(), JFrame.EXIT_ON_CLOSE);
			} else if (src.equals(abt)) {
				JOptionPane.showMessageDialog(null, "Ahmed Eid - Aliaa Othman - Radwa Elmasry - Shehab Elsamany",
						"Our Team", JOptionPane.INFORMATION_MESSAGE);
			}

		}
	

	}

}