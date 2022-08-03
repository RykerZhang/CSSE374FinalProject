package gameObjects;

import Main.gamePanel;

import java.awt.*;
import java.util.ArrayList;

public class gameObjectSetter {
    gamePanel gp;
    public ArrayList<gameObject> NPCList = new ArrayList<>();
    public ArrayList<gameObject> EnemyList = new ArrayList<>();

    public gameObjectSetter(gamePanel gp){
        this.gp = gp;
        this.addNPCs();
        this.addEnemies();
    }

    public void setNPCs(Graphics2D g2d){
        for(int i = 0;i<NPCList.size();i++){
            gameObject go = NPCList.get(i);
            double screenx = go.getBIGX() - gp.player1.getBIGX()+gp.player1.getX();
            double screeny = go.getBIGY() - gp.player1.getBIGY()+gp.player1.getY();
            g2d.drawImage(go.ObjectImage, (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
            go.OutOfCombatMovement();
        }

        for(int i = 0;i<EnemyList.size();i++) {
            gameObject go = EnemyList.get(i);
            double screenx = go.getBIGX() - gp.player1.getBIGX() + gp.player1.getX();
            double screeny = go.getBIGY() - gp.player1.getBIGY() + gp.player1.getY();
            g2d.drawImage(go.ObjectImage, (int) screenx, (int) screeny, gp.currentSize, gp.currentSize, null);
            g2d.setColor(Color.red);
            g2d.fillRect((int) screenx, (int) screeny, go.collideArea.width, go.collideArea.height);
            go.OutOfCombatMovement();


            // System.out.println(go.getBIGX());
           // System.out.println(go.getBIGY());
        }
    }

    public void addNPCs(){
        NPC_initialHelper initialHelper = new NPC_initialHelper(gp,"src/Pictures/NPCs/initialHelper1.png", 34, 9, "down");
        this.NPCList.add(initialHelper);
    }

    public void addEnemies(){
        Thief thief1 = new Thief(gp, 33, 26,"right");
        this.EnemyList.add(thief1);
    }




}
