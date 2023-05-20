package emeditatii;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public void validateUsername(String username) throws Exception {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+\\.[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(username);
        if (!matcher.matches()) {
        throw new Exception("Username must be in the format firstname.lastname");
        }
    }
    public void validateEmail(String email) throws Exception {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@(gmail\\.com|yahoo\\.com|365\\.univ-ovidius\\.ro)$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new Exception("Invalid email format. Must be gmail.com, yahoo.com, or 365.univ-ovidius.ro");
        }
    }
    public void validateMobileNumber(String mobileNumber) throws Exception {
        Pattern pattern = Pattern.compile("^07\\d{8}$");
        Matcher matcher = pattern.matcher(mobileNumber);
        if (!matcher.matches()) {
            throw new Exception("Invalid mobile number format. Must be 07xxxxxxxxx");
        }
    }
    public void validatePassword(String password) throws Exception {
        // check if the password has at least 8 characters
        if (password.length() < 8) {
          throw new Exception("Password must have at least 8 characters");
        }
    
        // check if the password has at least one capital letter
        boolean hasCapitalLetter = false;
        for (int i = 0; i < password.length(); i++) {
          if (Character.isUpperCase(password.charAt(i))) {
            hasCapitalLetter = true;
            break;
          }
        }
        if (!hasCapitalLetter) {
          throw new Exception("Password must have at least one capital letter");
        }
    
        // check if the password has at least one digit
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
          if (Character.isDigit(password.charAt(i))) {
            hasDigit = true;
            break;
          }
        }
        if (!hasDigit) {
          throw new Exception("Password must have at least one digit");
        }
      }
}
