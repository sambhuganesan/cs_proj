import java.util.ArrayList;

/**
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * Stores the X, Y, and Z axis along with all the lines
 * as seen in matplotlib- essentially the base 3d graph function
 */
public class plot {
    

    //can have plot change size based on constructors
    private final double INTERVAL_ = 1;
    private final double DISTANCE_ = 10;

    private int numWide;
    private int numLong;
    private int numTall;

    private ArrayList<graphableLine> axis;

    /**
     * No-args constructor for plot. It sets every value to 10.
     */
    public plot (){
        numWide = 10;
        numLong = 10;
        numTall = 10;
        
        axis = new ArrayList<graphableLine>();

        defineAxisArr();
    }
    
    /**
     * Main constructor for plot, setting each size 
     * of the plot to be a given value
     * @param w The number of X axis lines
     * @param l The number of Y axis lines
     * @param t The number of Z axis lines
     */
    public plot (int w, int l, int t){
        numWide = w;
        numLong = l;
        numTall = t;
        
        axis = new ArrayList<graphableLine>();

        defineAxisArr();
    }
    
    private void defineAxisArr (){
        double temp = 0;
        for (int i = 0; i < numWide + 1; i++){
            axis.add(new graphableLine(temp, 0, 0, temp, DISTANCE_, 0));
            temp += INTERVAL_;
        }


        temp = 0;
        for (int i = 0; i < numLong + 1; i++){
            axis.add(new graphableLine(0, temp, 0, DISTANCE_, temp, 0));
            temp += INTERVAL_;
        }
        
        //z axis

        temp = 0;
        for (int i = 0; i < numWide + 1; i++){
            axis.add(new graphableLine (temp, 0, 0, temp, 0, DISTANCE_));
            temp += INTERVAL_;
        }

        temp = 0;
        for (int i = 0; i < numLong + 1; i++){
            axis.add(new graphableLine (0, temp, 0, 0, temp, DISTANCE_));
            temp += INTERVAL_;
        }

        //sideways z axis things
        temp = 0;
        for (int i = 0; i < numTall + 1; i++){
            axis.add(new graphableLine (0, 0, temp, DISTANCE_, 0, temp));
            temp += INTERVAL_;
        }


        temp = 0;
        for (int i = 0; i < numTall + 1; i++){
            axis.add(new graphableLine(0, 0, temp, 0, DISTANCE_, temp));
            temp += INTERVAL_;
        }
        
        
    }
    
    /**
     * Getter method for all the axis
     * @return The X-Axis
     */
    public ArrayList<graphableLine> getAxis (){
        return axis;
    }

}
