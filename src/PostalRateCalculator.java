import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PostalRateCalculator {

/*
    static String csvFile = "/Users/edwardson/Desktop/Mcgill/winter2018/tdd_2/rates.csv";
    static BufferedReader br = null;
    static String line = "";
    static String cvsSplitBy = ",";

    public static void readCSV(){

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] rate = line.split(cvsSplitBy);

                System.out.println(Arrays.toString(rate));

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
    }*/

    //params[] = from, to, length, height, width, weight, type
    public static double calculateRate(String params[]) throws Exception {
        //functionality needs to throw errors at the invalid conditions
        //throw new Exception("oups");
        //data passed as string, then convert to double for height, weight, ...
        //Double.parseDouble(string);
        return 0;
    }
}
