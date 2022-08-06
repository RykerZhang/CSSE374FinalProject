package ObserversAndSubjects;

import java.awt.image.BufferedImage;

public interface PlayerObserver {
    public void updatePlayerPosition(int BIGX, int BIGY, BufferedImage PlayerImagek, int PlayerX, int PlayerY );
    public void updatePlayerHP(int currentHP);
    public void updateAttackStatus(boolean doAttack);
}
