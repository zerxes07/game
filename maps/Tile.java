package maps;

import java.awt.image.BufferedImage;

import Data.GameObject;

public class Tile extends GameObject {

    private BufferedImage sprite;
    private boolean solid;
    private boolean overLap;

    //se crea un consturctor vacio para poder crear variables auxiliares
    // que no tengan que recibir parametros y solo sirvan de referencia
    public Tile(){}
    Tile(BufferedImage sprite, int x, int y){
        super( x, y );
        this.sprite = sprite;
        this.solid = false;
    }
    
    public Tile( BufferedImage sprite, int x, int y, boolean solid){
        super( x, y );
        this.sprite = sprite;
        this.solid = solid;
    }

    public boolean isSolid(){ return this.solid; }
    public boolean isOverLapAble(){ return this.overLap; }

    public void setSprite( BufferedImage sprite ){ this.sprite = sprite; }
    public void setSolid( boolean solid){ this.solid = solid; }
    public void setOverLap( boolean overLap ){ this.overLap = overLap ; }
    
    public BufferedImage getSprite(){ return this.sprite; }
}
