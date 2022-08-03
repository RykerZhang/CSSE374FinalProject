package gameObjects;

import Main.gamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Thief extends Enemy{
    public Thief(gamePanel gp, int col, int row, String direction) {
        super(gp, col, row, direction);
        this.setEightImage();
        this.name = "Thief";
        this.maxLife = 10;
        this.speed = 1;
        this.currentLife = this.maxLife;
        this.collideArea.x = 0;
        this.collideArea.y = 0;
        this.inFight = false;
        this.direction = "right";
        this.col = col;
        this.row = row;
        this.BIGX = this.col*gp.currentSize;
        this.BIGY = this.row*gp.currentSize;
    }

    public void setEightImage(){
        try {
            this.EnemyImageUp1 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_up1.png"));
            this.EnemyImageUp2 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_up2.png"));
            this.EnemyImageLeft1 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_left1.png"));
            this.EnemyImageLeft2 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_left2.png"));
            this.EnemyImageDown1 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_down1.png"));
            this.EnemyImageDown2 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_down2.png"));
            this.EnemyImageRight1 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_right1.png"));
            this.EnemyImageRight2 = ImageIO.read(new FileInputStream("./src/Pictures/Enemies/thief_right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
