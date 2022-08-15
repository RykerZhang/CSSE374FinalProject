package Main;

import gameObjects.Player;

import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class gameUI {
    gamePanel gp;
    Font UIFont;
    String currentDialogueSentence = "";
    int sentanceNumber = 0;
    int startMenuChoose = 0;
    public gameUI(gamePanel gp){
        this.gp = gp;
        UIFont=new Font(("ARIAL"),Font.BOLD, 12);
    }

    public void draw(Graphics2D g2d){
        g2d.setFont(UIFont);
        g2d.setColor(Color.BLACK);
        String positionString = "Col: " + gp.player1.getCol() + ", Row: " + gp.player1.getRow();

        g2d.drawString(positionString,5, 15);

        //Dialogue state:
        if(gp.gameState == gp.startState){
            g2d.setFont(g2d.getFont().deriveFont(40F));
            String title = "Yujie Zhang's Game";
            int x =200 ;
            int y = gp.currentSize*3;
            g2d.setColor(Color.white);
            g2d.drawString(title, x,y);
            g2d.setFont(g2d.getFont().deriveFont(20F));

            g2d.setColor(Color.WHITE);
            title = "New Game";
            x = 200;
            y = gp.currentSize*5;
            if(startMenuChoose == 0){
                g2d.setColor(Color.CYAN);
            }
            g2d.drawString(title,x,y);

            g2d.setColor(Color.WHITE);
            title = "Load Game";
            x = 200;
            y += gp.currentSize;
            if(startMenuChoose == 1){
                g2d.setColor(Color.CYAN);

            }
            g2d.drawString(title,x,y);

            g2d.setColor(Color.WHITE);
            title = "Exit";
            x = 200;
            y += gp.currentSize;
            if(startMenuChoose == 2){
                g2d.setColor(Color.CYAN);
            }
            g2d.drawString(title,x,y);
        }

        if(gp.gameState == gp.playingState){

        }
        if(gp.gameState == gp.dialogueState){
            displayDialogue(g2d);
        }
        if(gp.gameState == gp.propertyState){
            displayCharacterProperty(g2d);
        }
        if(gp.gameState == gp.deathState){
            showEnd(g2d);
        }
        if(gp.gameState == gp.winState){
            showWin(g2d);
            //System.out.println("WinWINWIN");
        }
    }

    public void showWin(Graphics2D g2d){
        int x = gp.currentSize*3;
        int y = gp.currentSize*2;
        int width = gp.currentSize*20;
        int height = gp.currentSize*10;
        this.drawWindowInside(g2d, x, y, width, height);
        x+=160;
        y+=60;
        g2d.setColor(Color.yellow);
        Font propertyFont = new Font("Arial", Font.BOLD, 54);
        g2d.setFont(propertyFont);
        g2d.drawString("You WIN ", x, y);
        Font propertyFont2 = new Font("Arial", Font.BOLD, 24);
        g2d.setFont(propertyFont2);
        y+=50;
        x+=20;
        //g2d.drawString("Press Enter to Exit", x, y);
    }

    public void showEnd(Graphics2D g2d){
        int x = gp.currentSize*3;
        int y = gp.currentSize*2;
        int width = gp.currentSize*20;
        int height = gp.currentSize*10;
        this.drawWindowInside(g2d, x, y, width, height);
        x+=160;
        y+=60;
        g2d.setColor(Color.red);
        Font propertyFont = new Font("Arial", Font.BOLD, 54);
        g2d.setFont(propertyFont);
        g2d.drawString("You Died ", x, y);

        Font propertyFont2 = new Font("Arial", Font.BOLD, 24);
        g2d.setFont(propertyFont2);

    }
    public void displayCharacterProperty(Graphics2D g2d){
        int x = gp.currentSize*2;
        int y = gp.currentSize;
        int width = gp.currentSize*20;
        int height = gp.currentSize*12;
        this.drawWindowInside(g2d, x, y, width, height);
        //show property
        g2d.setColor(Color.white);
        int lineInterval = 30;
        x+=10;
        y+=lineInterval;
        Font propertyFont = new Font("Arial", Font.BOLD, 14);
        g2d.setFont(propertyFont);
        g2d.drawString("Enemy Killed: ", x, y);
        String enemyKilled = String.valueOf(this.gp.player1.getEnemyKilled());
        g2d.drawString(enemyKilled, x+this.getStringDisplayedLength("Enemy Killed ", g2d)+5,y );
        y+=lineInterval;
        g2d.drawString("Level: ", x, y);
        String level = String.valueOf(this.gp.player1.getLevel());
        g2d.drawString(level, x+this.getStringDisplayedLength("Level ", g2d)+5,y );
        y+=lineInterval;
        g2d.drawString("HP: ", x, y);
        String HP = String.valueOf(this.gp.player1.getHP());
        g2d.drawString(HP, x+this.getStringDisplayedLength("HP ", g2d)+5,y );
        y+=lineInterval;
        g2d.drawString("Attack: ", x, y);
        String attack = String.valueOf(this.gp.player1.getAttack());
        g2d.drawString(attack, x+this.getStringDisplayedLength("Attack ", g2d)+5,y );
        y+=lineInterval;
        g2d.drawString("Defense: ", x, y);
        String defense = String.valueOf(this.gp.player1.getDefense());
        g2d.drawString(defense, x+this.getStringDisplayedLength("Defense ", g2d)+5,y );
        y+=lineInterval;
        g2d.drawString("Exp: ", x, y);
        String Exp = String.valueOf(this.gp.player1.getExperience());
        g2d.drawString(Exp, x+this.getStringDisplayedLength("Exp ", g2d)+5,y );
        y+=lineInterval-10;
        g2d.drawString("Current Weapon: ", x, y);
        if(this.gp.player1.getCurrentWeapon()!=null){
            String currentWeapon = String.valueOf(this.gp.player1.getCurrentWeapon().getName());
            g2d.drawImage(this.gp.player1.getCurrentWeapon().ObjectImage, x+this.getStringDisplayedLength("Current Weapon ", g2d)+5,y, null);
        }else{
            g2d.drawString("No Weapon", x+this.getStringDisplayedLength("Current Weapon ", g2d)+5,y );
        }
        y+=lineInterval;
        g2d.drawString("Current Armor: ", x, y);
        if(this.gp.player1.getCurrentArmor() != null){
            g2d.drawImage(this.gp.player1.getCurrentArmor().ObjectImage, x+this.getStringDisplayedLength("Current Armor ", g2d)+5,y, null);
        }else{
            g2d.drawString("No Armor", x+this.getStringDisplayedLength("Current Armor ", g2d)+5,y );
        }

    }

    public void drawWindowInside(Graphics2D g2d, int x, int y, int width, int height){
        g2d.setColor( new Color(0,0,0,100));
        g2d.fillRoundRect(x,y,width,height,40,40);
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(x+1, y+3, width, height-6, 30,30);
    }
    public void displayDialogue(Graphics2D g2d){
        int height = (int) (gp.screenHeight/3);
        int width = (int) (gp.screenWidth - 50);
        int x = 720-width-25;
        int y = 320 -height/3;
        Color dialogueColor = Color.BLACK;
        g2d.setColor(dialogueColor);
        g2d.fillRoundRect(x,y,width,height,40,40);
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(x+1, y+3, width, height-6, 30,30);
        ArrayList<String> dialogueList = this.gp.player1.getInteractingObject().readDialogueFile(this.gp.initialHelperAndPlayer);
        this.displayLines(dialogueList, g2d, sentanceNumber);
    }

    public void displayLines(ArrayList<String> dialogueList, Graphics2D g2d, int sentanceNumber){
        if(sentanceNumber<dialogueList.size()) {
            this.currentDialogueSentence = dialogueList.get(sentanceNumber);
            int x = 720 - (int) (gp.screenWidth - 50) - 25 + gp.currentSize;
            int y = 320 - (int) (gp.screenHeight / 3) / 3 + gp.currentSize;
            if (this.gp.gameState == this.gp.dialogueState) {
                for (String str : currentDialogueSentence.split("\n")) {
                    g2d.drawString(str, x, y);
                    y += 40;
                }
            }
        }else{
            this.gp.gameState = this.gp.playingState;
            this.sentanceNumber = 0;
            //System.out.println(this.gp.gameState);
            g2d.clearRect(0,0,0,0);
        }
    }
    public void continueDialogue(){
        this.sentanceNumber++;
    }
    public int getStringDisplayedLength(String string, Graphics2D g2d){
        int width = g2d.getFontMetrics().stringWidth(string);
        return width;
    }
}
