package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author willi
 */
public class Pelota {

    private int x, y;
    private int dx=1, dy=1;
    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x, y, 20, 20);
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        x+=dx;
        y+=dy;
        if(colisionR1 == true ){
            dx=-dx;
            x=25;
        }
        if (colisionR2 == true) {
            dx=-dx;
            x=750;
        }
        if(x>limites.getMaxX()){
            dx=-dx;
        }
        if (y>limites.getMaxY()-15){
           dy=-dy;
        }
        if (x<-20){
            dx=-dx;
        }
        if (y<0){
            dy=-dy;
        }
    }
}
