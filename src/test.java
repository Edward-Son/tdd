import org.junit.Assert;
import org.junit.Test;

public class test {

    //valid conditions tests
    //order they appear is order they were done in
    //from, to, length, height, width, weight, type
    @Test
    public void validCSVRead() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "V9A1A1", "H1Y1A1", "25", "50",
                "90", "20", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertNotEquals("valid to postal code, no error thrown", "I/O", error);
        Assert.assertEquals("Expected Rate", 32.38, rate, 0);
    }

    @Test
    public void validPostal() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "V9A1A1", "H1Y1A1", "25", "50",
                "90", "20", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid to postal code, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 32.38, rate, 0);
    }

    @Test
    public void validDimensions() {
        double rate = 0;
        String error =  null;
        String params[] = {
               "M3C1A1", "H1Y1A1", "25", "50",
                "90", "20", "Xpress",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid from postal code, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 26.98, rate, 0);
    }

    @Test
    public void validTypes() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "C1A1A1", "H1Y1A1", "25", "50",
                "90", "20", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Regular Shipping type, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 19.28, rate, 0);

        params[6] = "Xpress";
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Xpress Shipping type, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 23.28, rate, 0);


        params[6] = "Priority";
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Priority Shipping type", null, error);
        Assert.assertEquals("Expected Rate", 39.28, rate, 0);

    }

    //invalid conditions tests
    @Test
    public void fewArguments() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1"
                //missing other parameters
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("not enough arguments check", "please insert correct amount of arguments", error);
    }

    @Test
    public void moreArguments() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "2.2", "2.4",
                "2.5", "10", "Priority", "extra param"
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("too many arguments check", "please insert correct amount of arguments", error);
    }

    @Test
    public void fromInvalid() {
        String error = null;
        String params[] = {
                "invalid", "H1Y1A1", "22", "24",
                "25", "10", "Xpress",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid From Postal Code check", "invalid 'From' Postal Code", error);
    }

    @Test
    public void toInvalid() {
        String error = null;
        String params[] = {
                "R2C1A1", "invalid", "22", "24",
                "25", "10", "Xpress",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid To Postal Code check", "invalid 'To' Postal Code", error);
    }

    @Test
    public void lengthOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "0.1", "24",
                "25", "10", "Xpress",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small length check", params[2] + " is a too small length", error);
    }

    @Test
    public void lengthOutOfUpperBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "1000", "24",
                "25", "10", "Xpress",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large length check",params[2] + " is a too large length", error);
    }

    @Test
    public void invalidLength() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "not a number", "24",
                "25", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", params[2] + " is not a number", error);
    }

    @Test
    public void heightOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "0.2",
                "25", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small height check", params[3] + " is a too small height", error);
    }

    @Test
    public void heightOutOfUpperBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "1000",
                "25", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large height check", params[3] + " is a too large height", error);
    }

    @Test
    public void invalidHeight() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "22", "not a number",
                "25", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid height check", params[3] + " is not a number", error);
    }

    @Test
    public void widthOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "20",
                "0.01", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small width check",params[4] + " is a too small width", error);
    }

    @Test
    public void widthOutOfUpperBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "20",
                "8934893", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large width check",params[4] + " is a too large width", error);
    }

    @Test
    public void invalidWidth() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "20", "24",
                "wrong", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", params[4] + " is not a number", error);
    }

    @Test
    public void weightOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "20",
                "20", "0", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small weight check",params[5] + " is a too small weight", error);
    }

    @Test
    public void weightOutOfUpperBounds() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "20",
                "20", "1000000", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large weight check",params[5] + " is a too large weight", error);
    }

    @Test
    public void invalidWeight() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "20", "24",
                "25", "not number", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid weight check", params[5] + " is not a number", error);
    }

    @Test
    public void invalidTypes() {
        String error = null;
        String params[] = {
                "R2C1A1", "H1Y1A1", "24", "20",
                "20", "10", "Something Else",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Incorrect Shipping type", params[6] + " is not a valid shipping option", error);
    }
}