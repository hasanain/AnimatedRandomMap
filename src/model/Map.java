package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Map {
	private Tile[][] map;
	int width;
	int height;
	BufferedImage mapImage;
	public Map(int width, int height){
		
		this.width = width <= 0 ? 100: width;
		this.height = height <= 0 ? 100: height;
		
		map = new Tile[this.width][this.height];
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile();
			}
		}
		drawMap();
	}
	
	public void drawMap(){
		
		mapImage = new BufferedImage(width*32, height*32, Image.SCALE_SMOOTH);
		Graphics2D g = (Graphics2D) mapImage.getGraphics();
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				map[i][j].draw(g, i*32, j*32);
			}
		}
	}
	public BufferedImage getMapImage(){
		
		return this.mapImage;
	}
}
