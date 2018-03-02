import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class test {

    //invalid tests
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
        Assert.assertEquals("not enough arguments check",error, "please insert correct amount of arguments");
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
        Assert.assertEquals("too many arguments check", error, "please insert correct amount of arguments");
    }

    @Test
    public void fromInvalid() {
        String error =  null;
        String params[] = {
                "invalid", "e3f4g5", "2.2", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid From Postal Code check", error, "invalid 'From' Postal Code");
    }

    @Test
    public void toInvalid() {
        String error =  null;
        String params[] = {
                "e3f4g5", "invalid", "2.2", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid To Postal Code check", error, "invalid 'To' Postal Code");
    }

    @Test
    public void lengthOutOfLowerBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "0.1", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small length check", error, params[2] + " is a too small length");
    }

    @Test
    public void lengthOutOfUpperBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "100", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large length check", error, params[2] + " is a too large length");
    }
    @Test
    public void invalidLength() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "not a number", "2.4",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", error, params[2] + " is no a number");
    }

    @Test
    public void heightOutOfLowerBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "0.2",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small height check", error, params[3] + " is a too small height");
    }

    @Test
    public void heightOutOfUpperBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "1000",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large height check", error, params[3] + " is a too large height");
    }

    @Test
    public void invalidHeight() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.2", "not a number",
                "2.5", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid height check", error, params[3] + " is no a number");
    }

    @Test
    public void widthOutOfLowerBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "0.01", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small width check", error, params[4] + " is a too small width");
    }

    @Test
    public void widthOutOfUpperBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "8934893", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large width check", error, params[4] + " is a too large width");
    }

    @Test
    public void invalidWidth() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.0", "2.4",
                "wrong", "10", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid length check", error, params[4] + " is no a number");
    }

    @Test
    public void weightOutOfLowerBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2.0", "0.1", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too small weight check", error, params[5] + " is a too small weight");
    }

    @Test
    public void weightOutOfUpperBounds() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "1000000", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Too large weight check", error, params[5] + " is a too large weight");
    }
    @Test
    public void invalidWeight() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.0", "2.4",
                "2.5", "not number", "Priority",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("invalid weight check", error, params[5] + " is no a number");
    }

    @Test
    public void invalidTypes() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Something Else",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Incorrect Shipping type", error, params[6] + " is not a valid shipping option");
    }

    //valid tests
    @Test
    public void validTypes() {
        String error =  null;
        String params[] = {
                "e3f4g5", "h4s3t7", "2.4", "2.0",
                "2", "10", "Regular",
        };
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Regular Shipping type, no error thrown", error, null);

        params[6] = "Xpress";
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Xpress Shipping type, no error thrown", error, null);

        params[6] = "Regular";
        try {
            PostalRateCalculator.calculateRate(params);
        } catch (Exception e) {
            error = e.getMessage();
        }
        Assert.assertEquals("Priority Shipping type", error, null);
    }

    @Test
    public void validRate1() {

    }

    @Test
    public void validRate2() {

    }

    @Test
    public void validRate3() {

    }

    @Test
    public void validRate4() {

    }

    @Test
    public void validRate5() {

    }

    @Test
    public void validRate6() {

    }

    @Test
    public void validRate7() {

    }

    @Test
    public void validRate8() {

    }
}
