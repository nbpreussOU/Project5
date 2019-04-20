import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class AllStations
{
    private TreeSet<String> listOfStations;
    public AllStations()
    {
        try
        {
            listOfStations = allStations("Mesonet.txt");
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public TreeSet<String> allStations(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
        String strg = "";
        TreeSet<String> stations = new TreeSet<>();
        
        //as long as there is another string
        strg = br.readLine();

        while(strg != null)
        {
            //ensures that only station names can be added
            if(strg.length() == 4)
            {
                stations.add(strg.trim());
            }
                //reads in the next line, if available
                strg = br.readLine();
        }
        
        br.close();
        
        //finishes the string to be returned
        return stations;
    }
    
    public void addStation(String str)
    {
        listOfStations.add(str);
    }

    public TreeSet<String> getListOfStations()
    {
        return listOfStations;
    }
}
