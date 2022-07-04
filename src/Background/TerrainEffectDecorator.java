package Background;

public abstract class TerrainEffectDecorator extends background{
    public background terrain;
    public double SpeedPercentage;
    public abstract double getSpeedPercentage();

    public String getName(){
        return terrain.name;
    }

}
