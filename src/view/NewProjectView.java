package view;

import controller.NewProjectController;
import controller.UserViewController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class NewProjectView extends JFrame {


    private LinkedList<User> usuaris= new LinkedList<>();
    private JComboBox<String> jcbMembres;
    private JButton jbAfegir;
    private JButton jbEditar;
    private JButton jbEliminar;
    private JButton jbDelete;
    private JButton jbMembre;
    private JList<String>  llista;
    private Button jbBack;
    private JComboBox jcColum;
    private JSpinner jsColumna;

    public NewProjectView() {

        setTitle("Dades Projecte");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 600);

        getContentPane().setLayout(new GridLayout(3,1));


        // Dades del nou Projecte
        JPanel jpDades = new JPanel(new GridLayout(2, 2));

        //Nom projecte
        JLabel jlNom = new JLabel("  Nom projecte: ");
        jtfNom = new JTextField();
        jpDades.setSize(700,50);
        jpDades.add(jlNom);
        jpDades.add(jtfNom);

        //Membres
        JLabel jlMembres = new JLabel("  Membres: ");
       // String  infoCombo = { "Usuari 1", "Usuari 2", "Usuari 3", "Usuari 4"};
        jcbMembres = new JComboBox();
        //jcbMembres.setPromptText("Nom del usuari o correu");
        jcbMembres.setEditable(true);
        jpDades.add(jlMembres);
        jpDades.add(jcbMembres);
        jpDades.setSize(600,20);
        add(jpDades,BorderLayout.NORTH);

        JPanel jpMembres= new JPanel();
        llista = new JList<String>();
        jpMembres.add(llista);

        add(jpMembres, BorderLayout.CENTER);

        JPanel jpInf = new JPanel(new GridLayout(6,1));

        //Botons Membres
        JPanel jpBoto = new JPanel(new GridLayout(1,2));
        jbMembre = new JButton("Afegir");
        jbDelete= new JButton("Eliminar");
        jpBoto.add(jbMembre);
        jpBoto.add(jbDelete);
        jpInf.add(jpBoto);

        //Columnes
        JPanel jpCol= new JPanel(new GridLayout(1,2));
        JLabel jlColum = new JLabel("Nº Columnes: ");
        //jcColum = new JComboBox();
        SpinnerNumberModel jsColum = new SpinnerNumberModel(1,1,100,1);

        jsColumna= new JSpinner(jsColum);
        //sColumna.addChangeListener(this);
        jpCol.add(jlColum);
        jpCol.add(jsColumna);
        jpInf.add(jpCol);

        //Background
        JPanel jpFons = new JPanel(new GridLayout(1,2));
        JLabel jlColor = new JLabel("Color fondo: ");
        jbBack= new Button("Background");
        jbBack.setBackground(Color.pink);


        jpFons.add(jlColor);
        jpFons.add(jbBack);
        jpInf.add(jpFons);

        //Etiqueta
        JPanel jpEtiqueta= new JPanel(new GridLayout(1,2));
        JLabel jlEtiqueta = new JLabel("Etiqueta: ");
        jpEtiqueta.add(jlEtiqueta);
        jpInf.add(jpEtiqueta);

        JPanel jpBotons = new JPanel(new GridLayout(1, 3));
        jbAfegir = new JButton("Afegir");
        jbEditar = new JButton("Editar");
        jbEliminar = new JButton("Eliminar");
        jbAfegir.setSize(10,50);
        jbEditar.setSize(10,50);
        jbEliminar.setSize(10,50);
        jpBotons.add(jbAfegir);
        jpBotons.add(jbEditar);
        jpBotons.add(jbEliminar);
        jpInf.add(jpBotons);


        //Boto Crear
        jbProjecte = new JButton("Crear Projecte");
        jpInf.add(jbProjecte);
        add(jpInf, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public JTextField getJtfNom() {
        return jtfNom;
    }

    public JSpinner getJsColumna() {
        return jsColumna;
    }

    private JTextField jtfNom;
    private JButton jbProjecte;

    public JComboBox<String> getJcbMembres() {
        return jcbMembres;
    }

    public void setJcbMembres(JComboBox<String> jcbMembres) {
        this.jcbMembres = jcbMembres;
    }

    public JList<String> getLlista() {
        return llista;
    }

    public void setLlista(JList<String> llista) {
        this.llista = llista;
    }

    public void addMemberToList(){
        //llista.add(jcbMembres.getSelectedItem().toString());
    }
    public void registerController(NewProjectController c){

        jbMembre.setActionCommand("Afegir Membre");
        jbMembre.addActionListener(c);
        jbDelete.setActionCommand("Eliminar Membre");
        jbDelete.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Etiqueta");
        jbEliminar.addActionListener(c);
        jbAfegir.setActionCommand("Afegir Etiqueta");
        jbAfegir.addActionListener(c);
        jbEditar.setActionCommand("Editar Etiqueta");
        jbEditar.addActionListener(c);
        jbProjecte.setActionCommand("Nou projecte");
        jbProjecte.addActionListener(c);
        jbBack.setActionCommand("Fondo");
        jbBack.addActionListener(c);
    }

}




    /*public void handle(ActionEvent e) {
                if (emailComboBox.getValue() != null &&
                    !emailComboBox.getValue().toString().isEmpty()){
                        notification.setText("Your message was successfully sent"
                            + " to " + address);

                            */


