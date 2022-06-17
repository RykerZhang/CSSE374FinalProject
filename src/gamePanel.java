import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;

public class gamePanel extends JPanel implements Runnable{
    int currentSize = 48;
    int screenColumn = 16;
    int screenRow = 9;
    int screenWidth = screenColumn * currentSize;
    int screenHeight = screenRow * currentSize;

    Thread gameThread;

    public gamePanel(){
        super();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
