
//not to be graphed
/**
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * An object made to represent the camera, which is used when running the graph GUI 
 * to properly determine where everything should be translated
 */
public class camera extends graphable{
    private double angleW;
    private double angleL;

    /**
     * The main constructor for the camera object
     * @param tX The X value for the camera
     * @param tY The Y value for the camera
     * @param tZ The Z value for the camera
     * @param ang1 The angle value for width. 
     * @param ang2 The angle value for length. 
     */
    public camera (double tX, double tY, double tZ, double ang1, double ang2){
        super(tX, tY, tZ);
        angleW = ang1;
        angleL = ang2;
    }
    /**
     * getter method for accessing angleW(pan angle)
     * @return the angleW in camera
     */
    public double getAngleW()
    {
        return angleW;
    }

    /**
     * getter method for accessing angleL(tilt angle)
     * @return the angleL in camera
     */
    public double getAngleL()
    {
        return angleL;
    }

    /**
     * Setter method for width angle.
     * @param newAng The new angle. 
     */
    public void setAngleW (double newAng){
        angleW = newAng;
    }

    /**
     * Setter method for length angle.
     * @param newAng The new angle.
     */
    public void setAngleL (double newAng){
        angleL = newAng;
    }
}
