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
    private JList<String> listLeft ;
    private JList<String> listRigth;
    private ArrayList<Project> projectesPropis;
    private ArrayList<Project> projectesCompartits;
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
        projectesPropis = new ArrayList<>();
        projectesCompartits= new ArrayList<>();

        //PantallaPrincipal p= new PantallaPrincipal();
        //ScrollPane jspProject = new JScrollPane();


        jlNomUsuari= new JLabel("Nom Usuari");
        jlNomUsuari.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25));
        jpMeu.add(jlNomUsuari, BorderLayout.NORTH);

        DefaultListModel<String> model= new DefaultListModel<>();
        listLeft= new JList(model);
        listLeft.setBorder(BorderFactory.createTitledBorder("Els meus projectes : "));

        Project p1= new Project("Clara");
        projectesPropis.add(p1);
        Project p2 = new Project("Guillermo");
        projectesPropis.add(p2);

        for(Project pro: projectesPropis){

            model.addElement(pro.toString());
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
        JPanel jpSearch= new JPanel(new GridLayout(1,3));
        jbId= new JButton("Search");
        jpSearch.add(new JLabel(" ID Project :"));
        jtfId= new JTextField();
        jpSearch.add(jtfId);
        jpSearch.add(jbId);
        //jpCompartit.setBorder(BorderFactory.createTitledBorder("Projectes compartits : "));
        DefaultListModel<String> modelCompartit= new DefaultListModel<>();
        listRigth = new JList(modelCompartit);

        jbProjecte= new JButton("Nou Projecte");

        Project p4= new Project("cucut!");
        projectesCompartits.add(p4);
        Project p6 = new Project("heeey");
        projectesCompartits.add(p6);

        for(Project p: projectesCompartits) {

            modelCompartit.addElement(p.toString());

        }

        jpCompartit.add(jpSearch, BorderLayout.NORTH);
        listRigth.setBorder(BorderFactory.createTitledBorder("Projectes compartits : "));
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


    public void registerController(UserViewController c){
        jbProjecte.setActionCommand("Nou Projecte");
        jbProjecte.addActionListener(c);
        jbEliminar.setActionCommand("Eliminar Projecte");
        jbEliminar.addActionListener(c);
        jbEditar.setActionCommand("Editar Projecte");
        jbEditar.addActionListener(c);

    }


public static void main(String[] args) {
//
      UserView vista = new UserView();
        vista.setVisible(true);
    }



}
