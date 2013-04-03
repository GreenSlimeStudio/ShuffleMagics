/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.Enitiy;

public class Entity {
    
    //---------------------------------------------------Variables
    protected int xPos;
    protected int yPos;
    
    protected int width;
    protected int height;
    
    //---------------------------------------------------Constructors
    public Entity(){
        this(0, 0);
    }
    
    public Entity(int xPos, int yPos){
        this(xPos, yPos, 32, 32);  
    }
    
    public Entity(int xPos, int yPos, int width, int height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        
        doInit();
    }

    //---------------------------------------------------Getter
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
    
    public int getwidth() {
        return width;
    }
    
    public int getheight() {
        return height;
    }
    
    //---------------------------------------------------Setter
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    } 
    
    //---------------------------------------------------Functions
    private void doInit(){
        
    }
}
