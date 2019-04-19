import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

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
    
    private JTextField hammingDistText;
    private JTextArea showStationText;
    private JTextField distance0Text;
    private JTextField distance1Text;
    private JTextField distance2Text;
    private JTextField distance3Text;
    private JTextField distance4Text;
    private JTextField addStationText;
    
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
        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.PAGE_AXIS));
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
        hammingDistText = (JTextField) addTextArea(1, 20, false, true, "2");
        hammingDistance.add(enterHammingDistance);
        hammingDistance.add(hammingDistText);
        
        //adds the slider to the left side frame
        hammingdist = addSlider(1, 4, true, true);
        sliderToStation.add(hammingdist, BorderLayout.NORTH);
        
        //creates the show station button and adds it to the jpanel
        showStation = new JButton("Show Station");
        sliderToStation.add(showStation, BorderLayout.CENTER);
        
        //creates a text area to enter a mesonet station
        showStationText = (JTextArea) addTextArea(10, 30, true, false, "");
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
        
        //create jlabels, button, and text area
        distance0 = new JLabel("Distance 0");
        distance1 = new JLabel("Distance 1");
        distance2 = new JLabel("Distance 2");
        distance3 = new JLabel("Distance 3");
        distance4 = new JLabel("Distance 4");
        addStation = new JButton("Add Station");
        distance0Text = (JTextField)addTextArea(1, 10, false, true, "1");
        distance1Text = (JTextField)addTextArea(1, 10, false, true, "2");
        distance2Text = (JTextField)addTextArea(1, 10, false, true, "3");
        distance3Text = (JTextField)addTextArea(1, 10, false, true, "4");
        distance4Text = (JTextField)addTextArea(1, 10, false, true, "5");
        addStationText = (JTextField)addTextArea(1, 10, true, true, "");
        
        //add labels, button, and text areas to the Jpanels
        distancePanel0.add(distance0, BorderLayout.WEST);
        distancePanel1.add(distance1, BorderLayout.WEST);
        distancePanel2.add(distance2, BorderLayout.WEST);
        distancePanel3.add(distance3, BorderLayout.WEST);
        distancePanel4.add(distance4, BorderLayout.WEST);
        distanceButtonPanel.add(addStation, BorderLayout.WEST);
        distancePanel0.add(distance0Text, BorderLayout.EAST);
        distancePanel1.add(distance1Text, BorderLayout.EAST);
        distancePanel2.add(distance2Text, BorderLayout.EAST);
        distancePanel3.add(distance3Text, BorderLayout.EAST);
        distancePanel4.add(distance4Text, BorderLayout.EAST);
        distanceButtonPanel.add(addStationText, BorderLayout.EAST);
        
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
    /*
     * @param field true if text field, false if text area
     */
    public Object addTextArea(int row, int column, boolean editable, boolean field, String str)
    {
        //TODO: Properly size all text fields
        if(field)
        {
            JTextField jta = new JTextField(str);
            jta.setEditable(editable);
            return jta;
        }else
        {
            JTextArea jta = new JTextArea(str, row, column);
            jta.setEditable(editable);
            return jta;
        }
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
