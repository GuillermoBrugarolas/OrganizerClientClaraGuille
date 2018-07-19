package view;

import javax.swing.*;
import java.awt.*;

public class Elimina extends JFrame {


    public Elimina() {

        setTitle("Eliminar");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(450, 200);

        setLayout( new BorderLayout());

        ImageIcon myImage = new ImageIcon("Elimina.png");


        // Somewhere later in the code ...
        JLabel myLabel = new JLabel();
        myLabel.setIcon(myImage);

        JLabel jlError = new JLabel(" Segur que ho vols eliminar ?", SwingConstants.CENTER);
        add(jlError, BorderLayout.CENTER);
        add(myLabel, BorderLayout.WEST);

    }
    public static void main(String[] args) {

        Elimina error= new Elimina();
        error.setVisible(true);
        //c.setVisible(true);
    }
}
