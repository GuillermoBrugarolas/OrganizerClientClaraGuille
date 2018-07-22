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
    private JComboBox jcbBackgrounds;
    private JButton jbAfegir;
    private JButton jbEliminar;
    private JButton jbDelete;
    private JButton jbMembre;
    private JList<String>  llista;
    private JList tasks;
    private JButton jbBack;
    private JButton jbProjecte;
    private JTextField jtfMembre;
    private JTextField jtfNom;
    private JTextField jtfID;
    private JPanel jpColumns;
    private JLabel jlCol1;
    private JTextField jtfCol1;
    private JLabel jlCol2;
    private JTextField jtfCol2;
    private JLabel jlCol3;
    private JTextField jtfCol3;
    DefaultListModel<String> modelTasca;
    DefaultListModel<String> modelLlista;


    public NewProjectView() {

        this.setTitle("Dades Projecte");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 700);

        this.getContentPane().setLayout(new BorderLayout());


        // Dades del nou Projecte
        JPanel jp1= new JPanel(new GridLayout(2,1));
        jp1.setSize(400,80);
        JPanel jpNameIDProject = new JPanel(new GridLayout(2, 2));

        //Nom projecte
        JLabel jlNom = new JLabel("   Nom projecte:");
        jtfNom = new JTextField();
        jtfNom.setSize(30,10);
        jpNameIDProject.add(jlNom);
        jpNameIDProject.add(jtfNom);

        //ID projecte
        JLabel jlID = new JLabel("   ID projecte (2 dígits + 2 MAJÚS.):");
        jtfID = new JTextField();
        jtfID.setSize(30,10);
        jpNameIDProject.add(jlID);
        jpNameIDProject.add(jtfID);
        jp1.add(jpNameIDProject);

        //Membres
        JPanel jpUsers= new JPanel(new GridLayout(1,2));
        JLabel jlMembres = new JLabel("   Usuaris:");
        jcbMembres = new JComboBox<String>();
        jpUsers.add(jlMembres);
        jpUsers.add(jcbMembres);

        jp1.add(jpUsers);
        add(jp1,BorderLayout.NORTH);

        JPanel mig= new JPanel(new GridLayout(2,1));
        JPanel jp2= new JPanel(new BorderLayout());
        JPanel jpMembres= new JPanel(new BorderLayout());
        modelLlista = new DefaultListModel<String>();
        llista= new JList(modelLlista);
        llista.setBorder(BorderFactory.createTitledBorder("Compartir amb:"));

        jpMembres.add(llista);
        //jpMembres.setSize(10,5);
        jp2.add(jpMembres, BorderLayout.CENTER);

        //Back button
        jbBack = new JButton("Back");
        //Botons Membres
        JPanel jpBoto = new JPanel(new GridLayout(1,2));
        jbMembre = new JButton("Afegir");
        jbDelete= new JButton("Eliminar");
        jpBoto.add(jbMembre);
        jpBoto.add(jbDelete);
        jp2.add(jpBoto, BorderLayout.SOUTH);
        mig.add(jp2);

        JPanel jp3 = new JPanel(new BorderLayout());
        this.jpColumns = new JPanel();
        this.jpColumns.setBorder(BorderFactory.createTitledBorder("Columnes:"));
        this.jpColumns.setLayout(new GridLayout(3, 2));
        this.jlCol1 = new JLabel("   Nom 1a Columna:");
        this.jtfCol1 = new JTextField();
        this.jlCol2 = new JLabel("   Nom 2a Columna:");
        this.jtfCol2 = new JTextField();
        this.jlCol3 = new JLabel("   Nom 3a Columna:");
        this.jtfCol3 = new JTextField();
        this.jpColumns.add(jlCol1);
        this.jpColumns.add(jtfCol1);
        this.jpColumns.add(jlCol2);
        this.jpColumns.add(jtfCol2);
        this.jpColumns.add(jlCol3);
        this.jpColumns.add(jtfCol3);
        jp3.add(this.jpColumns, BorderLayout.NORTH);


        //Tasca

        JPanel jpTasca= new JPanel(new BorderLayout());
        modelTasca= new DefaultListModel<String>();
        tasks = new JList(modelTasca);
        tasks.setBorder(BorderFactory.createTitledBorder("Tasques:"));

        jpTasca.add(tasks);
        jp3.add(jpTasca,BorderLayout.CENTER);
        JPanel jpBotons = new JPanel(new GridLayout(1, 3));
        jbAfegir = new JButton("Afegir");
        jbEliminar = new JButton("Eliminar");
        jbAfegir.setSize(10,50);
        jbEliminar.setSize(10,50);
        jpBotons.add(jbAfegir);
        jpBotons.add(jbEliminar);
        jp3.add(jpBotons,BorderLayout.SOUTH);
        mig.add(jp3);
        this.add(mig,BorderLayout.CENTER);

        //Background
        JPanel jp4= new JPanel(new GridLayout(2,1));
        JPanel jpFons = new JPanel(new GridLayout(1,2));
        String[]  infoCombo = { "Acuarela", "Cielo", "Circuito", "Corcho", "Madera", "Pizarra", "Verdor"};
        jcbBackgrounds = new JComboBox(infoCombo);
        jcbBackgrounds.setEditable(true);
        JLabel jlFons = new JLabel("  Fons:");
        jpFons.add(jlFons);
        jpFons.add(jcbBackgrounds);
        jp4.add(jpFons);

        //Boto Crear
        jbProjecte = new JButton("CREAR PROJECTE");
        jbProjecte.setBackground(new Color(250, 250, 150));
        jp4.add(jbProjecte);
        this.add(jp4, BorderLayout.SOUTH);
        //add(jpInf, BorderLayout.SOUTH);
        this.setVisible(false);

    }

    public JTextField getJtfNom() {
        return jtfNom;
    }

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

    public void registerController(NewProjectController c){

        jbMembre.setActionCommand("Afegir Membre");
        jbMembre.addActionListener(c);
        jbDelete.setActionCommand("Eliminar Membre");
        jbDelete.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Tasca");
        jbEliminar.addActionListener(c);
        jbAfegir.setActionCommand("Afegir Tasca");
        jbAfegir.addActionListener(c);
        jbProjecte.setActionCommand("Nou projecte");
        jbProjecte.addActionListener(c);
        jbBack.setActionCommand("Fondo");
        jbBack.addActionListener(c);
    }

    public void loadAllUserNames(String[] userNameList, String dontInclude){
        int i;
        for (i = 0; i < userNameList.length; i++){
            if (!userNameList[i].equals(dontInclude)) {
                this.jcbMembres.addItem(userNameList[i]);
            }
        }
        this.setVisible(true);
    }

    public void addUser(){
        int pos = this.jcbMembres.getSelectedIndex();
        String userSelected = this.jcbMembres.getSelectedItem().toString();
        this.modelLlista.addElement(userSelected);
        this.jcbMembres.removeItemAt(pos);
    }

    public void deleteFromList(){
        int pos = this.llista.getSelectedIndex();
        String name = this.llista.getSelectedValue();
        this.jcbMembres.addItem(name);
        this.modelLlista.removeElementAt(pos);
    }

    public void makeDialog(String message, boolean type) {
        if (type) {
            Dialog.DialogOK(message);
        } else {
            Dialog.DialogKO(message);
        }
    }

    public LinkedList<User> getAddedMembers(){
        LinkedList<User> added = new LinkedList<User>();
        User uu = new User();
        int h, j;
        j = modelLlista.size();
        for (h = 0; h < j; h++){
            uu.setNickname(modelLlista.get(h));
            added.add(uu);
        }
        return added;
    }

    public String getColumnOne(){
        return this.jtfCol1.getText();
    }

    public String getColumnTwo(){
        return this.jtfCol2.getText();
    }

    public String getColumnThree(){
        return this.jtfCol3.getText();
    }

    public boolean checkColumnNamesFilled(){
        return !(((this.jtfCol1.getText().isEmpty()) || (this.jtfCol1.getText().equals("")) || (this.jtfCol1.getText().equals(null)))
                || ((this.jtfCol2.getText().isEmpty()) || (this.jtfCol2.getText().equals("")) || (this.jtfCol2.getText().equals(null)))
                || ((this.jtfCol3.getText().isEmpty()) || (this.jtfCol3.getText().equals("")) || (this.jtfCol3.getText().equals(null))));
    }

    public boolean checkAllFilled(){
        if (!checkColumnNamesFilled()){
            return false;
        }
        if ((this.jtfNom.getText().equals(""))||(this.jtfNom.getText().isEmpty())){
            return false;
        }
        if ((this.jtfID.getText().equals("")) || (this.jtfID.getText().length() != 4) || (!this.jtfID.getText().matches("[A-Za-z0-9]+"))){
            return false;
        }
        if ((!checkMemberListFilled()) || (!checkTaskListFilled())){
            return false;
        }
        return true;
    }

    public String getNewProjectName(){
        return this.jtfNom.getText();
    }

    public String getNewProjectID(){
        return this.jtfID.getText();
    }

    public String getNewProjectBackground(){
        return this.jcbBackgrounds.getSelectedItem().toString();
    }

    public void addTask(Task task){
        String taskString = task.toString();
        this.modelTasca.addElement(taskString);
    }

    public String getSelectedTask(){
        return (this.tasks.getSelectedValue().toString());
    }

    public void deleteTaskFromList(){
        int i = this.tasks.getSelectedIndex();
        this.modelTasca.removeElementAt(i);
    }

    public String getSelectedUser(){
        return (this.jcbMembres.getSelectedItem().toString());
    }

    public String getSelectedMember(){
        return (this.llista.getSelectedValue());
    }

    public boolean checkMemberListFilled(){
        return (this.modelLlista.getSize() > 0);
    }

    public boolean checkTaskListFilled(){
        return (this.modelTasca.getSize() > 0);
    }
}