import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightSide
{
    private static JPanel rightSide;
    private static JPanel row0;
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
        row0 = new JPanel(new BorderLayout());
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
        
        updateStat = new JButton("Update Statistics");
        
        //add everything to the proper JPanel
        row0.add(explanationOfStatistics, BorderLayout.WEST);
        row1.add(mostCommonLetter, BorderLayout.WEST);
        row2.add(leastCommonLetter, BorderLayout.WEST);
        row3.add(closestStation, BorderLayout.WEST);
        row4.add(furthestStation, BorderLayout.WEST);
        
        row1.add(mostCommonLetterText, BorderLayout.EAST);
        row2.add(leastCommonLetterText, BorderLayout.EAST);
        row3.add(closestStationText, BorderLayout.EAST);
        row4.add(furthestStationText, BorderLayout.EAST);
        
        //add JPanels to the right side panel
        rightSide.add(row0);
        rightSide.add(row1);
        rightSide.add(row2);
        rightSide.add(row3);
        rightSide.add(row4);
        
        return rightSide;
    }
}
