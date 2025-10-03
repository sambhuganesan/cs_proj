import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Queue;
import java.awt.event.*;
import javax.swing.JFrame;
 
/** 
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 * Class that deals with all the GUI portions of our code
 */
public class runGraphGUI extends JFrame implements KeyListener{

    private runGraph rG;
    private final int DOT_SIZE = 8;
    private camera Cam;
    private ArrayList<graphable> baseballPoints;


    /**
     * Constructor for the runGraphGUI class
     * @param c a camera object that is used to create a runGraph object
     * @param baseballDots An array of graphable objects to be plotted
     */
    public runGraphGUI(camera c, ArrayList<graphable> baseballDots) {
        super("3D Representation of Baseball");
        
        baseballPoints = new ArrayList<graphable>();

        for (graphable i : baseballDots){
            baseballPoints.add(i);
        }
        Cam = c;

        rG = new runGraph(Cam, baseballPoints);
        
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(this);  

    }
    
    void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawLine(x1 + getWidth() / 2, y1 + getHeight() / 2,
                     x2 + getWidth() / 2, y2 + getHeight() / 2);
        
    }
    
    void drawDot(Graphics g, int x, int y) {
        Graphics g2d = (Graphics2D) g;

        g2d.setColor(new Color(230, 0, 0));
        g2d.fillOval(x + getWidth() / 2, y + getHeight() / 2, DOT_SIZE, DOT_SIZE);
    }

    /**
     * The default paint function that is called 
     *every time the window is shifted, and etc.
     * @param g a graphic object
     */
    public void paint(Graphics g) {
        super.paint(g);

        rG = new runGraph(Cam, baseballPoints);

        graphableList a = rG.getGraphList();
        
        Queue<graphableLine> lineList = a.getLineList();
        
        
        Queue<graphable> pointList = a.getPointList();

        for (graphable i : pointList){
            System.out.println("Drawing point at " + i);
            drawDot(g, (int) i.getX(), (int) i.getY());
        }

        for (graphableLine i : lineList){
            System.out.println("Drawing line at " + i.getX() + " " + i.getY() + " TO " +  
                                                    i.getEX() + " " + i.getEY());

            drawLine(g, (int) i.getX(), (int) i.getY(), (int) i.getEX(), (int) i.getEY());

        }


        /*
        if (pointList.size() != 0 || lineList.size() != 0){
            try {
                throw new Exception("something went terribly wrong");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         */

    }
    
    /* 
    public static void main(String[] args) {
        
        runGraphGUI a = new runGraphGUI(r);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new runGraphGUI().setVisible(true);
            }
        });

        

    }
    */

    /**
     * Function that changes camera angles and location
     */
    @Override
    public void keyPressed(KeyEvent e){

        int keyCode = e.getKeyCode();
        if (keyCode == 37){
            rG.getC().setAngleW(rG.getC().getAngleW() + 0.1);
            repaint();
            
        }
        if (keyCode == 39){
            rG.getC().setAngleW(rG.getC().getAngleW() - 0.1);
            repaint();
        }
        
        if (keyCode == 38){
            rG.getC().setAngleL(rG.getC().getAngleL() - 0.1);
            repaint();
            
        }
        if (keyCode == 40){
            rG.getC().setAngleL(rG.getC().getAngleL() + 0.1);
            repaint();
        }


        if (keyCode == 87){
            rG.getC().setPoint(rG.getC().getX(), rG.getC().getY() - 0.2, rG.getC().getZ());
            repaint();
        }

        if (keyCode == 83){
            rG.getC().setPoint(rG.getC().getX(), rG.getC().getY() + 0.2, rG.getC().getZ());
            repaint();
        }

        if (keyCode == 65){
            rG.getC().setPoint(rG.getC().getX() + 0.2, rG.getC().getY(), rG.getC().getZ());
            repaint();
        }

        if (keyCode == 68){
            rG.getC().setPoint(rG.getC().getX() - 0.2, rG.getC().getY(), rG.getC().getZ());
            repaint();
        }

        if (keyCode == 69){
            rG.getC().setPoint(rG.getC().getX(), rG.getC().getY(), rG.getC().getZ() + 0.2);
            repaint();
        }

        if (keyCode == 81){
            rG.getC().setPoint(rG.getC().getX(), rG.getC().getY(), rG.getC().getZ() - 0.2);
            repaint();
        }


        System.out.println(rG.getC().getAngleW());
        System.out.println(rG.getC().getAngleL());
        System.out.println(rG.getC().getX());
        System.out.println(rG.getC().getY());
        System.out.println(rG.getC().getZ());

    
    }

    /**
     * Empty method for keyListener interface
     */
    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    /**
     * Empty method for keyListener interface
     */
    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }


}