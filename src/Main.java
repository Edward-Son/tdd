import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

     String csvFile = "/Users/edwardson/Desktop/Mcgill/winter2018/tdd_2/rates.csv";
     BufferedReader br = null;
     String line = "";
     String cvsSplitBy = ",";
     String[] rate = new String[0];

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                rate = line.split(cvsSplitBy);

                System.out.println(Arrays.toString(rate));

            }

        } catch (java.io.IOException e) {
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

       /*for (int i=0; i< rate.length; i++){
            if (args[0].equals(rate[i])){

            }
        }*/
    }
}
