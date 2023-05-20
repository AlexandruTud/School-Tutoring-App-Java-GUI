package emeditatii;

public class Professor extends User {
    private String discipline;
  
    public Professor(String name, String email, String password, String gender, String mobileNumber, boolean isProfessor, String discipline) {
      super(name, email, password, gender, mobileNumber, isProfessor);
      this.discipline = discipline;
    }
  
    public String getDiscipline() {
      return discipline;
    }
  
    public void setDiscipline(String discipline) {
      this.discipline = discipline;
    }
  }
