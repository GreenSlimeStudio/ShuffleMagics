/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityCol;

import ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotLiving;
import java.awt.Rectangle;

public class EntityCol extends EntityNotLiving{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    public EntityCol(){
        this(0,0);
    }
    
    public EntityCol(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public EntityCol(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public EntityCol(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    
    //---------------------------------------------------Getter
    
    public Rectangle getNextRectangle(){
        return new Rectangle(xPos+xAdd, yPos+yAdd, width, height);
    }
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void doInit(){

    }
}
