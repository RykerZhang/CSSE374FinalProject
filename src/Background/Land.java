package Background;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Land extends background{
    private String name;
    private BufferedImage image;
    private boolean collide = false;

    public Land(){
        this.name = "Land";
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/Background/land1.png"));
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
