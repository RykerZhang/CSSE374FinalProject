package gameObjects.InteractableObjects;

import Main.gamePanel;
import java.awt.*;
import java.util.ArrayList;

public class Placement {
    private gamePanel gp;
    private static Placement uniqueInstance;
    private ArrayList<Integer> chestXList = new ArrayList<>(); private ArrayList<Integer> chestYList = new ArrayList<>();
    private ArrayList<Chest> chestList = new ArrayList<>();

    private Placement(gamePanel gp){
        this.gp = gp;
        this.addChest();
    }

    public static Placement getInstance(gamePanel gp) {
        if (uniqueInstance == null) {
            uniqueInstance = new Placement(gp);
        }
        return uniqueInstance;
    }

    public void placeObjects(Graphics2D g2d){
        for(Chest thechest : chestList){
            thechest.draw(g2d);
        }
    }
    private void addChest(){
        chestXList.add(13); chestYList.add(9);
        chestXList.add(14); chestYList.add(9);
        int count = 0;
        for (int i = 0;i<chestXList.size();i++) {
            double col = chestXList.get(i);
            double row = chestYList.get(i);
            double BIGX = col*gp.currentSize;
            double BIGY = row*gp.currentSize ;
            String chestName = "Chest" + count;
            Chest createdChest = new Chest(chestName, this.gp, BIGX, BIGY);
            chestList.add(createdChest);
        }
    }





}
