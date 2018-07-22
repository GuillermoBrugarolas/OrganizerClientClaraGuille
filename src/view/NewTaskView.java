package view;

import controller.NewProjectController;
import model.User;

import javax.swing.*;
import java.awt.*;

public class NewTaskView extends JFrame {

    private JTextField jtfNom;
    private JComboBox<String> jcbEtiqueta;
    private JComboBox<String> jcbUser;
    private JSpinner jsPos;
    private JButton jbAddTask;
    private JButton jbCancel;
    private JTextArea jtDescripcio;

    private int columna = 1;


    public NewTaskView(){

        this.setTitle("New Task");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setSize(500, 400);
        this.getContentPane().setLayout(new FlowLayout());
        JPanel jpGeneral= new JPanel(new GridLayout(6,1));

        JPanel jpNorth = new JPanel(new GridLayout(3,2));
        JLabel jlNom= new JLabel("Task Name:");
        jtfNom= new JTextField();
        JLabel jlOrdre = new JLabel("Column:");
        SpinnerNumberModel jsPosicio = new SpinnerNumberModel(1,1, 3,1);
        jsPos= new JSpinner(jsPosicio);
        JLabel jlDescripcio= new JLabel("Description:");
        jpNorth.add(jlNom);
        jpNorth.add(jtfNom);
        jpNorth.add(jlOrdre);
        jpNorth.add(jsPos);
        jpNorth.add(jlDescripcio);
        jpNorth.setSize(600,200);
        jpGeneral.add(jpNorth);

        JPanel jpCentre= new JPanel();
        jtDescripcio= new JTextArea();
        jpCentre.setSize(600,30);
        jpGeneral.add(jtDescripcio);

        JPanel jpEtiqueta = new JPanel(new GridLayout(1,2));
        JLabel jlEtiqueta = new JLabel("Tag:");
        String[] infoCombo = {"Minor", "Moderate", "Important", "Urgent", "Critical"};
        jcbEtiqueta = new JComboBox<>(infoCombo);
        jpEtiqueta.add(jlEtiqueta);
        jpEtiqueta.add(jcbEtiqueta);
        jpGeneral.add(jpEtiqueta);

        JPanel jpUser= new JPanel(new GridLayout(1,2));
        JLabel jlUsuari=new JLabel("User in charge:");
        jcbUser = new JComboBox<String>();
        jpUser.add(jlUsuari);
        jpUser.add(jcbUser);
        jpGeneral.add(jpUser);

        JPanel jpBotton = new JPanel(new GridLayout(1, 2));
        jbAddTask = new JButton("Add Task");
        jbCancel = new JButton("Cancel");
        jbAddTask.setSize(200,50);
        jbCancel.setSize(200,50);
        jpBotton.add(jbAddTask);
        jpBotton.add(jbCancel);
        jpGeneral.add(jpBotton);

        this.add(jpGeneral);

    }

    public JTextField getJtfNom() {
        return jtfNom;
    }

    public JTextArea getJtDescripcio() {
        return jtDescripcio;
    }

    public JComboBox<String> getJcbEtiqueta() {
        return jcbEtiqueta;
    }

    public void setJcbEtiqueta(JComboBox<String> jcbEtiqueta) {
        this.jcbEtiqueta = jcbEtiqueta;
    }

    public JComboBox<String> getJcbUser() {
        return jcbUser;
    }

    public JSpinner getJsPos() {
        return jsPos;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void registerController(NewProjectController c){
        jbAddTask.setActionCommand("Afegir Tasca NovaTasca");
        jbAddTask.addActionListener(c);
        jbCancel.setActionCommand("Cancelar NovaTasca");
        jbCancel.addActionListener(c);
    }

    public void loadAllMembers(Object[] members){
        int len = members.length;
        User uu;
        int i;
        for (i = 0; i < len; i++){
            uu = (User)members[i];
            this.jcbUser.addItem(uu.getNickname());
        }
        this.setVisible(true);
    }
}
