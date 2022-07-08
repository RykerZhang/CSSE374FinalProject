package gameObjects.InteractableObjects;

import Main.gamePanel;
import gameObjects.gameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Chest extends gameObject {
    public String name;
    public BufferedImage image;
    public double BIGX;
    public double BIGY;
    public boolean isCollide;
    public gamePanel gp;
    public Rectangle collideArea = new Rectangle(0,0,30,30);
    public int collideAreaX = 0;
    public int collideAreaY = 0;


    public Chest(String name, gamePanel gp, double x, double y){
        this.name = name;
        this.gp = gp;
        this.isCollide = true;
        this.BIGX = x;
        this.BIGY = y;
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/InteractableObjects/chest1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update() {

    }

    @Override
    public double getBIGX() {
        return this.BIGX;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public double getBIGY() {
        return this.BIGY;
    }

    @Override
    public int getCol() {
        return this.col;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public void draw(Graphics2D g2d) {
        double screenx = this.BIGX - gp.player1.getBIGX()+gp.player1.getX();
        double screeny = this.BIGY - gp.player1.getBIGY()+gp.player1.getY();
        g2d.drawImage(this.image, (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isInteractable() {
        return false;
    }

    @Override
    public ArrayList<String> readDialogueFile(int initialHelperAndPlayer) {
        return null;
    }

}
