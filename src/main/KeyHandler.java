package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{    // the listner interface for receiving keyboards events(keystrokes) 
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();  // returns the integer keyCode associated with the key in this event when pressed (eg. Enter-10, A-65, tab-9)
		
		if (code==KeyEvent.VK_W) {
			upPressed=true;
		}
		if (code==KeyEvent.VK_S) {
			downPressed=true;
		}
		if (code==KeyEvent.VK_A) {
			leftPressed=true;
		}
		if (code==KeyEvent.VK_D) {
			rightPressed=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if (code==KeyEvent.VK_W) {
			upPressed=false;
		}
		if (code==KeyEvent.VK_S) {
			downPressed=false;
		}
		if (code==KeyEvent.VK_A) {
			leftPressed=false;
		}
		if (code==KeyEvent.VK_D) {
			rightPressed=false;
		}
	}   
	
 
}
