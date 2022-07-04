package gameObjects;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends gameObject implements PlayerObserver {
    private boolean isPlayer;
    private String Name;
    private double x;
    private double y;
    private double BIGX;
    private double BIGY;
    private keyControl kc;
    private gamePanel gp;
    private BufferedImage PlayerImgae;
    PlayerMove playerMove;

    public Player(keyControl kc, gamePanel gp){
        this.isPlayer = false;
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
        g2d.drawImage(this.PlayerImgae, (int)this.x, (int)this.y, (int)gp.currentSize,(int)gp.currentSize,null);
    }

    @Override
    public void updatePlayerPosition(int BIGX, int BIGY, BufferedImage PlayerImage, int PlayerX ,int PlayerY) {
        this.BIGX = BIGX;
        this.BIGY = BIGY;
        this.x = PlayerX;
        this.y = PlayerY;
        this.PlayerImgae = PlayerImage;
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getName(){
        return this.Name;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getBIGX() {
        return BIGX;
    }

    public double getBIGY() {
        return BIGY;
    }


}
