
package picturecomparetwo;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Twiztedcyph
 */
public class LoadPic
{
    private String filePath, errorMsg;
    private File file;
    private BufferedImage image;
    private boolean valid;
    
    //Regular expression to ensure the image is of the correct type.
    private final String IMG_REG = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    
    public LoadPic(String filePath)
    {
        valid = false;
        errorMsg = new String();
        if(filePath.matches(IMG_REG))
        {
            this.filePath = filePath;
            file = new File(this.filePath);
            if(file.canRead())
            {
                try
                {
                    image = ImageIO.read(file);
                    valid = true;
                } catch (Exception e)
                {
                    errorMsg = "Exception: " +e;
                }
                
            }else
            {
                errorMsg = "File " + this.filePath + " does not exist or cannot be read.";
            }
        }else
        {
            errorMsg = "This type of file is not accepted.";
        }
        
        if(!errorMsg.isEmpty())
        {
            System.out.println(errorMsg);
        }
    }
    
    public boolean isValid()
    {
        return valid;
    }
    
    public BufferedImage getImage()
    {
        return image;
    }
}
