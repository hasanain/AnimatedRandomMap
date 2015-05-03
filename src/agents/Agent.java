package agents;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Map;
import sprites.AgentSprite;

public class Agent extends SpriteObject {

	Timer animTimer;
	volatile int counter = 0;
	public int m;
	public Agent(int x, int y, Map map, JPanel panel) {
		super(new AgentSprite(), x, y, 100);
		
		start();
		animTimer = new Timer(15, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				switch (m % 5765) {
				case 0:
					moveUp();
					break;
				case 1:
					moveDown();
					break;
				case 2:
					moveLeft();
					break;
				case 3:
					moveRight();
					break;
				default:
					stop();
					break;
				}
				panel.repaint();
				counter+=4;
				
			}
			
		});
	}
	public void move(){
		animTimer.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(counter < 32){
//					 System.out.println(counter);
				}
				animTimer.stop();
				counter = 0;
				
			}
		}).start();

	}
	

}
