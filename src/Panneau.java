import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	  public void paintComponent(Graphics g){
		  
		//int x,
		//int y,
		//int width,
		//int height,
		//int arcWidth,
		//int arcHeight
		g.setColor(Color.lightGray);  
	    g.fillRoundRect(5,5,110,110,30,30);
	    g.fillRoundRect(125,5,110,110,30,30);
	    g.fillRoundRect(245,5,110,110,30,30);
	    g.fillRoundRect(365,5,110,110,30,30);
	    g.fillRoundRect(5,125,110,110,30,30);
	    g.fillRoundRect(125,125,110,110,30,30);
	    g.fillRoundRect(245,125,110,110,30,30);
	    g.fillRoundRect(365,125,110,110,30,30);
	    g.fillRoundRect(5,245,110,110,30,30);
	    g.fillRoundRect(125,245,110,110,30,30);
	    g.fillRoundRect(245,245,110,110,30,30);
	    g.fillRoundRect(365,245,110,110,30,30);
	    g.fillRoundRect(5,365,110,110,30,30);
	    g.fillRoundRect(125,365,110,110,30,30);
	    g.fillRoundRect(245,365,110,110,30,30);
	    g.fillRoundRect(365,365,110,110,30,30);
	  }               
	}
