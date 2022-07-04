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
    public double objectLeftBigX;
    public double objectUpBigY;
    public double objectDownBigY;
    public double objectRightBigX;
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
         objectLeftColumn = (int) (go.BIGX / gp.currentSize);
         objectRightColumn = (int) ((go.BIGX+30) / gp.currentSize);
         objectUpRow = (int) (go.BIGY/ gp.currentSize);
         objectDownRow = (int) ((go.BIGY + 30) / gp.currentSize);
    }

    public void getColAndRow(PlayerMove pm){
        objectUpBigY = pm.getBIGY()+ pm.getCollideArea().y;
        objectLeftBigX = pm.getBIGX() + pm.getCollideArea().x;
        objectRightBigX = objectLeftBigX + pm.getCollideArea().width;
        objectDownBigY = objectUpBigY + pm.getCollideArea().height;
        objectLeftColumn = (int) (objectLeftBigX / gp.currentSize);
        objectRightColumn = (int) (objectRightBigX / gp.currentSize);
        objectUpRow = (int) (objectUpBigY/ gp.currentSize);
        objectDownRow = (int) (objectDownBigY / gp.currentSize);
    }

    public void checkUpCollision(PlayerMove pm){
        this.getColAndRow(pm);
        double estimatedY = objectUpBigY - pm.getSpeed();
        int estiamtedUpRow = (int) (estimatedY / gp.currentSize);
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
        double estimatedX = objectLeftBigX- pm.getSpeed();
        int estiamtedLeftColumn = (int) (estimatedX / gp.currentSize);
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
        double estimatedY = objectDownBigY + pm.getSpeed();
        int estiamtedDownRow = (int) (estimatedY/ gp.currentSize);
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
        double estimatedX = objectRightBigX + pm.getSpeed();
        int estiamtedRightColumn = (int) (estimatedX / gp.currentSize);
        background b1 = this.readTerrainNumber(estiamtedRightColumn, objectUpRow);
        background b2 = this.readTerrainNumber(estiamtedRightColumn, objectDownRow);
        if(b1.isCollide() == true||b2.isCollide() == true){
            pm.setDoRightCollide(true);
        }else{
            pm.setDoRightCollide(false);
        }
    }

    public void checkSpeed(PlayerMove pm) {
        this.getColAndRow(pm);
        background b1 = this.readTerrainNumber(objectLeftColumn, objectUpRow);
        double sp1 = b1.getSpeedPercentage();
        pm.setSpeed(sp1 * 4);
      //  System.out.println(pm.getSpeed());
    }
}
