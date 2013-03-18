/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics;

import javax.swing.JFrame;

public class ShuffleMagics extends JFrame{
    
    //Defines the size of the JFrame
    //Height will be calculatet with the 16:9 solution
    private final int WIDTH = 1280;
    private int HEIGHT;
    
    private GamePanel gamePanel;
    
    public ShuffleMagics(){
        
        HEIGHT = WIDTH/16*9;
        
        //Creating new GamePanel as base for all the paintings
        gamePanel = new GamePanel(WIDTH, HEIGHT);
        add(gamePanel);
        
        setTitle("Shuffle Magics (C)Green Slime Studio");
        setSize(WIDTH+6, HEIGHT+25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new ShuffleMagics();
    }
}
