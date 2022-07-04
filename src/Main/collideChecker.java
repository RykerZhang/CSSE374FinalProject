package Main;

import Background.background;
import gameObjects.PlayerMove;
import gameObjects.gameObject;

public class collideChecker {
    gamePanel gp;
    public int objectLeftColumn;
    public int objectRightColumn;
    public int objectUpRow;
    public int objectDownRow;
    public int gameMap[][];
    public background[] backgrounds ;
    public collideChecker(gamePanel gp){
        this.gp = gp;
        this.gameMap = this.gp.bgHandler.gameMap;
        this.backgrounds = this.gp.bgHandler.backgrounds;
    }

    public background readTerrainNumber(int col, int row){
        int terrainNumber = gameMap[col][row];
       // System.out.println(terrainNumber);
        return backgrounds[terrainNumber];
    }

    public void collideTerrain(gameObject go){
         objectLeftColumn = go.BIGX / gp.currentSize;
         objectRightColumn = (go.BIGX+30) / gp.currentSize;
         objectUpRow = go.BIGY/ gp.currentSize;
         objectDownRow = (go.BIGY + 30) / gp.currentSize;
    }

    public void getColAndRow(PlayerMove pm){
        objectLeftColumn = pm.getBIGX() / gp.currentSize;
        objectRightColumn = (pm.getBIGX()+30) / gp.currentSize;
        objectUpRow = pm.getBIGY()/ gp.currentSize;
        objectDownRow = (pm.getBIGY() + 30) / gp.currentSize;
    }

    public void checkUpCollision(PlayerMove pm){
        this.getColAndRow(pm);
        int estimatedY = pm.getBIGY() - pm.getSpeed();
        int estiamtedUpRow = estimatedY / gp.currentSize;
        background b1 =  this.readTerrainNumber(objectLeftColumn, estiamtedUpRow);
        background b2 = this.readTerrainNumber(objectRightColumn, objectDownRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoUpCollide(true);
        }else{
            pm.setDoUpCollide(false);
        }
    }
}
