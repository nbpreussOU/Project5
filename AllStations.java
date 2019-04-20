import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class AllStations
{
    protected static TreeSet<String> listOfStations; //prevent duplicates
    
    /**
     * constructor for a treeset of all the station IDs, in a try catch block because IOExceptions are the devil
     */
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

    /**
     * method to read in all of the station IDs from a filename
     * @param filename the filename of the .txt file
     * @return a TreeSet with all the strings included
     * @throws IOException file exception
     */
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
    
    /**
     * adds a station to the list of station
     * @param str stID to be added
     */
    public static void addStation(String str)
    {
        listOfStations.add(str);
    }

    /**
     * method to return the current list of stations
     * @return Treeset<String> list of stations
     */
    public static TreeSet<String> getListOfStations()
    {
        return listOfStations;
    }    
}
