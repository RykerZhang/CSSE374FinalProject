package Player;

import Main.gamePanel;
import Main.keyControl;
import ObserversAndSubjects.PlayerObserver;
import ObserversAndSubjects.PlayerSubject;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerMove implements PlayerSubject {
    private int x;
    private int y;
    private int BIGX;
    private int BIGY;
    private int speed;
    private int MoveImageCount = 0;
    private int imageChoose = 1;
    private keyControl kc;
    private ArrayList<PlayerObserver> playerObservers;
    private BufferedImage PlayerImage;
    private BufferedImage playerFront1, playerFront2, playerBack1, playerBack2, playerLeft1, playerLeft2, playerRight1, playerRight2;

    public PlayerMove(keyControl kc, gamePanel gp){
        this.setMoveImage();
        this.PlayerImage = this.getDefaultImage();
        playerObservers = new ArrayList<>();
        this.x = gp.screenWidth/2-gp.currentSize;
        this.y = gp.screenHeight/2-gp.currentSize;
        this.BIGX = gp.currentSize*48/2 - gp.currentSize;
        this.BIGY = gp.currentSize*32/2 - gp.currentSize;
        this.speed = 4;
        this.kc = kc;
    }
    public void updatePlayerPosition(){
        this.switchSameDirectionImage();
        if(kc.isPressRight){
            if(imageChoose == 1){
                this.PlayerImage = playerRight1;
            }else{
                this.PlayerImage = playerRight2;
            }
            BIGX += speed;
        }
        if(kc.isPressUp){
            if(imageChoose == 1){
                this.PlayerImage = playerBack1;
            }else{
                this.PlayerImage = playerBack2;
            }
            BIGY -= speed;
        }
        if(kc.isPressDown){
            if(imageChoose == 1){
                this.PlayerImage = playerFront1;
            }else{
                this.PlayerImage = playerFront2;
            }            BIGY += speed;
        }
        if(kc.isPressLeft) {
            if(imageChoose == 1){
                this.PlayerImage = playerLeft1;
            }else{
                this.PlayerImage = playerLeft2;
            }            BIGX -= speed;
        }
        this.notifyObservers();
    }

    public void setMoveImage(){
        try {
            playerFront1 = ImageIO.read(new FileInputStream("./src/Pictures/Player/playerfront1.png"));
            playerFront2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerfront2.png"));
            playerBack1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerback1.png"));
            playerBack2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerback2.png"));
            playerLeft1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerleft1.png"));
            playerLeft2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerleft2.png"));
            playerRight1 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerright1.png"));
            playerRight2 = ImageIO.read(new FileInputStream("src/Pictures/Player/playerright2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int switchSameDirectionImage(){
        this.MoveImageCount++;
        if(this.MoveImageCount > 15){
            if(this.imageChoose == 1){
                this.imageChoose = 2;
            }else if(this.imageChoose == 2){
                this.imageChoose = 1;
            }
            this.MoveImageCount = 0;
        }
        return this.imageChoose;
    }
    public BufferedImage getDefaultImage(){
        return playerFront1;
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
            o.updatePlayerPosition(this.BIGX, this.BIGY, this.PlayerImage, this.x, this.y);
        }
    }

}
