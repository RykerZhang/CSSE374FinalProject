package Background;

import java.awt.image.BufferedImage;

public class background {
   public String name;
   public BufferedImage image;
   public boolean collide = false;

   public BufferedImage getImage() {
      return image;
   }

   public String getName() {
      return name;
   }

   public boolean isCollide() {
      return collide;
   }
}
