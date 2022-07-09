package gameObjects;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import ObserversAndSubjects.PlayerSubject;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerMove implements PlayerSubject {
    private double x;
    private double y;
    private double BIGX;
    private double BIGY;
    private double speed;
    private int MoveImageCount = 0;
    private int imageChoose = 1;
    private keyControl kc;
    private gamePanel gp;
    private ArrayList<PlayerObserver> playerObservers;
    private BufferedImage PlayerImage;
    private BufferedImage playerFront1, playerFront2, playerBack1, playerBack2, playerLeft1, playerLeft2, playerRight1, playerRight2;
    public Rectangle collideArea;
    private boolean doUpCollide;
    private boolean doLeftCollide;
    private boolean doRightCollide;
    private boolean doDownCollide;
    private boolean doUpObjectCollide;
    private boolean doLeftObjectCollide;
    private boolean doRightObjectCollide;
    public gameObject collideObject = null;
    public Player player;
    private boolean doDownObjectCollide;
    private String direction;
    public int defaultCollideX = 0;
    public int defaultCollideY = 0;

    gameObject go;

    public PlayerMove(keyControl kc, gamePanel gp, gameObject go, Player player){
        this.gp = gp;
        this.setMoveImage();
        this.PlayerImage = this.getDefaultImage();
        playerObservers = new ArrayList<>();
        this.x = gp.screenWidth/2-gp.currentSize;
        this.y = gp.screenHeight/2-gp.currentSize;
        this.BIGX = gp.currentSize*48/2 - gp.currentSize;
        this.BIGY = gp.currentSize*32/2 - gp.currentSize;
        this.speed = 4;
        this.kc = kc;
        this.collideArea = new Rectangle(2,2, 26, 26);
        this.go = go;
        this.player = player;
    }

    public void updatePlayerPosition(){
        this.checkCollision();
        this.switchSameDirectionImage();
        if(kc.isPressRight){
            this.direction = "right";
            this.doUpObjectCollide = false;
            this.doDownObjectCollide = false;
            this.doLeftObjectCollide = false;
            if(imageChoose == 1){
                this.PlayerImage = playerRight1;
            }else{
                this.PlayerImage = playerRight2;
            }
            if(this.doRightCollide == false && this.doRightObjectCollide == false) {
                BIGX += speed;
            }else{
            }
        }
        if(kc.isPressUp){
            this.direction = "up";
            this.doDownObjectCollide = false;
            this.doLeftObjectCollide = false;
            this.doRightObjectCollide = false;
            if(imageChoose == 1){
                this.PlayerImage = playerBack1;
            }else{
                this.PlayerImage = playerBack2;
            }
            if(this.doUpCollide == false && this.doUpObjectCollide == false) {
                BIGY -= speed;
            }else{
            }
        }
        if(kc.isPressDown){
            this.direction = "down";
            this.doUpObjectCollide = false;
            this.doLeftObjectCollide = false;
            this.doRightObjectCollide = false;
            if(imageChoose == 1){
                this.PlayerImage = playerFront1;
            }else{
                this.PlayerImage = playerFront2;
            }
            if(this.doDownCollide == false && this.doDownObjectCollide == false) {
                BIGY += speed;
            }else{
            }
        }
        if(kc.isPressLeft) {
            this.direction = "left";
            this.doUpObjectCollide = false;
            this.doDownObjectCollide = false;
            this.doRightObjectCollide = false;
            if(imageChoose == 1){
                this.PlayerImage = playerLeft1;
            }else{
                this.PlayerImage = playerLeft2;
            }
            if(this.doLeftCollide == false && this.doLeftObjectCollide == false) {
                BIGX -= speed;
            }else{
            }
        }
        if(kc.isPressInteract){
            if(this.collideObject!=null){
                //System.out.println(this.collideObject.isInteractable());

                if(this.collideObject.isInteractable() ){
                    this.player.InteractNPC();
                    this.player.setInteractingObject(this.collideObject);
                }
            }
        }

        this.notifyObservers();
    }

    public void setCollideArea(Rectangle collideArea) {
        this.collideArea = collideArea;
    }

    public void checkCollision(){
//        this.doUpCollide = false;
//        this.doDownCollide = false;
//        this.doLeftCollide = false;
//        this.doRightCollide = false;
//        this.doUpObjectCollide = false;
//        this.doDownObjectCollide = false;
//        this.doLeftObjectCollide = false;
//        this.doRightObjectCollide = false;
        this.gp.cc.checkSpeed(this);
        this.gp.cc.checkUpCollision(this);
        this.gp.cc.checkLeftCollision(this);
        this.gp.cc.checkDownCollision(this);
        this.gp.cc.checkRightCollision(this);
        this.collideObject = gp.cc.checkObjectCollision( true, this);
    }

    public void setMoveImage(){
        try {
            playerFront1 = ImageIO.read(new FileInputStream("./src/Pictures/Player/playerfront1.png"));
            playerFront2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerfront2.png"));
            playerBack1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerback1.png"));
            playerBack2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerback2.png"));
            playerLeft1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerleft1.png"));
            playerLeft2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerleft2.png"));
            playerRight1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerright1.png"));
            playerRight2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerright2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int switchSameDirectionImage(){
        this.MoveImageCount++;
        if(this.MoveImageCount > 15){
            if(this.imageChoose == 1){
                this.imageChoose = 2;
            }else if(this.imageChoose == 2){
                this.imageChoose = 1;
            }
            this.MoveImageCount = 0;
        }
        return this.imageChoose;
    }
    public BufferedImage getDefaultImage(){
        return playerFront1;
    }
    @Override
    public void registerObserver(PlayerObserver o) {
        playerObservers.add(o);
    }

    @Override
    public void removeObserver(PlayerObserver o) {

        playerObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver o: playerObservers){
            o.updatePlayerPosition((int)this.BIGX, (int)this.BIGY, this.PlayerImage,(int) this.x, (int)this.y);
        }
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

    public double getSpeed() {
        return speed;
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

    public Rectangle getCollideArea() {
        return collideArea;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }
    public boolean isDoUpObjectCollide() {
        return doUpObjectCollide;
    }

    public void setDoUpObjectCollide(boolean doUpObjectCollide) {
        this.doUpObjectCollide = doUpObjectCollide;
    }

    public boolean isDoLeftObjectCollide() {
        return doLeftObjectCollide;
    }

    public void setDoLeftObjectCollide(boolean doLeftObjectCollide) {
        this.doLeftObjectCollide = doLeftObjectCollide;
    }

    public boolean isDoRightObjectCollide() {
        return doRightObjectCollide;
    }

    public void setDoRightObjectCollide(boolean doRightObjectCollide) {
        this.doRightObjectCollide = doRightObjectCollide;
    }

    public boolean isDoDownObjectCollide() {
        return doDownObjectCollide;
    }

    public void setDoDownObjectCollide(boolean doDownObjectCollide) {
        this.doDownObjectCollide = doDownObjectCollide;
    }
}
