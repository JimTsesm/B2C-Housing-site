package lsh;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Create_listing {
	

    public static void main(String[] args) throws IOException {

        String csvFile1 = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/ratings(after sentiment analysis).csv";
        String csvFile2 = "C:/Users/turbox/Desktop/di/тед/Ergasies/database/new_listing.csv";
        FileWriter writer = new FileWriter(csvFile2);
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
       String listing_id,listing_id_prev=null;
        try {

            br = new BufferedReader(new FileReader(csvFile1));
            while ((line = br.readLine()) != null) {
            	
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                listing_id = data[0];
                if(!listing_id.equals(listing_id_prev)) {writer.append(String.valueOf(listing_id));writer.append("\n");}
               listing_id_prev=listing_id;
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
        System.out.println("ok");
        writer.close();

    }
}

