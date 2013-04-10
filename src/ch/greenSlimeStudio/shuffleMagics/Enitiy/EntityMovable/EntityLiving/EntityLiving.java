/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityLiving;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityMovable;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class EntityLiving extends EntityMovable implements Runnable{

    //---------------------------------------------------Variables
    protected boolean up;
    protected boolean right;
    protected boolean down;
    protected boolean left;
    protected boolean previousUp;
    protected boolean previousRight;
    protected boolean previousDown;
    protected boolean previousLeft;
    
    protected int imageLine;
    protected int imageRow;
    
    private int animateCount;
    private int animateSpeed;
    private final int numberAnimateImages = 5-1;//5 Images - 1 because the index starts with 0
    
    private final int DELAY = 50;//Max time between the While-Loop
    
    private Thread thread;
    
    //---------------------------------------------------Constructors
    public EntityLiving(){
        this(0,0);
    }
    
    public EntityLiving(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public EntityLiving(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public EntityLiving(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    //---------------------------------------------------Getter
    public Rectangle getNextRectangle(){
        return new Rectangle(xPos+xAdd+6, yPos+yAdd+6, width-12, height-12);
    }

    public int getImageLine() {
        return imageLine;
    }
    
    public int getImageRow() {
        return imageRow;
    }
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    private void doInit(){
        
        up = false;
        right = false;
        down = false;
        left = false;
        
        imageLine = 0;
        imageRow = 0;
               
        animateCount = 0;
        animateSpeed = 2;
                 
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        
        while(true){
            
            changeImageParams();
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
    
    public void changeImageParams(){
        
        previousDown = down;
        previousRight = right;
        previousLeft = left;
        previousUp = up;
        
        if(down || right || up || left){

            if(down){
                if(right){
                    imageLine = 1;//Down-Right
                }else if(left){
                    imageLine = 7;//Down-Left
                }else{
                    imageLine = 0;//Down
                }
            }else if(up){

                if(right){
                    imageLine = 3;//Up-Right
                }else if(left){
                    imageLine = 5;//Up-Left
                }else{
                    imageLine = 4;//Up
                }
            }else if(right){
                imageLine = 2;//Right
            }else if(left){
                imageLine = 6;//Left
            }
        }else{
            down = previousDown;
            right = previousRight;
            left = previousLeft;
            up = previousUp;
        }
        
        if(xAdd != 0 || yAdd != 0){
            animate();
        }
    }
    
    public void animate(){
        if(animateCount == animateSpeed){
            animateCount = 0;
            if(imageRow==numberAnimateImages){
                imageRow = 0;
            }else{
                imageRow++;
            }
        }else{
            animateCount++;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){//set the right X/Y-add
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
                xAdd = getSpeed();
                left = true;
                right = false;
        }
        if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
                xAdd = -getSpeed();
                right = true;
                left = false;
        }
        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W){
                yAdd = getSpeed();
                up = true;
                down = false;
        }
        if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
                yAdd = -getSpeed();
                down = true;
                up = false;
        }
        if(key == KeyEvent.VK_SHIFT){
            //Speed = fastSpeed;
            setSpeed(fastSpeed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){//reset the X/Y-add
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A){
                xAdd = 0;
                left = false;
        }
        if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
                xAdd = 0;
                right = false;
        }
        if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W){
                yAdd = 0;
                up = false;
        }
        if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S){
                yAdd = 0;
                down = false;
        }
        if(key == KeyEvent.VK_SHIFT){
            Speed = slowSpeed;
        }
    }
}
