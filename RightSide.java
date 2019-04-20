import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        mostCommonLetterText = (JTextField) CreateComponents.addTextArea(1, 10, false, true, "");
        leastCommonLetterText = (JTextField) CreateComponents.addTextArea(1, 10, false, true, "");
        closestStationText = (JTextField) CreateComponents.addTextArea(1, 10, false, true, "");
        furthestStationText = (JTextField) CreateComponents.addTextArea(1, 10, false, true, "");
        
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
        row2.add(leastCommonLetterText, BorderLayout.EAST);
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

    public static void updateStats()
    {
        //set variables for commonly used values
        String stID = (String)LeftSide.stationList.getSelectedItem();
        int sliderValue = LeftSide.hammingdist.getValue();
        
        //update the title based on what the parameters are
        String title = String.format("Statistics for station %s with all stations at Hamming Distance %f", stID, sliderValue);
        explanationOfStatistics.setText(title);
        
        //update the text of each of the textfields based on methods
    }
}
