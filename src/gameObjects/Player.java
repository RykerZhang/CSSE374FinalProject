package gameObjects;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    public Rectangle collideArea = new Rectangle(2,2,26,26);
    public int collideAreaX = 0;
    public int collideAreaY = 0;
    private int col;
    private int row;
    public gameObject interactingObject;
    public boolean isPressEnter;
    public int HP =100;




    public Player(keyControl kc, gamePanel gp){
        this.isPlayer = false;
        this.x = 100;
        this.y = 100;
        //this.BIGX = 100;
       // this.BIGY = 100;
        this.kc = kc;
        this.gp = gp;
        playerMove = new PlayerMove(kc, gp, this, this);
        playerMove.registerObserver(this);
        this.col = (int) (this.BIGX/gp.currentSize);
        this.row = (int) (this.BIGY/gp.currentSize);
    }

    public void update(){

        playerMove.updatePlayerPosition();

    }

    public void InteractNPC(){
        gp.gameState = gp.dialogueState;

    }
    public void draw(Graphics2D g2d){
        g2d.setColor(Color.red);
        g2d.fillRect(6, 25, this.HP*2, 10);
        g2d.drawImage(this.PlayerImgae, (int)this.x, (int)this.y, (int)gp.currentSize,(int)gp.currentSize,null);
    }

    @Override
    public void updatePlayerPosition(int BIGX, int BIGY, BufferedImage PlayerImage, int PlayerX ,int PlayerY) {
        this.BIGX = BIGX;
        this.BIGY = BIGY;
        this.x = PlayerX;
        this.y = PlayerY;
        this.PlayerImgae = PlayerImage;
        this.col = (int) (this.BIGX/gp.currentSize);
        this.row = (int) (this.BIGY/gp.currentSize);
    }

    public void setName(String name){
        this.Name = name;
    }

    public String getName(){
        return this.Name;
    }

    @Override
    public ArrayList<String> readDialogueFile(int number) {
        return null;
    }

    @Override
    public boolean isInteractable() {
        return false;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getBIGX() {
        return this.BIGX;
    }

    public double getBIGY() {
        return this.BIGY;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public boolean isPressEnter() {
        return this.kc.isPressEnter;
    }

    @Override
    public void OutOfCombatMovement() {

    }
}
