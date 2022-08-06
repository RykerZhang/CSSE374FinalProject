package gameObjects;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import gameObjects.Equipment.WoodSword;

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
    public int HP = 100;
    public int attack;
    public int defense;
    public int experience;
    public int level;
    public gameObject currentWeapon;
    public gameObject currentArmor;
    public int money;
    public boolean doAttack;



    public Player(keyControl kc, gamePanel gp){
        this.isPlayer = false;
        this.x = 100;
        this.y = 100;
        this.kc = kc;
        this.gp = gp;
        playerMove = new PlayerMove(kc, gp, this, this);
        playerMove.registerObserver(this);
        this.col = (int) (this.BIGX/gp.currentSize);
        this.row = (int) (this.BIGY/gp.currentSize);
        this.attack = 0;
        this.defense = 0;
        this.currentArmor = null;
        this.currentWeapon = new WoodSword(this.gp);
        this.experience = 0;
        this.level = 1;
        this.money = 0;
        this.doAttack = this.playerMove.doAttack;

    }

    public void update(){
        playerMove.updateHP();
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

    @Override
    public void updatePlayerHP(int currentHP) {
        this.HP = currentHP;
        if(this.HP<=0){
            this.gp.gameState = this.gp.deathState;
        }
    }

    @Override
    public void updateAttackStatus(boolean doAttack) {
        this.doAttack = doAttack;
       // System.out.println(this.doAttack);
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

    public int getHP() {
        return this.HP;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getLevel() {
        return this.level;
    }

    public gameObject getCurrentWeapon() {
        return this.currentWeapon;
    }

    public gameObject getCurrentArmor() {
        return this.currentArmor;
    }

    public int getMoney() {
        return money;
    }

    public boolean isDoAttack() {
        return this.doAttack;
    }

    @Override
    public void getHurt(int attack) {

    }
}
