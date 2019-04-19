import java.awt.BorderLayout;

import javax.swing.BoxLayout;
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
    private static JPanel row5;
    
    private static JLabel explanationOfStatistics;
    private static JLabel mostCommonLetter;
    private static JLabel leastCommonLetter;
    private static JLabel closestStation;
    private static JLabel furthestStation;
    
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
        row5 = new JPanel(new BorderLayout());
        
        return rightSide;
    }
}
