import ObserversAndSubjects.PlayerObserver;
import ObserversAndSubjects.PlayerSubject;

import java.util.ArrayList;

public class Player implements PlayerSubject{
    private int x;
    private int y;
    private int speed;
    private ArrayList<PlayerObserver> playerObservers;
    private keyControl kc;
    private gamePanel gp;

    public Player(keyControl kc, gamePanel gp){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.kc = kc;
        this.gp = gp;
        playerObservers = new ArrayList<>();
    }

    public void updatePlayerPosition(){
        if(kc.isPressRight){
            x += speed;
        }
        if(kc.isPressUp){
            y -= speed;
        }
        if(kc.isPressDown){
            y += speed;
        }
        if(kc.isPressLeft){
            x -= speed;
        }
        this.notifyObservers();
    }

    @Override
    public void registerObserver(PlayerObserver o) {
        playerObservers.add(o);
    }

    @Override
    public void removeObserver(PlayerObserver o) {
        playerObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (PlayerObserver o: playerObservers){
            o.updatePlayerPosition(this.x, this.y);
        }
    }
}
