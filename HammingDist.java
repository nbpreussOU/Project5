import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class HammingDist
{
    private TreeSet<String> listStations;
    public HammingDist()
    {
        try
        {
            listStations = allStations("Mesonet.txt");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public int getMostCommonLetter()
    {
        
    }
    
    public int getLeastCommonLetter()
    {
        
    }
    
    public String getClosestStation()
    {
        
    }
    
    public String getFurthestStation()
    {
        
    }
    
    public int[] getHammingDistance()
    {
        
    }
    
    public String[] getListOfStationsAtHammingDistance()
    {
        
    }
    
    public TreeSet<String> allStations(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
        String strg;
        TreeSet<String> stations = new TreeSet<>();
        
        //as long as there is another string
        strg = br.readLine();

        while(strg != null)
        {
            //ensures that only station names can be added
            if(strg.length() == 4)
            {
                stations.add(strg);
            }
                //reads in the next line, if available
                strg = br.readLine();
            
        }
        
        br.close();
        
        //finishes the string to be returned
        return stations;
    }
    
    public TreeSet<String> addStation(TreeSet<String> stationList, String newStation)
    {
        
    }
}
