/**
 *
 * @author GreenSlimeStudio
 */

package ch.greenSlimeStudio.shuffleMagics.images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class SubImage {
    
    //---------------------------------------------------Variables
    private Image image;
    private ImageIcon ii;
    private BufferedImage buffImage;
    
    //---------------------------------------------------Constructors
    public SubImage(int x, int y, int width, int height, String path){
        
        File file = new File(path);
        try{
            this.buffImage = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(SubImage.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Get a Subimage from a BufferedImage and saves it as Images
        BufferedImage subBuff = buffImage.getSubimage(x, y, width, height);	
        ii = new ImageIcon(subBuff);

        image = ii.getImage();
    }
    
    //---------------------------------------------------Getter
    public Image getImage(){
        return image;
    }
    
    //---------------------------------------------------Setter
    
    //---------------------------------------------------Functions
}
