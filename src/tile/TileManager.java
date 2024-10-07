package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tile;    // imp : note this basically works on the input given by the txt file 
	public int mapTileNum[] [];
	public TileManager(GamePanel gp) {
		this.gp=gp;
		tile=new Tile[10];   // we gonna create 10 kinds of tile like grass,water,a wall etc.
		mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];  // will store all the numbers frm the txt files which we give the input to 
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[0]=new Tile();
			tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1]=new Tile();
			tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision=true;

			tile[2]=new Tile();
			tile[2].image=ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision=true;
			
			tile[3]=new Tile();
			tile[3].image=ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[4]=new Tile();
			tile[4].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision=true;
		
			tile[5]=new Tile();
			tile[5].image=ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	public void loadMap(String filePath) {
		
		try {
			InputStream is=getClass().getResourceAsStream(filePath);  // we use this to import the text file
			BufferedReader un=new BufferedReader (new InputStreamReader(is));   //we use this to read the content of the txt file
			
			int col=0;
			int row=0;
			
			while(col<gp.maxWorldCol && row<gp.maxWorldRow) {
				
				String line= un.readLine(); 	// Read a line of text 
				
				while(col<gp.maxWorldCol) {
					String numbers[]=line.split(" ");  //split the string at a space 
									// the line 56 gets the string and tn line 57 make it as integer
					int num=Integer.parseInt(numbers[col]);   //use col as an index for numbers[] array
					mapTileNum[col][row]=num;   // we store the extracted number in the mapTileNUm[][]
					
					col++; // we have to continue this until everything in the numbers[] is stored in the mapTileNum[][]
					
				}
				if(col==gp.maxWorldCol) {
					col=0;
					row++;
				}
			}
			un.close();
			
		}catch(Exception e) {
			
		}
		
		
		
	}
		public void draw(Graphics2D g2) {
			
																					//			g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
																					//			g2.drawImage(tile[1].image,48,0,gp.tileSize,gp.tileSize,null);
																					//			g2.drawImage(tile[2].image,96,0,gp.tileSize,gp.tileSize,null);
			int worldCol=0;
			int worldRow=0;

			
			while(worldCol<gp.maxWorldCol && worldRow<gp.maxWorldRow) {
				
				int tileNum=mapTileNum[worldCol][worldRow];   // extract a tile number which is stored in mapTileNum[0][0]
				
				int worldX=worldCol*gp.tileSize;
				int worldY=worldRow*gp.tileSize;
				int screenX=worldX-gp.player.worldX +gp.player.screenX;
				int screenY=worldY-gp.player.worldY+ gp.player.screenY;
				
				if(worldX+gp.tileSize>gp.player.worldX-gp.player.screenX && 
				   worldX-gp.tileSize<gp.player.worldX+gp.player.screenX &&
				   worldY+gp.tileSize>gp.player.worldY-gp.player.screenY &&
				   worldY-gp.tileSize<gp.player.worldY+gp.player.screenY) {
					
					g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
					
				}
				worldCol++;

				
				if(worldCol==gp.maxWorldCol) {
					worldCol=0;
					worldRow++;
				}
				
			}
			
		}
	
}
