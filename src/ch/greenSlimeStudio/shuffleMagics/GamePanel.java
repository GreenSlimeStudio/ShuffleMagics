/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityLiving.EntityPlayer;
import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityCol.Stone;
import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol.Gras;
import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol.Spawn;
import ch.greenSlimeStudio.shuffleMagics.images.ImageLoader;
import ch.greenSlimeStudio.shuffleMagics.map.Map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
   
    //---------------------------------------------------Variables
    private int WIDTH;
    private int HEIGHT;
    
    public final int characterFactor = 128;
    public final int blockFactor = 64;
    
    private final int DELAY = 50;//Max time between the While-Loop

    public boolean inGame;
    
    private Thread thread;
    
    private ImageLoader imageLoader;
    
    private EntityPlayer character;
    
    private Map map;
    private ArrayList stoneList;
    private ArrayList grasList;
    private ArrayList spawnList;
    
    //---------------------------------------------------Constructors
    public GamePanel(int width, int height) throws Exception{
        
        this.WIDTH = width;
        this.HEIGHT = height;
        
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        System.out.println("Loaded the GamePanel");
        
        map = new Map(1);
        stoneList = map.getStoneList();
        grasList = map.getGrasList();
        spawnList = map.getSpawnList();
        
        
        Spawn spawn;
        spawn = (Spawn) spawnList.get(0);
        character = new EntityPlayer(spawn.getxPos(), spawn.getyPos(), 32, 32, 8, 16);
        map.allXYSetter(WIDTH/2-32+12, HEIGHT/2-32+24, character.getxPos(), character.getyPos());
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void addNotify(){//Is called, when the JPanel is added to the JFrame
        super.addNotify();
        
        inGame = true;
        
        //Loading all the images
        imageLoader = new ImageLoader();    
        
        //Creating new thread and starts it
        thread = new Thread(this);
        thread.start();
    }
    
    public void paint(Graphics g){//Does all the paintings
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        if(inGame){   
            for(int i=0;i<grasList.size();i++){
                Gras gras;
                gras = (Gras) grasList.get(i);

                Image image = imageLoader.getImageGras();
                g2d.drawImage(image, gras.getxPos(), gras.getyPos(), blockFactor, blockFactor, this);
            }
            
            for(int i=0;i<stoneList.size();i++){
                Stone stone;
                stone = (Stone) stoneList.get(i);

                Image image = imageLoader.getImageStone();
                g2d.drawImage(image, stone.getxPos(), stone.getyPos(), blockFactor, blockFactor, this);
            }
            //draw Character
            g2d.drawImage(imageLoader.getImageCharacter(character.getImageLine(), character.getImageRow()), WIDTH/2-(characterFactor/2), HEIGHT/2-(characterFactor/2), characterFactor, characterFactor, this);
            //draw Character-Colliderbox
            g2d.setColor(Color.RED);
            g2d.drawRect(WIDTH/2-(characterFactor/4), HEIGHT/2, blockFactor, blockFactor);
        }
    }
     
    @Override
    public void run() {//Is called only once with thread.start()
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
        while(inGame){
            
            repaint();
            try {
                checkCollision();
            } catch (Exception ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if(sleep < 0){
                sleep = 2;
            }
            
            try{
                Thread.sleep(sleep);
            }catch(InterruptedException e){
                System.out.println("ERROR: Thread.sleep()");
            }

            beforeTime = System.currentTimeMillis();
        }
    }
    
    public void checkCollision() throws Exception{


        Rectangle rCharacter = new Rectangle(WIDTH/2-(characterFactor/4), HEIGHT/2, blockFactor, blockFactor);
        
        boolean check = true;

        for (int i=0;i<stoneList.size();i++) {
            Stone stone = (Stone) stoneList.get(i);
            Rectangle rStone = stone.getNextRectangle();
            if (rStone.intersects(rCharacter)) {
                check = false;
                break;
            }
        }

        if(check == true){
            moveAllComponents();
        }
    }
    
    public void moveAllComponents(){//Calls every move-Method
        
        for(int i=0;i<grasList.size();i++){
            Gras gras = (Gras) grasList.get(i);
            gras.move();
        }
        for(int i=0;i<stoneList.size();i++){
            Stone stone = (Stone) stoneList.get(i);
            stone.move();
        }
        character.move();
    }
    
    public void keyPressed(KeyEvent e){
        for(int i=0;i<grasList.size();i++){
            Gras gras = (Gras) grasList.get(i);
            gras.keyPressed(e);
        }
        for(int i=0;i<stoneList.size();i++){
            Stone stone = (Stone) stoneList.get(i);
            stone.keyPressed(e);
        }
        character.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e){
        for(int i=0;i<grasList.size();i++){
            Gras gras = (Gras) grasList.get(i);
            gras.keyReleased(e);
        }
        for(int i=0;i<stoneList.size();i++){
            Stone stone = (Stone) stoneList.get(i);
            stone.keyReleased(e);
        }
        character.keyReleased(e);
    }
}
