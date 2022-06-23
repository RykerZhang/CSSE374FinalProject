package Main;

import Background.backgroundHandler;
import Player.Player;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable{
    public int currentSize = 30;
    public int screenColumn = 24;
    public int screenRow = 16;
    public int screenWidth = screenColumn * currentSize;
    public int screenHeight = screenRow * currentSize;
    private keyControl kc = new keyControl();
    private Thread thread;
    private int FPS = 60;
    Player player1 = new Player( kc, this);
    backgroundHandler bgHandler = new backgroundHandler(this);


    public gamePanel(){
        super();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kc);
        this.setFocusable(true);
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
        bgHandler.draw(g2d);
        player1.draw(g2d);
        g2d.dispose();
    }

    public void update(){
        player1.update();
    }

}
