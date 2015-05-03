package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.Timer;

import model.Map;
import agents.SpriteObject;
import agents.Agent;

public class MainView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4353980520321698822L;

	Map map;
	JPanel panel, buttons;
	JScrollPane wrapper;
	Agent agent;
	JButton move;
	Timer t;

	public MainView() {
		makePanel();
		buttons = new JPanel(new GridLayout(7,1));
		move = new JButton("move");
		move.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!t.isRunning()){
					t.start();
				}else{
					t.stop();
				}
				
			}
		});
		makeTimer();
		buttons.add(move);
		JTextArea instructions = new JTextArea("Click the move button once to move and another time to stop");
		instructions.setLineWrap(true);
		buttons.add(instructions);
		buttons.setSize(new Dimension(200, 400));
		buttons.setPreferredSize(new Dimension(200, 400));
		buttons.setLayout(new GridLayout(7, 1));
		agent = new Agent(200, 400, map, panel);
		
		map = new Map(100, 100);
		wrapper = new JScrollPane();
		this.setLayout(new BorderLayout());
		
		panel.setSize(new Dimension(32 * 100, 32 * 100));
		panel.setPreferredSize(new Dimension(32 * 100, 32 * 100));

		wrapper.setSize(new Dimension(600, 400));
		wrapper.setPreferredSize(new Dimension(600, 400));
		wrapper.setViewportView(new JViewport().add(panel));
		
		this.add(wrapper, BorderLayout.WEST);
		this.add(buttons, BorderLayout.EAST);
		
	}

	public void makeTimer() {
		t = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				agent.m = r.nextInt(4);
				agent.move();
				
			}
		});
	}

	public void makePanel() {
		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3277456389480389779L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(map.getMapImage(), 0, 0, null);
				agent.draw(g);
			}
		};
	}

}
