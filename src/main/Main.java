package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window=new JFrame ();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);This lets the window properly  close when user clicks on ('x')button
		window.setResizable(false); // can't resize the window
		window.setTitle("Adventure Hunt");   //to set the title
		
		GamePanel gamePanel= new GamePanel();  // so basically we are adding the GamePanel to this window
		window.add(gamePanel); 
		
		window.pack(); // causes this window to be sized to fit preferred size and layputs of its subcomponents
		
		window.setLocationRelativeTo(null); // not specify the location of the window = window will be displayed at the center of the screen
		window.setVisible(true); // so that we can see the window
		
		gamePanel.startGameThread();
	}

}
 