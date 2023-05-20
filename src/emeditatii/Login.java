package emeditatii;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {


  public String usernameString;
   JPanel panel;
   JLabel user_label, password_label, message;
   JTextField userName_text;
   JPasswordField password_text;
   JButton login, cancel;
   Login() {
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation(dim.width/3-this.getSize().width, dim.height/4-this.getSize().height/3);
      // Username Label
      user_label = new JLabel();
      user_label.setText("Username :");
      user_label.setFont(new Font("Courier", Font.BOLD,30));
      userName_text = new JTextField();
      userName_text.setFont(new Font("Courier", Font.BOLD,20));
      user_label.setHorizontalAlignment(SwingConstants.CENTER);
      // Password Label
      password_label = new JLabel();
      password_label.setText("Password :");
      password_text = new JPasswordField();
      password_text.setFont(new Font("Courier", Font.BOLD,20));
      password_label.setFont(new Font("Courier", Font.BOLD,30));
      password_label.setHorizontalAlignment(SwingConstants.CENTER);
      // Submit
      login = new JButton("Login");
      panel = new JPanel(new GridLayout (3, 2));
      panel.add(user_label);
      panel.add(userName_text);
      panel.add(password_label);
      panel.add(password_text);
      message = new JLabel();
      panel.add(login);
      JButton register = new JButton("Register");  
      register.setBounds(50,100,95,30);  
      panel.add(register);
      usernameString = userName_text.getText();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Adding the listeners to components..
      login.addActionListener(this);
      add(panel, BorderLayout.CENTER);
      setTitle("EMeditatii");
      setSize(450,350);
      setVisible(true);
      ImageIcon img = new ImageIcon("E:\\education.png");
      setIconImage(img.getImage());
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      register.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
          dispose();
	  new RegisterFrame();
      }
    });
      
      login.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        String savedUseString=userName_text.getText();
        String savedpaString=password_text.getText();
        
        try{
          if(isLoginValid(userName_text.getText(), password_text.getText())){
            BufferedWriter writer = new BufferedWriter(new FileWriter("savedUsAndPass.txt", false));
            writer.write(savedUseString+","+savedpaString);
            writer.newLine();
            writer.close();
            JOptionPane.showMessageDialog(null, "Login successfully...");
            if(isProfessor(userName_text.getText())){
              dispose();

              new TeacherFrame();
            }
            else{
              dispose();
              new StudentFrame();
              
            
            }
          }else{
            JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
          }
          }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
          }

        
      
      }
      
    });
   }
   public boolean isLoginValid(String username, String password) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] fields = line.split(",");
      if (fields[0].equals(username) && fields[2].equals(password)) {
        reader.close();
        return true;
      }
    }
    reader.close();
    return false;
  }
  public boolean isProfessor(String username) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
      String[] fields = line.split(",");
      if (fields[0].equals(username)) {
        reader.close();
        return Boolean.parseBoolean(fields[5]);
      }
    }
    reader.close();
    return false;
  }
   public static void main(String[] args) {
      new Login();
   }
   
   
   public void actionPerformed(ActionEvent ae) {

   }
  
}
