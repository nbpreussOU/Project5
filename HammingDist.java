import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
    
    public int[] getHammingDistance(String stID)
    {
        int temp;
        int[] arrayHD = new int[5];
        TreeSet<String> ts = getListStations();
        //populates arrays with 0 to start
        Arrays.fill(arrayHD,  0);
        
        //fills the array with information about the hamming distance
        for(String s: ts)
        {
            //encapsulates the comparison of strings
            temp = compareStrings(s, stID);
            
            //adds one to the correct array number [0] = distance 0, [1] = distance 1, [2] = distance 2, [3] = distance 3, [4] = distance 4
            switch(temp)
            {
                case 0:
                    arrayHD[0]++;
                    break;
                case 1:
                    arrayHD[1]++;
                    break;
                case 2:
                    arrayHD[2]++;
                    break;
                case 3:
                    arrayHD[3]++;
                    break;
                case 4:
                    arrayHD[4]++;
                    break;
            }
        }
        return arrayHD;
    }
    /**
     * a method for comparing two strings and returning the hamming value
     * @param station String station name
     * @param node String station name
     * @return Hamming Distance for the object
     */
    public int compareStrings(String station, String node)
    {
        int distance = 0;
        for(int i = 0; i < 4; i++)
        {
            if(station.charAt(i) != node.charAt(i))
                {
                    distance++;
                }
        }
        return distance;
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

    public TreeSet<String> getListStations()
    {
        return listStations;
    }
    
    
}
