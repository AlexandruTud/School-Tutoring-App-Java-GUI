package emeditatii;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.*;
public class TeacherFrame {
    private final JLabel imageLabel;
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel nume;
    private final JLabel materie;
    private final JTextField tnume;
    private final JLabel titluCreeazaCerere;
    private final JLabel bunVenit;
    private final String materii[] =
    {
        
    };
    private final String ora[] =
    {
        "14","15","16","17","18"
    };
    private final String minute[] =
    {
        "00","30"
    };
    private final String loc[] =
    {
        "Sala 15","Sala 20"
    };
    private final String pret[] =
    {
        "100","120"
    };
    private final JComboBox locBox;
    private final JComboBox pretBox;
    private final JComboBox oraBox;
    private final JComboBox minuteBox;
    private final JComboBox materiiBox;
    private final String dates[]
            = { "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31" };
    private final String months[]
            = { "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sup", "Oct", "Nov", "Dec" };
    private final String years[]
            = { "2023" , "2024" , "2025" };
    private final String cereri[] ={" "," "," "};
    private final JList<String> cereriList; 
    private final JComboBox date;
    private final JComboBox month;
    private final JComboBox year;
    private final JLabel dataText;
    private final JLabel informatii;
    private final String listaSedinte[] = { " "," "," "," "," "," "," "," "," "," "," " };
    private final JList<String> listaSed;
    private final JList listaRec;
    private final JLabel titluDatePersonale;
    private final JLabel numeHome;
    private final JLabel prenumeHome;
    private final JLabel dataNasteriiHome;
    private final JLabel adresaHome;
    private final JLabel facultateHome;

    private final JLabel creeazaRecenzie;
    private final JLabel nota;
    private final JComboBox notaBox;
    private final String note[]
            = { "1" , "2" , "3", "4" , "5", "6", "7", "8", "9", "10" };
    private final JLabel materieRecenzie;
    private final JComboBox materieBox;
    private final JLabel recenzie;
    private final JTextArea trecenzie;
    private final JLabel trecenziileTale;
    private final JTextField homeNume;
    private final JTextField homePrenume;
    private final JTextField homeDataNasterii;
    private final JTextField homeAdresa;
    private final JTextField homeFacultate;
    private final JLabel oraCreeazaCerere;
    private final JLabel locCreeazaCerere;
    private final JLabel pretCreeazaCerere;
    private final JButton trimiteRecenzie;
    private final String listaRecenzii[] = { " "," "," "," "," "," "," "," "," "," "," "};
    private final JButton acceptaCereri;
    private final JButton nuAcceptaCereri;
    private final JButton modificaCereri;

    TeacherFrame()
    {
        
        frame = new JFrame("Teacher Frame");
        panel = new JPanel();
        frame.getContentPane();
        String defaultpath;
        imageLabel = new JLabel();
        ImageIcon image = new ImageIcon("defaultImage.png");
        imageLabel.setIcon(image);
        imageLabel.setSize(100, 100);
        imageLabel.setLocation(300,200);
        imageLabel.setBackground(Color.red);
        imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageLabel.setVisible(true);
        imageLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imageLabel.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
            }
        }
    });
        panel.add(imageLabel);
        bunVenit = new JLabel("Welcome, Teacher! ");
        bunVenit.setFont(new Font("Serif", Font.BOLD, 30));
        bunVenit.setSize(300, 40);
        bunVenit.setLocation(500, 200);
        panel.add(bunVenit);
        
        informatii = new JLabel("You are on the Teachers page!");
        informatii.setFont(new Font("Serif", Font.PLAIN, 30));
        informatii.setSize(500, 40);
        informatii.setLocation(380, 230);
        panel.add(informatii);
        
        JButton logOut = new JButton("Log Out");
        Dimension size = logOut.getPreferredSize();
        logOut.setBounds(1, 460, 150, 200);
        panel.add(logOut);
        
        JButton recenzii = new JButton("Reviews");
        recenzii.setBounds(1, 360, 150, 100);
        panel.add(recenzii);
        
       recenzii.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String savedDiscipline= new String();
            String username = new String();
            String line;
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("savedUsAndPass.txt"));
                
            while ((line = reader.readLine()) != null) {
                String fields[]=line.split(",");
                username=fields[0];
            } 
        }catch (IOException e1) {
             
            e1.printStackTrace();
        }
        try{
            reader = new BufferedReader(new FileReader("Users.txt"));
            String[] split;
            while ((line = reader.readLine()) != null) {  
                split = line.split(",");
                if(split[0].equals(username)){                     
                    savedDiscipline=split[6];
                }
            }
            }catch(IOException exc){
                exc.getMessage();
            }
          int i=0;
            try{
                reader = new BufferedReader(new FileReader("Reviews.txt"));
                String[] split;
                while ((line = reader.readLine()) != null) {  
                    split = line.split(",");
                    if(split[3].equals(savedDiscipline)){                     
                    listaRecenzii[i]=line;
                    i++;
                    }
                }
                }catch(IOException exc){
                    exc.getMessage();
                }
        }
    });
        
        JButton sedinte = new JButton("Manage Sessions");
        sedinte.setBounds(1, 260, 150, 100);
        panel.add(sedinte);
        
        JButton gestioneazaCerere = new JButton("Manage Requests");
        gestioneazaCerere.setBounds(1, 160, 150, 100);
        panel.add(gestioneazaCerere);
        
        
        JButton home = new JButton("Home");
        home.setBounds(1, 0, 150, 160);
        panel.add(home);
        

        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 5);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 6);
        frame.setLocation(x, y);
        
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1000, 700);
        frame.setVisible(true);
        
        ImageIcon img = new ImageIcon("E:\\education.png");
        frame.setIconImage(img.getImage());
        frame.setTitle("Teacher Page");
      

        
        
        JButton stergeSedinta = new JButton("Delete");
        stergeSedinta.setBounds(810, 590, 100, 40);
        stergeSedinta.setFont(new Font("Sans", Font.BOLD, 20));
        panel.add(stergeSedinta);
        
        stergeSedinta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedRequest = listaSed.getSelectedValue();


                ArrayList<String> requests = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader("Sessions.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    requests.add(line);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            
            
            int indexToRemove = -1;
            for (int i = 0; i < requests.size(); i++) {
                if (requests.get(i).equals(selectedRequest)) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove != -1) {
                requests.remove(indexToRemove);
            }           
            try (PrintWriter writer = new PrintWriter(new FileWriter("Sessions.txt"))) {
                for (String request : requests) {
                    writer.println(request);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"The Session has been deleted");
            
            
            DefaultListModel model = (DefaultListModel) cereriList.getModel();
            model.removeAllElements();
            for (String request : requests) {
                model.addElement(request);
            }

            }
        });
        titluCreeazaCerere = new JLabel("Creeaza Cerere");
        titluCreeazaCerere.setFont(new Font("Serif", Font.BOLD, 30));
        titluCreeazaCerere.setSize(500, 40);
        titluCreeazaCerere.setLocation(470, 100);
        panel.add(titluCreeazaCerere);
        
        nume = new JLabel("Name:");
        nume.setFont(new Font("Serif", Font.BOLD, 30));
        nume.setSize(300, 40);
        nume.setLocation(300, 190);
        panel.add(nume);
        
        materie = new JLabel("Materie:");
        materie.setFont(new Font("Serif", Font.BOLD, 30));
        materie.setSize(300, 40);
        materie.setLocation(300, 250);
        panel.add(materie);
        
        JButton send = new JButton("Send");
        send.setBounds(610, 540, 100, 40);
        send.setFont(new Font("Sans",Font.BOLD,20));
        panel.add(send);
        
        tnume = new JTextField();
        tnume.setFont(new Font("Serif", Font.BOLD, 20));
        tnume.setSize(300, 40);
        tnume.setLocation(405, 195);
        panel.add(tnume);
        
        materiiBox = new JComboBox(materii);
        materiiBox.setFont(new Font("Arial", Font.BOLD, 20));
        materiiBox.setSize(275, 30);
        materiiBox.setLocation(430, 260);
        panel.add(materiiBox);
        
        dataText = new JLabel("Data:");
        dataText.setFont(new Font("Serif", Font.BOLD, 30));
        dataText.setSize(300, 40);
        dataText.setLocation(300, 310);
        panel.add(dataText);
        
        date = new JComboBox(dates);
        date.setFont(new Font("Serif", Font.PLAIN, 15));
        date.setSize(100, 30);
        date.setLocation(400, 318);
        panel.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Serif", Font.PLAIN, 15));
        month.setSize(100, 30);
        month.setLocation(505, 318);
        panel.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Serif", Font.PLAIN, 15));
        year.setSize(100, 30);
        year.setLocation(610, 318);
        panel.add(year);
        
        listaSed = new JList<String>(listaSedinte);
        listaSed.setFont(new Font("Serif", Font.PLAIN, 20));
        listaSed.setSize(680, 500);
        listaSed.setLocation(230, 50);
        panel.add(listaSed);
        
        titluDatePersonale = new JLabel("Personal data");
        titluDatePersonale.setFont(new Font("Serif", Font.BOLD, 30));
        titluDatePersonale.setSize(500, 40);
        titluDatePersonale.setLocation(470, 100);
        panel.add(titluDatePersonale);
        
        numeHome = new JLabel("Username:");
        numeHome.setFont(new Font("Serif", Font.BOLD, 30));
        numeHome.setSize(300, 40);
        numeHome.setLocation(300, 200);
        panel.add(numeHome);
        
        prenumeHome = new JLabel("Password:");
        prenumeHome.setFont(new Font("Serif", Font.BOLD, 30));
        prenumeHome.setSize(300, 40);
        prenumeHome.setLocation(300, 250);
        panel.add(prenumeHome);
    
        adresaHome = new JLabel("Mail Adress:");
        adresaHome.setFont(new Font("Serif", Font.BOLD, 30));
        adresaHome.setSize(300, 40);
        adresaHome.setLocation(300, 350);
        panel.add(adresaHome);
        
        dataNasteriiHome = new JLabel("Gender:");
        dataNasteriiHome.setFont(new Font("Serif", Font.BOLD, 30));
        dataNasteriiHome.setSize(300, 40);
        dataNasteriiHome.setLocation(300, 300);
        panel.add(dataNasteriiHome);
        
        facultateHome = new JLabel("Discipline:");
        facultateHome.setFont(new Font("Serif", Font.BOLD, 30));
        facultateHome.setSize(300, 40);
        facultateHome.setLocation(300, 400);
        panel.add(facultateHome);
        

        
        
        creeazaRecenzie = new JLabel("Creeaza recenzie");
        creeazaRecenzie.setFont(new Font("Serif", Font.BOLD, 30));
        creeazaRecenzie.setSize(500, 40);
        creeazaRecenzie.setLocation(470, 100);
        panel.add(creeazaRecenzie);
        
        nota = new JLabel("Nota");
        nota.setFont(new Font("Serif", Font.BOLD, 30));
        nota.setSize(500, 40);
        nota.setLocation(300, 200);
        panel.add(nota);
        
        notaBox = new JComboBox(note);
        notaBox.setFont(new Font("Arial", Font.BOLD, 20));
        notaBox.setSize(275, 30);
        notaBox.setLocation(390, 208);
        panel.add(notaBox);
        
        materieRecenzie = new JLabel("Materie");
        materieRecenzie.setFont(new Font("Serif", Font.BOLD, 30));
        materieRecenzie.setSize(500, 40);
        materieRecenzie.setLocation(300, 250);
        panel.add(materieRecenzie);
        
        materieBox = new JComboBox(materii);
        materieBox.setFont(new Font("Arial", Font.BOLD, 20));
        materieBox.setSize(275, 30);
        materieBox.setLocation(425, 258);
        panel.add(materieBox);
        
        recenzie = new JLabel("Recenzia dumneavostra");
        recenzie.setFont(new Font("Serif", Font.BOLD, 30));
        recenzie.setSize(500, 40);
        recenzie.setLocation(300, 300);
        panel.add(recenzie);
        
        trecenzie = new JTextArea();
        trecenzie.setFont(new Font("Serif", Font.BOLD, 20));
        trecenzie.setSize(550, 220);
        trecenzie.setLocation(300, 350);
        panel.add(trecenzie);
        
        trecenziileTale = new JLabel("Your Reviews");
        trecenziileTale.setFont(new Font("Serif", Font.BOLD, 30));
        trecenziileTale.setSize(500, 40);
        trecenziileTale.setLocation(470, 100);
        panel.add(trecenziileTale);
       
        
        homeNume = new JTextField();
        homeNume.setFont(new Font("Serif", Font.BOLD, 15));
        homeNume.setSize(250, 40);
        homeNume.setLocation(490, 205);
        panel.add(homeNume);
        homeNume.setEnabled(false);
        
        homePrenume = new JTextField();
        homePrenume.setFont(new Font("Serif", Font.BOLD, 15));
        homePrenume.setSize(250, 40);
        homePrenume.setLocation(490, 255);
        panel.add(homePrenume);
        homePrenume.setEnabled(false);
        
        homeDataNasterii = new JTextField();
        homeDataNasterii.setFont(new Font("Serif", Font.BOLD, 15));
        homeDataNasterii.setSize(250, 40);
        homeDataNasterii.setLocation(490, 305);
        panel.add(homeDataNasterii);
        homeDataNasterii.setEnabled(false);
        
        homeAdresa = new JTextField();
        homeAdresa.setFont(new Font("Serif", Font.BOLD, 15));
        homeAdresa.setSize(250, 40);
        homeAdresa.setLocation(490, 355);
        panel.add(homeAdresa);
        homeAdresa.setEnabled(false);
        
        homeFacultate = new JTextField();
        homeFacultate.setFont(new Font("Serif", Font.BOLD, 15));
        homeFacultate.setSize(250, 40);
        homeFacultate.setLocation(490, 405);
        panel.add(homeFacultate);
        homeFacultate.setEnabled(false);
        
        JButton modificaHome = new JButton("Modify Data");
        modificaHome.setBounds(620, 470, 120, 30);
        panel.add(modificaHome);
        
        JButton salveazaButtonHome = new JButton("Save Data");
        salveazaButtonHome.setBounds(500, 470, 120, 30);
        panel.add(salveazaButtonHome);
        
        oraCreeazaCerere = new JLabel("Time:");
        oraCreeazaCerere.setFont(new Font("Serif", Font.BOLD, 30));
        oraCreeazaCerere.setSize(300, 40);
        oraCreeazaCerere.setLocation(300, 360);
        panel.add(oraCreeazaCerere);
        
        locCreeazaCerere = new JLabel("Place:");
        locCreeazaCerere.setFont(new Font("Serif", Font.BOLD, 30));
        locCreeazaCerere.setSize(300, 40);
        locCreeazaCerere.setLocation(300, 410);
        panel.add(locCreeazaCerere);
        
        pretCreeazaCerere = new JLabel("Price:");
        pretCreeazaCerere.setFont(new Font("Serif", Font.BOLD, 30));
        pretCreeazaCerere.setSize(300, 40);
        pretCreeazaCerere.setLocation(300, 460);
        panel.add(pretCreeazaCerere);
        
        oraBox = new JComboBox(ora);
        oraBox.setFont(new Font("Arial", Font.BOLD, 20));
        oraBox.setSize(70, 30);
        oraBox.setLocation(430, 370);
        panel.add(oraBox);
        
        minuteBox = new JComboBox(minute);
        minuteBox.setFont(new Font("Arial", Font.BOLD, 20));
        minuteBox.setSize(70, 30);
        minuteBox.setLocation(510, 370);
        panel.add(minuteBox);
        
        locBox = new JComboBox(loc);
        locBox.setFont(new Font("Arial", Font.BOLD, 20));
        locBox.setSize(180, 30);
        locBox.setLocation(400, 420);
        panel.add(locBox);
        
        pretBox = new JComboBox(pret);
        pretBox.setFont(new Font("Arial", Font.BOLD, 20));
        pretBox.setSize(180, 30);
        pretBox.setLocation(400, 470);
        panel.add(pretBox);
        
        trimiteRecenzie = new JButton("Send");
        trimiteRecenzie.setBounds(730, 585, 120, 30);
        panel.add(trimiteRecenzie);
       
        listaRec = new JList<String>(listaRecenzii);
        listaRec.setFont(new Font("Serif", Font.PLAIN, 15));
        listaRec.setSize(680, 350);
        listaRec.setLocation(230, 140);
        panel.add(listaRec);
        
        cereriList = new JList<String>(cereri);
        cereriList.setFont(new Font("Serif", Font.PLAIN, 20));
        cereriList.setSize(680, 350);
        cereriList.setLocation(230, 140);
        panel.add(cereriList);
        
        acceptaCereri = new JButton("Accept");
        acceptaCereri.setBounds(450, 500, 120, 30);
        panel.add(acceptaCereri);
        
        nuAcceptaCereri = new JButton("Delete");
        nuAcceptaCereri.setBounds(600, 500, 120, 30);
        panel.add(nuAcceptaCereri);
        
        modificaCereri = new JButton("Modify");
        modificaCereri.setBounds(750, 500, 120, 30);
        panel.add(modificaCereri);
        
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acceptaCereri.hide();
                nuAcceptaCereri.hide();
                modificaCereri.hide();
                bunVenit.hide();
                informatii.hide();
                stergeSedinta.hide();
                materiiBox.hide();
                tnume.hide();
                send.hide();
                materie.hide();
                nume.hide();
                dataText.hide();
                date.hide();
                month.hide();
                year.hide();
                titluCreeazaCerere.hide();
                listaSed.hide();
                titluDatePersonale.show();
                numeHome.show();
                prenumeHome.show();
                adresaHome.show();
                dataNasteriiHome.show();
                facultateHome.show();
                nota.hide();
                notaBox.hide();
                materieRecenzie.hide();
                materieBox.hide();
                recenzie.hide();
                creeazaRecenzie.hide();
                trecenzie.hide();
                trecenziileTale.hide();
                homeNume.show();
                homePrenume.show();
                homeDataNasterii.show();
                homeAdresa.show();
                homeFacultate.show();
                modificaHome.show();
                salveazaButtonHome.show();
                locCreeazaCerere.hide();
                oraCreeazaCerere.hide();
                pretCreeazaCerere.hide();
                oraBox.hide();
                minuteBox.hide();
                locBox.hide();
                pretBox.hide();
                trimiteRecenzie.hide();
                listaRec.hide();
                cereriList.hide();
                imageLabel.show();
                String username = new String();
                String password = new String();
                String line;
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("savedUsAndPass.txt"));
                    
                while ((line = reader.readLine()) != null) {
                    String fields[]=line.split(",");
                    username=fields[0];
                    password=fields[1];
                } 
            }catch (IOException e1) {
                 
                e1.printStackTrace();
            }
    try {
        reader = new BufferedReader(new FileReader("Users.txt"));
        
        while ((line = reader.readLine()) != null) {
        String[] fields2 = line.split(",");
            if (fields2[0].equals(username) && fields2[2].equals(password)) {
                homeNume.setText(username);
                homePrenume.setText(password);
                homeAdresa.setText(fields2[1]);
                homeDataNasterii.setText(fields2[3]);
                homeFacultate.setText(fields2[6]);    
            }
        }
    }catch (IOException e1) {
      
        e1.printStackTrace();
    }
}
    });
    modificaHome.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            homeNume.setEnabled(true);
            homePrenume.setEnabled(true);
            homeAdresa.setEnabled(true);
            homeDataNasterii.setEnabled(true);
            homeFacultate.setEnabled(true);
        }
    });

        
       /* salveazaButtonHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
  
                Validate valid = new Validate();
                String usernname = homeNume.getText();
                String password = homePrenume.getText();
                String mailAdd= homeAdresa.getText();
                String gender = homeDataNasterii.getText();
                String discipline = homeFacultate.getText();
                String mobileNumber= new String();
                Boolean isprof;
                Boolean isValid = true;
                UserRegistration uRegistration = new UserRegistration();
               
                try{
                    valid.validateUsername(usernname);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null , ex.getMessage());
                    isValid= false;
                }
                try{
                    valid.validateEmail(mailAdd);                   
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null , ex.getMessage());
                    isValid= false;
                }
                try{
                    valid.validatePassword(password);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null , ex.getMessage());
                    isValid= false;
                }
                if(isValid){
                    try {
                        
                       BufferedReader reader = new BufferedReader(new FileReader("Users.txt"));
                        String line;
                        while ((line = reader.readLine()) != null) {
                        String[] fields2 = line.split(",");
                            if (fields2[0].equals(usernname)) {
                                mobileNumber=fields2[4];
                                isprof=Boolean.parseBoolean(fields2[5]);                               
                                Professor p= new Professor(usernname, mailAdd, password, gender, mobileNumber, isprof, discipline);
                                ArrayList<String> lines = new ArrayList<>();
                                int i= 0; 
                                try {
                                    reader = new BufferedReader(new FileReader("Users.txt"));
                                    while ((line = reader.readLine()) != null) {
                                        if (fields2[0].equals(usernname)) {
                                            lines.add(line);
                                            ++i;
                                        }
                                    }
                                    lines.add(i, p.toString());
                                reader.close();
                                } catch (IOException exc) {
                                    exc.printStackTrace();
                                }
                                try {
                                    BufferedWriter writer = new BufferedWriter(new FileWriter("Users.txt"));
                                    for (String line2 : lines) {
                                        writer.write(line2 + System.lineSeparator());
                                        writer.close();
                                    }
                                    }catch (IOException exc) {
                                        exc.printStackTrace();
                                    }
                                
                                JOptionPane.showMessageDialog(null,"Your data has been update");
                            }
                        }
                    }catch (IOException e1) {
                      
                        e1.printStackTrace();
                    }
                }

            }
        });*/
        gestioneazaCerere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bunVenit.hide();
                informatii.hide();
                stergeSedinta.hide();
                materiiBox.hide();
                tnume.hide();
                send.hide();
                materie.hide();
                nume.hide();
                dataText.hide();
                date.hide();
                month.hide();
                year.hide();
                titluCreeazaCerere.hide();
                listaSed.hide();
                numeHome.hide();
                titluDatePersonale.hide();
                prenumeHome.hide();
                adresaHome.hide();
                dataNasteriiHome.hide();
                facultateHome.hide();
                nota.hide();
                notaBox.hide();
                materieRecenzie.hide();
                materieBox.hide();
                recenzie.hide();
                creeazaRecenzie.hide();
                trecenzie.hide();
                trecenziileTale.hide();
                homeNume.hide();
                homePrenume.hide();
                homeDataNasterii.hide();
                homeAdresa.hide();
                homeFacultate.hide();
                modificaHome.hide();
                salveazaButtonHome.hide();
                locCreeazaCerere.hide();
                oraCreeazaCerere.hide();
                pretCreeazaCerere.hide();
                oraBox.hide();
                minuteBox.hide();
                locBox.hide();
                pretBox.hide();
                trimiteRecenzie.hide();
                listaRec.hide();
                cereriList.show();
                acceptaCereri.show();
                nuAcceptaCereri.show();
                modificaCereri.show();
                imageLabel.hide();
                String username = new String();
                String savedDiscipline = new String();
                String line;
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("savedUsAndPass.txt"));
                    
                while ((line = reader.readLine()) != null) {
                    String fields[]=line.split(",");
                    username=fields[0];
                } 
            }catch (IOException e1) {
                 
                e1.printStackTrace();
            }
    try {
        reader = new BufferedReader(new FileReader("Users.txt"));
        
        while ((line = reader.readLine()) != null) {
        String[] fields2 = line.split(",");
            if (fields2[0].equals(username)) {
                savedDiscipline=fields2[6];
            }
        }
    }catch (IOException e1) {
      
        e1.printStackTrace();
    }
    int i=0;
    try{
        reader = new BufferedReader(new FileReader("Requests.txt"));
        String[] split;
        while ((line = reader.readLine()) != null) {  
            split = line.split(",");
            if(split[1].equals(savedDiscipline)){                     
            cereri[i]=line;
            i++;
            }
        }
        }catch(IOException exc){
            exc.getMessage();
        }
        }
    });
    modificaCereri.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           int selectedIndex = cereriList.getSelectedIndex();
           String selectedString = cereriList.getSelectedValue();
           if (selectedIndex != -1) {

            String Split[]= selectedString.split(",");
            Request selectedRequest = new Request(Split[0],Split[1],Split[2],Split[3],Split[4],Split[5],Boolean.parseBoolean(Split[6]));
             
     
              String newPrice = JOptionPane.showInputDialog("Enter new price: ");
              selectedRequest.setPrice(newPrice);
     
              String newPlace = JOptionPane.showInputDialog("Enter new place: ");
              selectedRequest.setPlace(newPlace);
     
              String newDate = JOptionPane.showInputDialog("Enter new date: ");
              selectedRequest.setRequestDate(newDate);
     
              String newHour = JOptionPane.showInputDialog("Enter new hour: ");
              selectedRequest.setRequestHour(newHour);
              
           } else {
              JOptionPane.showMessageDialog(null, "No request selected!");
           }
        }
     });
    acceptaCereri.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            
                int selectedIndex = cereriList.getSelectedIndex();
                String selectedString = cereriList.getSelectedValue();
                if (selectedIndex == -1) {
                  JOptionPane.showMessageDialog(null, "Please select a request.");
                  return;
                }
                String Split[]= selectedString.split(",");
                Request selectedRequest = new Request(Split[0],Split[1],Split[2],Split[3],Split[4],Split[5],Boolean.parseBoolean(Split[6]));
                selectedRequest.setIsAccepted(true);     
                JOptionPane.showMessageDialog(null, "The Request has been added to the Sessions");    
        try {
             RegisterRequests register = new RegisterRequests();
             register.registerRequest("Sessions.txt", selectedRequest);
             cereriList.remove(selectedIndex);

            
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        ArrayList<String> requests = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Requests.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            requests.add(line);
        }
    } catch (IOException exc) {
        exc.printStackTrace();
    }
    
    
    int indexToRemove = -1;
    for (int i = 0; i < requests.size(); i++) {
        if (requests.get(i).equals(selectedString)) {
            indexToRemove = i;
            break;
        }
    }
    
    
    if (indexToRemove != -1) {
        requests.remove(indexToRemove);
    }
    

    
    try (PrintWriter writer = new PrintWriter(new FileWriter("Requests.txt"))) {
        for (String request : requests) {
            writer.println(request);
        }
    } catch (IOException exc) {
        exc.printStackTrace();
    }
    
    
    DefaultListModel model = (DefaultListModel) cereriList.getModel();
    model.removeAllElements();
    for (String request : requests) {
        model.addElement(request);
    }
            
        }
        
    });
    nuAcceptaCereri.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
        String selectedRequest = cereriList.getSelectedValue();


    ArrayList<String> requests = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("Requests.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        requests.add(line);
    }
} catch (IOException exc) {
    exc.printStackTrace();
}


int indexToRemove = -1;
for (int i = 0; i < requests.size(); i++) {
    if (requests.get(i).equals(selectedRequest)) {
        indexToRemove = i;
        break;
    }
}


if (indexToRemove != -1) {
    requests.remove(indexToRemove);
}


try (PrintWriter writer = new PrintWriter(new FileWriter("Requests.txt"))) {
    for (String request : requests) {
        writer.println(request);
        JOptionPane.showMessageDialog(null,"The request has been deleted");
    }
} catch (IOException exc) {
    exc.printStackTrace();
}


DefaultListModel model = (DefaultListModel) cereriList.getModel();
model.removeAllElements();
for (String request : requests) {
    model.addElement(request);
}
        }
    });
        
        sedinte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bunVenit.hide();
                informatii.hide();
                stergeSedinta.show();
                materiiBox.hide();
                tnume.hide();
                send.hide();
                materie.hide();
                nume.hide();
                dataText.hide();
                date.hide();
                month.hide();
                year.hide();
                titluCreeazaCerere.hide();
                numeHome.hide();
                listaSed.show();
                prenumeHome.hide();
                adresaHome.hide();
                dataNasteriiHome.hide();
                facultateHome.hide();
                creeazaRecenzie.hide();
                nota.hide();
                notaBox.hide();
                materieRecenzie.hide();
                materieBox.hide();
                recenzie.hide();
                trecenzie.hide();
                trecenziileTale.hide();
                homeNume.hide();
                homePrenume.hide();
                homeDataNasterii.hide();
                homeAdresa.hide();
                homeFacultate.hide();
                modificaHome.hide();
                salveazaButtonHome.hide();
                locCreeazaCerere.hide();
                oraCreeazaCerere.hide();
                pretCreeazaCerere.hide();
                oraBox.hide();
                minuteBox.hide();
                locBox.hide();
                pretBox.hide();
                trimiteRecenzie.hide();
                listaRec.hide();
                cereriList.hide();
                acceptaCereri.hide();
                nuAcceptaCereri.hide();
                modificaCereri.hide();
                imageLabel.hide();
                int i=0;
                try{
                    BufferedReader reader = new BufferedReader(new FileReader("Sessions.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        listaSedinte[i]=line;
                        i++;
                    }
                }catch(IOException exc){
            exc.getMessage();
        }
            }
        
        });
        stergeSedinta.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
            String selectedRequest = listaSed.getSelectedValue();
    
    
        ArrayList<String> requests = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Sessions.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            requests.add(line);
        }
    } catch (IOException exc) {
        exc.printStackTrace();
    }
    
    
    int indexToRemove = -1;
    for (int i = 0; i < requests.size(); i++) {
        if (requests.get(i).equals(selectedRequest)) {
            indexToRemove = i;
            break;
        }
    }
    
    
    if (indexToRemove != -1) {
        requests.remove(indexToRemove);
    }
    
    
    try (PrintWriter writer = new PrintWriter(new FileWriter("Sessions.txt"))) {
        for (String request : requests) {
            writer.println(request);
            JOptionPane.showMessageDialog(null,"The Session has been deleted");
        }
    } catch (IOException exc) {
        exc.printStackTrace();
    }
            }
        });
        
        recenzii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bunVenit.hide();
                informatii.hide();
                stergeSedinta.hide();
                materiiBox.hide();
                tnume.hide();
                send.hide();
                materie.hide();
                nume.hide();
                dataText.hide();
                date.hide();
                month.hide();
                year.hide();
                titluCreeazaCerere.hide();
                numeHome.hide();
                listaSed.hide();
                prenumeHome.hide();
                adresaHome.hide();
                dataNasteriiHome.hide();
                facultateHome.hide();
                creeazaRecenzie.hide();
                nota.hide();
                notaBox.hide();
                materieRecenzie.hide();
                materieBox.hide();
                recenzie.hide();
                trecenzie.hide();
                trecenziileTale.show();
                homeNume.hide();
                homePrenume.hide();
                homeDataNasterii.hide();
                homeAdresa.hide();
                homeFacultate.hide();
                                modificaHome.hide();
                salveazaButtonHome.hide();
                                locCreeazaCerere.hide();
                oraCreeazaCerere.hide();
                pretCreeazaCerere.hide();
                oraBox.hide();
                minuteBox.hide();
                locBox.hide();
                pretBox.hide();
                trimiteRecenzie.hide();
                listaRec.show();
                cereriList.hide();
                acceptaCereri.hide();
                nuAcceptaCereri.hide();
                modificaCereri.hide();
                imageLabel.hide();
            }
        
        });
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            logOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                frame.dispose();
                new Login();
            }});
            
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("D:\\Ovidius\\Java Proiecte\\EMeditatii\\a.png"));
        Dimension size1 = label.getPreferredSize();
        label.setBounds(-800, 0, 1800, 800);
        panel.add(label);
        
         stergeSedinta.hide();
        materiiBox.hide();
        tnume.hide();
        send.hide();
        materie.hide();
        nume.hide();
        dataText.hide();
        date.hide();
        month.hide();
        year.hide();
        titluCreeazaCerere.hide();
        listaSed.hide();
        titluDatePersonale.hide();
        numeHome.hide();
        prenumeHome.hide();
        adresaHome.hide();
        dataNasteriiHome.hide();
        facultateHome.hide();
        creeazaRecenzie.hide();
        nota.hide();
        notaBox.hide();
        materieRecenzie.hide();
        materieBox.hide();
        recenzie.hide();
        trecenzie.hide();
        trecenziileTale.hide();
        homeNume.hide();
        homePrenume.hide();
        homeDataNasterii.hide();
        homeAdresa.hide();
        homeFacultate.hide();
        modificaHome.hide();
        salveazaButtonHome.hide();
        locCreeazaCerere.hide();
        oraCreeazaCerere.hide();
        pretCreeazaCerere.hide();
        oraBox.hide();
        minuteBox.hide();
        locBox.hide();
        pretBox.hide();
        trimiteRecenzie.hide();
        listaRec.hide();
        cereriList.hide();
        acceptaCereri.hide();
        nuAcceptaCereri.hide();
        modificaCereri.hide();
    }
    
    public static void main(String[] args){
        TeacherFrame a = new TeacherFrame();
        
    }
}