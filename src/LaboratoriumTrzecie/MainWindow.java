package LaboratoriumTrzecie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JLabel jLabel;
    //private JLabel sprawdzenieLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextArea textArea;
    private boolean justif = false;
    private String justification="Justuj tekst";

    public MainWindow() {
        int buttonW1=150, buttonW2=125, buttonH1=25, buttonH2=30; //szerokosci i wysokosci przyciskow
        setTitle("GUI w Swing - zadania 1-3");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(); //na nim sa wszystkie przyciski
        mainPanel.setLayout(null); //dzieki temu dziala setBounds()
        add(mainPanel);

        //wiadomość powitalna
        jLabel = new JLabel("Witaj!");
        jLabel.setBounds(20, 15, 300, 25);

        mainPanel.add(jLabel);

        /*sprawdzenieLabel = new JLabel("Żegnaj!");
        sprawdzenieLabel.setBounds(20, 15, 300, 25);
        sprawdzenieLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(sprawdzenieLabel);*/

        JButton askNameButton = new JButton("Wprowadz imię.");
        askNameButton.setBounds(325, 15, 150, 25);
        mainPanel.add(askNameButton);

        // etykieta przy textfildzie
        JLabel textLabel = new JLabel("Pole do tekstu:");
        textLabel.setBounds(20, 60, 100, 25);
        mainPanel.add(textLabel);

        //pole tekstowe
        textField = new JTextField();
        textField.setBounds(20, 90, 150, 25);
        mainPanel.add(textField);

        //etykieta do hasla
        JLabel passLabel = new JLabel("Wpisz hasło:");
        passLabel.setBounds(20, 115, 100, 25);
        mainPanel.add(passLabel);

        //haslo
        passwordField = new JPasswordField();
        passwordField.setBounds(20, 145, 150, 25);
        mainPanel.add(passwordField);

        //sila hasla
        JButton checkStrengthButton = new JButton("Sprawdź siłę");
        checkStrengthButton.setBounds(20, 180, 150, 25);
        mainPanel.add(checkStrengthButton);

        JButton showButton = new JButton("Wyświetl dane");
        showButton.setBounds(290, 200, 150, 25);
        mainPanel.add(showButton);

        //dokladnie tu sa wyswietlane dane
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(200, 60, 240, 120);
        mainPanel.add(scrollPane);


        //etykieta do settingsow
        JLabel settLabel = new JLabel("Zarządzaj GUI:");
        settLabel.setBounds(20, 270, 150, 25);
        mainPanel.add(settLabel);

        JButton colorButton = new JButton("Zmień kolor tła");
        colorButton.setBounds(20, 310, 125, 30);
        mainPanel.add(colorButton);

        JButton sizeButton = new JButton("Zmień rozmiar");
        sizeButton.setBounds(500-20-125-125-42-8, 310, 125, 30);
        mainPanel.add(sizeButton);

        JButton moveButton = new JButton(justification);
        moveButton.setBounds(500-20-125-15, 310, 125, 30);
        mainPanel.add(moveButton);

        //akcje
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textField.getText();
                String haslo = new String(passwordField.getPassword());
                textArea.append("tekst: " + tekst + "\nhasło: " + haslo + "\n");
            }
        });

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color wybranyKolor = JColorChooser.showDialog(
                        MainWindow.this,
                        "Wybierz nowy kolor tła",
                        mainPanel.getBackground()
                );
                if (wybranyKolor != null) {
                    mainPanel.setBackground(wybranyKolor);
                }
            }
        });

        sizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int widthRightNow = askNameButton.getWidth();
                if(widthRightNow==buttonW1) {
                    askNameButton.setSize(buttonW2, buttonH2);
                    showButton.setSize(buttonW2, buttonH2);
                    checkStrengthButton.setSize(buttonW2, buttonH2);
                    colorButton.setSize(buttonW1, buttonH1);
                    sizeButton.setSize(buttonW1, buttonH1);
                    moveButton.setSize(buttonW1, buttonH1);
                }
                else {
                    askNameButton.setSize(buttonW1, buttonH1);
                    showButton.setSize(buttonW1, buttonH1);
                    checkStrengthButton.setSize(buttonW1, buttonH1);
                    colorButton.setSize(buttonW2, buttonH2);
                    sizeButton.setSize(buttonW2, buttonH2);
                    moveButton.setSize(buttonW2, buttonH2);
                }

            }
        });


        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x_dobrane1=40, x_dobrane2=180;
                if(justif) {
                    Point position1 = textLabel.getLocation();
                    textLabel.setLocation(position1.x - x_dobrane1+10, position1.y);
                    Point position2 = passLabel.getLocation();
                    passLabel.setLocation(position2.x - x_dobrane1, position2.y);
                    Point position3 = settLabel.getLocation();
                    settLabel.setLocation(position3.x - x_dobrane2, position3.y);
                    justif=false;
                    moveButton.setText("Justuj");
                }
                else {
                    Point position1 = textLabel.getLocation();
                    textLabel.setLocation(position1.x + x_dobrane1-10, position1.y);
                    Point position2 = passLabel.getLocation();
                    passLabel.setLocation(position2.x + x_dobrane1, position2.y);
                    Point position3 = settLabel.getLocation();
                    settLabel.setLocation(position3.x + x_dobrane2, position3.y);
                    justif=true;
                    moveButton.setText("Przesuń w lewo");
                }
            }
        });
        checkStrengthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String haslo = new String(passwordField.getPassword());

                int criteria = 0;

                //zgodnie z zaleceniami:
                //długość minimum 8 znaków
                if (haslo.length() >= 8) criteria++;
                //zawiera małą literę
                if (haslo.matches(".*[a-z].*")) criteria++; //.* dowolna liczba znakow przed [
                //zawiera wielką literę
                if (haslo.matches(".*[A-Z].*")) criteria++; //[...] -- dokladnie jeden znak z zakresu[...]
                //zawiera cyfrę
                if (haslo.matches(".*[0-9].*")) criteria++;
                //zawiera znak specjalny (np !@#$%^&*)
                if (haslo.matches(".*[^a-zA-Z0-9].*")) criteria++;


                if (haslo.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            MainWindow.this,
                            "Prosze podac najpierw hasło.",
                            "Błąd",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                if (criteria <= 2) {
                    JOptionPane.showMessageDialog(
                            MainWindow.this,
                            "Siła hasła: SŁABE (" + criteria + "/5)",
                            "Siła hasła",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (criteria <= 4) {
                    JOptionPane.showMessageDialog(
                             MainWindow.this,
                            "Siła hasła: ŚREDNIE (" + criteria + "/5)",
                            "Siła hasła",
                            JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            MainWindow.this,
                            "Siła hasła: SILNE (" + criteria + "/5)",
                            "Siła hasła",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        askNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                askAboutName();
            }
        });
    }

    private void askAboutName() {
        String name = JOptionPane.showInputDialog(
                this, //mozna dac null, aby bylo na srodku
                "Proszę podać imię:",
                "Welcome to my GUI",
                JOptionPane.QUESTION_MESSAGE
        );

        if (name != null && !name.trim().isEmpty()) { //trim - usuwanie bialych znakow
            jLabel.setText("Witaj, " + name.trim() + "!");
        }
    }

    public static void main(String[] args) {
        //EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow app = new MainWindow();
                app.setVisible(true);
                //wywolanie okna z prosba o wypisanie imienia odrazu:
                app.askAboutName();
            }
        });
    }
}