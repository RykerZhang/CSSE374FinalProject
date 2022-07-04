package Background;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class GrassLand extends background{
    private String name;
    private BufferedImage image;
    private boolean collide;

    public GrassLand(){
        this.name = "GrassLand";
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/Background/grass1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.collide = false;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isCollide() {
        return collide;
    }
}
