/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotLiving;

public class EntityNotCol extends EntityNotLiving{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    public EntityNotCol(){
        this(0,0);
    }
    
    public EntityNotCol(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public EntityNotCol(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public EntityNotCol(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void doInit(){
        
    }
}
