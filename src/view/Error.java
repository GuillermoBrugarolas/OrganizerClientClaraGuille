package view;

import javax.swing.*;
import java.awt.*;

public class Error extends JFrame{



    public Error() {

        setTitle("ERROR!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(450, 200);

        setLayout( new BorderLayout());

        ImageIcon myImage = new ImageIcon("Imagen 1.png");

        // Somewhere later in the code ...
        JLabel myLabel = new JLabel();
        myLabel.setIcon(myImage);

        JLabel jlError = new JLabel("Les credencials introduïdes són incorrectes !", SwingConstants.CENTER);
        add(jlError, BorderLayout.CENTER);
        add(myLabel, BorderLayout.WEST);

    }
    public static void main(String[] args) {

        Error error= new Error();
        error.setVisible(true);
        //c.setVisible(true);
    }

}
