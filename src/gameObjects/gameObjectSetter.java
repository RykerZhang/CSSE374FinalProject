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
        this.addEnemies(33, 26);
    }

    public void setNPCs(Graphics2D g2d){
        for(int i = 0;i<NPCList.size();i++){
            gameObject go = NPCList.get(i);
            //System.out.println("I'm at "+ go.getBIGX());
            double screenx = go.getBIGX() - gp.player1.getBIGX()+gp.player1.getX();
            double screeny = go.getBIGY() - gp.player1.getBIGY()+gp.player1.getY();
            g2d.drawImage(go.ObjectImage, (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
            //go.OutOfCombatMovement();
        }

        for(int i = 0;i<EnemyList.size();i++) {
            gameObject go = EnemyList.get(i);
            double screenx = go.getBIGX() - gp.player1.getBIGX() + gp.player1.getX();
            double screeny = go.getBIGY() - gp.player1.getBIGY() + gp.player1.getY();
            g2d.drawImage(go.ObjectImage, (int) screenx, (int) screeny, gp.currentSize, gp.currentSize, null);
            g2d.setColor(Color.red);
            //g2d.fillRect((int) screenx, (int) screeny, go.collideArea.width, go.collideArea.height);
            go.OutOfCombatMovement();
            g2d.setColor(Color.red);
            g2d.fillRect((int)screenx, (int)screeny - 15, go.HP/4, 5);
            g2d.setColor(Color.gray);
            g2d.fillRect((int) screenx+ go.HP/4, (int)screeny - 15, 25-go.HP/4, 5);
            //System.out.println(go.getHP());
            if(go.getHP()<=0){
                this.EnemyList.remove(go);
                this.gp.player1.enemyKilled++;
                if(this.gp.player1.enemyKilled < 5){
                    this.addEnemies(33+ this.gp.player1.enemyKilled*3, 26+this.gp.player1.enemyKilled*3);
                }else if(this.gp.player1.enemyKilled==5){
                    this.gp.cc.gameMap[55][38] = 1;
                }
            }
        }
    }

    public void addNPCs(){
        NPC_initialHelper initialHelper = new NPC_initialHelper(gp,"src/Pictures/NPCs/initialHelper1.png", 34, 9, "down");
        this.NPCList.add(initialHelper);
        Girl sister = new Girl(gp, "src/Pictures/NPCs/girl_down.png", 56, 38,"down");
        this.NPCList.add(sister);
    }

    public void addEnemies(int col, int row){
        Thief thief1 = new Thief(gp, col, row,"right");
        this.EnemyList.add(thief1);
    }




}
