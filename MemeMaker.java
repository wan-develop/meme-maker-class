import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMaker {

    static void create( InputStream input, String text1, String text2, String outputFileName) throws IOException {
        
        // URL url = new URL("")
        BufferedImage image = ImageIO.read(input);

        int width  = image.getWidth();
        int height  = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height + 50, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D)newImage.getGraphics();

        graphics.drawImage(image, 0, 0, null);
        
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
      
        graphics.setColor(Color.BLACK);
        
        graphics.drawString(text1, width / 8, 218);
        graphics.drawString(text2, width - 250, 180);

        ImageIO.write(newImage, "png", new File(String.format("output/%s.png", outputFileName)));


    }
}
