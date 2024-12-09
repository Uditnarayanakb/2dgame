package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;  // indicates where we draw player on the screen.
	public final int screenY;  // indicates where we draw player on the screen.
	public int hasKey=0;
	int standCounter=0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp=gp;
		this.keyH=keyH;
		
		screenX=gp.screenWidth/2 - (gp.tileSize/2);    // places the player at the center of the screen .  And we move the background not the player 
		screenY=gp.screenHeight/2- (gp.tileSize/2);  // Subtract a half tile length from both screenX and screenY 
		
		solidArea=new Rectangle(); // u can enter like:  solidArea=new Rectangle(8,16,32,32);  this is set to make only a part of image as solid 
		solidArea.x=8;
		solidArea.y=16;
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		solidArea.width=32;
		solidArea.height=32;
		
		setDefaultValues();		
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldX=gp.tileSize *23;
		worldY=gp.tileSize*21;
		speed=4;
		direction= "down";
	}
	public void getPlayerImage() {
		try {
			
			up1= ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2= ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1= ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2= ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1= ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {   // it gets called FPS time per seconds as it is inside the loop in the GamePanel
		
		if(keyH.upPressed==true|| keyH.downPressed==true||
				keyH.leftPressed==true||keyH.rightPressed==true) {
			if(keyH.upPressed==true) {
				direction="up";
			}
			else if(keyH.downPressed==true) {
				direction="down";
			}
			else if(keyH.leftPressed==true) {
				direction="left";
			}
			else if(keyH.rightPressed==true) {
				direction="right";				
			}
			//CHECK TILE COLLISION
			collisionOn=false;
			gp.cChecker.checkTile(this);
			
			//CHECK OBJECT COLLISION
			int objIndex=gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			
			//IF COLLISION IS FALSE,PLAYER CAN MOVE 
			if(collisionOn==false) {
				switch(direction) {
				case "up":worldY-=speed;break;
				case "down":worldY +=speed;break;
				case "left":worldX-=speed;break;
				case "right":worldX+=speed;break;
					
				}
			}
			spriteCounter++;
			if(spriteCounter>12) {
				if(spritNum==1) {
					spritNum=2;
				}
				else if(spritNum==2) {
					spritNum=1;
				}
				spriteCounter=0;
			}
			
		}
		else {
			standCounter++;
			if(standCounter ==20) {
				spritNum=1;	
				standCounter=0;
			}
			
		}

	
	}
	
	public void pickUpObject(int i) {
		
		if(i!=999)   {        // 999 is used bcos its not used by the array's index so 
			
			String objectName=gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				gp.playSE(1);
				hasKey++;
				gp.obj[i]=null;
				gp.ui.showMessage("You got a key!");
				break;
			case "Door":
				gp.playSE(3);
				if(hasKey >0) {
					gp.obj[i] =null;
					hasKey--;
					gp.ui.showMessage("You opened a door!");
				}
				else {
					gp.ui.showMessage("You need a key");
				}
				System.out.println("Key:"+hasKey);
				break;
			case "Boots":
				gp.playSE(2);
				speed+=2;
				gp.obj[i]=null;
				gp.ui.showMessage("Speed UP!");
				break;
			case "Chest":
				gp.ui.gameFinished=true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
																				//		g2.setColor(Color.white);  // sets a color to use for drawing objects
																				//		
																				//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);  // draws a rectangle on the screen  // tileSize is frm GamePanel class 

		BufferedImage image=null;
		
		switch(direction) {
		case "up":
			if(spritNum==1) {
				image=up1;
			}
			if(spritNum==2) {
				image=up2;
			}
			break;
		case "down":
			if(spritNum==1) {
				image=down1;			
			}
			if(spritNum==2) {
				image=down2;
			}
			break;
		case "left":
			if(spritNum==1) {
				image=left1;				
			}
			if(spritNum==2) {
				image=left2;
			}
			break;
		case "right":
			if(spritNum==1) {
				image=right1;				
			}
			if(spritNum==2) {
				image=right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,null) ;    // draw an image on sccreen 
		
		
	}
}
