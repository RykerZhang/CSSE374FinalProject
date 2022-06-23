package Player;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player implements PlayerObserver{
    private int x;
    private int y;
    private keyControl kc;
    private gamePanel gp;
    private BufferedImage PlayerImgae;
    PlayerMove playerMove;
    public Player(keyControl kc, gamePanel gp){
        this.x = 100;
        this.y = 100;
        this.kc = kc;
        this.gp = gp;
        playerMove = new PlayerMove(kc);
        playerMove.registerObserver(this);
    }

    public void update(){
        playerMove.updatePlayerPosition();
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(this.PlayerImgae, this.x, this.y, gp.currentSize,gp.currentSize,null);
    }

    @Override
    public void updatePlayerPosition(int PlayerX, int PlayerY, BufferedImage PlayerImage) {
        this.x = PlayerX;
        this.y = PlayerY;
        this.PlayerImgae = PlayerImage;
    }
}
