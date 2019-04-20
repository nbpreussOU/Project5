import java.awt.Dimension;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateComponents
{
    /**
     * this method creates a text field or a text area.  this is in one method and not two because I didn't want to write 
     * two similar methods with similar parameters, so a boolean controlls which type is created
     * @param row how many rows of text the text should have
     * @param column how many columns of text the text should have
     * @param editable true if this is editable, false if not editable
     * @param field true if a JTextField, false is JTextArea
     * @param str String to title the object
     * @return Object to be casted to either a JTextField or JTextArea
     */
    public static Object addTextArea(int row, int column, boolean editable, boolean field, String str)
    {
        if(field)
        {
            JTextField jtf = new JTextField(str);
            jtf.setPreferredSize(new Dimension(row, column));
            jtf.setEditable(editable);
            return jtf;
        }else
        {
            JTextArea jta = new JTextArea(str, row, column);
            jta.setEditable(editable);
            return jta;
        }
    }
    
    /**
     * constructor for the slider, moved into its own method because it took up too much spacce
     * @param min minimum value for hte slider
     * @param max maximum value for the slider
     * @param ticks true if the tick marks are visible, false otherwise
     * @param labels true if the labels are visible, false otherwise
     * @return a JSlider with the given configuration
     */
    public static JSlider addSlider(int min, int max, boolean ticks, boolean labels)
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
    
    /**
     * method to populate a JComboBox with station ID's at the beginning of the program, and if another station is added
     * @param cb JComboBox to be edited
     * @param ts List of station names in the treeset to prevent duplicates
     */
    public static void populateJComboBox(JComboBox<String> cb, TreeSet<String> ts)
    {
        //removes all items and then repopulates it
        cb.removeAllItems();
        for(String s: ts)
        {
            cb.addItem(s);
        }
    }
}
