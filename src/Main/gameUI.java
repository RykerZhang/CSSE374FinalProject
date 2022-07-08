package Main;

import java.awt.*;

public class gameUI {
    gamePanel gp;
    Font UIFont;

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
    }
}
