public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            PostalRateCalculator.calculateRate(args);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
