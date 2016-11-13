package Graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Case extends JPanel {
	private static final int TILE_SIZE = 80;
	private static final int TILES_MARGIN = 10;
	private static final int GAME_SIZE = 360;
	private static final Font FONT = new Font("Arial", Font.BOLD, 32);
	

	
	public void paintComponent(Graphics g){
		
		g.setFont(FONT);
			
		
	    for(int j=TILES_MARGIN; j<=GAME_SIZE; j+=90){
			for(int i=TILES_MARGIN; i<=GAME_SIZE; i+=90){
				g.setColor(Color.LIGHT_GRAY);
				g.fillRoundRect(j, i, TILE_SIZE, TILE_SIZE, 10, 10);
				
			}
	    }
	    
		this.setCase(3,0,4,g);
	}
	
	public void setCase(int x, int y, int valeur, Graphics g){
		String sValeur = String.valueOf(valeur);
		g.fillRoundRect(y*(TILE_SIZE+TILES_MARGIN)+TILES_MARGIN, x*(TILE_SIZE+TILES_MARGIN)+TILES_MARGIN, TILE_SIZE, TILE_SIZE, 10, 10);
		g.setColor(Color.BLACK);
		g.drawString(sValeur, x*(TILE_SIZE+TILES_MARGIN)+TILE_SIZE/2, y*(TILE_SIZE+TILES_MARGIN)+TILES_MARGIN+TILE_SIZE/2+10);
	}


}
