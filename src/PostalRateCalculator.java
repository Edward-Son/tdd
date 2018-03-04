public class PostalRateCalculator {


    //params[] = from, to, length, height, width, weight, type
    public static double calculateRate(String params[]) throws Exception {

        if (params.length != 7) {
            throw new Exception("please insert correct amount of arguments");
        }

        if (params[0].length() != 6) {
            throw new Exception("invalid 'From' Postal Code");
        } else {
            for (int i = 0; i < params[0].length(); i++) {
                if (i % 2 == 0) { // even digits
                    if (!Character.isLetter(params[0].charAt(i))) {
                        throw new Exception("invalid 'From' Postal Code");
                    }
                } else { // odd digits
                    if (!Character.isDigit(params[0].charAt(i))) {
                        throw new Exception("invalid 'From' Postal Code");
                    }
                }
            }
        }

        if (params[1].length() != 6) {
            throw new Exception("invalid 'To' Postal Code");
        } else {
            for (int i = 0; i < params[1].length(); i++) {
                if (i % 2 == 0) { // even digits
                    if (!Character.isLetter(params[1].charAt(i))) {
                        throw new Exception("invalid 'To' Postal Code");
                    }
                } else { // odd digits
                    if (!Character.isDigit(params[1].charAt(i))) {
                        throw new Exception("invalid 'To' Postal Code");
                    }
                }
            }
        }

        //check if valid number
        try {
            Double.parseDouble(params[2]);
        } catch (NumberFormatException nfe) {
            throw new Exception(params[2] + " is not a number");
        }
        if (Double.parseDouble(params[2]) < 10) {
            throw new Exception(params[2] + " is a too small length");
        } else if (Double.parseDouble(params[2]) > 210) {
            throw new Exception(params[2] + " is a too large length");
        }

        //check if valid number
        try {
            Double.parseDouble(params[3]);
        } catch (NumberFormatException nfe) {
            throw new Exception(params[3] + " is not a number");
        }
        if (Double.parseDouble(params[3]) < 7) {
            throw new Exception(params[3] + " is a too small height");
        } else if (Double.parseDouble(params[3]) > 275) {
            throw new Exception(params[3] + " is a too large height");
        }

        //check if valid number
        try {
            Double.parseDouble(params[4]);
        } catch (NumberFormatException nfe) {
            throw new Exception(params[4] + " is not a number");
        }
        if (Double.parseDouble(params[4]) < 1) {
            throw new Exception(params[4] + " is a too small width");
        } else if (Double.parseDouble(params[4]) > 210) {
            throw new Exception(params[4] + " is a too large width");
        }

        //check if valid number
        try {
            Double.parseDouble(params[5]);
        } catch (NumberFormatException nfe) {
            throw new Exception(params[5] + " is not a number");
        }
        if (Double.parseDouble(params[5]) < 0.1) {
            throw new Exception(params[5] + " is a too small weight");
        } else if (Double.parseDouble(params[5]) > 30) {
            throw new Exception(params[5] + " is a too large weight");
        }

        if (!params[6].equals("Regular") && !params[6].equals("Xpress") && !params[6].equals("Priority")) {
            throw new Exception(params[6] + " is not a valid shipping option");
        }
        return 9;
    }
}
