import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateComponents
{
    public static JButton addButton(String str)
    {
        JButton jb = new JButton(str);
        //need to add action listeners for each button?
        return jb;
    }
    /*
     * @param field true if text field, false if text area
     */
    public static Object addTextArea(int row, int column, boolean editable, boolean field, String str)
    {
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
    
    public static void populateJComboBox(JComboBox<String> cb, TreeSet<String> ts)
    {
        cb.removeAllItems();
        for(String s: ts)
        {
            cb.addItem(s);
        }
    }
}
