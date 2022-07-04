package Background;

import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class backgroundHandler {
    private gamePanel gp;
    public background [] backgrounds;
    public int gameMap[][];

    public backgroundHandler(gamePanel gp){
        this.gp = gp;
        this.backgrounds = new background[5];
        this.gameMap = new int[gp.BIGCOL][gp.BIGROW];
        this.setBackgrounds();
        this.readMap();
    }

    public void setBackgrounds(){
        this.backgrounds[0] = new Land();
        this.backgrounds[1] = new GrassLand();
        this.backgrounds[2] = new WaterLand();
        this.backgrounds[3] = new Wall();
    }

    public void readMap(){
        try {
            File file = new File("./src/Maps/World.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int column = 0;
            int row = 0;
            while(column<gp.BIGCOL && row<gp.BIGROW){
                String currentLine = br.readLine();
               // System.out.println("Current line is " + column + "  " + row + " "+ currentLine);
                while (column<gp.BIGCOL){
                    String[] splitedCurrentLine = currentLine.split(" ");
                    int number = Integer.parseInt(splitedCurrentLine[column]);
                    gameMap[column][row] = number;
                    column++;

                }
                if(column == gp.BIGCOL){
                    column = 0;
                    row++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2d){
        //g2d.drawImage(backgrounds[0].image, 100,100, 300,300,null);
        int bigcolumn = 0;
        int bigrow = 0;

        while(bigcolumn<gp.BIGCOL&&bigrow<gp.BIGROW){
                int number = gameMap[bigcolumn][bigrow];
                int bigx = bigcolumn * gp.currentSize;
                int bigy = bigrow * gp.currentSize;
                int screenx = bigx - gp.player1.getBIGX()+gp.player1.getX();
                int screeny = bigy - gp.player1.getBIGY()+gp.player1.getY();
                g2d.drawImage(backgrounds[number].getImage(), screenx, screeny, gp.currentSize, gp.currentSize, null);
                bigcolumn++;
            if(bigcolumn == gp.BIGCOL){
                bigcolumn = 0;
                bigrow++;
            }
        }
    }
}
