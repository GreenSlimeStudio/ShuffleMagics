/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityNotLiving.EntityNotCol;

public class Gras extends EntityNotCol{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    public Gras(){
        this(0,0);
    }
    
    public Gras(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public Gras(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 8, 16);
    }
    
    public Gras(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    public void doInit(){
        
    }
}
