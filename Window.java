import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class Window extends JFrame
{
    //need a gridbag
    //need a label and text area
    //need a slider
    //need a button
    //need a writable text area
    //need a label and a dropdown menu
    //need a button
    //need 5 labels and 5 text areas
    //need a button and a writable text area
    
    //need methods to add a button, text area, writable text area, labels
    private JPanel leftSide;
    private JPanel rightSide;
    private JPanel hammingDistance;
    private JFrame jf;
    
    private JButton showStation;
    private JButton calculateHD;
    private JButton addStation;
    
    private JLabel enterHammingDistance;
    private JLabel compareWith;
    private JLabel distance0;
    private JLabel distance1;
    private JLabel distance2;
    private JLabel distance3;
    private JLabel distance4;
    
    private JTextArea hammingDistText;
    private JTextArea showStationText;
    private JTextArea addStationText;
    
    private JSlider hammingdist;
    
    private JComboBox stationList;
    
    public Window()
    {
        //initialize JFrame and JPanels, add layout managers
        jf = new JFrame("Hamming Distance");
        jf.setSize(400,800);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        
        leftSide = new JPanel();
        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.PAGE_AXIS));
        rightSide = new JPanel();
        rightSide.setLayout(new BorderLayout());
        hammingDistance = new JPanel();
        
        //adds the top JLabel and textare to the left Jpanel     
        enterHammingDistance = new JLabel("Enter Hamming Distance:");
        //TODO: Get this to update based on the slider
        hammingDistText = addTextArea(1, 20, false, "2");
        hammingDistance.add(enterHammingDistance);
        hammingDistance.add(hammingDistText);
        leftSide.add(hammingDistance);
        
        
        //adds jpanels to the jframe
        jf.add(leftSide, BorderLayout.WEST);
        jf.add(rightSide, BorderLayout.EAST);
        
        //sets the JFrame to be visible
        jf.setVisible(true);

        
        
    }
    
    public static void main(String[] args)
    {
        Window window = new Window();
    }
    
    public JButton addButton(String str)
    {
        JButton jb = new JButton(str);
        //need to add action listeners for each button?
        return jb;
    }
    
    public JTextArea addTextArea(int row, int column, boolean editable, String str)
    {
        JTextArea jta = new JTextArea(str, row, column);
        jta.setEditable(editable);
        return jta;
    }
    
    public JLabel addLabel(String str)
    {
        JLabel jl = new JLabel(str);
        return jl;
    }
}
