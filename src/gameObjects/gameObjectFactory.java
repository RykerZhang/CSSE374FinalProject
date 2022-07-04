package gameObjects;

import Main.gamePanel;
import Main.keyControl;

public abstract class gameObjectFactory {
    gamePanel gp;
    keyControl kc;

    public abstract gameObject createObject();
}
