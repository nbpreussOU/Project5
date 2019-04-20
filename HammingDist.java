import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class HammingDist
{
    private HashMap<Integer, String> hammingDist;
    
    /**
     * calculates the hamming distance to every other station given a station ID
     * @param str String station ID
     */
    public HammingDist(String str)
    {           
        //checks for the right length of a string, and finds the hamming distance of all other stations
        if(str.length() == 4)
        {
            hammingDist = getHammingDistance(str);  
        }        
    }
    
    /**
     * this methods finds the most common and uncommon letters of the station names at a given hamming distance
     * @param hD int for whichever hamming distance is selected on the slider
     * @return String[2]  |  [0] is commonest letter, [1] is uncommonest 
     */
    public String[] commonUncommonLetter(int hD)
    {
        HashMap<Integer, String> hm = getHammingDist();
        String stationsUnbroken = hm.get(hD);
        int[] alphabetFrequency = new int[26];
        Arrays.fill(alphabetFrequency,  0);
        
        //populates the array with number of occurance of each letter
        for(int i = 0; i < stationsUnbroken.length() - 1; i++)
        {
            switch(stationsUnbroken.charAt(i))
            {
                case 'A':
                    alphabetFrequency[0]++;
                    break;
                case 'B':
                    alphabetFrequency[1]++;
                    break;
                case 'C':
                    alphabetFrequency[2]++;
                    break;
                case 'D':
                    alphabetFrequency[3]++;
                    break;
                case 'E':
                    alphabetFrequency[4]++;
                    break;
                case 'F':
                    alphabetFrequency[5]++;
                    break;
                case 'G':
                    alphabetFrequency[6]++;
                    break;
                case 'H':
                    alphabetFrequency[7]++;
                    break;
                case 'I':
                    alphabetFrequency[8]++;
                    break;
                case 'J':
                    alphabetFrequency[9]++;
                    break;
                case 'K':
                    alphabetFrequency[10]++;
                    break;
                case 'L':
                    alphabetFrequency[11]++;
                    break;
                case 'M':
                    alphabetFrequency[12]++;
                    break;
                case 'N':
                    alphabetFrequency[13]++;
                    break;
                case 'O':
                    alphabetFrequency[14]++;
                    break;
                case 'P':
                    alphabetFrequency[15]++;
                    break;
                case 'Q':
                    alphabetFrequency[16]++;
                    break;
                case 'R':
                    alphabetFrequency[17]++;
                    break;
                case 'S':
                    alphabetFrequency[18]++;
                    break;
                case 'T':
                    alphabetFrequency[19]++;
                    break;
                case 'U':
                    alphabetFrequency[20]++;
                    break;
                case 'V':
                    alphabetFrequency[21]++;
                    break;
                case 'W':
                    alphabetFrequency[22]++;
                    break;
                case 'X':
                    alphabetFrequency[23]++;
                    break;
                case 'Y':
                    alphabetFrequency[24]++;
                    break;
                case 'Z':
                    alphabetFrequency[25]++;
                    break;
            }
        }
        
        //finds the max and min values
        int max = 0;
        for(int i = 0; i < 26; i++)
        {
            if(alphabetFrequency[i] > max)
            {
                max = alphabetFrequency[i];
            }
        }
        
        int min = max;
        for(int i = 0; i < 26; i++)
        {
            if(alphabetFrequency[i] < min)
            {
                min = alphabetFrequency[i];
            }
        }
        
        //writes the max and min letters out to a string
        String maxLetters = "";
        String minLetters = "";
        for(int i = 0; i < 26; i++)
        {
            if(alphabetFrequency[i] == min)
            {
                minLetters = minLetters + (char)(i+65) + "  "; // lines up the int values and the ascii table
            }
            if(alphabetFrequency[i] == max)
            {
                maxLetters = maxLetters + (char)(i+65) + "  "; // lines up the int values and the ascii table
            }
        }
        
        return new String[] {maxLetters, minLetters};
    }    
    
    /**
     * this method finds the closest ASCII station to a given station
     * @param stID station to compare all stations to
     * @param hD the hamming distance on the slider
     * @return string station ID
     */
    public String getClosestStation(String stID, int hD)
    {
        HashMap<Integer, String> hm = getHammingDist();
        int min = Integer.MAX_VALUE;
        int temp;
        String strMin = "";
        
        //break the string up into each individual station
        String stationsUnbroken = hm.get(hD);
        String[] stationsBroken = stationsUnbroken.split("\n");
        
        for(String s: stationsBroken)
        {
            //calculate the total ascii distance between the stations
            temp = calculateASCIIDistance(s, stID);
            if(temp < min)
            {
                //change the max values if a max occurs
                min = temp;
                strMin = s;
            }
        }
        
        return strMin;
    }
    
    /**
     * this method finds the furthest ASCII station to a given station
     * @param stID station to compare all stations to
     * @param hD the hamming distance on the slider
     * @return String station ID
     */
    public String getFurthestStation(String stID, int hD)
    {
        HashMap<Integer, String> hm = getHammingDist();
        int max = Integer.MIN_VALUE;
        int temp;
        String strMax = "";
        
        //break the string up into each individual station
        String stationsUnbroken = hm.get(hD);
        String[] stationsBroken = stationsUnbroken.split("\n");
        
        for(String s: stationsBroken)
        {
            //calculate the total ascii distance between the stations
            temp = calculateASCIIDistance(s, stID);
            if(temp > max)
            {
                //change the max values if a max occurs
                max = temp;
                strMax = s;
            }
        }
        
        return strMax;
    }
    
    /**
     * this method calculates the ascii distance between two stations
     * @param s one station ID
     * @param stID the other station ID that is being compared
     * @return int total ascii difference between the two stations
     */
    public int calculateASCIIDistance(String s, String stID)
    {
       char[] rotatingStation = s.toCharArray();
       char[] fixedStation = stID.toCharArray();
       int total = 0;
       
       //calculates the distance between two characters on the ascii table
       for(int i = 0; i < 4; i++)
       {
           //flat value if there is the number in the station name
           if(fixedStation[i] == 2 || rotatingStation[i] == 2)
           {
               total += 15;
           }else
           {
               total += Math.abs(fixedStation[i] - rotatingStation[i]);
           }
       }
       
       return total;   
    }

    /**
     * this method returns a hashmap of all stations at all possible hamming distances of the given station
     * @param stID station that all the hamming relationships are being computed for
     * @return hashmap with integer hamming distances as keys and a string of all stations at a length as values
     */
    public HashMap<Integer, String> getHammingDistance(String stID)
    {
        int temp;
        String[] stringHD = new String[5];
        TreeSet<String> ts = AllStations.getListOfStations();
        HashMap<Integer, String> hm  = new HashMap<>();
        
        //populates arrays with 0 to start
        Arrays.fill(stringHD, "");
        
        //fills the array with information about the hamming distance
        for(String s: ts)
        {
            //encapsulates the comparison of strings
            temp = compareStrings(s, stID);
            
            //adds one to the correct array number [0] = distance 0, [1] = distance 1, [2] = distance 2, [3] = distance 3, [4] = distance 4
            switch(temp)
            {
                case 0:
                    stringHD[0] = stringHD[0] + s + "\n";
                    break;
                case 1:
                    stringHD[1] = stringHD[1] + s + "\n";
                    break;
                case 2:
                    stringHD[2] = stringHD[2] + s + "\n";
                    break;
                case 3:
                    stringHD[3] = stringHD[3] + s + "\n";
                    break;
                case 4:
                    stringHD[4] = stringHD[4] + s + "\n";
                    break;
            }
        }
        
        //puts each array into the hashmap
        for(int i = 0; i < 5; i++)
        {
            hm.put(i, stringHD[i]);
        }
        return hm;
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
    
    /**
     * returns the hashmap currently being used
     * @return Hashmap<Integer, String> of hamming values and stations
     */
    public HashMap<Integer, String> getHammingDist()
    {
        return hammingDist;
    }
  
}
