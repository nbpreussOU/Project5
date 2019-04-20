import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame
{
    private JPanel leftSide;
    private JPanel rightSide;
    private JFrame jf;

    /*
     * constructor for the window to be displayed
     */
    public Window()
    {
        //initialize JFrame and JPanels, add layout managers
        jf = new JFrame("Hamming Distance");
        jf.setSize(800,800);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        
        //create a leftSide and rightSide JPanel
        leftSide = LeftSide.addLeftSide();
        rightSide = RightSide.addRightSide();
        
        //adds jpanels to the jframe
        jf.add(leftSide, BorderLayout.WEST);
        jf.add(rightSide, BorderLayout.EAST);
        
        //sets the JFrame to be visible
        jf.setVisible(true);   
    }
    
    /**
     * main method of the project, displays a window
     */
    public static void main(String[] args)
    {
        //makes a list of all the stations and displays them
        AllStations allStations = new AllStations();
        Window window = new Window();
    } 
    
}
