
package picturecomparetwo;

import java.awt.image.BufferedImage;

/**
 * In this class the images will be compared for differences.
 *
 * @author TwiztedCyph
 */
public class ComparePic
{
    private BufferedImage imageOne, imageTwo;
    private int lengthOne, widthOne, lengthTwo, widthTwo, tolerance, diffCount;
    private boolean[][] diffArray;
    
    public ComparePic(BufferedImage imageOne, BufferedImage imageTwo)
    {
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
        
        /*
         * This value will be used to specify a tollerance level for the rgb 
         * comparison.
         */
        
        this.tolerance = 0;
        
        diffCount = 0;
        
        //get the dimesions of both images.
        lengthOne = imageOne.getHeight();
        widthOne = imageOne.getWidth();
        lengthTwo = imageTwo.getHeight();
        widthTwo = imageTwo.getWidth();
    }
    
    
    /*
    * For now this program will only compare images of the same size.....
    * At some stage I may change this.
    */
    public boolean[][] compare()
    {
        
        //These variable are just to make the process a little clearer....
        int redOne, redTwo, greenOne, greenTwo, blueOne, blueTwo;
        
        if (lengthOne == lengthTwo && widthOne == widthTwo)
        {
            //initialize the array to the "size" of the images.
            diffArray = new boolean[lengthOne][widthOne];
            
            //iterate through the whole image pixel by pixel.
            for (int i = 0; i < lengthOne; i++)
            {
                for (int j = 0; j < widthOne; j++)
                {
                    /*
                     * Get a separate red, green and blue value for 
                     * the current pixel for each image.
                     */
                    redOne = imageOne.getRGB(j, i) >> 16 & 0xFF;
                    greenOne = imageOne.getRGB(j, i) >> 8 & 0xFF;
                    blueOne = imageOne.getRGB(j, i) & 0xFF;
                    
                    redTwo = imageTwo.getRGB(j, i) >> 16 & 0xFF;
                    greenTwo = imageTwo.getRGB(j, i) >> 8 & 0xFF;
                    blueTwo = imageTwo.getRGB(j, i) & 0xFF;
                    
                    
                    /*
                     * I wanted to make an overlay of all 
                     * the differences using this matrix.
                     */
                    if(isDifferent(redOne, redTwo) || isDifferent(blueOne, blueTwo) || isDifferent(greenOne, greenTwo))
                    {
                        diffArray[i][j] = true;
                        diffCount++;
                    }else
                    {
                        diffArray[i][j] = false;
                    }
                }
            }
            System.out.println(diffCount);
            return diffArray;
        }else
        {
            //images are not the same size.
            System.out.println("Image dimensions are different.");
            return null;
        }
    }
    
    private boolean isDifferent(int valueOne, int valueTwo)
    {
        //Made into a method since I needed to compare numbers a few times.
        if(valueTwo < (valueOne - tolerance) || valueTwo > (valueOne + tolerance))
        {
            return true;
        }else
        {
            return false;
        }
    }
    
    public int getDiffCount()
    {
        return diffCount;
    }
}
