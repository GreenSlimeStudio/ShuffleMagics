/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
   
    //---------------------------------------------------Variables
    private int WIDTH;
    private int HEIGHT;
    
    private final int DELAY = 50;//Max time between the While-Loop

    public boolean inGame;
    
    private Thread thread;
    
    //---------------------------------------------------Constructors
    public GamePanel(int width, int height){
        
        this.WIDTH = width;
        this.HEIGHT = height;
        
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setDoubleBuffered(true);
        
        System.out.println("Loaded the GamePanel");
        
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void addNotify(){//Is called, when the JPanel is added to the JFrame
        super.addNotify();
        
        inGame = true;
        
        //Creating new thread and starts it
        thread = new Thread(this);
        thread.start();
    }
    
    public void paint(Graphics g){//Does all the paintings
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        if(inGame){
            
            g2d.setColor(Color.yellow);
            g2d.fillRect(10, 10, 500, 600);
        }
    }
     
    @Override
    public void run() {//Is called only once with thread.start()
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
        while(inGame){
            
            repaint();
            
            moveAllComponents();
            
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
    
    
    public void moveAllComponents(){//Calls every move-Method
        
    }
}
