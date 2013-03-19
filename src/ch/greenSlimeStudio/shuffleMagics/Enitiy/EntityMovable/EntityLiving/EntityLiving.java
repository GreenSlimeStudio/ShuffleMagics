/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityLiving;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityMovable;

import java.awt.Rectangle;

public class EntityLiving extends EntityMovable implements Runnable{

    //---------------------------------------------------Variables
    protected boolean up;
    protected boolean right;
    protected boolean down;
    protected boolean left;
    
    protected int imageLine;
    protected int imageRow;
    
    private int animateCount;
    private int animateSpeed;
    private final int numberAnimateImages = 5-1;
    
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
        this(xPos, yPos, width, height, 2, 4);
    }
    
    public EntityLiving(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    //---------------------------------------------------Getter
    public Rectangle getNextRectangle(){
        return new Rectangle(xPos+xAdd, yPos+yAdd, width, height);
    }

    public int getImageLine() {
        return imageLine;
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
        animateSpeed = 6;
                 
        thread = new Thread(this);
        thread.start();
        
        System.out.println("Loaded EntityLiving");
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
            down = true;
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
}
