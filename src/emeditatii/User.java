package emeditatii;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class User {
  private String name;
  private String email;
  private String password;
  private String gender;
  private String mobileNumber;
  private boolean isProfessor;

  public User(String name, String email, String password, String gender, String mobileNumber, boolean isProfessor) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.gender = gender;
    this.mobileNumber = mobileNumber;
    this.isProfessor = isProfessor;
  }

  public User(String fileName) throws IOException, ParseException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    this.name = reader.readLine();
    this.email = reader.readLine();
    this.password = reader.readLine();
    this.gender = reader.readLine();
    this.mobileNumber = reader.readLine();
    this.isProfessor = Boolean.parseBoolean(reader.readLine());
    reader.close();
    }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public boolean isProfessor() {
    return isProfessor;
  }

  public void setProfessor(boolean professor) {
    isProfessor = professor;
  }
}
