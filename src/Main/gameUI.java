package Main;

import java.awt.*;
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
            System.out.println(this.gp.gameState);
            g2d.clearRect(0,0,0,0);
        }
    }
    public void continueDialogue(){
        this.sentanceNumber++;
    }

}
