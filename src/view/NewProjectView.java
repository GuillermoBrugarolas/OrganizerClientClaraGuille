package view;

import controller.NewProjectController;
import model.Task;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class NewProjectView extends JFrame {


    private LinkedList<User> usuaris= new LinkedList<>();
    private LinkedList<Task> tasques= new LinkedList<>();
    private JComboBox<String> jcbMembres;
    private JButton jbAfegir;
    private JButton jbEditar;
    private JButton jbEliminar;
    private JButton jbDelete;
    private JButton jbMembre;
    private JList<String>  llista;
    private JList<String>  tasks;
    private Button jbBack;
    private JComboBox jcColum;
    private JSpinner jsColumna;
    private JTextField jtfMembre;


    public NewProjectView() {

        setTitle("Dades Projecte");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 400);

        getContentPane().setLayout(new BorderLayout());


        // Dades del nou Projecte
        JPanel jp1= new JPanel(new GridLayout(2,1));
        jp1.setSize(400,80);
        JPanel jpNameProject = new JPanel(new GridLayout(1, 2));

        //Nom projecte
        JLabel jlNom = new JLabel("  Nom projecte: ");
        jtfNom = new JTextField();
        jtfNom.setSize(30,10);
        jpNameProject.add(jlNom);
        jpNameProject.add(jtfNom);
        jp1.add(jpNameProject);

        //Membres
        JPanel jpUsers= new JPanel(new GridLayout(1,2));
        JLabel jlMembres = new JLabel("  Usuaris: ");
        jtfMembre = new JTextField();
        //jtfMembre.setSize(10,5);
        jpUsers.add(jlMembres);
        jpUsers.add(jtfMembre);

        jp1.add(jpUsers);
        add(jp1,BorderLayout.NORTH);

        JPanel mig= new JPanel(new GridLayout(2,1));
        JPanel jp2= new JPanel(new BorderLayout());
        JPanel jpMembres= new JPanel(new BorderLayout());
        DefaultListModel<String> model= new DefaultListModel<>();
        llista= new JList(model);
        llista.setBorder(BorderFactory.createTitledBorder("Compartir amb... "));

        for(User u: usuaris){
            model.addElement(u.getNickname());
        }
        jpMembres.add(llista);
        //jpMembres.setSize(10,5);
        jp2.add(jpMembres, BorderLayout.CENTER);

        //JPanel jpInf = new JPanel(new GridLayout(6,1));

        //Botons Membres
        JPanel jpBoto = new JPanel(new GridLayout(1,2));
        jbMembre = new JButton("Afegir");
        jbDelete= new JButton("Eliminar");
        jpBoto.add(jbMembre);
        jpBoto.add(jbDelete);
        jp2.add(jpBoto, BorderLayout.SOUTH);
        mig.add(jp2);


        /*Columnes
        JPanel jpCol= new JPanel(new GridLayout(1,2));
        JLabel jlColum = new JLabel("Nº Columnes: ");
        SpinnerNumberModel jsColum = new SpinnerNumberModel(1,1,3,1);
        jsColumna= new JSpinner(jsColum);
        jpCol.add(jlColum);
        jpCol.add(jsColumna);
        jpInf.add(jpCol);*/


        JPanel jp3= new JPanel(new BorderLayout());

        //Etiqueta

        JPanel jpTasca= new JPanel(new BorderLayout());
        DefaultListModel<String> modelTasca= new DefaultListModel<>();
        tasks= new JList(modelTasca);
        tasks.setBorder(BorderFactory.createTitledBorder("Tasques: "));

        for(Task t: tasques){
            modelTasca.addElement(t.getName());
        }

        jpTasca.add(tasks);
        jp3.add(jpTasca,BorderLayout.CENTER);
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
        jp3.add(jpBotons,BorderLayout.SOUTH);
        mig.add(jp3);
        add(mig,BorderLayout.CENTER);

        //Background
        JPanel jp4= new JPanel(new GridLayout(2,1));
        JPanel jpFons = new JPanel(new GridLayout(1,2));
        String[]  infoCombo = { "Acuarela", "Cielo", "Circuito", "Corcho", "Madera", "Pizarra", "Verdor"};
        jcbMembres = new JComboBox(infoCombo);
        //jcbMembres.setPromptText("Nom del usuari o correu");
        jcbMembres.setEditable(true);
        jpFons.add(jcbMembres);
        jp4.add(jpFons);

        //Boto Crear
        jbProjecte = new JButton("Crear Projecte");
        jp4.add(jbProjecte);
        add(jp4, BorderLayout.SOUTH);
        //add(jpInf, BorderLayout.SOUTH);
        //this.setVisible(true);

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

    public static void main(String[] args) {

        NewProjectView vista = new NewProjectView();
        vista.setVisible(true);
    }
}




    /*public void handle(ActionEvent e) {
                if (emailComboBox.getValue() != null &&
                    !emailComboBox.getValue().toString().isEmpty()){
                        notification.setText("Your message was successfully sent"
                            + " to " + address);

                            */


