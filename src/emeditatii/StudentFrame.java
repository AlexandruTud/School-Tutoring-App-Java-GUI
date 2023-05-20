package emeditatii;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
public class StudentFrame extends JFrame{
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel nume;
    private final JLabel materie;
    private final JTextField tnume;
    private final JLabel titluCreeazaCerere;
    private final JLabel bunVenit;
    private final String materii[] =
    {
        "Geometry", "Automata Theory" , "Operating Sistems"
    };
    private final String ora[] =
    {
        "14","15","16","17","18" , "19"
    };
    private final String minute[] =
    {
        "00","30"
    };
    private final String loc[] =
    {
        "Sala 10" , "Sala 15","Sala 20" , "Sala 30"
    };
    private final String pret[] =
    {
        "100","120", "150"
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
    private final JComboBox date;
    private final JComboBox month;
    private final JComboBox year;
    private final JLabel dataText;
    private final JLabel informatii;
    private final String listaSedinte[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
    private final JList listaSed;
    private final JList listaRec;
    private final JLabel titluDatePersonale;
    private final JLabel numeHome;
    private final JLabel passwordHome;
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
    private final JTextField homePassword;
    private final JTextField homeDataNasterii;
    private final JTextField homeAdresa;
    private final JTextField homeFacultate;
    private final JLabel oraCreeazaCerere;
    private final JLabel locCreeazaCerere;
    private final JLabel pretCreeazaCerere;
    private final JButton trimiteRecenzie;
    private final String listaRecenzii[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
    StudentFrame() 
    {
        Login lg = new Login();
        lg.hide();
        frame = new JFrame("Student Frame");
        panel = new JPanel();
        frame.getContentPane();
        bunVenit = new JLabel("Welcome, Student");
        bunVenit.setFont(new Font("Serif", Font.BOLD, 30));
        bunVenit.setSize(300, 40);
        bunVenit.setLocation(500, 200);
        panel.add(bunVenit);
        
        informatii = new JLabel("You are on the Student Page!");
        informatii.setFont(new Font("Serif", Font.PLAIN, 30));
        informatii.setSize(500, 40);
        informatii.setLocation(380, 230);
        panel.add(informatii);
        
        JButton logOut = new JButton("Log Out");
        Dimension size = logOut.getPreferredSize();
        logOut.setBounds(1, 560, 150, 100);
        panel.add(logOut);
        
        JButton recenzii = new JButton("Your Reviews");
        recenzii.setBounds(1, 460, 150, 100);
        panel.add(recenzii);

        
        JButton creeazaRecenzii = new JButton("Leave a Review");
        creeazaRecenzii.setBounds(1, 360, 150, 100);
        panel.add(creeazaRecenzii);
        
        JButton sedinte = new JButton("Sessions");
        sedinte.setBounds(1, 260, 150, 100);
        panel.add(sedinte);
        
        JButton creeazaCerere = new JButton("Create Request");
        creeazaCerere.setBounds(1, 160, 150, 100);
        panel.add(creeazaCerere);
        
        
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
        frame.setTitle("Student Page");
      
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            logOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                frame.dispose();
                new Login();
            }});
        
        
        JButton stergeSedinta = new JButton("Delete");
        stergeSedinta.setBounds(810, 590, 100, 40);
        stergeSedinta.setFont(new Font("Sans", Font.BOLD, 20));
        panel.add(stergeSedinta);
        
        titluCreeazaCerere = new JLabel("Create Request");
        titluCreeazaCerere.setFont(new Font("Serif", Font.BOLD, 30));
        titluCreeazaCerere.setSize(500, 40);
        titluCreeazaCerere.setLocation(470, 100);
        panel.add(titluCreeazaCerere);
        
        nume = new JLabel("Name:");
        nume.setFont(new Font("Serif", Font.BOLD, 30));
        nume.setSize(300, 40);
        nume.setLocation(300, 190);
        panel.add(nume);
        
        materie = new JLabel("Discipline:");
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
        materiiBox.setLocation(440, 260);
        panel.add(materiiBox);
        
        dataText = new JLabel("Date:");
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
        
        passwordHome = new JLabel("Password:");
        passwordHome.setFont(new Font("Serif", Font.BOLD, 30));
        passwordHome.setSize(300, 40);
        passwordHome.setLocation(300, 250);
        panel.add(passwordHome);
    
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
        
        facultateHome = new JLabel("Faculty:");
        facultateHome.setFont(new Font("Serif", Font.BOLD, 30));
        facultateHome.setSize(300, 40);
        facultateHome.setLocation(300, 400);
        panel.add(facultateHome);
        

        
        
        creeazaRecenzie = new JLabel("Create Review");
        creeazaRecenzie.setFont(new Font("Serif", Font.BOLD, 30));
        creeazaRecenzie.setSize(500, 40);
        creeazaRecenzie.setLocation(470, 100);
        panel.add(creeazaRecenzie);
        
        nota = new JLabel("Rating");
        nota.setFont(new Font("Serif", Font.BOLD, 30));
        nota.setSize(500, 40);
        nota.setLocation(300, 200);
        panel.add(nota);
        
        notaBox = new JComboBox(note);
        notaBox.setFont(new Font("Arial", Font.BOLD, 20));
        notaBox.setSize(275, 30);
        notaBox.setLocation(435, 208);
        panel.add(notaBox);
        
        materieRecenzie = new JLabel("Discipline");
        materieRecenzie.setFont(new Font("Serif", Font.BOLD, 30));
        materieRecenzie.setSize(500, 40);
        materieRecenzie.setLocation(300, 250);
        panel.add(materieRecenzie);
        
        materieBox = new JComboBox(materii);
        materieBox.setFont(new Font("Arial", Font.BOLD, 20));
        materieBox.setSize(275, 30);
        materieBox.setLocation(435, 258);
        panel.add(materieBox);
        
        recenzie = new JLabel("Your comment");
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
        homeNume.setFont(new Font("Serif", Font.BOLD, 20));
        homeNume.setSize(250, 40);
        homeNume.setLocation(490, 205);
        panel.add(homeNume);
        homeNume.setEnabled(false);
        
        homePassword = new JTextField();
        homePassword.setFont(new Font("Serif", Font.BOLD, 20));
        homePassword.setSize(250, 40);
        homePassword.setLocation(490, 255);
        panel.add(homePassword);
        homePassword.setEnabled(false);
        
        homeDataNasterii = new JTextField();
        homeDataNasterii.setFont(new Font("Serif", Font.BOLD, 20));
        homeDataNasterii.setSize(250, 40);
        homeDataNasterii.setLocation(490, 305);
        panel.add(homeDataNasterii);
        homeDataNasterii.setEnabled(false);
        
        homeAdresa = new JTextField();
        homeAdresa.setFont(new Font("Serif", Font.BOLD, 20));
        homeAdresa.setSize(250, 40);
        homeAdresa.setLocation(490, 355);
        panel.add(homeAdresa);
        homeAdresa.setEnabled(false);
        
        homeFacultate = new JTextField();
        homeFacultate.setFont(new Font("Serif", Font.BOLD, 20));
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
       
        trimiteRecenzie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numeReviewer;
                String rating;
                String comment;
                String discipline;
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
            numeReviewer=username;
            rating=(String)notaBox.getSelectedItem();
            comment=trecenzie.getText();
            discipline=(String)materieBox.getSelectedItem();
            Review review = new Review(numeReviewer, rating, comment, discipline);
            RegisterReviews rr = new RegisterReviews();
            try{    
                rr.RegisterRev("Reviews.txt", review);
                JOptionPane.showMessageDialog(null, "Your review has been sent");
                trecenzie.setText("");
            }catch(IOException exc){
                exc.getMessage();
            }
            }
        });

        listaRec = new JList<String>(listaRecenzii);
        listaRec.setFont(new Font("Serif", Font.PLAIN, 15));
        listaRec.setSize(680, 350);
        listaRec.setLocation(230, 140);
        panel.add(listaRec);
        
        recenzii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
              int i=0;
                try{
                    reader = new BufferedReader(new FileReader("Reviews.txt"));
                    String[] split;
                    while ((line = reader.readLine()) != null) {  
                        split = line.split(",");
                        if(split[0].equals(username)){                     
                        listaRecenzii[i]=line;
                        i++;
                        }
                    }
                    }catch(IOException exc){
                        exc.getMessage();
                    }
            }
        });
        home.addActionListener(new ActionListener() {
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
                titluDatePersonale.show();
                numeHome.show();
                passwordHome.show();
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
                homePassword.show();
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
                homePassword.setText(password);
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
                homePassword.setEnabled(true);
                homeAdresa.setEnabled(true);
                homeDataNasterii.setEnabled(true);
                homeFacultate.setEnabled(true);
            }
        });

        creeazaCerere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bunVenit.hide();
                informatii.hide();
                stergeSedinta.hide();
                materiiBox.show();
                tnume.show();
                send.show();
                materie.show();
                nume.show();
                dataText.show();
                date.show();
                month.show();
                year.show();
                titluCreeazaCerere.show();
                listaSed.hide();
                numeHome.hide();
                titluDatePersonale.hide();
                passwordHome.hide();
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
                homePassword.hide();
                homeDataNasterii.hide();
                homeAdresa.hide();
                homeFacultate.hide();
                modificaHome.hide();
                salveazaButtonHome.hide();
                locCreeazaCerere.show();
                oraCreeazaCerere.show();
                pretCreeazaCerere.show();
                oraBox.show();
                minuteBox.show();
                locBox.show();
                pretBox.show();
                trimiteRecenzie.hide();
                listaRec.hide();
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
            tnume.setText(username);
            tnume.setEnabled(false);
            }
        });
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name;
                String discipline;
                String date1;
                String time;
                String place;
                String price;
                Boolean isAccepted=false;
                name=tnume.getText();
                discipline=(String)materiiBox.getSelectedItem();
                date1= (String)date.getSelectedItem()+"/"+(String)month.getSelectedItem()+"/"+(String)year.getSelectedItem();
                time=(String)oraBox.getSelectedItem()+":"+(String)minuteBox.getSelectedItem();
                place=(String)locBox.getSelectedItem();
                price=(String)pretBox.getSelectedItem();
                Request req = new Request(name,discipline,date1,time,place,price,isAccepted);
                RegisterRequests rg = new RegisterRequests();
                try{
                    rg.registerRequest("Requests.txt",req);
                    JOptionPane.showMessageDialog(null, "Your request has been sent succesfully");
                    tnume.setText("");
                }catch(IOException ee){
                    JOptionPane.showMessageDialog(null, ee);
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
                passwordHome.hide();
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
                homePassword.hide();
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
        
        creeazaRecenzii.addActionListener(new ActionListener() {
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
                passwordHome.hide();
                adresaHome.hide();
                dataNasteriiHome.hide();
                facultateHome.hide();
                creeazaRecenzie.show();
                nota.show();
                notaBox.show();
                materieRecenzie.show();
                materieBox.show();
                recenzie.show();
                trecenzie.show();
                trecenziileTale.hide();
                homeNume.hide();
                homePassword.hide();
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
                trimiteRecenzie.show();
                listaRec.hide();
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
                passwordHome.hide();
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
                homePassword.hide();
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
            }
        
        });
               
        stergeSedinta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
            
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
        passwordHome.hide();
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
        homePassword.hide();
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
    }
    
}