/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class ShuffleMagics extends JFrame{
    
    //---------------------------------------------------Variables  
    private final int WIDTH = 1280;//Defines the size of the JFrame
    private int HEIGHT;//Height will be calculatet with the 16:9 solution
    
    public final int characterFactor = 128;
    public final int blockFactor = 64;
    
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    
    //---------------------------------------------------Constructors
    public ShuffleMagics() throws Exception{
        
        HEIGHT = WIDTH/16*9;
        
        //Creating new GamePanel as base for all the paintings
        gamePanel = new GamePanel(WIDTH, HEIGHT);
        //add(gamePanel);
        
        menuPanel = new MenuPanel((WIDTH), HEIGHT);
        add(menuPanel);
        
        setTitle("Shuffle Magics (C)Green Slime Studio");
        setSize(WIDTH+6, HEIGHT+25);//+6 & +25 because of the frame-border
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        System.out.println("Loaded the Game");
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    
    //---------------------------------------------------Classes 
    private class TAdapter extends KeyAdapter {//Calls every keyPressed/keyReleased-Method
        
        public void keyPressed(KeyEvent e) {
            //gamePanel.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e) {
            //gamePanel.keyReleased(e);
        }     
    }
    
    public static void main(String[] args) throws Exception {
        
        new ShuffleMagics();      
    }
}
