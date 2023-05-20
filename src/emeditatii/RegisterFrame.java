package emeditatii;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class RegisterFrame extends JFrame implements ActionListener {
    private final Container c;
    private final JLabel title;
    private final JLabel name;
    private final JTextField tname;
    private final JLabel mno;
    private final JTextField tmno;
    private final JLabel gender;
    private final JRadioButton male;
    private final JRadioButton female;
    private final ButtonGroup gengp;
    private final JLabel add;
    private final JTextArea tadd;
    private final JCheckBox term;
    private final JButton sub;
    private final JButton reset;
    private final JTextArea tout;
    private final JLabel res;
    private final JTextArea resadd;
    private final JLabel password;
    private final JPasswordField tpassword;
    private final JCheckBox profesor;
    private final JButton profesorButon;
    
    public RegisterFrame() {
            ImageIcon img = new ImageIcon("E:\\education.png");
            setIconImage(img.getImage());
            setTitle("Registration Page");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);

            c = getContentPane();
            c.setLayout(null);

            title = new JLabel("Registration Form");
            title.setFont(new Font("Serif", Font.BOLD, 30));
            title.setSize(300, 40);
            title.setLocation(300, 30);
            c.add(title);

            name = new JLabel("Username");
            name.setFont(new Font("Serif", Font.PLAIN, 20));
            name.setSize(100, 20);
            name.setLocation(100, 100);
            c.add(name);
            
            password = new JLabel("Password");
            password.setFont(new Font("Serif", Font.PLAIN, 20));
            password.setSize(200, 30);
            password.setLocation(100, 345);
            c.add(password);

            tname = new JTextField();
            tname.setFont(new Font("Serif", Font.PLAIN, 15));
            tname.setSize(190, 20);
            tname.setLocation(200, 100);
            c.add(tname);
            
            tpassword = new JPasswordField();
            tpassword.setFont(new Font("Serif", Font.PLAIN, 15));
            tpassword.setSize(190, 20);
            tpassword.setLocation(200, 350);
            c.add(tpassword);

            
            mno = new JLabel("Mobile");
            mno.setFont(new Font("Serif", Font.PLAIN, 20));
            mno.setSize(100, 20);
            mno.setLocation(100, 150);
            c.add(mno);

            tmno = new JTextField();
            tmno.setFont(new Font("Serif", Font.PLAIN, 15));
            tmno.setSize(190, 20);
            tmno.setLocation(200, 150);
            c.add(tmno);

            gender = new JLabel("Gender");
            gender.setFont(new Font("Serif", Font.PLAIN, 20));
            gender.setSize(100, 20);
            gender.setLocation(100, 200);
            c.add(gender);

            male = new JRadioButton("Male");
            male.setFont(new Font("Serif", Font.PLAIN, 15));
            male.setSelected(true);
            male.setSize(75, 20);
            male.setLocation(200, 200);
            c.add(male);

            female = new JRadioButton("Female");
            female.setFont(new Font("Serif", Font.PLAIN, 15));
            female.setSelected(false);
            female.setSize(80, 20);
            female.setLocation(275, 200);
            c.add(female);

            gengp = new ButtonGroup();
            gengp.add(male);
            gengp.add(female);

            add = new JLabel("Address");
            add.setFont(new Font("Serif", Font.PLAIN, 20));
            add.setSize(100, 20);
            add.setLocation(100, 300);
            c.add(add);

            tadd = new JTextArea();
            tadd.setFont(new Font("Serif", Font.PLAIN, 15));
            tadd.setSize(200, 75);
            tadd.setLocation(200, 300);
            tadd.setLineWrap(true);
            c.add(tadd);

            term = new JCheckBox("Accept Terms And Conditions.");
            term.setFont(new Font("Serif", Font.PLAIN, 15));
            term.setSize(250, 20);
            term.setLocation(150, 400);
            c.add(term);
            
            profesor = new JCheckBox("Professor");
            profesor.setFont(new Font("Serif", Font.PLAIN, 15));
            profesor.setSize(250, 20);
            profesor.setLocation(150, 380);
            c.add(profesor);

            sub = new JButton("Register");
            sub.setFont(new Font("DIALOG", Font.BOLD, 15));
            sub.setSize(100, 20);
            sub.setLocation(150, 450);
            sub.addActionListener((ActionListener) this);
            c.add(sub);

            reset = new JButton("Reset");
            reset.setFont(new Font("DIALOG", Font.BOLD, 15));
            reset.setSize(100, 20);
            reset.setLocation(300, 450);
            reset.addActionListener((ActionListener) this);
            c.add(reset);

            tout = new JTextArea();
            tout.setFont(new Font("Serif", Font.PLAIN, 15));
            tout.setSize(300, 400);
            tout.setLocation(500, 100);
            tout.setLineWrap(true);
            tout.setEditable(false);
            c.add(tout);

            res = new JLabel("");
            res.setFont(new Font("Serif", Font.PLAIN, 20));
            res.setSize(500, 25);
            res.setLocation(100, 500);
            c.add(res);

            resadd = new JTextArea();
            resadd.setFont(new Font("Serif", Font.PLAIN, 15));
            resadd.setSize(200, 75);
            resadd.setLocation(580, 175);
            resadd.setLineWrap(true);
            c.add(resadd);
            
            profesorButon = new JButton("Click here to go back!");
            profesorButon.setFont(new Font("DIALOG", Font.BOLD, 15));
            profesorButon.setSize(250, 20);
            profesorButon.setLocation(150, 425);
            profesorButon.addActionListener((ActionListener) this);
            c.add(profesorButon);
                 
            setVisible(true);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            profesorButon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                dispose();
                new Login();
            }});
          
        }
    public boolean isUsernameAndEmailExists(String username, String email) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields[0].equals(username) || fields[1].equals(email)) {
            reader.close();
            return true;
            }
        }
        reader.close();
        return false;
    }
   //--------------------method for selecting the disciplines for professors-----------------     
    public String showDisciplineSelection() {
        String[] options = {"Computer Science", "Mathematics", "Physics"};
        JOptionPane pane = new JOptionPane(
            "Select a discipline:",
            JOptionPane.QUESTION_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            options,
            options[0]
        );
        JDialog dialog = pane.createDialog(null, "Discipline Selection");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        Object selectedValue = pane.getValue();
        return (String) selectedValue;
    }
    //---------------------------method to select the faculty the student is in-----------------
    public String showFacultySelection() {
        String[] options = {"Informatics", "Mathematics", "Informatics and Mathematics"};
        JOptionPane pane = new JOptionPane(
            "Select a Faculty:",
            JOptionPane.QUESTION_MESSAGE,
            JOptionPane.DEFAULT_OPTION,
            null,
            options,
            options[0]
        );
        JDialog dialog = pane.createDialog(null, "Discipline Selection");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        Object selectedValue = pane.getValue();
        return (String) selectedValue;
    }
    //-----------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        Boolean isCorrect=true;
        Validate valid= new Validate();
        String username = tname.getText();
        String emailAdress= tadd.getText();
        String password = tpassword.getText();
        String gender ="";
        String mobileNumber=tmno.getText();
        Boolean isProfessor=false;
        String discipline;
        String faculty;
        UserRegistration uRegistration = new UserRegistration();
        Professor newProfessor;
        Student newStudent;
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                try{
                    try{
                        valid.validateUsername(username);
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                        tname.setText("");
                        res.setText("Registration failed, please try again!");
                        isCorrect=false;
                    }
                    try{
                        valid.validatePassword(password);
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                        tpassword.setText("");
                        res.setText("Registration failed, please try again!");
                        isCorrect=false;
                    }
                    try{
                        valid.validateEmail(emailAdress);
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                        tadd.setText("");
                        res.setText("Registration failed, please try again!");
                        isCorrect=false;
                    }
                    try{
                        valid.validateMobileNumber(mobileNumber);
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                        tmno.setText("");
                        res.setText("Registration failed, please try again!");
                        isCorrect=false;
                    }

                    if(isUsernameAndEmailExists(username, emailAdress) ){
                        JOptionPane.showMessageDialog(null, "Username or Email already exists"); 
                        res.setText("Registration failed, please try again!");                      
                    }else if(isCorrect){
                        String data1;
                        String data = "Name : " + tname.getText() + "\n"
                                + "Mobile : " + tmno.getText() + "\n";
                        if (male.isSelected()){
                            data1 = "Gender : Male" + "\n";
                            gender="Male";
                        }else{
                            data1 = "Gender : Female" + "\n";
                            gender="Female";
                        }
                        String data3 = "Address : " + tadd.getText() + "\n";
                        String data4 = "Password : " + tpassword.getText();

                        tout.setText(data + data1 + data3 + data4);
                        tout.setEditable(false);
                        
                        
                        try{
                            if(profesor.isSelected()){
                                isProfessor=true;
                                discipline=showDisciplineSelection();
                                newProfessor = new Professor(username, emailAdress, password, gender, mobileNumber, isProfessor, discipline);
                                uRegistration.registerProfessor("Users.txt", newProfessor);
                            }else{
                                faculty=showFacultySelection();
                                newStudent = new Student(username, emailAdress, password, gender, mobileNumber, isProfessor, faculty);
                                uRegistration.registerStudent("Users.txt", newStudent);
                            }                            
                            res.setText("Registration Successfully...");
                        }catch(IOException ex){
                            JOptionPane.showMessageDialog(null, ex);
                            JOptionPane.showMessageDialog(null , "Users.txt cannot be oppend");
                    
                        }
                        
                        

                    }
                }catch(IOException Exception){
                    JOptionPane.showMessageDialog(null, Exception);
                    JOptionPane.showMessageDialog(null , "Users.txt cannot be oppend");
                }                   
            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the terms & conditions...");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
        tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            resadd.setText(def);
        }
    }
}

class Registration {
    public static void main(String[] args) throws Exception
    {
        RegisterFrame f = new RegisterFrame();
    }
}


