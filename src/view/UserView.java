package view;

import controller.UserViewController;
import model.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserView extends JFrame{

    private JButton jbProjecte;
    private JButton jbEditar;
    private JButton jbEliminar;
    private List listLeft ;
    private List listRigth;
    private ArrayList<Project> projectes;


    public UserView(){

        setTitle("Benvinguts al Organizer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,300);

        CardLayout total = new CardLayout();
        JPanel jpProjecte= new JPanel(new GridLayout(1,2));
        JPanel jpMeu = new JPanel(new BorderLayout());
        projectes = new ArrayList<>();

        //PantallaPrincipal p= new PantallaPrincipal();
        //ScrollPane jspProject = new JScrollPane();
        jpMeu.setBorder(BorderFactory.createTitledBorder("Els meus projectes : "));
        listLeft= new List();

        for(Project pro: projectes){

            listLeft.add(pro.getName());
        }

        JPanel jpBotons = new JPanel(new GridLayout(1,2));
        jbEditar= new JButton("Editar");
        jbEliminar = new JButton("Eliminar");
        jpBotons.add(jbEditar);
        jpBotons.add(jbEliminar);
        jpMeu.add(listLeft);
        //jpMeu.add(jspProject);
        jpMeu.add(jpBotons, BorderLayout.SOUTH);


        JPanel jpCompartit= new JPanel(new BorderLayout());
        jpCompartit.setBorder(BorderFactory.createTitledBorder("Projectes compartits : "));
        listRigth = new List(5);
        jbProjecte= new JButton("Nou Projecte");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        listRigth.add("Projecte 1");
        listRigth.add("Projecte 2");
        listRigth.add("Projecte 3");
        jpCompartit.add(listRigth);
        jpCompartit.add(jbProjecte, BorderLayout.SOUTH);

        jpProjecte.add(jpMeu);
        jpProjecte.add(jpCompartit);
        add(jpProjecte);
        this.setVisible(true);

    }

    public void removeObjectLeft(PantallaPrincipal pantallaPrincipal){

            remove(pantallaPrincipal);
    }

    public String seleccionatLeft() {

     return listLeft.getSelectedItem();

    }


    public void addProjectLeft(Project p){
        projectes.add(p);
        listLeft.add(p.getName());
    }

    public void addProjectRigth(Project p){
        projectes.add(p);
        listRigth.add(p.getName());
    }

    public List getListLeft() {
        return listLeft;
    }

    public void setListLeft(List listLeft) {
        this.listLeft = listLeft;
    }

    public List getListRigth() {
        return listRigth;
    }

    public void setListRigth(List listRigth) {
        this.listRigth = listRigth;
    }


    public void registerController(UserViewController c){
        jbProjecte.setActionCommand("Nou Projecte");
        jbProjecte.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Projecte");
        jbEliminar.addActionListener(c);
        jbEditar.setActionCommand("Editar Projecte");
        jbEditar.addActionListener(c);

    }


//    public static void main(String[] args) {
//
//        UserView vista = new UserView();
//        vista.setVisible(true);
//    }



}
