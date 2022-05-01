package drawMap;

import com.jhlabs.map.proj.MercatorProjection;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Coordinates {
    int x;
    int y;
    public Vector<Integer> vectorX=new Vector<>();
    public Vector<Integer> vectorY=new Vector<>();
    public Coordinates(){

    }

    /**
     * Changes the longitude and latitude into X and Y coordinates, and stores them
     * @param longitude Float parameter representing the longitude
     * @param latitude Float parameter representing the latitude
     */
    public void addCoordinates(float longitude, float latitude){

        MercatorProjection projection = new MercatorProjection();

        latitude = (float) (latitude * Math.PI / 180);
        longitude = (float) (longitude * Math.PI / 180);

        Point2D.Double d = projection.project(longitude, latitude, new Point2D.Double());
        int magnifiedX = (int) Math.round(( 2+ d.x) * 150);
        int magnifiedY = (int) Math.round(( 2 + d.y) * 150);

        vectorX.add(magnifiedX);
        vectorY.add(magnifiedY);
    }

    /**
     * Stores an X and Y coordinate
     * @param x X coordinate
     * @param y Y coordinate
     */
    public void addXYCoordinates(int x, int y){
        this.x=x;
        this.y=y;
        vectorX.add(x);
        vectorY.add(y);
    }
}
