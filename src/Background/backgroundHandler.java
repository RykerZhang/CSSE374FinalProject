package Background;

import Main.gamePanel;
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
        this.backgrounds[0] = new SlowDown(this.backgrounds[0], 1.0);
        this.backgrounds[1] = new GrassLand();
        this.backgrounds[1] = new SlowDown(this.backgrounds[1], 0.7);
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
                double bigx = bigcolumn * gp.currentSize;
                double bigy = bigrow * gp.currentSize;
                double screenx = bigx - gp.player1.getBIGX()+gp.player1.getX();
                double screeny = bigy - gp.player1.getBIGY()+gp.player1.getY();
                g2d.drawImage(backgrounds[number].getImage(), (int)screenx, (int)screeny, gp.currentSize, gp.currentSize, null);
                bigcolumn++;
            if(bigcolumn == gp.BIGCOL){
                bigcolumn = 0;
                bigrow++;
            }
        }
    }
}
