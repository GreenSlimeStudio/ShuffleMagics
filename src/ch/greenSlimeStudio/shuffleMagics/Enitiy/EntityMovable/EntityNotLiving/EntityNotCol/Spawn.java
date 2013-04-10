/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol;

public class Spawn extends EntityNotCol{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    public Spawn(){
        this(0,0);
    }
    
    public Spawn(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public Spawn(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public Spawn(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void doInit(){
        
    }
}
