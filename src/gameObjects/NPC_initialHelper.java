package gameObjects;

import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NPC_initialHelper extends gameObject{
    public int col;
    public int row;
    public int BIGX;
    public int BIGY;
    public String name;
    public boolean Interactable = true;
    public ArrayList<String> dialogueFileNameList = new ArrayList<>();
    gamePanel gp;

    public NPC_initialHelper(gamePanel gp, String downURL, int col, int row, String direction){
        this.name = "InitialHelper";
        direction = "down";
        this.gp = gp;
        this.col = col;
        this.row = row;
        this.BIGX = this.col*gp.currentSize;
        this.BIGY = this.row*gp.currentSize;
        //this.Interactable = true;
        this.setImage(downURL);
        this.manuallyAddDialogueFileName();
    }

    public void setImage(String downURL){
        try {
            this.ObjectImage = ImageIO.read(new FileInputStream(downURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> readDialogueFile(int number){
        ArrayList<String> dialogueList = new ArrayList<>();
        String filePath =this.dialogueFileNameList.get(number);
        File dialogueFile = new File(filePath);
        try {
            Scanner scanner = new Scanner((dialogueFile));
            while(scanner.hasNext()){
                dialogueList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dialogueList;
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
        return this.name;
    }

    public boolean isInteractable() {
        return Interactable;
    }

    public void manuallyAddDialogueFileName(){
        this.dialogueFileNameList.add("src/Dialogues/InitialHelper0 ");
    }
}
