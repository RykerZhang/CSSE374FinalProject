package Background;

import java.awt.image.BufferedImage;

public class SlowDown extends TerrainEffectDecorator{
    public String name;
    public BufferedImage image;
    public boolean collide = false;
    public double SpeedPercentage = 1;

    public SlowDown(background terrain, double SpeedPercentage){
        this.terrain = terrain;
        this.SpeedPercentage = SpeedPercentage;
        this.name = terrain.getName();
        this.image = terrain.getImage();
        this.collide = terrain.isCollide();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public boolean isCollide() {
        return collide;
    }

    @Override
    public double getSpeedPercentage() {
       return this.SpeedPercentage;
    }
}
