import java.util.ArrayList;

/**
 * @author Justin
 * @version 6.2.23
 * Main function to be ran. Contains and interlocks everything.
 */
public class main {
    /**
     * Main method where camera object is created and baseballDots are plotted
     * @param args[] an string of arguments
     */
    public static void main (String args[]){
        camera c = new camera (-3.8, 14.2, 5, 
                                14, -6.3);
        calc objs = new calc();
        ArrayList<graphable> baseballDots = objs.getGList(); 
        
        new runGraphGUI(c, baseballDots).setVisible(true);
        
        //arrows are camera angle changes, WASD is camera x/y movement, and EQ is up/down
    }
}
