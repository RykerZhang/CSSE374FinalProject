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
    public background[] backgrounds;


    public collideChecker(gamePanel gp) {
        this.gp = gp;
        this.gameMap = this.gp.bgHandler.gameMap;
        this.backgrounds = this.gp.bgHandler.backgrounds;
    }

    public background readTerrainNumber(int col, int row) {
        int terrainNumber = gameMap[col][row];
        return backgrounds[terrainNumber];
    }

    public void collideTerrain(gameObject go) {
        objectLeftColumn = (int) (go.BIGX / gp.currentSize);
        objectRightColumn = (int) ((go.BIGX + 30) / gp.currentSize);
        objectUpRow = (int) (go.BIGY / gp.currentSize);
        objectDownRow = (int) ((go.BIGY + 30) / gp.currentSize);
    }

    public void getColAndRow(PlayerMove pm) {
        objectUpBigY = pm.getBIGY() + pm.getCollideArea().y;
        objectLeftBigX = pm.getBIGX() + pm.getCollideArea().x;
        objectRightBigX = objectLeftBigX + pm.getCollideArea().width;
        objectDownBigY = objectUpBigY + pm.getCollideArea().height;
        objectLeftColumn = (int) (objectLeftBigX / gp.currentSize);
        objectRightColumn = (int) (objectRightBigX / gp.currentSize);
        objectUpRow = (int) (objectUpBigY / gp.currentSize);
        objectDownRow = (int) (objectDownBigY / gp.currentSize);
    }

    public void checkUpCollision(PlayerMove pm) {
        this.getColAndRow(pm);
        double estimatedY = objectUpBigY - pm.getSpeed();
        int estiamtedUpRow = (int) (estimatedY / gp.currentSize);
        background b1 = this.readTerrainNumber(objectLeftColumn, estiamtedUpRow);
        background b2 = this.readTerrainNumber(objectRightColumn, estiamtedUpRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            pm.setDoUpCollide(true);
        } else {
            pm.setDoUpCollide(false);
        }
    }

    public void checkLeftCollision(PlayerMove pm) {
        this.getColAndRow(pm);
        double estimatedX = objectLeftBigX - pm.getSpeed();
        int estiamtedLeftColumn = (int) (estimatedX / gp.currentSize);
        background b1 = this.readTerrainNumber(estiamtedLeftColumn, objectUpRow);
        background b2 = this.readTerrainNumber(estiamtedLeftColumn, objectDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            pm.setDoLeftCollide(true);
        } else {
            pm.setDoLeftCollide(false);
        }
    }

    public void checkDownCollision(PlayerMove pm) {
        this.getColAndRow(pm);
        double estimatedY = objectDownBigY + pm.getSpeed();
        int estiamtedDownRow = (int) (estimatedY / gp.currentSize);
        background b1 = this.readTerrainNumber(objectLeftColumn, estiamtedDownRow);
        background b2 = this.readTerrainNumber(objectRightColumn, estiamtedDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            pm.setDoDownCollide(true);
        } else {
            pm.setDoDownCollide(false);
        }
    }

    public void checkRightCollision(PlayerMove pm) {
        this.getColAndRow(pm);
        double estimatedX = objectRightBigX + pm.getSpeed();
        int estiamtedRightColumn = (int) (estimatedX / gp.currentSize);
        background b1 = this.readTerrainNumber(estiamtedRightColumn, objectUpRow);
        background b2 = this.readTerrainNumber(estiamtedRightColumn, objectDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            pm.setDoRightCollide(true);
        } else {
            pm.setDoRightCollide(false);
        }
    }

    public void checkSpeed(PlayerMove pm) {
        this.getColAndRow(pm);
        background b1 = this.readTerrainNumber(objectLeftColumn, objectUpRow);
        double sp1 = b1.getSpeedPercentage();
        pm.setSpeed(sp1 * 4);
    }

//    public int checkObjectCollision(gameObject go, boolean isPlayer, PlayerMove pm) {
//        int index = 999;
//        for (int i = 0; i < gp.placement.getChestList().size(); i++) {
//            go.collideArea.x += go.getBIGX();
//            go.collideArea.y += go.getBIGY();
//            gp.placement.getChestList().get(i).collideArea.x += gp.placement.getChestList().get(i).getBIGX();
//            gp.placement.getChestList().get(i).collideArea.y += gp.placement.getChestList().get(i).getBIGY();
//            if (pm.getDirection() == "up") {
//                go.collideArea.y -= pm.getSpeed();
//                if (pm.getCollideArea().intersects(gp.placement.getChestList().get(i).collideArea)) {
//                    break;
//                }
//            } else if (pm.getDirection() == "right") {
//                go.collideArea.y -= pm.getSpeed();
//                if (pm.getCollideArea().intersects(gp.placement.getChestList().get(i).collideArea)) {
//                    break;
//                }
//            } else if (pm.getDirection() == "down") {
//                go.collideArea.y -= pm.getSpeed();
//                if (pm.getCollideArea().intersects(gp.placement.getChestList().get(i).collideArea)) {
//                   // System.out.println("Down Collision");
//                    break;
//                }
//            } else if (pm.getDirection() == "left") {
//                go.collideArea.y -= pm.getSpeed();
//                if (pm.getCollideArea().intersects(gp.placement.getChestList().get(i).collideArea)) {
//                    //System.out.println("Left Collision");
//                    break;
//                }
//            }
//            pm.collideArea.x = go.collideAreaX;
//            pm.collideArea.y = go.collideAreaY;
//            gp.placement.getChestList().get(i).collideArea.x = gp.placement.getChestList().get(i).collideAreaX;
//            gp.placement.getChestList().get(i).collideArea.y = gp.placement.getChestList().get(i).collideAreaY;
//
//        }
//        return index;
//    }

    //For Player Check
    public int checkObjectCollision(boolean isPlayer, PlayerMove pm) {
        int index = 99;
        for (int j = 0; j < gp.placement.gameObejctList.size(); j++) {
            for (int i = 0; i < gp.placement.gameObejctList.get(j).size(); i++) {
                pm.collideArea.x += pm.getBIGX();
                pm.collideArea.y += pm.getBIGY();
                gp.placement.gameObejctList.get(j).get(i).collideArea.x +=  gp.placement.gameObejctList.get(j).get(i).getBIGX();
                gp.placement.gameObejctList.get(j).get(i).collideArea.y +=  gp.placement.gameObejctList.get(j).get(i).getBIGY();
                if (pm.getDirection() == "up") {
                    pm.collideArea.y -=1;
                 //   System.out.println(gp.placement.gameObejctList.get(j).get(i).getName());
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoUpObjectCollide(true);
                     //   System.out.println("Up Collision");
                        break;
                    }
                } else if (pm.getDirection() == "right") {
                    pm.collideArea.y -= 1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoRightObjectCollide(true);
                        break;
                    }
                } else if (pm.getDirection() == "down") {
                    pm.collideArea.y -= 1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoDownObjectCollide(true);
                        break;
                    }
                } else if (pm.getDirection() == "left") {
                    pm.collideArea.y -=1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoLeftObjectCollide(true);
                        break;
                    }
                }
                pm.collideArea.x = pm.defaultCollideX;
                pm.collideArea.y = pm.defaultCollideY;
                gp.placement.gameObejctList.get(j).get(i).collideArea.x =  gp.placement.gameObejctList.get(j).get(i).collideAreaX;
                gp.placement.gameObejctList.get(j).get(i).collideArea.y =  gp.placement.gameObejctList.get(j).get(i).collideAreaY;
            }
            if(pm.isDoUpObjectCollide()||pm.isDoRightObjectCollide()||pm.isDoLeftObjectCollide()||pm.isDoDownObjectCollide()){
                break;
            }
        }
        for (int j = 0; j < gp.goSetter.NPCList.size(); j++) {
            pm.collideArea.x += pm.getBIGX();
            pm.collideArea.y += pm.getBIGY();
            gp.goSetter.NPCList.get(j).collideArea.x += gp.goSetter.NPCList.get(j).getBIGX();
            gp.goSetter.NPCList.get(j).collideArea.y += gp.goSetter.NPCList.get(j).getBIGY();
            if (pm.getDirection() == "up") {
                pm.collideArea.y -= 1;
                //   System.out.println(gp.placement.gameObejctList.get(j).get(i).getName());
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoUpObjectCollide(true);
                    //   System.out.println("Up Collision");
                    break;
                }
            } else if (pm.getDirection() == "right") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoRightObjectCollide(true);
                    break;
                }
            } else if (pm.getDirection() == "down") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoDownObjectCollide(true);
                    break;
                }
            } else if (pm.getDirection() == "left") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoLeftObjectCollide(true);
                    break;
                }
            }
            pm.collideArea.x = pm.defaultCollideX;
            pm.collideArea.y = pm.defaultCollideY;
            gp.goSetter.NPCList.get(j).collideArea.x = gp.goSetter.NPCList.get(j).collideAreaX;
            gp.goSetter.NPCList.get(j).collideArea.y = gp.goSetter.NPCList.get(j).collideAreaY;
            if (pm.isDoUpObjectCollide() || pm.isDoRightObjectCollide() || pm.isDoLeftObjectCollide() || pm.isDoDownObjectCollide()) {
                break;
            }
        }
        return index;
    }
}
