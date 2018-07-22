package view;

import controller.UserViewController;
import model.Project;
import model.User;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame{

    private JButton jbProjecte;
    private JButton jbEditar;
    private JButton jbEliminar;
    private JList<Project> listLeft;
    private JList<Project> listRight;
    private JTextField jtfId;
    private JButton jbId;
    private JButton jbTancar;
    private JLabel jlNomUsuari;


    public UserView(){

        setTitle("Benvinguts al Organizer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,600);

        JPanel jpProjecte= new JPanel(new GridLayout(1,2));
        JPanel jpMeu = new JPanel(new BorderLayout());

        jlNomUsuari= new JLabel("Nom Usuari");
        jlNomUsuari.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        jpMeu.add(jlNomUsuari, BorderLayout.NORTH);

        listLeft= new JList<Project>();
        listLeft.setBorder(BorderFactory.createTitledBorder("Els meus projectes: "));

        JPanel jpBotons = new JPanel(new GridLayout(1,2));
        jbEditar= new JButton("Editar");
        jbEditar.setBackground(new Color(250, 250, 100));
        jbEliminar = new JButton("Eliminar");
        jbEliminar.setBackground(new Color(250, 250, 100));
        jpBotons.add(jbEditar);
        jpBotons.add(jbEliminar);
        jpMeu.add(listLeft);
        //jpMeu.add(jspProject);
        jpMeu.add(jpBotons, BorderLayout.SOUTH);


        JPanel jpCompartit= new JPanel(new BorderLayout());
        JPanel jpSearch= new JPanel(new GridLayout(1,3));
        jbId= new JButton("Join");
        jpSearch.add(new JLabel(" ID Project:"));
        jtfId= new JTextField();
        jpSearch.add(jtfId);
        jpSearch.add(jbId);
        jbProjecte= new JButton("Nou Projecte");
        jbProjecte.setBackground(new Color(250, 250, 100));
        jpCompartit.add(jpSearch, BorderLayout.NORTH);
        listRight = new JList<Project>();
        listRight.setBorder(BorderFactory.createTitledBorder("Projectes compartits:"));
        jpCompartit.add(listRight);
        JPanel jpProjectancar = new JPanel();
        this.jbTancar = new JButton("Tancar Sessió");
        this.jbTancar.setBackground(new Color(150, 150, 150));
        jpProjectancar.add(this.jbProjecte);
        jpProjectancar.add(this.jbTancar);
        jpCompartit.add(jpProjectancar, BorderLayout.SOUTH);
        jpProjecte.add(jpMeu);
        jpProjecte.add(jpCompartit);
        add(jpProjecte);
        this.setLocationRelativeTo(null);
        this.setVisible(false);

    }

    public void removeObjectLeft(ProjectView projectView){

        remove(projectView);
    }


    public void registerController(UserViewController c){
        jbProjecte.setActionCommand("Nou Projecte");
        jbProjecte.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Projecte");
        jbEliminar.addActionListener(c);
        jbEditar.setActionCommand("Editar Projecte");
        jbEditar.addActionListener(c);
        jbId.setActionCommand("Join Project");
        jbId.addActionListener(c);
        jbTancar.setActionCommand("Tancar Sessió");
        jbTancar.addActionListener(c);
    }

    public void loadUserData(User u){
        int w, v;
        System.out.println(u.getNickname());
        System.out.println(u.getEmail());
        System.out.println(u.getPassword());
        jlNomUsuari.setText(u.getNickname());
        Object[] ownList = u.getOwnProjects().toArray();
        Object[] joinedList = u.getJoinedProjects().toArray();
        Project[] ownPs = new Project[ownList.length];
        Project[] joinedPs = new Project[joinedList.length];

        joinedList = u.getJoinedProjects().toArray();
        for (w = 0; w < ownList.length; w++){
            ownPs[w] = (Project)ownList[w];
        }
        for (v = 0; v < joinedList.length; v++){
            joinedPs[v] = (Project)joinedList[v];
        }
        this.listLeft.setListData(ownPs);
        this.listRight.setListData(joinedPs);
        this.setVisible(true);
    }

    public void makeDialog(String message, boolean type){
        if(type){
            Dialog.DialogOK(message);
        }else{
            Dialog.DialogKO(message);
        }
    }

    public JButton getJbProjecte() {
        return jbProjecte;
    }

    public void setJbProjecte(JButton jbProjecte) {
        this.jbProjecte = jbProjecte;
    }

    public JButton getJbEditar() {
        return jbEditar;
    }

    public void setJbEditar(JButton jbEditar) {
        this.jbEditar = jbEditar;
    }

    public JButton getJbEliminar() {
        return jbEliminar;
    }

    public void setJbEliminar(JButton jbEliminar) {
        this.jbEliminar = jbEliminar;
    }

    public JList<Project> getListLeft() {
        return listLeft;
    }

    public void setListLeft(JList<Project> listLeft) {
        this.listLeft = listLeft;
    }

    public JList<Project> getListRight() {
        return listRight;
    }

    public void setListRight(JList<Project> listRight) {
        this.listRight = listRight;
    }

    public JTextField getJtfId() {
        return jtfId;
    }

    public void setJtfId(JTextField jtfId) {
        this.jtfId = jtfId;
    }

    public JButton getJbId() {
        return jbId;
    }

    public void setJbId(JButton jbId) {
        this.jbId = jbId;
    }

    public JLabel getJlNomUsuari() {
        return jlNomUsuari;
    }

    public void setJlNomUsuari(JLabel jlNomUsuari) {
        this.jlNomUsuari = jlNomUsuari;
    }

    public boolean checkOwnProjSelected(){
        return !this.listLeft.isSelectionEmpty();
    }

    public boolean checkJoinedProjSelected(){
        return !this.listRight.isSelectionEmpty();
    }

    public Project getSelectedOwnProj(){
        return (this.listLeft.getSelectedValue());
    }

    public Project getSelectedJoinedProj(){
        return (this.listRight.getSelectedValue());
    }

    public void deleteProject(){
        DefaultListModel dlm = (DefaultListModel)this.listLeft.getModel();
        dlm.removeElementAt(this.listLeft.getSelectedIndex());
    }

    public String getID(){
        return this.jtfId.getText();
    }
}
