/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics;

import ch.greenSlimeStudio.shuffleMagics.graphics.ShuffleMagicsButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MenuPanel extends JPanel implements Runnable{

    //---------------------------------------------------Variables
    private int WIDTH;
    private int HEIGHT;
    
    private final int DELAY = 50;//Max time between the While-Loop
    
    private Thread thread;
       
    //---------------------------------------------------Constructors
    public MenuPanel(int width, int height){
        
        this.WIDTH = width;
        this.HEIGHT = height;
        
        setSize(WIDTH, HEIGHT);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        System.out.println("Loaded the MenuPanel");
        
        ShuffleMagicsButton myButton = new ShuffleMagicsButton(12, 12, 100, 100);
        
        add(myButton);
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void paint(Graphics g){//Does all the paintings
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        
        
        g2d.setColor(Color.red);
        g2d.drawRect(0, 0, 100, 100);
    }
    
    public void addNotify(){//Is called, when the JPanel is added to the JFrame
        super.addNotify();   
        
        //Creating new thread and starts it
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {//Is called only once with thread.start()
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
        while(true){
            
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
