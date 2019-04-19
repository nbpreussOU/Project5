import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class createComponents
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
}
