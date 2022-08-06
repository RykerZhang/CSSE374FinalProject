package gameObjects;

import Main.gamePanel;
import Main.keyControl;

public class PlayerFactory extends gameObjectFactory {
    gamePanel gp;
    keyControl kc;
    public PlayerFactory(keyControl kc, gamePanel gp){
        this.gp = gp;
        this.kc = kc;
    }
    public Player createPlayer(){
        return new Player(kc, gp);
    }

    @Override
    public gameObject createObject() {
        return new Player(kc, gp);
    }
}
