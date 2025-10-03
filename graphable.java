
/**
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * Class that represents a 3d object. 
 */
public class graphable {
    
    
    private double x;
    private double y;
    private double z;
    
    /**
     * Default constructor, setting the points for a 3D representation
     * @param tX The X coordinate
     * @param tY The Y coordinate
     * @param tZ The Z coordinante
     */
    public graphable (double tX, double tY, double tZ){
        x = tX;
        y = tY;
        z = tZ;
    }
    
    /**
     * Secondary constructor that is used when Graphable is represented as a 2d object
     * @param tX The X coordinate
     * @param tY The Y coordinate
     */
    public graphable (double tX, double tY){
        x = tX;
        y = tY;
        z = 0;
    }

    /**
     * Getter method for the X coordinate
     * @return X coordinate
     */
    public double getX (){
        return x;
    }

    /**
     * Getter method for the Y coordinate
     * @return Y coordinate
     */
    public double getY (){
        return y;
    }
    
    /**
     * Getter method for the Z coordinate
     * @return Z coordinate
     */
    public double getZ (){
        return z;
    }

    /**
     * Setting the new point
     * @param nX The new X value.
     * @param nY The new Y value.
     * @param nZ The new Z value.
     */
    public void setPoint (double nX, double nY, double nZ){
        x = nX;
        y = nY;
        z = nZ;
    }

    /**
     * overrides the toString function for debugging
     * @return the string in a new format
     */
    public String toString() {
        return getX() + " " + getY() + " " + getZ();
    }   
}
