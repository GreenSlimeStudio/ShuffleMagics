/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.map;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityCol.Stone;
import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol.Gras;
import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol.Spawn;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Map {

    //---------------------------------------------------Variables
    private String mapPath;
    private int mapLevel;
    
    private File mapFile;
    
    private ArrayList stoneList;
    private ArrayList grasList;
    private ArrayList spawnList;

    private String[][] mapArray;
    private BufferedImage mapImage;
    
    private int mapImageWidth;
    private int mapImageHeight;

    //---------------------------------------------------Constructors
    public Map(int level) throws Exception{

        stoneList = new ArrayList();
        grasList = new ArrayList();
        spawnList = new ArrayList();
        
        //Loads the right level
        mapPath = "res/maps/level0";
        mapLevel = level;	
        mapPath += Integer.toString(level) + ".png";		
        mapFile = new File(mapPath);
        mapImage = ImageIO.read(mapFile);
                  
        mapImageWidth = mapImage.getWidth();
        mapImageHeight = mapImage.getHeight();

        mapArray = new String[mapImageWidth][mapImageHeight];
        for(int i=0;i<mapImageWidth;i++){

            for(int j=0;j<mapImageHeight;j++){
                //                                  x  y
                Color c = new Color(mapImage.getRGB(i, j));
                if(c.equals(Color.RED)){
                    mapArray[i][j] = "stone";
                }else if(c.equals(Color.WHITE)){
                    mapArray[i][j] = "gras";
                }else if(c.equals(Color.GREEN)){
                    mapArray[i][j] = "spawn";
                }else{
                    mapArray[i][j] = "NOTHING";
                }
            }
        }
        for(int i=0;i<mapArray.length;i++){

            for(int j=0;j<mapArray[0].length;j++){

                if("stone".equals(mapArray[i][j])){
                    Stone stone;
                    stoneList.add(stone = new Stone(i*64, j*64, 64, 64, 8, 16));
                }
                if("gras".equals(mapArray[i][j])){
                    Gras gras;
                    grasList.add(gras = new Gras(i*64, j*64, 64, 64, 8, 16));
                }
                if("spawn".equals(mapArray[i][j])){
                    Spawn spawn;
                    spawnList.add(spawn = new Spawn(i*64, j*64, 64, 64, 8, 16));
                }
            }
        }
    }

    //---------------------------------------------------Getter
    public String[][] getMapArray(){
        return mapArray;
    }

    public ArrayList getStoneList(){
        return stoneList;
    }
    
    public ArrayList getGrasList(){
        return grasList;
    }
    
    public ArrayList getSpawnList(){
        return spawnList;
    }
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void allXYSetter(int x, int y, int charX, int charY){
        //character.setXPos(map.getSpawn().getxPos());
        //character.setYPos(map.getSpawn().getyPos());
        for(int i=0;i<stoneList.size();i++){
            Stone stone = (Stone) stoneList.get(i);
            stone.setxPos(stone.getxPos()+(x-charX));
            stone.setyPos(stone.getyPos()+(y-charY));
        }
        for(int i=0;i<grasList.size();i++){
            Gras gras = (Gras) grasList.get(i);
            gras.setxPos(gras.getxPos()+(x-charX));
            gras.setyPos(gras.getyPos()+(y-charY));
        }     
        Spawn spawn;
        spawn = (Spawn) spawnList.get(0);
        spawn.setxPos(x);
        spawn.setyPos(y);
    }
    
}
