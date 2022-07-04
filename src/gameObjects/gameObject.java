package gameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class gameObject {
    public boolean isPlayer;
    public String name;
    public int x;
    public int y;
    public int BIGX;
    public int BIGY;
    public BufferedImage Image;
    public String direction;
    public boolean doUpCollide;
    public boolean doLeftCollide;
    public boolean doRightCollide;
    public boolean doDownCollide;
    public abstract void update();
    public abstract int getBIGX();
    public abstract int getX();
    public abstract int getY();
    public abstract int getBIGY();
    public abstract void draw(Graphics2D g2d);
     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }
}
