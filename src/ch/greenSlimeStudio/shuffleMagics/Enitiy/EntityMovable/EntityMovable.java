/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.Entity;

import java.awt.event.KeyEvent;

public class EntityMovable extends Entity{
    
    //---------------------------------------------------Variables
    protected int xAdd;
    protected int yAdd;
    protected int Speed;//Actual speed
    private final int slowSpeed;
    private final int fastSpeed;
    
    //---------------------------------------------------Constructors
    public EntityMovable(){
        this(0,0);
    }
    
    public EntityMovable(int xPos, int yPos){   
        this(xPos, yPos, 32, 32);
    }
    
    public EntityMovable(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public EntityMovable(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height);
        this.slowSpeed = slowSpeed;
        this.fastSpeed = fastSpeed;
        
        this.Speed = this.slowSpeed;
        
        xAdd = 0;
        yAdd = 0;
        
        doInit();
    }

    //---------------------------------------------------Getter
    public int getxAdd() {
        return xAdd;
    }

    public int getyAdd() {
        return yAdd;
    }

    public int getSpeed() {
        return Speed;
    }

    public int getSlowSpeed() {
        return slowSpeed;
    }

    public int getFastSpeed() {
        return fastSpeed;
    }

    //---------------------------------------------------Setter
    public void setxAdd(int xAdd) {
        this.xAdd = xAdd;
    }

    public void setyAdd(int yAdd) {
        this.yAdd = yAdd;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
    
    //---------------------------------------------------Functions
    private void doInit(){  

    }
    
    public void move(){//set new X/Y-positions
        xPos += xAdd;
        yPos += yAdd;
    }
    

    public void keyPressed(KeyEvent e){//set the right X/Y-add
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            xAdd = Speed;
        }
        if(key == KeyEvent.VK_RIGHT){
            xAdd = -Speed;
        }
        if(key == KeyEvent.VK_UP){
            yAdd = Speed;
        }
        if(key == KeyEvent.VK_DOWN){
            yAdd = -Speed;
        }
        if(key == KeyEvent.VK_SHIFT){
            Speed = fastSpeed;
            System.out.println("Fast");
            System.out.println(Speed);
        }
    }

    public void keyReleased(KeyEvent e){//reset the X/Y-add
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            xAdd = 0;
        }
        if(key == KeyEvent.VK_RIGHT){
            xAdd = 0;
        }
        if(key == KeyEvent.VK_UP){
            yAdd = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            yAdd = 0;
        }
        if(key == KeyEvent.VK_SHIFT){
            Speed = slowSpeed;
        }
    }
}
