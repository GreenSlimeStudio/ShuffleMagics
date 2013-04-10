/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.images;

import java.awt.Image;

public class ImageLoader {
    
    //---------------------------------------------------Variables
    private String path;
    
    private Image imageGras;
    private Image imageStone;
    private Image[][] imageCharacter;
    
    //---------------------------------------------------Constructors
    public ImageLoader(){
        path = "res/terrain.png";
               
        //imageGras = (new SubImage(0, 0, 32, 32, path)).getImage();
        imageGras = (new SubImage(0, 0, 16, 16, "res/Gras.png")).getImage();
        //imageStone = (new SubImage(32, 0, 32, 32, path)).getImage();
        imageStone = (new SubImage(0, 0, 16, 16, "res/stone.png")).getImage();
        
        imageCharacter = new Image[8][5];
        for(int i=0;i<8;i++){
            for(int j=0;j<5;j++){
                imageCharacter[i][j] = new SubImage(j*32, i*32, 32, 32, "res/character.png").getImage();
            }
        }        
    }

    //---------------------------------------------------Getter
    public Image getImageGras() {
        return imageGras;
    }

    public Image getImageStone() {
        return imageStone;
    }
    
    public Image getImageCharacter(int imageLine, int imageRow) {
        return imageCharacter[imageLine][imageRow];
    }
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
}
