package view;

import javax.swing.*;
import java.awt.*;

public class PantallaNovaTasca extends JFrame {

    private JTextField jtfNom;
    private JComboBox jcbEtiqueta;
    private JComboBox jcbUser;
    private JButton jbAfegirEt;
    private JButton jbEditarEt;
    private JButton jbEliminarEt;
    private JSpinner jsPos;
    private JButton jbAfegirUser;
    private JButton jbEliminarUser;
    private JButton jbEditarUser;
    private JTextArea jtDescripcio;



    private int posicio=1;


    public PantallaNovaTasca(){

        setTitle("PantallaNovaTasca");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 500);
        getContentPane().setLayout(new FlowLayout());
        JPanel jpGeneral= new JPanel(new GridLayout(6,1));



        JPanel jpNorth = new JPanel(new GridLayout(3,2));
        JLabel jlNom= new JLabel("Nom tasca: ");
        jtfNom= new JTextField("Nom");
        JLabel jlOrdre = new JLabel("Posició: ");
        SpinnerNumberModel jsPosicio = new SpinnerNumberModel(1,1,posicio,1);
        jsPos= new JSpinner(jsPosicio);
        JLabel jlDescripcio= new JLabel("Descripcio: ");
        jpNorth.add(jlNom);
        jpNorth.add(jtfNom);
        jpNorth.add(jlOrdre);
        jpNorth.add(jsPos);
        jpNorth.add(jlDescripcio);
        jpNorth.setSize(600,200);
        jpGeneral.add(jpNorth);

        JPanel jpCentre= new JPanel();
        jtDescripcio= new JTextArea();
        //jpCentre.add(jtDescripcio);
        jpCentre.setSize(600,30);
        jpGeneral.add(jtDescripcio);

        JPanel jpEtiqueta = new JPanel(new GridLayout(1,2));
        JLabel jlEtiqueta = new JLabel("Etiqueta: ");
        String [] infoCombo = { "Etiqueta 1", "Etiqueta 2", "Etiqueta 3", "Etiqueta 4"};
        jcbEtiqueta = new JComboBox(infoCombo);
        jpEtiqueta.add(jlEtiqueta);
        jpEtiqueta.add(jcbEtiqueta);
        jpGeneral.add(jpEtiqueta);

        JPanel jpBotons = new JPanel(new GridLayout(1, 3));
        jbAfegirEt = new JButton("Afegir");
        jbEditarEt = new JButton("Editar");
        jbEliminarEt = new JButton("Eliminar");
        jbAfegirEt.setSize(200,50);
        jbEditarEt.setSize(200,50);
        jbEliminarEt.setSize(200,50);
        jpBotons.add(jbAfegirEt);
        jpBotons.add(jbEditarEt);
        jpBotons.add(jbEliminarEt);
        jpGeneral.add(jpBotons);

        JPanel jpUser= new JPanel(new GridLayout(1,2));
        JLabel jlUsuari=new JLabel("Usuari: ");
        String [] infoUser = { "Usuari 1", "Usuari 2", "Usuari 3", "Usuari 4"};
        jcbUser = new JComboBox(infoUser);
        jpUser.add(jlUsuari);
        jpUser.add(jcbUser);
        jpGeneral.add(jpUser);

        JPanel jpBotton = new JPanel(new GridLayout(1, 3));
        jbAfegirUser = new JButton("Afegir");
        jbEditarUser = new JButton("Editar");
        jbEliminarUser = new JButton("Eliminar");
        jbAfegirUser.setSize(200,50);
        jbEditarUser.setSize(200,50);
        jbEliminarUser.setSize(200,50);
        jpBotton.add(jbAfegirUser);
        jpBotton.add(jbEditarUser);
        jpBotton.add(jbEliminarUser);
        jpGeneral.add(jpBotton);

        add(jpGeneral);

    }

    public JTextField getJtfNom() {
        return jtfNom;
    }

    public JTextArea getJtDescripcio() {
        return jtDescripcio;
    }

    public JComboBox getJcbEtiqueta() {
        return jcbEtiqueta;
    }

    public void setJcbEtiqueta(JComboBox jcbEtiqueta) {
        this.jcbEtiqueta = jcbEtiqueta;
    }

    public JComboBox getJcbUser() {
        return jcbUser;
    }

    public JSpinner getJsPos() {
        return jsPos;
    }

    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }

  /*  public void registerController(Controller c){
        jbAfegirEt.setActionCommand("Afegir Etiqueta");
        jbAfegirEt.addActionListener(c);
        jbEditarEt.setActionCommand("Editar Etiqueta");
        jbEditarEt.addActionListener(c);
        jbEliminarEt.setActionCommand("Eliminar Etiqueta");
        jbEliminarEt.addActionListener(c);
        jbAfegirUser.setActionCommand("Afegir Usuari");
        jbAfegirUser.addActionListener(c);
        jbEditarUser.setActionCommand("Editar Usuari");
        jbEditarUser.addActionListener(c);
        jbEliminarUser.setActionCommand("Eliminar Usuari");
        jbEliminarUser.addActionListener(c);

    }*/



    public static void main(String[] args) {

        PantallaNovaTasca vista = new PantallaNovaTasca();
        vista.setVisible(true);
    }
}
