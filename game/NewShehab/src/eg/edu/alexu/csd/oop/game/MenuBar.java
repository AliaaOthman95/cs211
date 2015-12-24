 package eg.edu.alexu.csd.oop.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	
	private final JMenuBar menubar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem pauseMenuItem = new JMenuItem("Pause");
	private JMenuItem resumeMenuItem = new JMenuItem("Resume");
	
	public MenuBar(){
		menubar.add(file);
    	file.add(pauseMenuItem);
		file.add(resumeMenuItem);
		file.addSeparator();
		file.add(save);
		MenuBarButtons m = new MenuBarButtons();
		save.addActionListener(m);
	}
	
	public JMenuBar getMenubar() {
		return menubar;
	}
	
	private class MenuBarButtons implements ActionListener{

		private SavingStrategy savingStrategy = new SavingStrategy();
		@Override
		public void actionPerformed(ActionEvent event) {
			
			JComponent src = (JComponent) event.getSource();

			if (src.equals(save)){
				
				savingStrategy.Save();
				
			}
		}
		
	}

	public JMenuItem getPause(){
		return pauseMenuItem;
	}
	
	public JMenuItem getResume(){
		return resumeMenuItem;
	}
	

}
