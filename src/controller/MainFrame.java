package controller;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

import view.MainView;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3384363961531038554L;
	
	private MainView mainView;
	
	public MainFrame(){
		mainView = new MainView();
		this.add(mainView);
		this.setSize(new Dimension(830,450));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Demo Map");
	}
	
	public static void main(String [] args){
		EventQueue.invokeLater(new Runnable(){
			
			public void run(){
				new MainFrame();
			}
		});
	}
}


