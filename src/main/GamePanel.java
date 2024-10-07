package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel  implements Runnable{   // the class inherites JPanel class
	
	//SCREEN SETTINGS
	final int originalTileSize=16; // 16x16 tile
	final int scale=3; // to scale up the display it in the recent monitors whre those resolution would be ranging from 1280x960
	
	public final int tileSize=originalTileSize*scale;  // 48x48 tile // also changed to public when we want to access from other packages
	
	public final int maxScreenCol=16;
	public final int maxScreenRow=12;
	public final int screenWidth= tileSize*maxScreenCol;  // 16*48==768 pixels
	public final int screenHeight=tileSize*maxScreenRow; // 48*12== 576 pixels
	
	//WORLD SETTINGS
	public final int maxWorldCol=50;
	public final int maxWorldRow=50;
	public final int worldWidth=tileSize*maxWorldCol;
	public final int worldHeight= tileSize*maxWorldRow;
	
	//FPS
	int FPS=120;    
	TileManager tileM=new TileManager(this);
	KeyHandler keyH= new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker =new CollisionChecker(this);
	public Player player=new Player(this,keyH);
	
	
	public GamePanel() {               // constructor
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));    // to set the size of this class (Jpanel)
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);  // enabling this can improve game's rending performance
		this.addKeyListener(keyH);
		this.setFocusable(true);   // with this, this GamePael can be "focused" to receive key input
		
	}
	public void startGameThread()
	{
		gameThread=new Thread(this);
		gameThread.start();
	}

//	@Override
//	public void run() {
//		double drawInterval=1000000000/FPS;   //0.016666 seconds
//		double nextDrawTime= System.nanoTime()+ drawInterval;
//		// we create the game loop 
//		while(gameThread !=null) { // as long as this gameThread exist it repeats the process
//			
//			
//			
//																																	//			long currentTime=System.nanoTime();	// returns the current value of the running Java VIrtual Machine's high resolution time source, in nanoseconds 		
//																																	//			System.out.println("current Time:"+currentTime);
//			
//			 // 1. UPDATE: update info such as character position
//			update();													// so as long as this loop continues
//			// 2. DRAW: draw the screen with the updated value			// it keeps on calling update
//			repaint();  // use to call paintComponent method            //and repaint 
//			
//			try {
//				double remainingTime=nextDrawTime- System.nanoTime();
//				remainingTime/=1000000;  // bcos the nxt line accepts the time in 
//				
//				if(remainingTime<0) {
//					remainingTime=0;
//				}
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime+=drawInterval;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//		
//	}
	
	public void run() { 
		// we make the game loop
		double drawInterval= 1000000000/FPS;
		double delta=0;
		long lastTime=System.nanoTime();
		long currentTime;
		long timer=0;
		int drawCount=0;
		
		
		while(gameThread !=null) { 				// as long as this gameThread exist it repeats the process
			currentTime=System.nanoTime();
			delta+=(currentTime-lastTime)/drawInterval;
			timer+=(currentTime-lastTime);
			lastTime=currentTime;
			
			if(delta>=1) {
											// 1. UPDATE: update info such as character position
							update();																	// so as long as this loop continues
											// 2. DRAW: draw the screen with the updated value			// it keeps on calling update
							repaint();  																		// use to call paintComponent method  
							delta--;
							drawCount++;
			}			
			if(timer>=1000000000) {
				System.out.println("FPS:"+drawCount);
				drawCount=0;
				timer=0;
			}
			
		}
		
	}
	
	public void update () { // to update the character position
		player.update();
	}
	public void paintComponent(Graphics g) { // a class that has many functions to draw objects on the screen 
		super.paintComponent(g);
		
		Graphics2D g2= (Graphics2D)g; // Graphics2D:it is a class extending the graphics class that provides more control over geometry, color management, text layout
		tileM.draw(g2);    // we have types this line bfore player.draw as we have to get the bground img first and tn folled by the player
		
		player.draw(g2);
		
		g2.dispose(); // dispose of this graphics context and release any system resource that it is using 
		
		
		
	}
	}
