import ObserversAndSubjects.PlayerObserver;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class gamePanel extends JPanel implements Runnable, PlayerObserver {
    int currentSize = 48;
    int screenColumn = 16;
    int screenRow = 9;
    int screenWidth = screenColumn * currentSize;
    int screenHeight = screenRow * currentSize;
    int PlayerX = 100;
    int PlayerY = 100;
    private keyControl kc = new keyControl();
    private Thread thread;
    private int FPS = 60;
    Player player1 = new Player( kc, this);


    public gamePanel(){
        super();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kc);
        this.setFocusable(true);
        player1.registerObserver(this);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double currentTime = System.nanoTime();
        double timeInterval = 1000000000/this.FPS;
        double nextTime = currentTime + timeInterval;
        while(thread!=null){
            this.update();
            repaint();
            this.setSleep(nextTime);
            nextTime +=timeInterval;
        }
    }

    public void setSleep(double nextTime){
        try {
            double TimeRest = nextTime - System.nanoTime();
            TimeRest = TimeRest/1000000;
            if(TimeRest<0){
                TimeRest = 0;
            }
            Thread.sleep((long) TimeRest);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(this.PlayerX,this.PlayerY,currentSize,currentSize);
        g2d.dispose();
    }

    public void update(){
        player1.updatePlayerPosition();
    }

    @Override
    public void updatePlayerPosition(int x, int y) {
        this.PlayerX = x;
        this.PlayerY = y;
    }
}
