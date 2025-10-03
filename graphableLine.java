/**
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * An object that represents a line on a 3D plane. It extends graphable and is represented 
 * through a start point and an endpoint.
 */
public class graphableLine extends graphable {
    //treat x, y, and z as start

    private double endX;
    private double endY;
    private double endZ;

    /**
     * Common constructor that represents a 3D line
     * @param tX The start X coordinate
     * @param tY The start Y coordinate
     * @param tZ The start Z coordinate
     * @param eX The ending X coordinate
     * @param eY The ending Y coordinate
     * @param eZ The ending Z coordnate
     */
    public graphableLine (double tX, double tY, double tZ, double eX, double eY, double eZ){
        super(tX, tY, tZ);
        endX = eX;
        endY = eY;
        endZ = eZ;
    }

    /**
     * Secondary constructor when representing a 2D line. Disregards Z axis.
     * @param tX The start X coordinate
     * @param tY The start Y coordinate
     * @param eX The ending X coordinate
     * @param eY The ending Y coordinate
     */
    public graphableLine (double tX, double tY, double eX, double eY){
        super(tX, tY);
        endX = eX;
        endY = eY;
        endZ = 0;
    }

    /**
     * Setter method for the new line
     * @param tX The start X coordinate
     * @param tY The start Y coordinate
     * @param tZ The start Z coordinate
     * @param eX The ending X coordinate
     * @param eY The ending Y coordinate
     * @param eZ The ending Z coordnate
     */
    public void setLine (double tX, double tY, double tZ, double eX, double eY, double eZ){
        setPoint(tX, tY, tZ);
        endX = eX;
        endY = eY;
        endZ = eZ;
    }

    /**
     * Getter method for the ending X point
     * @return The ending X coordinate
     */
    public double getEX (){
        return endX;
    }
    
    /**
     * Getter method for the ending Y point
     * @return The ending Y coordinate
     */
    public double getEY (){
        return endY;
    }
    
    /**
     * Getter method for the ending Z part
     * @return The ending Z coordinate
     */
    public double getEZ (){
        return endZ;
    }
    
    /**
     * Overrides the toString method
     * @return the string in a new format
     */
    public String toString() {
        return getX() + " " + getY() + " " + getZ() + " TO " + 
                getEX() + " " + getEY() + " " + getEZ();
    }
}
