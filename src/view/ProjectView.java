package view;

import controller.ProjectViewController;
import model.Column;
import model.Project;
import model.Task;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.LinkedList;

public class ProjectView extends JFrame {


    private JButton jbAfegir;
    private String name;
    private int price;
    private LinkedList<Task> tasks1 = new LinkedList<>();
    private LinkedList<Task> tasks2;
    private LinkedList<Task> tasks3;
    //private ArrayList<Projecte> projectes;


    //private JScrollPane jsp2;
    //private JScrollPane jsp3;
    private JLabel jlDescripcio;
    private JLabel jlDescripcio2;
    private JLabel jlDescripcio3;
    private JButton jbEliminar;
    private JButton jbEditar;
    private JLabel jlName;
    private TitledBorder titledBorder;
    private TitledBorder titledBorder2;
    private TitledBorder titledBorder3;
    private JComboBox jcbMembres;
    private JTextArea jtaMembres;
    private  JLabel jlNameProject;
    private JScrollPane jsp1;
    private JScrollPane jsp2;
    private JScrollPane jsp3;


    public ProjectView() {

        setTitle("ProjectView");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 900);


        JPanel jpNameProject= new JPanel(new BorderLayout());
        jlNameProject = new JLabel();
        jlNameProject.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 50));
        jpNameProject.add(jlNameProject);
        add(jpNameProject, BorderLayout.NORTH);


        /*JPanel jpTitol = new JPanel(new BorderLayout());
        ImageIcon image = new ImageIcon("logo.png");
        JLabel imageLabel = new JLabel(image);
        jpTitol.add(jpDades,BorderLayout.EAST);
        jpTitol.add(imageLabel, BorderLayout.CENTER);
        add(jpTitol, BorderLayout.NORTH);*/


        JPanel jpTotal= new JPanel(new GridLayout(1, 4));

        //TO DO

        //JPanel jpColumna1 = new JPanel();

            this.jsp1 = new JScrollPane();;
            this.jsp1.setBounds(10, 20, 500, 400);
            this.jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jpTotal.add(this.jsp1);

            JPanel jpProva = new JPanel();
            this.jsp1.setViewportView(jpProva);
            jpProva.setLayout(new BorderLayout(0, 0));

            JPanel columnpanel = new JPanel();
            jpProva.add(columnpanel);
            columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
            columnpanel.setBackground(Color.BLACK);

        for(int i=0; i <10 ;i++) {

                //Vinyeta de cada tasca

            JPanel jpTasca = new JPanel(new BorderLayout());
            jpTasca.setBackground(SystemColor.gray);
            jpTasca.setPreferredSize(new Dimension(100, 90));
            columnpanel.add(jpTasca);
            //jpTasca.setLayout(null);

            //D'ALT
            titledBorder = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "task1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(2, 2, 2));
            jpTasca.setBorder(titledBorder);

            //CENTRE
            //jlName = new JLabel("Nom: ------ ");
            jlDescripcio = new JLabel(" Descripció: \n ------ ");
            jpTasca.add(jlDescripcio, BorderLayout.CENTER);
            //BAIX
            JPanel jpButton = new JPanel(new GridLayout(1, 2));
            jpButton.setBackground(Color.gray);
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton.add(jbEditar);
            jpButton.add(jbEliminar);

            jpTasca.add(jpButton, BorderLayout.SOUTH);

                //jpTasca.add(jlName, BorderLayout.NORTH);

        }


        //DOING


        //JPanel jpColumna2 = new JPanel();
        this.jsp2 = new JScrollPane();
        this.jsp2.setBounds(10,20,500,400);
        this.jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jpTotal.add(this.jsp2);

        JPanel jpProva2= new JPanel();
        this.jsp2.setViewportView(jpProva2);
        jpProva2.setLayout(new BorderLayout(5, 6));

        JPanel columnpanel2 = new JPanel();
        jpProva2.add(columnpanel2);
        columnpanel2.setLayout(new GridLayout(0,1,0,1));
        columnpanel2.setBackground(Color.black);

        for(int i=0; i <10 ;i++) {

            //Vinyeta de cada tasca

            JPanel jpTasca2 = new JPanel(new BorderLayout());
            jpTasca2.setPreferredSize(new Dimension(100,90));
            columnpanel2.add(jpTasca2);

            //D'ALT
            titledBorder2 = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "holaa 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0));
            jpTasca2.setBorder(titledBorder2);

            //CENTRE
            //jlName = new JLabel("Nom: ------ ");
            jlDescripcio2 = new JLabel(" Descripció: \n ------ ");
            jpTasca2.add(jlDescripcio2, BorderLayout.CENTER);
            //BAIX
            JPanel jpButton2 = new JPanel(new GridLayout(1, 2));
            jpButton2.setBackground(Color.lightGray);
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton2.add(jbEditar);
            jpButton2.add(jbEliminar);
            jpTasca2.add(jpButton2, BorderLayout.SOUTH);

            //jpTasca.add(jlName, BorderLayout.NORTH);


            jpTasca2.setBackground(SystemColor.lightGray);

        }
        //DONE


        //JPanel jpColumna3 = new JPanel();
        this.jsp3 = new JScrollPane();
        this.jsp3.setBounds(10,20,500,400);
        this.jsp3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jpTotal.add(this.jsp3);

        JPanel jpProva3= new JPanel();
        this.jsp3.setViewportView(jpProva3);
        jpProva3.setLayout(new BorderLayout(0, 0));

        JPanel columnpanel3 = new JPanel();
        jpProva3.add(columnpanel3);
        columnpanel3.setLayout(new GridLayout(0,1,0,1));
        columnpanel3.setBackground(Color.black);

        for(int i=0; i <10 ;i++) {

            //Vinyeta de cada tasca

            JPanel jpTasca3 = new JPanel(new BorderLayout());
            jpTasca3.setPreferredSize(new Dimension(100,90));
            columnpanel3.add(jpTasca3);


            //D'ALT
            titledBorder3 = new TitledBorder(UIManager.getBorder("TitledBorder.border"), "holaa coca.cola 3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(2, 2, 2));
            jpTasca3.setBorder(titledBorder3);

            //CENTRE
            //jlName = new JLabel("Nom: ------ ");
            jlDescripcio3 = new JLabel(" Descripció: " +" \n" + "------ ");
            jpTasca3.add(jlDescripcio3, BorderLayout.CENTER);

            //BAIX
            JPanel jpButton3 = new JPanel(new GridLayout(1, 2));
            jpButton3.setBackground(Color.gray);
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton3.add(jbEditar);
            jpButton3.add(jbEliminar);
            jpTasca3.add(jpButton3, BorderLayout.SOUTH);

            //jpTasca.add(jlName, BorderLayout.NORTH);


            jpTasca3.setBackground(SystemColor.gray);

        }
        JPanel jpDades = new JPanel(new BorderLayout());
        jpDades.setSize(600,500);
        JLabel jlMembres = new JLabel("  Membres: ");
        // String  infoCombo = { "Usuari 1", "Usuari 2", "Usuari 3", "Usuari 4"};
        jcbMembres = new JComboBox();
        //jcbMembres.setPromptText("Nom del usuari o correu");
        jcbMembres.setEditable(true);
        jtaMembres= new JTextArea("HOLA HOLA");
        jpDades.add(jtaMembres, BorderLayout.CENTER);
        jpDades.setBorder(BorderFactory.createTitledBorder(" Membres: "));
        jpDades.add(jcbMembres, BorderLayout.NORTH);
        jpDades.setSize(600,20);

        jpTotal.add(jpDades);

        add(jpTotal, BorderLayout.CENTER);
        this.setVisible(false);
    }

    public void registerController(ProjectViewController projectViewController){

    }

    public void loadProject(Project project){
        String projectName, projectBackground, c1Name, c2Name, c3Name;
        Column c1, c2, c3;
        c1 = project.getColumn(1);
        c2 = project.getColumn(2);
        c3 = project.getColumn(3);
//        c1Name = c1.getName();
//        c2Name = c2.getName();
//        c3Name = c3.getName();
        projectBackground = project.getBackground();
        projectName = project.getName();
        JLabel jlImage;
        jlImage = new JLabel(new ImageIcon(projectBackground+".jpg"));
        this.jlNameProject.setText(projectName);
        this.setContentPane(jlImage);
        this.jsp1.setBorder(BorderFactory.createTitledBorder(c1.getName()));
        this.jsp2.setBorder(BorderFactory.createTitledBorder(c2.getName()));
        this.jsp3.setBorder(BorderFactory.createTitledBorder(c3.getName()));
        this.setVisible(true);
    }



        /*LinkedList<String> descriptions = new LinkedList<>();


        for(Task t: tasques) {
            String label  = t.getTag() +"\n" +t.getName() +"\n" + t.getDescription() ;
            descriptions.add(label);
        }
        JList<String> jlList=  new JList<>(descriptions);

        JScrollPane scrollPane1 = new JScrollPane(jlList);
        jpTasca.add(scrollPane1);



        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                System.out.println("Name:" + listSelectionEvent.getClass().getName());

            }

            MouseListener mouseListener = new MouseAdapter() {
                public void mouseClicked(MouseEvent mouseEvent) {
                    JList theList = (JList) mouseEvent.getSource();
                    if (mouseEvent.getClickCount() == 2) {
                        int index = theList.locationToIndex(mouseEvent.getPoint());
                        if (index >= 0) {
                            Object o = theList.getModel().getElementAt(index);
                            System.out.println("Double-clicked on: " + o.toString());
                        }
                    }
                }

                //System.out.println("Description:" + listSelectionEvent.getClass().toGenericString());

                // JScrollPane jspTotal = new JScrollPane();
                //ObservableList<Task> tasques = FXCollections.observableArrayList();

*/
       /* JPanel jpTasca = new JPanel();

        for(Task t: tasques) {
            tasques.addAll(new Task(t.getName(),t.getPosition()));
            tasques.addAll(new CustomThing(t.getName(), 123), new CustomThing("Horse", 456), new CustomThing("Jam", 789));

        }



        ListView<Task> listView = new ListView<Task>(tasques);
        listView.setCellFactory(new Callback<ListView<Task>, ListCell<Task>>() {
            public ListCell<Task> call(ListView<Task> arg0) {
                return new ListCell<Task>() {

                    @Override
                    protected void updateItem(Task item, boolean bln) {
                        super.updateItem(item, bln);
                        if (item != null) {
                            VBox vBox = new VBox(new Text(item.getName()), new Text(String.format("%d $", item.getTag())));
                            Label graphic= new Label("[Graphic]");
                            HBox hBox = new HBox(vBox);
                            hBox.setSpacing(10);
                            setGraphic(hBox);
                        }
                    }

                };
            }

        });

        JPanel jpView= new JPanel(new GridLayout(1,4));
        JScrollPane jspColumna= new JScrollPane();
        jspColumna.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jbAfegir= new JButton("Afegir Task");
        //jpView.add(listView);
        jpView.add(jbAfegir);
        jpView.add(jspColumna);
    }
*/


    //Finestretes de tasques internes


    //};



//    public static void main(String[] args) {
//        // CustomListView c= new CustomListView();
//        ProjectView vista = new ProjectView();
//        vista.setVisible(true);
//        //c.setVisible(true);
////    }
//        //public void actualitzaProjecte(Project p){
//
//    }

    /*public class Tutorial extends Applet {

        public void paint(Graphics x){
            x.draw3DRect(5,5,5,5,true);
            x.setColor(Color.RED);
            x.fill3DRect(5,5,5,5,true);
        }

    }*/
}




