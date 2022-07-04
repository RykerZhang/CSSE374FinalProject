package Background;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class WaterLand extends background{
    private String name;
    private BufferedImage image;
    private boolean collide;

    public WaterLand(){
        this.name = "WaterLand";
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/Background/water1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.collide = true;
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
