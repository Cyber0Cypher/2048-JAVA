package Graphique;
import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	private static final Color BG_COLOR = Color.DARK_GRAY;
	  
	public Fenetre(){
		
		this.setTitle("2048");
	    this.setSize(380, 400);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setBackground(BG_COLOR);
	    this.setContentPane(new Case());
	    
	    
	    this.setVisible(true);
	   
	}
}
