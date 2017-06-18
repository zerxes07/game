package entity;

import java.awt.Rectangle;

import Data.SpriteSheet;
import systems.Animator;
import systems.Collider;
import systems.ImageLoader;

public class Player extends Character {
	private SpriteSheet[] sheet;
    private Animator animator;
    private Collider collider;
    private int velocity = 3;
    /*TODO
     * Atributos/funciones del sistema de combate.
     */

    public Player( String name, float life, int x, int y, int w, int h, int ox, int oy ){
        super( name, life, x, y );
        init();
        animator = new Animator( sheet );
        collider = new Collider( x, y , w, h, ox, oy );
    }
    
    public void init(){
        //se usa para inicializar
        sheet = new SpriteSheet[3];
        for (int i = 0; i < sheet.length; i++) {
			sheet[i] = new SpriteSheet(null);
		}      
        //Cargamos las hojas de sprites que utilizara nuestro personaje
        //Esto se puede lograr con cualquier tipo de objeto mediante
        //la clase SpriteSheet e ImageLoader
        setSheet( 0,"/Resources/Sprites/idle.png");
        setSheet( 1,"/Resources/Sprites/walk.png");
        setSheet( 2,"/Resources/Sprites/attack.png");
    }
    
    public void move( String axis ){
        switch( axis ){
            case "up":
                 y -= velocity;
                break;
            case "left":
                 x -= velocity;
                break;
            case "right":
                 x += velocity;
                break;
            case "down":
                 y += velocity;
                break;
            default:
                break;
        }
    }

    public void setVelocity( int velocity ){ this.velocity = velocity; }
    public void setSheet( int i, String path ){ sheet[i] = new SpriteSheet( ImageLoader.loadImage(path) ); }

    public Animator getAnimation(){ return animator; }
    public int getVelocity(){ return this.velocity; }
    public void updateBounds(){ collider.updateBound(x, y); }
    public Rectangle getBounds(){ return collider.getBounds(); }


}
