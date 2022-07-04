package gameObjects.InteractableObjects;

import Main.gamePanel;
import gameObjects.gameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Chest extends gameObject {
    public String name;
    public BufferedImage image;
    public double BIGX;
    public double BIGY;
    public boolean isCollide;
    public gamePanel gp;
    public Chest(String name, gamePanel gp, double x, double y){
        this.name = name;
        this.gp = gp;
        this.isCollide = true;
        this.BIGX = x;
        this.BIGY = y;
        try {
            this.image = ImageIO.read(new FileInputStream("./src/Pictures/Player/playerfront1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update() {

    }

    @Override
    public double getBIGX() {
        return 0;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getBIGY() {
        return 0;
    }

    @Override
    public void draw(Graphics2D g2d) {

    }
}
