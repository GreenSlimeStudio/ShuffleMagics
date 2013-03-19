/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy.EntityMovable.EntityLiving;

public class EntityPlayer extends EntityLiving{
    
    //---------------------------------------------------Variables
    
    //---------------------------------------------------Constructors
    
    public EntityPlayer(){
        this(0,0);
    }
    
    public EntityPlayer(int xPos, int yPos){
        this(xPos, yPos, 32, 32);
    }
    
    public EntityPlayer(int xPos, int yPos, int width, int height){
        this(xPos, yPos, width, height, 2, 4);
    }
    
    public EntityPlayer(int xPos, int yPos, int width, int height, int slowSpeed, int fastSpeed){
        super(xPos, yPos, width, height, slowSpeed, fastSpeed);
        
        doInit();
    }
    //---------------------------------------------------Getter
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
    private void doInit(){
        
        System.out.println("Loaded EntityPlayer");
    }
}
