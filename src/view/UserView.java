package view;

import controller.UserViewController;
import model.Project;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class UserView extends JFrame{

    private JButton jbProjecte;
    private JButton jbEditar;
    private JButton jbEliminar;
    private JList<Project> listLeft;
    private JList<Project> listRight;
    private JTextField jtfId;
    private JButton jbId;
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
        jbEliminar = new JButton("Eliminar");
        jpBotons.add(jbEditar);
        jpBotons.add(jbEliminar);
        jpMeu.add(listLeft);
        //jpMeu.add(jspProject);
        jpMeu.add(jpBotons, BorderLayout.SOUTH);


        JPanel jpCompartit= new JPanel(new BorderLayout());
        JPanel jpSearch= new JPanel(new GridLayout(1,3));
        jbId= new JButton("Search");
        jpSearch.add(new JLabel(" ID Project :"));
        jtfId= new JTextField();
        jpSearch.add(jtfId);
        jpSearch.add(jbId);
        jbProjecte= new JButton("Nou Projecte");
        jpCompartit.add(jpSearch, BorderLayout.NORTH);
        listRight = new JList<Project>();
        listRight.setBorder(BorderFactory.createTitledBorder("Projectes compartits: "));
        jpCompartit.add(listRight);
        jpCompartit.add(jbProjecte, BorderLayout.SOUTH);
        jpProjecte.add(jpMeu);
        jpProjecte.add(jpCompartit);
        add(jpProjecte);
        this.setLocationRelativeTo(null);
        this.setVisible(false);

    }

    public void removeObjectLeft(PantallaPrincipal pantallaPrincipal){

        remove(pantallaPrincipal);
    }


    public void registerController(UserViewController c){
        jbProjecte.setActionCommand("Nou Projecte");
        jbProjecte.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Projecte");
        jbEliminar.addActionListener(c);
        jbEditar.setActionCommand("Editar Projecte");
        jbEditar.addActionListener(c);

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


}
