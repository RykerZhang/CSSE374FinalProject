package Background;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Wall extends background{
    private String name;
    private BufferedImage image;
    private boolean collide;

    public Wall(){
        this.name = "Wall";
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/Background/wall1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.collide = true;
    }
    @Override
    public BufferedImage getImage() {return image;}
    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isCollide() {
        return collide;
    }
}
