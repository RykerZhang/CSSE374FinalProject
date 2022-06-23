package ObserversAndSubjects;

import java.awt.image.BufferedImage;

public interface PlayerObserver {
    public void updatePlayerPosition(int PlayerX, int PlayerY, BufferedImage PlayerImage);
}
