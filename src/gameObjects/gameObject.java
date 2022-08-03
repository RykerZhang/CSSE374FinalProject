package gameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class gameObject {
    public boolean hurtWhenCollide = false;
    public boolean isPlayer;
    public String name;
    public double x;
    public double y;
    public double BIGX;
    public double BIGY;
    public String direction;
    public BufferedImage upImage1, upImage2, leftImage1, leftImage2, rightImage1, rightImage2, downImage1, downImage2;
    public BufferedImage ObjectImage;
    public boolean Interactable;
    public gameObject interactingObject;
    public abstract void update();
    public abstract double getBIGX();
    public abstract double getX();
    public abstract double getY();
    public abstract double getBIGY();
    public abstract int getCol();
    public abstract int getRow();
    public Rectangle collideArea = new Rectangle(2,2,26,26);
    public int collideAreaX = 0;
    public int collideAreaY = 0;
    public int col;
    public int row;
    public boolean doUpCollide;
    public boolean doLeftCollide;
    public boolean doRightCollide;
    public boolean doDownCollide;
    public boolean doRightObjectCollide;
    public boolean doLeftObjectCollide;
    public  boolean doDownObjectCollide;
    public  boolean doUpObjectCollide;
    public int speed;
    public abstract void draw(Graphics2D g2d);
    public abstract String getName();
    public abstract boolean isInteractable();
    public abstract ArrayList<String> readDialogueFile(int initialHelperAndPlayer);
    //Only for gameObject
    public abstract boolean isPressEnter();
    public abstract void OutOfCombatMovement();
    public gameObject getInteractingObject() {
        return interactingObject;
    }

    public void setInteractingObject(gameObject interactingObject) {
        this.interactingObject = interactingObject;
    }

    public boolean isDoUpCollide() {
        return doUpCollide;
    }

    public void setDoUpCollide(boolean doUpCollide) {
        this.doUpCollide = doUpCollide;
    }

    public boolean isDoLeftCollide() {
        return doLeftCollide;
    }

    public void setDoLeftCollide(boolean doLeftCollide) {
        this.doLeftCollide = doLeftCollide;
    }

    public boolean isDoRightCollide() {
        return doRightCollide;
    }

    public void setDoRightCollide(boolean doRightCollide) {
        this.doRightCollide = doRightCollide;
    }

    public boolean isDoDownCollide() {
        return doDownCollide;
    }

    public void setDoDownCollide(boolean doDownCollide) {
        this.doDownCollide = doDownCollide;
    }
    public int getSpeed() {
        return speed;
    }

    public Rectangle getCollideArea() {
        return collideArea;
    }
    public String getDirection() {
        return direction;
    }

    public boolean isDoRightObjectCollide() {
        return doRightObjectCollide;
    }

    public void setDoRightObjectCollide(boolean doRightObjectCollide) {
        this.doRightObjectCollide = doRightObjectCollide;
    }

    public boolean isDoLeftObjectCollide() {
        return doLeftObjectCollide;
    }

    public void setDoLeftObjectCollide(boolean doLeftObjectCollide) {
        this.doLeftObjectCollide = doLeftObjectCollide;
    }

    public boolean isDoDownObjectCollide() {
        return doDownObjectCollide;
    }

    public void setDoDownObjectCollide(boolean doDownObjectCollide) {
        this.doDownObjectCollide = doDownObjectCollide;
    }

    public boolean isDoUpObjectCollide() {
        return doUpObjectCollide;
    }

    public void setDoUpObjectCollide(boolean doUpObjectCollide) {
        this.doUpObjectCollide = doUpObjectCollide;
    }

}
