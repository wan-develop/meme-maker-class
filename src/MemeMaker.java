//Files
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


//Graphics
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics2D;

public class MemeMaker {

    static void create( InputStream input, String text1, String text2, String outputFileName) throws IOException {
        
        //Read the Image
        BufferedImage image = ImageIO.read(input);
        
        //Get Dimentions
        int width  = image.getWidth();
        int height  = image.getHeight();
        
        //Create the Image buffer 
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
      
        //Get the graphics to draw on the buffered image
        Graphics2D graphics = (Graphics2D)newImage.getGraphics();
        
        //Add the original Image to the buffered Image
        graphics.drawImage(image, 0, 0, null);
        
        //setUp the font and text color
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        
        //draw the texts on buffered image
        graphics.drawString(text1, width / 8, 218);
        graphics.drawString(text2, width - 250, 180);
      
        //Create output/ path if it does't exists
        Path outputPath = Paths.get("output/");
        if ( !Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }
        
        //export the buffered image to output path
        ImageIO.write(newImage, "png", new File(String.format("output/%s.png", outputFileName)));


    }
}
