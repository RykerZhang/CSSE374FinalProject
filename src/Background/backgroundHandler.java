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
        this.Map = new int[gp.screenRow][gp.screenColumn];
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMap(){
        try {
            File file = new File("./src/Maps/HomeMap.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            int column = 0;
            int row = 0;
            while(column<gp.screenColumn && row<gp.screenRow){
                String currentLine = br.readLine();
                //System.out.println("Current line is " + column + "  " + row + " "+ currentLine);
                String[] splitedCurrentLine = currentLine.split(" ");
                for (int i = column;i<gp.screenColumn;i++){
                    int backgroundNumber = Integer.parseInt(splitedCurrentLine[i]);
                    Map[row][column] = backgroundNumber;
                    column++;
                }
                if(column == gp.screenColumn){
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
        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i<gp.screenRow;i++){
            x=0;
            for(int j = 0;j<gp.screenColumn;j++){
                int number = Map[i][j];
                g2d.drawImage(backgrounds[number].image, x, y, gp.currentSize, gp.currentSize, null);
                x+=30;
            }
            y+=30;
        }
    }
}
