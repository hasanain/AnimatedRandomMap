package model;

import java.awt.Graphics2D;

import resources.Images;

public class Tile {

	public boolean passable = true;
	
	public static Images images = Images.getInstance();
	
	public void draw(Graphics2D g,int x, int y){
		int width = 32;
		int height = 32;
		
		g.drawImage(images.getRandomImage(), x, y, width, height, null);
	}
	
}
