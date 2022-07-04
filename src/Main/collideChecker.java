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
    public int objectLeftBigX;
    public int objectUpBigY;
    public int objectDownBigY;
    public int objectRightBigX;
    public int gameMap[][];
    public background[] backgrounds ;
    public collideChecker(gamePanel gp){
        this.gp = gp;
        this.gameMap = this.gp.bgHandler.gameMap;
        this.backgrounds = this.gp.bgHandler.backgrounds;
    }

    public background readTerrainNumber(int col, int row){
        int terrainNumber = gameMap[col][row];
        return backgrounds[terrainNumber];
    }

    public void collideTerrain(gameObject go){
         objectLeftColumn = go.BIGX / gp.currentSize;
         objectRightColumn = (go.BIGX+30) / gp.currentSize;
         objectUpRow = go.BIGY/ gp.currentSize;
         objectDownRow = (go.BIGY + 30) / gp.currentSize;
    }

    public void getColAndRow(PlayerMove pm){
        objectUpBigY = pm.getBIGY()+ pm.getCollideArea().y;
        objectLeftBigX = pm.getBIGX() + pm.getCollideArea().x;
        objectRightBigX = objectLeftBigX + pm.getCollideArea().width;
        objectDownBigY = objectUpBigY + pm.getCollideArea().height;
        objectLeftColumn = objectLeftBigX / gp.currentSize;
        objectRightColumn = objectRightBigX / gp.currentSize;
        objectUpRow = objectUpBigY/ gp.currentSize;
        objectDownRow =objectDownBigY / gp.currentSize;
    }

    public void checkUpCollision(PlayerMove pm){
        this.getColAndRow(pm);
        int estimatedY = objectUpBigY - pm.getSpeed();
        int estiamtedUpRow = estimatedY / gp.currentSize;
        background b1 =  this.readTerrainNumber(objectLeftColumn, estiamtedUpRow);
        background b2 = this.readTerrainNumber(objectRightColumn, estiamtedUpRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoUpCollide(true);
        }else{
            pm.setDoUpCollide(false);
        }
    }

    public void checkLeftCollision(PlayerMove pm){
        this.getColAndRow(pm);
        int estimatedX = objectLeftBigX- pm.getSpeed();
        int estiamtedLeftColumn = estimatedX / gp.currentSize;
        background b1 =  this.readTerrainNumber(estiamtedLeftColumn, objectUpRow);
        background b2 = this.readTerrainNumber(estiamtedLeftColumn, objectDownRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoLeftCollide(true);
        }else{
            pm.setDoLeftCollide(false);
        }
    }

    public void checkDownCollision(PlayerMove pm){
        this.getColAndRow(pm);
        int estimatedY = objectDownBigY + pm.getSpeed();
        int estiamtedDownRow =estimatedY/ gp.currentSize;
        background b1 =  this.readTerrainNumber(objectLeftColumn, estiamtedDownRow);
        background b2 = this.readTerrainNumber(objectRightColumn, estiamtedDownRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoDownCollide(true);
        }else{
            pm.setDoDownCollide(false);
        }
    }

    public void checkRightCollision(PlayerMove pm){
        this.getColAndRow(pm);
        int estimatedX = objectRightBigX + pm.getSpeed();
        int estiamtedRightColumn = estimatedX / gp.currentSize;
        background b1 =  this.readTerrainNumber(estiamtedRightColumn, objectUpRow);
        background b2 = this.readTerrainNumber(estiamtedRightColumn, objectDownRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoRightCollide(true);
        }else{
            pm.setDoRightCollide(false);
        }
    }
}
