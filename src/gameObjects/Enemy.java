package gameObjects;

import Main.gamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends gameObject{
    public boolean inFight;
    public int MoveImageCount = 0;
    public int imageChoose = 1;
    public BufferedImage EnemyImageUp1;
    public BufferedImage EnemyImageUp2;
    public BufferedImage EnemyImageDown1;
    public BufferedImage EnemyImageDown2;
    public BufferedImage EnemyImageLeft1;
    public BufferedImage EnemyImageLeft2;
    public BufferedImage EnemyImageRight1;
    public BufferedImage EnemyImageRight2;
    public boolean doUpCollide;
    public boolean doLeftCollide;
    public boolean doRightCollide;
    public boolean doDownCollide;
    public boolean doUpObjectCollide;
    public boolean doLeftObjectCollide;
    public boolean doRightObjectCollide;
    private boolean doDownObjectCollide;
    public String direction;
    public String name;
    public int speed;
    public int maxLife;
    public int currentLife;
    public int actionTimeCounter = 0;
    public int col;
    public int row;
    public int BIGX;
    public int BIGY;
    public gamePanel gp;

    public Enemy(gamePanel gp, int col, int row, String direction){
        this.setEightImage();
        this.inFight = false;
        this.gp = gp;
        this.col = col;
        this.row = row;
        this.BIGX = this.col*gp.currentSize;
        this.BIGY = this.row*gp.currentSize;
        this.hurtWhenCollide = true;
        this.HP = 80;
    }

    public void setEightImage(){

    }

    public void OutOfCombatMovement(){
        if(this.direction == "left"){

        }else if(this.direction == "right"){

        }else if (this.direction == "up"){
            this.setDoLeftCollide(false);
            this.setDoDownCollide(false);;
            this.setDoRightCollide(false);
        }else if(this.direction == "down"){
            this.setDoLeftCollide(false);
            this.setDoRightCollide(false);
            this.setDoUpCollide(false);
        }
        checkCollision();
        actionTimeCounter++;
        this.move();
        if(actionTimeCounter == 60){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i<=25){
                this.direction = "left";
            }
            if(i>25&& i<=50){
                this.direction = "right";

            }
            if(i>50&& i<=75){
                this.direction = "up";
            }
            if(i>75&&i<=100){
                this.direction = "down";
            }
            actionTimeCounter = 0;
        }

    }

    @Override
    public boolean isDoAttack() {
        return false;
    }

    public void move(){
        //System.out.println(this.doDownCollide);
        this.gp.cc.objectCheckCollisionWithPlayer(this.gp.player1, this);
        this.switchSameDirectionImage();
        if(direction == "down"){

            if(imageChoose == 1){
                this.ObjectImage = EnemyImageDown1;
            }else{
                this.ObjectImage = EnemyImageDown2;
            }
            if(this.isDoDownCollide() == false &&this.isDoDownObjectCollide()== false ) {
                BIGY += speed;
            }else{
                this.direction = "up";
            }
        }
        if(direction == "up"){

            if(imageChoose == 1){
                this.ObjectImage = EnemyImageUp1;
            }else{
                this.ObjectImage = EnemyImageUp2;
            }
            if(this.isDoUpCollide() == false && this.isDoUpObjectCollide() == false) {
                BIGY -= speed;
            }else{
                this.direction = "down";
            }
        }
        if(direction == "right"){

            if(imageChoose == 1){
                this.ObjectImage = EnemyImageRight1;
            }else{
                this.ObjectImage = EnemyImageRight2;
            }
            if(this.isDoRightCollide() == false && this.isDoRightObjectCollide()==false) {
                BIGX += speed;
            }else{
                this.direction = "left";
            }
        }
        if(direction == "left"){

            if(imageChoose == 1){
                this.ObjectImage = EnemyImageLeft1;
            }else{
                this.ObjectImage = EnemyImageLeft2;
            }
            if(this.isDoLeftCollide() == false && this.isDoLeftObjectCollide()==false) {
                BIGX -= speed;
            }else{
                this.direction = "right";
            }
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

    public void getHurt(int Attack){
        this.HP -= Attack;

    }
    public void checkCollision(){
        this.gp.cc.checkUpCollisionForObject(this);
        this.gp.cc.checkLeftCollisionForObject(this);
        this.gp.cc.checkDownCollisionForObject(this);
        this.gp.cc.checkRightCollisionForObject(this);
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
        return false;
    }

    @Override
    public ArrayList<String> readDialogueFile(int initialHelperAndPlayer) {
        return null;
    }

    @Override
    public boolean isPressEnter() {
        return false;
    }


}
