package Main;

import Background.background;
import gameObjects.Player;
import gameObjects.PlayerMove;
import gameObjects.gameObject;

import java.awt.*;

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

    public int getGameObjectLeftColumn(gameObject go) {
        double gameObjectLeftBigX = go.getBIGX() + go.getCollideArea().x;
        int gameObjectLeftColumn = (int) (gameObjectLeftBigX / gp.currentSize);
       return gameObjectLeftColumn;
    }

    public int getGameObjectRightColumn(gameObject go){
        double gameObjectRightBigX = go.getBIGX() + go.getCollideArea().x + go.getCollideArea().width;
        int   gameObjectRightColumn = (int) (gameObjectRightBigX / gp.currentSize);
        return gameObjectRightColumn;
    }
    public int getGameObjectUpRow(gameObject go){
        double  gameObjectUpBigY = go.getBIGY() + go.getCollideArea().y;
        int  gameObjectUpRow = (int) (gameObjectUpBigY / gp.currentSize);
        return gameObjectUpRow;
    }

    public int getGameObjectDownRow(gameObject go){
        double  gameObjectDownBigY =  go.getBIGY() + go.getCollideArea().y + go.getCollideArea().height;
        int gameObjectDownRow = (int) (gameObjectDownBigY / gp.currentSize);
        return gameObjectDownRow;

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

    public void checkUpCollisionForObject(gameObject go) {
        int gameObjectUpRow = this.getGameObjectUpRow(go);
        int gameObjectDownRow = this.getGameObjectDownRow(go);
        int gameObjectLeftColumn = this.getGameObjectLeftColumn(go);
        int gameObjectRightColumn = this.getGameObjectRightColumn(go);
        double estimatedY = go.getBIGY() + go.getCollideArea().y - go.getSpeed();
        int estiamtedUpRow = (int) (estimatedY / gp.currentSize);
        background b1 = this.readTerrainNumber(gameObjectLeftColumn, estiamtedUpRow);
        background b2 = this.readTerrainNumber(gameObjectRightColumn, estiamtedUpRow);
       // System.out.println(b1.getName());
        if (b1.isCollide() == true || b2.isCollide() == true) {
            go.setDoUpCollide(true);
        } else {
            go.setDoUpCollide(false);
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

    public void checkLeftCollisionForObject(gameObject go) {
        int gameObjectUpRow = this.getGameObjectUpRow(go);
        int gameObjectDownRow = this.getGameObjectDownRow(go);
        int gameObjectLeftColumn = this.getGameObjectLeftColumn(go);
        int gameObjectRightColumn = this.getGameObjectRightColumn(go);
        double estimatedX = go.getBIGX() + go.getCollideArea().x - go.getSpeed();
        int estiamtedLeftColumn = (int) (estimatedX / gp.currentSize);
        background b1 = this.readTerrainNumber(estiamtedLeftColumn, gameObjectUpRow);
        background b2 = this.readTerrainNumber(estiamtedLeftColumn, gameObjectDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            go.setDoLeftCollide(true);
        } else {
            go.setDoLeftCollide(false);
        }
    }

    public void checkDownCollision(PlayerMove pm) {
        this.getColAndRow(pm);
        double estimatedY = objectDownBigY + pm.getSpeed();
        int estiamtedDownRow = (int) (estimatedY / gp.currentSize);
        //System.out.println(estimatedY);
        background b1 = this.readTerrainNumber(objectLeftColumn, estiamtedDownRow);
        background b2 = this.readTerrainNumber(objectRightColumn, estiamtedDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            pm.setDoDownCollide(true);
        } else {
            pm.setDoDownCollide(false);
        }
    }

    public void checkDownCollisionForObject(gameObject go) {
        int gameObjectUpRow = this.getGameObjectUpRow(go);
        int gameObjectDownRow = this.getGameObjectDownRow(go);
        int gameObjectLeftColumn = this.getGameObjectLeftColumn(go);
        int gameObjectRightColumn = this.getGameObjectRightColumn(go);
        double estimatedY = go.getBIGY() + go.getCollideArea().y + go.getCollideArea().height + go.getSpeed();
        int estiamtedDownRow = (int) (estimatedY / gp.currentSize);
        //System.out.println(estiamtedDownRow);

        background b1 = this.readTerrainNumber(gameObjectLeftColumn, estiamtedDownRow);
        background b2 = this.readTerrainNumber(gameObjectRightColumn, estiamtedDownRow);
        //System.out.println(b1.isCollide());
        if (b1.isCollide() == true || b2.isCollide() == true) {
            go.setDoDownCollide(true);
        } else {
            go.setDoDownCollide(false);
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

    public void checkRightCollisionForObject(gameObject go) {
        int gameObjectUpRow = this.getGameObjectUpRow(go);
        int gameObjectDownRow = this.getGameObjectDownRow(go);
        int gameObjectLeftColumn = this.getGameObjectLeftColumn(go);
        int gameObjectRightColumn = this.getGameObjectRightColumn(go);
        double estimatedX = go.getBIGX() + go.getCollideArea().x + go.getCollideArea().width+ go.getSpeed();
        int estiamtedRightColumn = (int) (estimatedX / gp.currentSize);
        background b1 = this.readTerrainNumber(estiamtedRightColumn, gameObjectUpRow);
        background b2 = this.readTerrainNumber(estiamtedRightColumn, gameObjectDownRow);
        if (b1.isCollide() == true || b2.isCollide() == true) {
            go.setDoRightCollide(true);
        } else {
            go.setDoRightCollide(false);
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
    public gameObject checkObjectCollision(boolean isPlayer, PlayerMove pm) {
        int index = 99;
        //check collision with interactable obejct
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
                        return gp.placement.gameObejctList.get(j).get(i);
                     //   System.out.println("Up Collision");
                    }
                } else if (pm.getDirection() == "right") {
                    pm.collideArea.y -= 1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoRightObjectCollide(true);
                        return gp.placement.gameObejctList.get(j).get(i);
                    }
                } else if (pm.getDirection() == "down") {
                    pm.collideArea.y -= 1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoDownObjectCollide(true);
                        return gp.placement.gameObejctList.get(j).get(i);
                    }
                } else if (pm.getDirection() == "left") {
                    pm.collideArea.y -=1;
                    if (pm.getCollideArea().intersects( gp.placement.gameObejctList.get(j).get(i).collideArea)) {
                        pm.setDoLeftObjectCollide(true);
                        return gp.placement.gameObejctList.get(j).get(i);
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
        //chekc collision with npc
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
                    return gp.goSetter.NPCList.get(j);
                    //   System.out.println("Up Collision");
                }
            } else if (pm.getDirection() == "right") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoRightObjectCollide(true);
                    return gp.goSetter.NPCList.get(j);
                }
            } else if (pm.getDirection() == "down") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoDownObjectCollide(true);
                    return gp.goSetter.NPCList.get(j);
                }
            } else if (pm.getDirection() == "left") {
                pm.collideArea.y -= 1;
                if (pm.getCollideArea().intersects(gp.goSetter.NPCList.get(j).collideArea)) {
                    pm.setDoLeftObjectCollide(true);
                    return gp.goSetter.NPCList.get(j);
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
        //check collision with enemy
//        for (int j = 0; j < gp.goSetter.EnemyList.size(); j++) {
//            pm.collideArea.x += pm.getBIGX();
//            pm.collideArea.y += pm.getBIGY();
//            gp.goSetter.EnemyList.get(j).collideArea.x += gp.goSetter.EnemyList.get(j).getBIGX();
//            gp.goSetter.EnemyList.get(j).collideArea.y += gp.goSetter.EnemyList.get(j).getBIGY();
//            if (pm.getDirection() == "up") {
//                pm.collideArea.y -= 1;
//                //   System.out.println(gp.placement.gameObejctList.get(j).get(i).getName());
//                if (pm.getCollideArea().intersects(gp.goSetter.EnemyList.get(j).collideArea)) {
//                    pm.setDoUpObjectCollide(true);
//                    return gp.goSetter.EnemyList.get(j);
//                    //   System.out.println("Up Collision");
//                }
//            } else if (pm.getDirection() == "right") {
//                pm.collideArea.y -= 1;
//                if (pm.getCollideArea().intersects(gp.goSetter.EnemyList.get(j).collideArea)) {
//                    pm.setDoRightObjectCollide(true);
//                    return gp.goSetter.EnemyList.get(j);
//                }
//            } else if (pm.getDirection() == "down") {
//                pm.collideArea.y -= 1;
//                if (pm.getCollideArea().intersects(gp.goSetter.EnemyList.get(j).collideArea)) {
//                    pm.setDoDownObjectCollide(true);
//                    return gp.goSetter.EnemyList.get(j);
//                }
//            } else if (pm.getDirection() == "left") {
//                pm.collideArea.y -= 1;
//                if (pm.getCollideArea().intersects(gp.goSetter.EnemyList.get(j).collideArea)) {
//                    pm.setDoLeftObjectCollide(true);
//                    return gp.goSetter.EnemyList.get(j);
//                }
//            }
//            pm.collideArea.x = pm.defaultCollideX;
//            pm.collideArea.y = pm.defaultCollideY;
//            gp.goSetter.EnemyList.get(j).collideArea.x = gp.goSetter.EnemyList.get(j).collideAreaX;
//            gp.goSetter.EnemyList.get(j).collideArea.y = gp.goSetter.EnemyList.get(j).collideAreaY;
//            if (pm.isDoUpObjectCollide() || pm.isDoRightObjectCollide() || pm.isDoLeftObjectCollide() || pm.isDoDownObjectCollide()) {
//                break;
//            }
//        }

        //using objectCheckCollisionof Enemy
        for(gameObject go : gp.goSetter.EnemyList) {
            this.objectCheckCollision(pm, go);
            //System.out.println("Right " + pm.isDoRightCollide());
           // System.out.println("Left " + pm.isDoLeftCollide());
            //System.out.println("Up " + pm.isDoUpCollide());
            //System.out.println("Down" + pm.isDoDownCollide());

        }
        return null;
    }

    public void objectCheckCollisionWithPlayer(gameObject go1, gameObject go2){
        int goLBigX1 = (int) (go1.getBIGX()+go1.collideArea.x);
        int goRBigX1 = (int) (go1.getBIGX()+go1.collideArea.x+go1.collideArea.width);
        int goUBigY1 = (int) (go1.getBIGY()+go1.collideArea.y);
        int goDBigY1 = (int) (go1.getBIGY()+go1.collideArea.y+go1.collideArea.height);
        int goLCol1 = goLBigX1 / this.gp.currentSize;
        int goRCol1 = goRBigX1/this.gp.currentSize;
        int goURow1 = goUBigY1/this.gp.currentSize;
        int goDRow1 = goDBigY1/this.gp.currentSize;

        int goLBigX2 = (int) (go2.getBIGX()+go2.collideArea.x);
        int goRBigX2 = (int) (go2.getBIGX()+go2.collideArea.x+go2.collideArea.width);
        int goUBigY2 = (int) (go2.getBIGY()+go2.collideArea.y);
        int goDBigY2 = (int) (go2.getBIGY()+go2.collideArea.y+go2.collideArea.height);
        int goLCol2 = goLBigX2 / this.gp.currentSize;
        int goRCol2 = goRBigX2/this.gp.currentSize;
        int goURow2 = goUBigY2/this.gp.currentSize;
        int goDRow2 = goDBigY2/this.gp.currentSize;

        if((goRCol1 == goLCol2 || goLCol1 == goRCol2)&&(goDRow1 == goURow2 || goURow1 == goDRow2)){
            if(goRCol1 == goLCol2){
                if(go1.getDirection() == "right"){
                    go1.setDoRightObjectCollide(true);
                }else{
                    go1.setDoRightObjectCollide(false);
                }
            }

            if(goLCol1 == goRCol2){
                if(go1.getDirection() == "left"){
                    go1.setDoLeftObjectCollide(true);
                }else{
                    go1.setDoLeftObjectCollide(false);
                }
            }

            if(goDRow1 == goURow2){
                if(go1.getDirection() == "down"){
                    go1.setDoDownObjectCollide(true);
                }else{
                    go1.setDoDownObjectCollide(false);
                }
            }

            if(goURow1 == goDRow2) {
                if (go1.getDirection() == "up") {
                    go1.setDoUpObjectCollide(true);
                } else {
                    go1.setDoUpObjectCollide(false);
                }
            }
        }else {
            go1.setDoUpObjectCollide(false);
            go1.setDoDownObjectCollide(false);
            go1.setDoLeftObjectCollide(false);
            go1.setDoRightObjectCollide(false);
        }
    }

    public void objectCheckCollision(PlayerMove go1, gameObject go2){
        int goLBigX1 = (int) (go1.getBIGX()+go1.collideArea.x);
        int goRBigX1 = (int) (go1.getBIGX()+go1.collideArea.x+go1.collideArea.width);
        int goUBigY1 = (int) (go1.getBIGY()+go1.collideArea.y);
        int goDBigY1 = (int) (go1.getBIGY()+go1.collideArea.y+go1.collideArea.height);
        int goLCol1 = goLBigX1 / this.gp.currentSize;
        int goRCol1 = goRBigX1/this.gp.currentSize;
        int goURow1 = goUBigY1/this.gp.currentSize;
        int goDRow1 = goDBigY1/this.gp.currentSize;

        int goLBigX2 = (int) (go2.getBIGX()+go2.collideArea.x);
        int goRBigX2 = (int) (go2.getBIGX()+go2.collideArea.x+go2.collideArea.width);
        int goUBigY2 = (int) (go2.getBIGY()+go2.collideArea.y);
        int goDBigY2 = (int) (go2.getBIGY()+go2.collideArea.y+go2.collideArea.height);
        int goLCol2 = goLBigX2 / this.gp.currentSize;
        int goRCol2 = goRBigX2/this.gp.currentSize;
        int goURow2 = goUBigY2/this.gp.currentSize;
        int goDRow2 = goDBigY2/this.gp.currentSize;

        if((goRCol1 == goLCol2 || goLCol1 == goRCol2)&&(goDRow1 == goURow2 || goURow1 == goDRow2)){
            if(goRCol1 == goLCol2){
                if(go1.getDirection() == "right"){
                    go1.setDoRightObjectCollide(true);
                    go1.collideObject = go2;
                }else{
                    go1.setDoRightObjectCollide(false);
                }
            }

            if(goLCol1 == goRCol2){
                if(go1.getDirection() == "left"){
                    go1.setDoLeftObjectCollide(true);
                    go1.collideObject = go2;

                }else{
                    go1.setDoLeftObjectCollide(false);
                }
            }

            if(goDRow1 == goURow2){
                if(go1.getDirection() == "down"){
                    go1.setDoDownObjectCollide(true);
                    go1.collideObject = go2;
                    //System.out.println(go1.collideObject.hurtWhenCollide);
                }else{
                    go1.setDoDownObjectCollide(false);
                }
            }

            if(goURow1 == goDRow2) {
                if (go1.getDirection() == "up") {
                    go1.setDoUpObjectCollide(true);
                    go1.collideObject = go2;

                } else {
                    go1.setDoUpObjectCollide(false);
                }
            }
        }else {
            go1.setDoUpObjectCollide(false);
            go1.setDoDownObjectCollide(false);
            go1.setDoLeftObjectCollide(false);
            go1.setDoRightObjectCollide(false);
        }
        go1.updateHP();
    }
}
