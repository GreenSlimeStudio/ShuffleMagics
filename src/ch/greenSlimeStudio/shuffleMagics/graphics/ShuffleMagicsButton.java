/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ShuffleMagicsButton extends JButton{
    
    private int x;
    private int y;
    private int width;
    private int height;
    
    public ShuffleMagicsButton(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setLocation(100, 100);
        setSize(300, 600);
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HALLO");
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 200, 300);
        g.fillRect(300, 300, 345, 342);
    }
    
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return y;
    }
    
    public int getwidth(){
        return width;
    }
    
    public int getheight(){
        return height;
    }

}
