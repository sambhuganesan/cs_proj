import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Calculations class that stores a set of 3d coordinates to be plotted in gui
 * @author Justin, Sambhu, Monesh
 * @version 6.2.23
 */
public class calc {

    private final double TIME_BETWEEN_FRAMES_= 0.0041666666;
    //private final double DISTANCE_FIXED = 12;
    //private final double WIDTH_OF_BALL = 2.85;
    //private final double PIXEL_WIDTH_OF_BALL_AT_DISTANCE_FIXED_AWAY = 131.636;
    //private final double focalLength = PIXEL_WIDTH_OF_BALL_AT_DISTANCE_FIXED_AWAY * DISTANCE_FIXED/WIDTH_OF_BALL;
    
    //outputs to coords.txt
    //f, [[x, y, s], [dx, dy, ds]]
    //What I need from Monesh
        //pixelHeight of the ball from the ground at initial pos and 2nd frame pos
        //need pixelWidth1 and pixelWidth2 of the ball in the two different frames
        //x= x0+vxt
        //y=y0+vyt
        //z=z0+vzt+1/2at^2
    
    private ArrayList<graphable> graphablePoints;
    private String[] delta;
    //private ArrayList<String> delta;
    
    /**
     * Main constructor method for calculations. Takes into account the
     * coord.txt file and finds the curve of the ball based off of that.
     */
    public calc (){

        graphablePoints = new ArrayList<graphable>();
        delta = new String[3];
        //delta = new double[];
        
        //third instance of [ in sig_frames

        double t = 0;
        ArrayList<String> values = accessFile();
        int counter1 = 0;
        int counter2 = 0;
        int pos1 = 0;
        int pos2 = 0;
        String s = "";
        
        for (int i = 0; i < values.get(0).length(); i++)
        {
            if (values.get(0).substring(i, i+1).equals("["))
            {
                counter1++;
                if (counter1 == 3)
                {
                    pos1 = i;
                    break;
                }
            }
        }


        for (int i = 0; i < values.get(0).length(); i++)
        {
            if(values.get(0).substring(i, i+1).equals("]"))
            {
                counter2++;
                if(counter2 == 2)
                {
                    pos2 = i;
                    break;
                }    
            }
        }

        s += values.get(0).substring(pos1+1, pos2);

        int counter3 = 0;
        for(int i = 0; i < s.length(); i++)
        {   
            if(s.substring(0, i+1).contains(","))
            {
                delta[counter3] =  s.substring(0, i);
                counter3++;
                s = s.substring(i+2);
                i = 0;
            }

            delta[counter3] = s;
        }
        // System.out.println(values);
        // System.out.println(values.get(0));
        // System.out.println(values.get(0).substring(17, 20));
        double dx = Double.parseDouble(delta[0]);
        System.out.println(dx);
        double dz = Double.parseDouble(delta[1]);
        System.out.println(dz);
        double dy = Double.parseDouble(delta[2]);
        System.out.println(dy);
        
        
        
        double xVelocityInPixels =  dx / TIME_BETWEEN_FRAMES_;
        double zVelocityInPixels =  dz / TIME_BETWEEN_FRAMES_;
        double yVelocityInPixels =  dy / TIME_BETWEEN_FRAMES_;

        double theta = Math.atan(zVelocityInPixels/yVelocityInPixels);
        double xVal = xVelocityInPixels * Math.cos(theta);
        double yVal = yVelocityInPixels * Math.cos(theta);
        double zVal = zVelocityInPixels * Math.sin(theta);
        
        System.out.println(xVelocityInPixels);
        System.out.println(zVelocityInPixels);
        System.out.println(yVelocityInPixels);
        System.out.println(theta);
        System.out.println(xVal);
        System.out.println(yVal);
        System.out.println(zVal);
        
        double maxValAbs = Math.max(Math.max(Math.abs(xVal), 
                                            Math.abs(yVal)), 
                                            Math.abs(zVal));
        double scaleFactor = 10 / maxValAbs;
        //As a function of t - sum on run a forloop or smth

        
        while(t < 20)
        {
            graphable g = new graphable(Math.abs(xVal * t * scaleFactor) + 4, 
                                        Math.abs(yVal * t * scaleFactor) + 4, 
                                        Math.abs((zVal + 0.5 * 9.81 * t * t) * scaleFactor));
            
            graphable a = new graphable(-Math.abs(xVal * t * scaleFactor) + 4, 
                                        -Math.abs(yVal * t * scaleFactor) + 4, 
                                        Math.abs((zVal + 0.5 * 9.81 * t * t) * scaleFactor));


            if (a.getX() > 0 && a.getY() > 0 && a.getZ() > 0){
                graphablePoints.add(a);
            }
            if (g.getX() < 10 && g.getY() < 10 && g.getZ() < 10){
                graphablePoints.add(g);
            }
            

            
            t += 0.5;
        }

    }

    private ArrayList<String> accessFile() {
        ArrayList<String> strArray = new ArrayList<String>();
        
        try {
            File myObj = new File("sig_frames.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                strArray.add(data);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return strArray;
    }
    
    /**
     * Getter method for graphablePoints, which is a list of points
     * that the graph needs to plot to represent the ball's path
     * @return the array of 3d points
     */
    public ArrayList<graphable> getGList (){
        return graphablePoints;
    }

    //creating an object, constructor looks at text file. 

    //then uses calc.getEquations(_____) that outputs an array of type graphable

    //just wanna let u know that the calc.getEquations(y) is an angle and not a set of points

}



