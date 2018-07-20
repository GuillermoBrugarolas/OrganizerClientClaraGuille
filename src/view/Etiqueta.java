package view;

import javax.swing.*;
import java.awt.*;

public class Etiqueta extends JFrame {

    JTextField jtfNom;
    Button jbColor;

    public Etiqueta(){

        setTitle("Benvinguts al Organizer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,100);
        setLayout(new FlowLayout());
        JPanel jpTotal= new JPanel(new GridLayout(2,2));



        JLabel jlNom= new JLabel("Nom etiqueta: ");
        jtfNom= new JTextField();
        JLabel jlColor= new JLabel("Color etiqueta: ");
        jbColor = new Button("Selecciona un color");
        jbColor.setBackground(Color.YELLOW);

        jpTotal.add(jlNom);
        jpTotal.add(jtfNom);
        jpTotal.add(jlColor);
        jpTotal.add(jbColor);

        add(jpTotal, BorderLayout.CENTER);

       // ColorChooser colorEtiqeta = new ColorChooser();


    }

//    public static void main(String[] args) {
//
//        Etiqueta vista = new Etiqueta();
//        vista.setVisible(true);
//    }
}
