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
    private JPanel leftSide;
    private JPanel rightSide;
   
    private JFrame jf;

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
    
    public static void main(String[] args)
    {
        Window window = new Window();
    }
    
    
}
