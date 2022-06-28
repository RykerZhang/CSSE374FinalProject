package Player;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements PlayerObserver{
    private int x;
    private int y;
    private int BIGX;
    private int BIGY;
    private keyControl kc;
    private gamePanel gp;
    private BufferedImage PlayerImgae;
    PlayerMove playerMove;
    public Player(keyControl kc, gamePanel gp){
        this.x = 100;
        this.y = 100;
        //this.BIGX = 100;
       // this.BIGY = 100;
        this.kc = kc;
        this.gp = gp;
        playerMove = new PlayerMove(kc, gp);
        playerMove.registerObserver(this);
    }

    public void update(){
        playerMove.updatePlayerPosition();
    }
    public void draw(Graphics2D g2d){
       // System.out.println(this.x);
        g2d.drawImage(this.PlayerImgae, this.x, this.y, gp.currentSize,gp.currentSize,null);
    }

    @Override
    public void updatePlayerPosition(int BIGX, int BIGY, BufferedImage PlayerImage, int PlayerX ,int PlayerY) {
        this.BIGX = BIGX;
        this.BIGY = BIGY;
        this.x = PlayerX;
        this.y = PlayerY;
        this.PlayerImgae = PlayerImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBIGX() {
        return BIGX;
    }

    public int getBIGY() {
        return BIGY;
    }
}
