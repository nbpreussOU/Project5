import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LeftSide
{
    private static JPanel hammingDistance;
    private static JPanel sliderToStation;
    private static JPanel compareWithHD;
    private static JPanel distancePanel0;
    private static JPanel distancePanel1;
    private static JPanel distancePanel2;
    private static JPanel distancePanel3;
    private static JPanel distancePanel4;
    private static JPanel distanceButtonPanel;
    private static JPanel leftSide;

    private static JButton showStation;
    private static JButton calculateHD;
    private static JButton addStation;

    private static JLabel enterHammingDistance;
    private static JLabel compareWith;
    private static JLabel distance0;
    private static JLabel distance1;
    private static JLabel distance2;
    private static JLabel distance3;
    private static JLabel distance4;

    private static JTextField hammingDistText;
    private static JTextArea showStationText;
    private static JTextField distance0Text;
    private static JTextField distance1Text;
    private static JTextField distance2Text;
    private static JTextField distance3Text;
    private static JTextField distance4Text;
    private static JTextField addStationText;

    protected static JSlider hammingdist;
    private static JScrollPane stationTextPane;
    protected static JComboBox<String> stationList;
    
    /**
     * creates the left JPanel in the image.  this conforms to the specifications in the assignment
     * @return a left side JPanel with all the necessary components added in
     */
    public static JPanel addLeftSide()
    {
        leftSide = new JPanel();
        leftSide.setLayout(new BoxLayout(leftSide, BoxLayout.PAGE_AXIS));
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
        hammingDistText = (JTextField) CreateComponents.addTextArea(1, 20, false, true, "4");
        hammingDistance.add(enterHammingDistance);
        hammingDistance.add(hammingDistText);
        
        //adds the slider to the left side frame
        hammingdist = CreateComponents.addSlider(1, 4, true, true);
        //updates the value of the hammingdistance jtextfield once the slider is moved
        hammingdist.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                //updates the above textfield if there is a change in value
                hammingDistText.setText(Integer.toString(hammingdist.getValue()));
            }
        });
        sliderToStation.add(hammingdist, BorderLayout.NORTH);
        
       //creates a text area in a scroll pane to enter a mesonet station
        showStationText = (JTextArea) CreateComponents.addTextArea(10, 30, true, false, "");
        stationTextPane = new JScrollPane(showStationText); 
        
        //creates the show station button, adds action listener, and adds it to the jpanel
        showStation = new JButton("Show Station");
        showStation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event)
            {
                //gets the correct hamming distance and the correct station to compare
                int sliderValue = hammingdist.getValue();
                String station = (String)stationList.getSelectedItem();
                
                //creates a hammingdist object
                HammingDist hd = new HammingDist(station);

                //uses the hamming distance object and the value of the sliders to return the string list of all the stations at a certain hamming distance
                HashMap<Integer,String> hm = hd.getHammingDist();
                String listStations = hm.get(sliderValue);
                showStationText.setText(listStations);
            }  
        });
        
        //adds the show station components to the jpanel
        sliderToStation.add(showStation, BorderLayout.CENTER);
        sliderToStation.add(stationTextPane, BorderLayout.SOUTH);
        
        //converts treeset to array, and uses it to create a dropdown menu
        stationList = new JComboBox<String>();
        CreateComponents.populateJComboBox(stationList, AllStations.getListOfStations());

        //creates the JLabel and dropdown menu
        compareWith = new JLabel("Compare With:");
        calculateHD = new JButton("Calculate HD");
        
        //adds an event listener and calculates the number of stations at each hamming distance
        calculateHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                calculateHD();
            }       
        });
        
        //adds these components to a subJPanel
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
        addStation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                //gets the text from the station and removes all the whitespace
                String newStation = addStationText.getText().trim();

                //adds the station to the list of stations, and ensures that it is the proper length and uppercase
                if(newStation.length() == 4)
                {
                    AllStations.addStation(newStation.toUpperCase());
                    System.out.println(newStation);
                    
                    CreateComponents.populateJComboBox(stationList, AllStations.getListOfStations());
                }  
            }  
        });
        
        distance0Text = (JTextField)CreateComponents.addTextArea(150, 25, false, true, "");
        distance1Text = (JTextField)CreateComponents.addTextArea(150, 25, false, true, "");
        distance2Text = (JTextField)CreateComponents.addTextArea(150, 25, false, true, "");
        distance3Text = (JTextField)CreateComponents.addTextArea(150, 25, false, true, "");
        distance4Text = (JTextField)CreateComponents.addTextArea(150, 25, false, true, "");
        addStationText = (JTextField)CreateComponents.addTextArea(150, 25, true, true, "");
        
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
        
        return leftSide;
    }
    
    /**
     * it was necessary to break this method away from the main body due to its length
     * this method sets the text for each of the JTextFields based on the number of stations at a given hamming distance
     */
    public static void calculateHD()
    {
        //initializes necessary variables
        String station = (String)stationList.getSelectedItem();
        HammingDist hd = new HammingDist(station);
        HashMap<Integer,String> hm = hd.getHammingDist();
        
        //for loop to loop over all the different hammingDistances
        int[] arrayDistances = new int[5];
        String[] numberStationsString = new String[0];
        
        for(int i = 0; i < 5; i++)
        {
            //gets the list of station names at a certain hamming distance
            String listStations = hm.get(i);

            //taking the number of stations and putting it into an array
            if(hm.get(i).equals(""))
            {
                arrayDistances[i] = 0;
            }else
            {
              //splits the station list on a newline character, telling how many different stations there are
                numberStationsString = listStations.split("\n");
                arrayDistances[i] = numberStationsString.length;
            } 
        }
        
        //assigns each JTextField the proper text
        distance0Text.setText(Integer.toString(arrayDistances[0]));
        distance1Text.setText(Integer.toString(arrayDistances[1]));
        distance2Text.setText(Integer.toString(arrayDistances[2]));
        distance3Text.setText(Integer.toString(arrayDistances[3]));
        distance4Text.setText(Integer.toString(arrayDistances[4]));    
    }
    
}
