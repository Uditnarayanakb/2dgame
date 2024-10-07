package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {   // this stores variables that will be used in player, monster & NPC classes
	public int worldX,worldY;
	public int speed;
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;  //it describes an image with an accessible buffer of image data.(We use this to store our images)
	public String direction;
	
	public int spriteCounter=0;  
	public int spritNum=1;
	public Rectangle solidArea; // we can create an invisible rectangle , and we can store dataa x,y,width,height
	public boolean collisionOn=false;
	
}
