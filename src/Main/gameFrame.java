package Main;

import javax.swing.*;
import java.awt.*;

public class gameFrame extends JFrame {

    public gameFrame(String title){
        super();
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setTitle(title);
        gamePanel theGamePanel = new gamePanel();
        this.add(theGamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        theGamePanel.startThread();
    }
}
