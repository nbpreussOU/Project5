import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class RightSide
{
    private static JPanel rightSide;
    private static JPanel row1;
    private static JPanel row2;
    private static JPanel row3;
    private static JPanel row4;
    
    private static JLabel explanationOfStatistics;
    private static JLabel mostCommonLetter;
    private static JLabel leastCommonLetter;
    private static JLabel closestStation;
    private static JLabel furthestStation;
    
    private static JButton updateStat;
    
    private static JTextField mostCommonLetterText;
    private static JTextField leastCommonLetterText;
    private static JTextField closestStationText;
    private static JTextField furthestStationText;
    
    private static JScrollBar uncommonLetter;
    
    /**
     * creates the right JPanel in the image.  this has some interesting statistics done to be "creative"
     * @return a right side JPanel with all the necessary components added in
     */
    public static JPanel addRightSide()
    {
        //initialize JPanels
        rightSide = new JPanel();
        rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.PAGE_AXIS));
        row1 = new JPanel(new BorderLayout());
        row2 = new JPanel(new BorderLayout());
        row3 = new JPanel(new BorderLayout());
        row4 = new JPanel(new BorderLayout());
        
        //initialize JLabels
        explanationOfStatistics = new JLabel("Statistics for station XXXX with all stations at Hamming Distance X    ");
        mostCommonLetter = new JLabel("Most Common Letter:");
        leastCommonLetter = new JLabel("Least Common Letter:");
        closestStation = new JLabel("Closest Station:");
        furthestStation = new JLabel("Furthest Station:");
        
        //initialize J Text fields
        mostCommonLetterText = (JTextField) CreateComponents.addTextArea(150, 25, false, true, "");
        leastCommonLetterText = (JTextField) CreateComponents.addTextArea(150, 25, false, true, "");
        closestStationText = (JTextField) CreateComponents.addTextArea(150, 25, false, true, "");
        furthestStationText = (JTextField) CreateComponents.addTextArea(150, 25, false, true, "");
        
        //leastCommonLetterText needs a scrollbar
        uncommonLetter = new JScrollBar(JScrollBar.HORIZONTAL);
        BoundedRangeModel brm = leastCommonLetterText.getHorizontalVisibility();
        uncommonLetter.setModel(brm);
        JPanel text = new JPanel(new BorderLayout());
        text.add(leastCommonLetterText, BorderLayout.CENTER);
        text.add(uncommonLetter, BorderLayout.SOUTH);
        
        //initialize and add afction listener to the button
        updateStat = new JButton("Update Statistics");
        updateStat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                updateStats();
            }
        });
        
        //add everything to the proper JPanel
        row1.add(explanationOfStatistics, BorderLayout.NORTH);
        row1.add(mostCommonLetter, BorderLayout.WEST);
        row2.add(leastCommonLetter, BorderLayout.WEST);
        row3.add(closestStation, BorderLayout.WEST);
        row4.add(furthestStation, BorderLayout.WEST);
        
        row1.add(mostCommonLetterText, BorderLayout.EAST);
        row2.add(text, BorderLayout.EAST);
        row3.add(closestStationText, BorderLayout.EAST);
        row4.add(furthestStationText, BorderLayout.EAST);
        row4.add(updateStat, BorderLayout.SOUTH);
        
        //add JPanels to the right side panel
        rightSide.add(row1);
        rightSide.add(row2);
        rightSide.add(row3);
        rightSide.add(row4);
        
        return rightSide;
    }

    /**
     * it was necessary to break this method away from the main body due to its length
     * this method sets the text for each of the JTextFields based on the various statistical methods
     */
    public static void updateStats()
    {
        //set variables for commonly used values
        String stID = (String)LeftSide.stationList.getSelectedItem();
        int sliderValue = LeftSide.hammingdist.getValue();
        HammingDist hd = new HammingDist(stID);
        
        //update the title based on what the parameters are
        String title = String.format("Statistics for station %s with all stations at Hamming Distance %d", stID, sliderValue);
        explanationOfStatistics.setText(title);
        
        //update the text of each of the textfields based on methods
        mostCommonLetterText.setText(hd.commonUncommonLetter(sliderValue)[0]);
        leastCommonLetterText.setText(hd.commonUncommonLetter(sliderValue)[1]);
        closestStationText.setText(hd.getClosestStation(stID, sliderValue));
        furthestStationText.setText(hd.getFurthestStation(stID, sliderValue));
    }
}
