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
    }
}
