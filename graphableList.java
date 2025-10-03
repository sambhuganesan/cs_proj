import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * An object that represents a list of both graphable and graphableLine objects
 * To be used as a container and is called during the GUI paint() function
 */
public class graphableList {
    
    //stored not in graphables but in 2ds
    private Queue<graphable> g;
    private Queue<graphableLine> gL;

    /**
     * Main constructor for graphList. Takes two arrays and sets them to the local fields
     * @param g1 The graphable list
     * @param gL1 The graphableLine list
     */
    public graphableList (ArrayList<graphable> g1, ArrayList<graphableLine> gL1){
        g = new LinkedList<graphable>();
        gL = new LinkedList<graphableLine>();

        for (graphable i : g1) {
            g.add(i);
        }

        for (graphableLine j : gL1) {
            gL.add(j);
        }

    }

    /**
     * Getter method for the graphable list
     * @return The graphable list
     */
    public Queue<graphable> getPointList () {
        return g;
    }

    /**
     * Getter method for the graphableLine list
     * @return The graphable line list
     */
    public Queue<graphableLine> getLineList () {
        return gL;
    }
}
