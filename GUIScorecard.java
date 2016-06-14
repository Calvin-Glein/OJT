import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUIScorecard extends JFrame{
	
	public GUIScorecard(){
		this.setPreferredSize(new Dimension(1500, 800));
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
	}

}
