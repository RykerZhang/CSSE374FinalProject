package gameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class gameObject {
    public boolean isPlayer;
    public String name;
    public double x;
    public double y;
    public double BIGX;
    public double BIGY;
  //  public BufferedImage Image;
  //  public String direction;
  //  public boolean doUpCollide;
  //  public boolean doLeftCollide;
  //  public boolean doRightCollide;
  //  public boolean doDownCollide;
    public abstract void update();
    public abstract double getBIGX();
    public abstract double getX();
    public abstract double getY();
    public abstract double getBIGY();
    public Rectangle collideArea = new Rectangle(0,0,28,28);
    public int collideAreaX = 0;
    public int collideAreaY = 0;
    public abstract void draw(Graphics2D g2d);
    public abstract String getName();
//     String getName() {
//        return name;
//    }

   //  void setName(String name) {
      //  this.name = name;
   // }
}
