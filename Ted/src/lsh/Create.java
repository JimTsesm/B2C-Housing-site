package lsh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Create {
	
	
    public static void main(String[] args) throws IOException {

        String csvFile1 = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/new_users.csv";
        String csvFile2 = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/new_listing.csv";
        String csvFile3 = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/ratings(after sentiment analysis).csv";
        String csvFile = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/table_output2.csv";
        FileWriter writer = new FileWriter(csvFile);
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int[][] table = new int[35202][1594];
        int i,j;
        for(i=0;i<35202;i++)
        	for(j=0;j<1594;j++)
        		table[i][j] = 0;
       
        i=1;
        j=0;
        try {

            br = new BufferedReader(new FileReader(csvFile1));
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                table[i][j] = Integer.parseInt(data[0]);
                i++;
                //System.out.println(data[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        i=0;
        j=1;
        try {

            br = new BufferedReader(new FileReader(csvFile2));
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                table[i][j] = Integer.parseInt(data[0]);
                j++;
                //System.out.println(data[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        int index,indexy,value,count=0,counter1=0,counter2=0;
        CSVUtils k = new CSVUtils();
        try {

            br = new BufferedReader(new FileReader(csvFile3));
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
               String[] data = line.split(cvsSplitBy);
               index = indexOfUser(table,Integer.parseInt(data[1]));
                indexy = indexOListing(table,Integer.parseInt(data[0]));
                value = Integer.parseInt(data[2]);
                if(index != -1 && indexy != -1) table[index][indexy] = value;
                else 
                {
                	count++;
                	if(index == -1) 
                	{
                		counter1++;
                	}
                	if(indexy==-1) counter2++;
                }
                //System.out.println(data[0]);
            	

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
System.out.println(count);
System.out.println(counter1);
System.out.println(counter2);
List<String> list = new ArrayList<String>();
for(i=0;i<35202;i++)
{
	list.clear();
	for(j=0;j<1594;j++)
	{
		//System.out.print(table[i][j]);
		//list.add(Integer.toString(table[i][j]));
		//if(i==1 && j==1500) System.out.println(list.get(1000));
		writer.append(String.valueOf(table[i][j]));
		if(j != 1593) writer.append(String.valueOf(","));
	}
	  writer.append("\n");
		//k.writeLine(writer,list);
  }
writer.close();
    System.out.println(count);
    System.out.println(counter1);
    System.out.println(counter2);
}
    public static int indexOfUser(int[][] a, int key) {
        int lo = 1;
        int hi = 35201;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid][0]) hi = mid - 1;
            else if (key > a[mid][0]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static int indexOListing(int[][] a, int key) {
        int lo = 1;
        int hi = 1593;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[0][mid]) hi = mid - 1;
            else if (key > a[0][mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
}