package emeditatii;

public class Student extends User {
    private String faculty;
  
    public Student(String name, String email, String password, String gender, String mobileNumber, boolean isProfessor, String faculty) {
      super(name, email, password, gender, mobileNumber, isProfessor);
      this.faculty = faculty;
    }
  
    public String getFaculty() {
      return faculty;
    }
  
    public void setFaculty(String faculty) {
      this.faculty = faculty;
    }
  }
  
  
  