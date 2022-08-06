package gameObjects.Equipment;

import Main.gamePanel;
import gameObjects.gameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WoodSword extends gameObject {

    public WoodSword(gamePanel gp){
        this.name = "Wood Sword";
        try {
            this.ObjectImage = ImageIO.read(new FileInputStream("./src/Pictures/Weapons/WoodSword16.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.attack = 1;
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

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isInteractable() {
        return true;
    }

    @Override
    public ArrayList<String> readDialogueFile(int initialHelperAndPlayer) {
        return null;
    }

    @Override
    public boolean isPressEnter() {
        return false;
    }

    @Override
    public void OutOfCombatMovement() {

    }

    @Override
    public boolean isDoAttack() {
        return false;
    }

    @Override
    public void getHurt(int attack) {

    }
}
