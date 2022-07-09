package gameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class gameObject {
    public boolean isPlayer;
    public String name;
    public double x;
    public double y;
    public double BIGX;
    public double BIGY;
    public String direction;
    public BufferedImage upImage1, upImage2, leftImage1, leftImage2, rightImage1, rightImage2, downImage1, downImage2;
    public BufferedImage NPCimage;
    public boolean Interactable;
    public gameObject interactingObject;
    public abstract void update();
    public abstract double getBIGX();
    public abstract double getX();
    public abstract double getY();
    public abstract double getBIGY();
    public abstract int getCol();
    public abstract int getRow();
    public Rectangle collideArea = new Rectangle(0,0,28,28);
    public int collideAreaX = 0;
    public int collideAreaY = 0;
    public int col;
    public int row;
    public abstract void draw(Graphics2D g2d);
    public abstract String getName();
    public abstract boolean isInteractable();
    public abstract ArrayList<String> readDialogueFile(int initialHelperAndPlayer);

    //Only for gameObject
    public abstract boolean isPressEnter();

    public gameObject getInteractingObject() {
        return interactingObject;
    }

    public void setInteractingObject(gameObject interactingObject) {
        this.interactingObject = interactingObject;
    }
}
