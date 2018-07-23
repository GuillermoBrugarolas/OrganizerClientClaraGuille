package view;

import controller.NewProjectController;
import controller.ProjectViewController;
import model.Task;
import model.User;

import javax.swing.*;
import java.awt.*;

public class NewTaskView extends JFrame {

    private JTextField jtfNom;
    private JComboBox<String> jcbEtiqueta;
    private JComboBox<String> jcbUser;
    private JSpinner jsPos;
    private JButton jbUpdate;
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
        this.jtfNom= new JTextField();
        JLabel jlOrdre = new JLabel("Column:");
        SpinnerNumberModel jsPosicio = new SpinnerNumberModel(1,1, 3,1);
        this.jsPos= new JSpinner(jsPosicio);
        JLabel jlDescripcio= new JLabel("Description:");
        jpNorth.add(jlNom);
        jpNorth.add(this.jtfNom);
        jpNorth.add(jlOrdre);
        jpNorth.add(this.jsPos);
        jpNorth.add(jlDescripcio);
        jpNorth.setSize(600,200);
        jpGeneral.add(jpNorth);

        JPanel jpCentre= new JPanel();
        this.jtDescripcio= new JTextArea();
        jpCentre.setSize(600,30);
        jpGeneral.add(this.jtDescripcio);

        JPanel jpEtiqueta = new JPanel(new GridLayout(1,2));
        JLabel jlEtiqueta = new JLabel("Tag:");
        String[] infoCombo = {"Minor", "Moderate", "Important", "Urgent", "Critical"};
        this.jcbEtiqueta = new JComboBox<>(infoCombo);
        jpEtiqueta.add(jlEtiqueta);
        jpEtiqueta.add(this.jcbEtiqueta);
        jpGeneral.add(jpEtiqueta);

        JPanel jpUser= new JPanel(new GridLayout(1,2));
        JLabel jlUsuari=new JLabel("User in charge:");
        this.jcbUser = new JComboBox<String>();
        jpUser.add(jlUsuari);
        jpUser.add(this.jcbUser);
        jpGeneral.add(jpUser);

        JPanel jpBotton = new JPanel(new GridLayout(1, 3));
        this.jbUpdate = new JButton("Update Task");
        this.jbUpdate.setEnabled(false);
        this.jbAddTask = new JButton("Add Task");
        this.jbCancel = new JButton("Cancel");
        this.jbUpdate.setSize(200, 50);
        this.jbAddTask.setSize(200,50);
        this.jbCancel.setSize(200,50);
        jpBotton.add(this.jbUpdate);
        jpBotton.add(this.jbAddTask);
        jpBotton.add(this.jbCancel);
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

    public void registerController2(ProjectViewController c){
        jbAddTask.setActionCommand("Afegir Tasca NovaTasca");
        jbAddTask.addActionListener(c);
        jbCancel.setActionCommand("Cancelar NovaTasca");
        jbCancel.addActionListener(c);
    }

    public void registerController3(ProjectViewController c){
        jbUpdate.setActionCommand("Actualitzar Tasca");
        jbUpdate.addActionListener(c);
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

    public void loadCurrentState(Task tt){
        this.jbUpdate.setEnabled(true);
        this.jbAddTask.setEnabled(false);
        this.jtfNom.setText(tt.getName());
        this.jsPos.setValue(tt.getColumn());
        this.jtDescripcio.setText(tt.getDescription());
        this.jcbEtiqueta.setSelectedItem(tt.getTag().getName());
        this.jcbUser.setSelectedItem((String)tt.getUserAssigned().getNickname());
    }
}
