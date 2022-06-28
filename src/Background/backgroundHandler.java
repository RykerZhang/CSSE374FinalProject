package Background;

import Main.gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class backgroundHandler {
    private gamePanel gp;
    private background [] backgrounds;
    private int Map[][];

    public backgroundHandler(gamePanel gp){
        this.gp = gp;
        this.backgrounds = new background[5];
        this.Map = new int[gp.BIGCOL][gp.BIGROW];
        this.getBackgroundImage();
        this.readMap();
    }

    public void getBackgroundImage(){
        try {
            //image 0 is land
            backgrounds[0] = new background();
            backgrounds[0].image = ImageIO.read(new FileInputStream("./src/Pictures/Background/land1.png"));
            //image 1 is grassland
            backgrounds[1] = new background();
            backgrounds[1].image = ImageIO.read(new FileInputStream("./src/Pictures/Background/grass1.png"));
            //image 2 is waterland
            backgrounds[2] = new background();
            backgrounds[2].image = ImageIO.read(new FileInputStream("./src/Pictures/Background/water1.png"));
            //iamge 3 is wall
            backgrounds[3] = new background();
            backgrounds[3].image = ImageIO.read(new FileInputStream("./src/Pictures/Background/wall1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    Map[column][row] = number;
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
            //System.out.println(bigcolumn + " "+ bigrow);
                int number = Map[bigcolumn][bigrow];
                int bigx = bigcolumn * gp.currentSize;
                int bigy = bigrow * gp.currentSize;
                int screenx = bigx - gp.player1.getBIGX()+gp.player1.getX();
                int screeny = bigy - gp.player1.getBIGY()+gp.player1.getY();
                //System.out.println(screenx + " " + screeny);
                g2d.drawImage(backgrounds[number].image, screenx, screeny, gp.currentSize, gp.currentSize, null);
                bigcolumn++;
            if(bigcolumn == gp.BIGCOL){
                bigcolumn = 0;
                bigrow++;
            }
        }
    }
}
