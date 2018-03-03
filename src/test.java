import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class test {

    //valid conditions tests
    //order they appear is order they were done in
    @Test
    public void validTo() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid to postal code, no error thrown", null, error);
        //for now just make it return 9 or some place holder rate when To is valid
        Assert.assertEquals("Expected Rate", 9, rate, 0);
    }

    @Test
    public void validFrom() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid from postal code, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);
    }

    @Test
    public void validWeight() {
        //fix so that rate it outputs is what we want
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("proper weight, no error thrown", null, error);
        Assert.assertEquals("Expected Rate based on weight", 9, rate, 0);
    }

    @Test
    public void validHeight() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid height, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);

    }

    @Test
    public void validLength() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid length, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);
    }

    @Test
    public void validWidth() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("valid width, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);
    }

    @Test
    public void validTypes() {
        double rate = 0;
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Regular Shipping type, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);

        params[6] = "Xpress";
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Xpress Shipping type, no error thrown", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);


        params[6] = "Regular";
        try {
            rate = PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Priority Shipping type", null, error);
        Assert.assertEquals("Expected Rate", 9, rate, 0);

    }

    //invalid conditions tests
    @Test
    public void fewArguments() {
        String error = null;
        String params[] = {
                "h4s3t7",
                "e3f4g5"
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
                "h4s3t7", "e3f4g5", "2.2", "2.4",
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
                "invalid", "e3f4g5", "2.2", "2.4",
                "2.5", "10", "Priority",
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
                "e3f4g5", "invalid", "2.2", "2.4",
                "2.5", "10", "Priority",
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
                "e3f4g5", "h4s3t7", "0.1", "2.4",
                "2.5", "10", "Priority",
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
                "e3f4g5", "h4s3t7", "100", "2.4",
                "2.5", "10", "Priority",
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
                "e3f4g5", "h4s3t7", "not a number", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", params[2] + " is no a number", error);
    }

    @Test
    public void heightOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "0.2",
                "2.5", "10", "Priority",
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
                "e3f4g5", "h4s3t7", "2.4", "1000",
                "2.5", "10", "Priority",
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
                "e3f4g5", "h4s3t7", "2.2", "not a number",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid height check", params[3] + " is no a number", error);
    }

    @Test
    public void widthOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
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
                "e3f4g5", "h4s3t7", "2.4", "2.0",
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
                "e3f4g5", "h4s3t7", "2.0", "2.4",
                "wrong", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", params[4] + " is no a number", error);
    }

    @Test
    public void weightOutOfLowerBounds() {
        String error = null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2.0", "0.1", "Priority",
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
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "1000000", "Priority",
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
                "e3f4g5", "h4s3t7", "2.0", "2.4",
                "2.5", "not number", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid weight check", params[5] + " is no a number", error);
    }

    @Test
    public void invalidTypes() {
        String error = null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Something Else",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Incorrect Shipping type", params[6] + " is not a valid shipping option", error);
    }
}