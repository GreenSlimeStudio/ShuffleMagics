/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityMovable;

public class EntityNotLiving extends EntityMovable{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    public EntityNotLiving(){
        this(0,0);
    }
    
    public EntityNotLiving(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public EntityNotLiving(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public EntityNotLiving(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void doInit(){

    }
}
