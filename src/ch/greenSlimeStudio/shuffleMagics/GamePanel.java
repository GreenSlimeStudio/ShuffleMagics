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
   
    private int WIDTH;
    private int HEIGHT;
    
    
    //Max time between the While-Loop
    private final int DELAY = 50;

    private boolean inGame;
    
    private Thread thread;
    
    public GamePanel(int width, int height){
        
        this.WIDTH = width;
        this.HEIGHT = height;
        
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setDoubleBuffered(true);
    }
    
    //Is called, when the JPanel is added to the JFrame
    public void addNotify(){
        super.addNotify();
        
        inGame = true;
        
        //Creating new thread and starts it
        thread = new Thread(this);
        thread.start();
    }
    
    //Does all the paintings
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        if(inGame){
            
            g2d.setColor(Color.yellow);
            g2d.fillRect(10, 10, 500, 600);
            g2d.fillRect(0,0,3,3);
        }
    }
    
    //Is called only once with thread.start()
    @Override
    public void run() {
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
        while(inGame){
            
            repaint();
            
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
}
