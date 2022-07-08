package gameObjects;

import Main.gamePanel;

import java.awt.*;
import java.util.ArrayList;

public class gameObjectSetter {
    gamePanel gp;
    public ArrayList<gameObject> NPCList = new ArrayList<>();

    public gameObjectSetter(gamePanel gp){
        this.gp = gp;
        this.addNPCs();
    }

    public void setNPCs(Graphics2D g2d){
        for(int i = 0;i<NPCList.size();i++){
            gameObject go = NPCList.get(i);
            double screenx = go.getBIGX() - gp.player1.getBIGX()+gp.player1.getX();
            double screeny = go.getBIGY() - gp.player1.getBIGY()+gp.player1.getY();
            g2d.drawImage(go.NPCimage, (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
            //System.out.println(go.getRow());
           // System.out.println(gp.player1.getX());
          //  System.out.println(go.NPCimage);
        }
    }

    public void addNPCs(){
        NPC_initialHelper initialHelper = new NPC_initialHelper(gp,"src/Pictures/NPCs/initialHelper1.png", 34, 9, "down");
        this.NPCList.add(initialHelper);
    }




}
