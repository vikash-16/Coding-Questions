package DSAPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileValidatiokn {
    public static void main(String[] args) {
        String mobileNumber = "+m9870543210";
        if (isValidMobileNumber(mobileNumber)) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }
    }
    public static boolean isValidMobileNumber(String mobileNumber) {
        // Regular expression for a valid mobile number
        String regex = "^(?:\\+\\d{1,3})?\\d{10}$";

        // Create a pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(mobileNumber);

        // Check if the given string matches the pattern
        return matcher.matches();
    }
}
