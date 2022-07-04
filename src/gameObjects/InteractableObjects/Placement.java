package gameObjects.InteractableObjects;

import Main.gamePanel;

import java.util.HashMap;
import java.util.Map;

public class Placement {
    private gamePanel gp;
    private static Placement uniqueInstance;
    private HashMap<Integer, Integer> chestColToRow = new HashMap<>();

    private Placement(gamePanel gp){
        this.gp = gp;
    }

    public static Placement getInstance(gamePanel gp) {
        if (uniqueInstance == null) {
            //System.out.println("Creating unique instance of Chocolate Boiler");
            uniqueInstance = new Placement(gp);
        }
       // System.out.println("Returning instance of our one and only Chocolate Boiler");
        return uniqueInstance;
    }

    public void placeObjects(){

    }

    private void addChest(){

    }
}
