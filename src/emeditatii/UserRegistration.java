package emeditatii;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserRegistration {
  
  public void registerProfessor(String fileName, Professor user) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
    writer.write(user.getName()+","+user.getEmail()+","+user.getPassword()+","+user.getGender()+","+user.getMobileNumber()+","+String.valueOf(user.isProfessor())+","+user.getDiscipline());
    writer.newLine();
    writer.close();
    }
    public void registerStudent(String fileName, Student user) throws IOException {
      BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
      writer.write(user.getName()+","+user.getEmail()+","+user.getPassword()+","+user.getGender()+","+user.getMobileNumber()+","+String.valueOf(user.isProfessor())+","+user.getFaculty());
      writer.newLine();
      writer.close();
      }
}