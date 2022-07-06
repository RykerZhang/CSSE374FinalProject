package gameObjects;

import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class NPC_initialHelper extends gameObject{
    public int col;
    public int row;
    public int BIGX;
    public int BIGY;
    gamePanel gp;
    public NPC_initialHelper(gamePanel gp, String downURL, int col, int row, String direction){
        this.gp = gp;
        direction = "down";
        this.col = col;
        this.row = row;
        this.BIGX = this.col*gp.currentSize;
        this.BIGY = this.row*gp.currentSize;
        this.setImage(downURL);
    }

    public void setImage(String downURL){
        try {
            this.NPCimage = ImageIO.read(new FileInputStream(downURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void setNPC(Graphics2D g2d){
//        BIGX = this.col*gp.currentSize;
//        BIGY = this.row* gp.currentSize;
//        double screenx = BIGX - gp.player1.getBIGX()+gp.player1.getX();
//        double screeny = BIGY - gp.player1.getBIGY()+gp.player1.getY();
//        g2d.drawImage(this.NPCimage, (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
//    }

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
        return null;
    }
}
