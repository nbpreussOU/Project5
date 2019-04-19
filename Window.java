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
    private JPanel sliderToStation;
    private JPanel compareWithHD;
    private JPanel distancePanel0;
    private JPanel distancePanel1;
    private JPanel distancePanel2;
    private JPanel distancePanel3;
    private JPanel distancePanel4;
    private JPanel distanceButtonPanel;
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
    private JTextArea distance0Text;
    private JTextArea distance1Text;
    private JTextArea distance2Text;
    private JTextArea distance3Text;
    private JTextArea distance4Text;
    private JTextArea distanceButtonText;
    private JTextArea addStationText;
    
    private JSlider hammingdist;
    
    private static JComboBox stationList;
    
    public Window()
    {
        //TODO: resize all buttons
        //initialize JFrame and JPanels, add layout managers
        jf = new JFrame("Hamming Distance");
        jf.setSize(400,800);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        
        leftSide = new JPanel();
        leftSide.setLayout(new BoxLayout(leftSide.getRootPane(), BoxLayout.PAGE_AXIS));
        rightSide = new JPanel(new BorderLayout());
        hammingDistance = new JPanel();
        sliderToStation = new JPanel(new BorderLayout());
        compareWithHD = new JPanel(new BorderLayout());
        distancePanel0 = new JPanel(new BorderLayout());
        distancePanel1 = new JPanel(new BorderLayout());
        distancePanel2 = new JPanel(new BorderLayout());
        distancePanel3 = new JPanel(new BorderLayout());
        distancePanel4 = new JPanel(new BorderLayout());
        distanceButtonPanel = new JPanel(new BorderLayout());
        
        //adds the top JLabel and textare to the left Jpanel     
        enterHammingDistance = new JLabel("Enter Hamming Distance:");
        //TODO: Get this to update based on the slider
        hammingDistText = addTextArea(1, 20, false, "2");
        hammingDistance.add(enterHammingDistance);
        hammingDistance.add(hammingDistText);
        
        //adds the slider to the left side frame
        hammingdist = addSlider(1, 4, true, true);
        sliderToStation.add(hammingdist, BorderLayout.NORTH);
        
        //creates the show station button and adds it to the jpanel
        showStation = new JButton("Show Station");
        sliderToStation.add(showStation, BorderLayout.CENTER);
        
        //creates a text area to enter a mesonet station
        showStationText = addTextArea(10, 30, true, "");
        sliderToStation.add(showStationText, BorderLayout.SOUTH);
        
        //creates the JLabel and dropdown menu
        compareWith = new JLabel("Compare With:");
        //FIXME
        String[] as = new String[] {"as", "df"};
        stationList = new JComboBox<String>(as);
        calculateHD = new JButton("Calculate HD");
        compareWithHD.add(compareWith, BorderLayout.WEST);
        compareWithHD.add(stationList, BorderLayout.EAST);
        compareWithHD.add(calculateHD, BorderLayout.SOUTH);
        
        //add jlabels and button to the leftside distances jpanel
        distance0 = new JLabel("Distance 0");
        distance1 = new JLabel("Distance 1");
        distance2 = new JLabel("Distance 2");
        distance3 = new JLabel("Distance 3");
        distance4 = new JLabel("Distance 4");
        addStation = new JButton("Add Station");
        
        
        
        //add sub Jpanels to leftside jpanel
        leftSide.add(hammingDistance);
        leftSide.add(sliderToStation);
        leftSide.add(compareWithHD);
        leftSide.add(distancePanel0);
        leftSide.add(distancePanel1);
        leftSide.add(distancePanel2);
        leftSide.add(distancePanel3);
        leftSide.add(distancePanel4);
        leftSide.add(distanceButtonPanel);
        
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
    
    public JSlider addSlider(int min, int max, boolean ticks, boolean labels)
    {
        JSlider js = new JSlider(JSlider.HORIZONTAL);
        js.setMinimum(min);
        js.setMaximum(max);
        js.setPaintTicks(ticks);
        js.setPaintLabels(labels);
        js.setPaintTrack(ticks);
        js.setMajorTickSpacing(1);
        return js;
    }
}
