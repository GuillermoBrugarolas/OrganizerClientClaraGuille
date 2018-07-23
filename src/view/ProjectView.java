package view;

import controller.ProjectViewController;
import model.Column;
import model.Project;
import model.Task;
import model.User;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ProjectView extends JFrame {


    private JButton jbAfegir;
    private String name;
    private int price;
    private LinkedList<Task> tasks1 = new LinkedList<Task>();
    private LinkedList<Task> tasks2 = new LinkedList<Task>();
    private LinkedList<Task> tasks3 = new LinkedList<Task>();
    private LinkedList<User> totsUsuaris;
    private LinkedList<User> usuarisProjecte;
    private JLabel jlDescripcio;
    private JLabel jlDescripcio2;
    private JLabel jlDescripcio3;
    private JButton jbEliminar;
    private JButton jbEditar;
    private JButton jbDelete;
    private JButton jbCloseSession;
    private JButton jbNovaTasca;
    private JLabel jlName;
    private TitledBorder titledBorder;
    private TitledBorder titledBorder2;
    private TitledBorder titledBorder3;
    private JComboBox jcbMembres;
    private JTextArea jtaMembres;
    private  JLabel jlNameProject;
    private JLabel jlOwner;
    private JLabel jlUserAssigned;
    private JLabel jlUserAssigned2;
    private JLabel jlUserAssigned3;
    private JScrollPane jsp1;
    private JScrollPane jsp2;
    private JScrollPane jsp3;
    private JPanel jpTotal;
    private JPanel jpDades;
    private JList<String> jlistMembres;
    private JComboBox<String> jcbUser;
    private JPanel jpCentre1;
    private JPanel jpCentre2;
    private JPanel jpCentre3;


    public ProjectView(Project project) {

        String projectName, projectBackground, c1Name, c2Name, c3Name;
        Column c1, c2, c3;
        c1 = project.getColumn(1);
        c2 = project.getColumn(2);
        c3 = project.getColumn(3);
        this.tasks1 = c1.getTasks();
        this.tasks2 = c2.getTasks();
        this.tasks3 = c3.getTasks();
        c1Name = c1.getName();
        c2Name = c2.getName();
        c3Name = c3.getName();
        projectBackground = project.getBackground();
        projectName = project.getName();
        try {
            File fondo = new File("src/"+projectBackground+".jpg");
            String fons = fondo.getAbsolutePath();
            final Image backgroundImage = javax.imageio.ImageIO.read(new File(fons));
            backgroundImage.getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
            this.setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JPanel jpNameProject = new JPanel(new BorderLayout());
        jpNameProject.setOpaque(false);
        this.jlNameProject = new JLabel();
        this.jlNameProject.setText(projectName);
        this.jlNameProject.setBackground(new Color(100, 0, 100));
        this.jlNameProject.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 50));
        jpNameProject.add(jlNameProject);
        this.jbCloseSession = new JButton("Tancar Sessió");
        this.jbCloseSession.setBackground(new Color(150, 150, 150));
        jpNameProject.add(this.jbCloseSession, BorderLayout.EAST);
        this.getContentPane().add(jpNameProject, BorderLayout.NORTH);

        this.jpTotal= new JPanel(new GridLayout(1, 4));
        this.jpTotal.setOpaque(false);
        //TO DO

        this.jsp1 = new JScrollPane();
        this.jsp1.setOpaque(false);
        this.jsp1.setBorder(BorderFactory.createTitledBorder(c1Name));
        this.jsp1.setBounds(10, 20, 500, 400);
        this.jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.jpTotal.add(this.jsp1);

        JPanel jpProva = new JPanel();
        this.jsp1.setViewportView(jpProva);
        jpProva.setLayout(new BorderLayout(0, 0));

        JPanel columnpanel = new JPanel();
        jpProva.add(columnpanel);
        columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
        columnpanel.setOpaque(false);
        
        int size1 = this.tasks1.size();
        for(int i = 0; i < size1 ; i++) {
                //Vinyeta de cada tasca
            JPanel jpTasca = new JPanel(new BorderLayout());
            jpTasca.setPreferredSize(new Dimension(100, 100));

            //D'ALT
            this.titledBorder = new TitledBorder(UIManager.getBorder("TitledBorder.border"), (this.tasks1.get(i).getName()), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(2, 2, 2));
            jpTasca.setBorder(this.titledBorder);

            //CENTRE
            this.jpCentre1 = new JPanel();
            this.jpCentre1.setLayout(new BorderLayout());
            this.jlDescripcio = new JLabel(" Descripció: "+tasks1.get(i).getDescription());
            this.jpCentre1.add(this.jlDescripcio, BorderLayout.NORTH);
            this.jlUserAssigned = new JLabel();
            String nick = this.tasks1.get(i).getUserAssigned().getNickname();
            this.jlUserAssigned.setText("USER ASSIGNED: "+nick);
            this.jpCentre1.add(this.jlUserAssigned, BorderLayout.SOUTH);
            jpTasca.add(this.jpCentre1, BorderLayout.CENTER);

            //BAIX
            JPanel jpButton = new JPanel(new GridLayout(1, 2));
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton.add(this.jbEditar);
            jpButton.add(this.jbEliminar);
            String tag = this.tasks1.get(i).getTag().getName();
            if (tag.equals("Minor")){
                this.jpCentre1.setBackground(new Color(100, 100, 255));
                jpTasca.setBackground(new Color(100, 100, 255));}
            else if (tag.equals("Moderate")){
                this.jpCentre1.setBackground(new Color(50, 200, 50));
                jpTasca.setBackground(new Color(50, 200, 50));}
            else if(tag.equals("Important")){
                this.jpCentre1.setBackground(new Color(250, 200, 50));
                jpTasca.setBackground(new Color(250, 200, 50));}
            else if (tag.equals("Urgent")){
                this.jpCentre1.setBackground(new Color(250, 50, 50));
                jpTasca.setBackground(new Color(250, 50, 50));}
            else if (tag.equals("Critical")){
                this.jpCentre1.setBackground(new Color(100, 0, 0));
                jpTasca.setBackground(new Color(100, 0, 0));}
            jpTasca.add(jpButton, BorderLayout.SOUTH);
            columnpanel.add(jpTasca);
        }

        //DOING
            
        this.jsp2 = new JScrollPane();
        this.jsp2.setOpaque(false);
        this.jsp2.setBorder(BorderFactory.createTitledBorder(c2Name));
        this.jsp2.setBounds(10,20,500,400);
        this.jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.jpTotal.add(this.jsp2);

        JPanel jpProva2 = new JPanel();
        this.jsp2.setViewportView(jpProva2);
        jpProva2.setLayout(new BorderLayout(5, 6));

        JPanel columnpanel2 = new JPanel();
        jpProva2.add(columnpanel2);
        columnpanel2.setLayout(new GridLayout(0,1,0,1));
        columnpanel2.setBackground(Color.black);
        
        int size2 = project.getColumn(2).getTasks().size();
        for(int ii=0; ii < size2; ii++) {
            
            //Vinyeta de cada tasca
            JPanel jpTasca2 = new JPanel(new BorderLayout());
            jpTasca2.setPreferredSize(new Dimension(100, 90));

            //D'ALT
            this.titledBorder = new TitledBorder(UIManager.getBorder("TitledBorder.border"), (this.tasks2.get(ii).getName()), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(2, 2, 2));
            jpTasca2.setBorder(this.titledBorder);

            //CENTRE
            this.jpCentre2 = new JPanel();
            this.jpCentre2.setLayout(new BorderLayout());
            this.jlDescripcio2 = new JLabel(" Descripció: "+this.tasks2.get(ii).getDescription());
            this.jpCentre2.add(this.jlDescripcio2, BorderLayout.NORTH);
            this.jlUserAssigned2 = new JLabel();
            String nick2 = this.tasks2.get(ii).getUserAssigned().getNickname();
            this.jlUserAssigned2.setText("USER ASSIGNED: "+nick2);
            this.jpCentre2.add(this.jlUserAssigned2, BorderLayout.SOUTH);
            jpTasca2.add(this.jpCentre2, BorderLayout.CENTER);

            //BAIX
            JPanel jpButton2 = new JPanel(new GridLayout(1, 2));
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton2.add(this.jbEditar);
            jpButton2.add(this.jbEliminar);
            String tag2 = this.tasks2.get(ii).getTag().getName();
            if (tag2.equals("Minor")){
                this.jpCentre2.setBackground(new Color(100, 100, 255));
                jpTasca2.setBackground(new Color(100, 100, 255));}
            else if (tag2.equals("Moderate")){
                this.jpCentre2.setBackground(new Color(50, 200, 50));
                jpTasca2.setBackground(new Color(50, 200, 50));}
            else if(tag2.equals("Important")){
                this.jpCentre2.setBackground(new Color(250, 200, 50));
                jpTasca2.setBackground(new Color(250, 200, 50));}
            else if (tag2.equals("Urgent")){
                this.jpCentre2.setBackground(new Color(250, 50, 50));
                jpTasca2.setBackground(new Color(250, 50, 50));}
            else if (tag2.equals("Critical")){
                this.jpCentre2.setBackground(new Color(100, 0, 0));
                jpTasca2.setBackground(new Color(100, 0, 0));}
            jpTasca2.add(jpButton2, BorderLayout.SOUTH);
            columnpanel2.add(jpTasca2);
        }
        //DONE


        //JPanel jpColumna3 = new JPanel();
        this.jsp3 = new JScrollPane();
        this.jsp3.setOpaque(false);
        this.jsp3.setBorder(BorderFactory.createTitledBorder(c3Name));
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
        
        int size3 = project.getColumn(3).getTasks().size();
        for(int iii = 0; iii < size3 ; iii++) {
            //Vinyeta de cada tasca
            JPanel jpTasca3 = new JPanel(new BorderLayout());
            jpTasca3.setPreferredSize(new Dimension(100, 90));

            //D'ALT
            this.titledBorder = new TitledBorder(UIManager.getBorder("TitledBorder.border"), (this.tasks3.get(iii).getName()), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(2, 2, 2));
            jpTasca3.setBorder(this.titledBorder);

            //CENTRE
            this.jpCentre3 = new JPanel();
            this.jpCentre3.setLayout(new BorderLayout());
            this.jlDescripcio3 = new JLabel(" Descripció: "+this.tasks3.get(iii).getDescription());
            this.jpCentre3.add(this.jlDescripcio3, BorderLayout.NORTH);
            this.jlUserAssigned3 = new JLabel();
            String nick3 = this.tasks3.get(iii).getUserAssigned().getNickname();
            this.jlUserAssigned3.setText("USER ASSIGNED: "+nick3);
            this.jpCentre3.add(this.jlUserAssigned3, BorderLayout.SOUTH);
            jpTasca3.add(this.jpCentre3, BorderLayout.CENTER);

            //BAIX
            JPanel jpButton3 = new JPanel(new GridLayout(1, 2));
            jbEditar = new JButton("Editar");
            jbEliminar = new JButton("Eliminar");
            jpButton3.add(this.jbEditar);
            jpButton3.add(this.jbEliminar);
            String tag3 = this.tasks3.get(iii).getTag().getName();
            if (tag3.equals("Minor")){
                jpTasca3.setBackground(new Color(100, 100, 255));
                this.jpCentre3.setBackground(new Color(100, 100, 255));
            }
            else if (tag3.equals("Moderate")){
                jpTasca3.setBackground(new Color(50, 200, 50));
                this.jpCentre3.setBackground(new Color(50, 200, 50));
            }
            else if(tag3.equals("Important")){
                jpTasca3.setBackground(new Color(250, 200, 50));
                this.jpCentre3.setBackground(new Color(250, 200, 50));
            }
            else if (tag3.equals("Urgent")){
                jpTasca3.setBackground(new Color(250, 50, 50));
                this.jpCentre3.setBackground(new Color(250, 50, 50));
            }
            else if (tag3.equals("Critical")){
                jpTasca3.setBackground(new Color(100, 0, 0));
                this.jpCentre3.setBackground(new Color(100, 0, 0));
            }
            jpTasca3.add(jpButton3, BorderLayout.SOUTH);
            columnpanel3.add(jpTasca3);
        }
        JPanel jpDades = new JPanel(new GridLayout(2, 1));
        JPanel jpUsuaris= new JPanel(new BorderLayout());
        JPanel jpX= new JPanel(new GridLayout(2,1));
        JPanel jpBotton= new JPanel(new GridLayout(1,2));
        jpDades.setSize(600, 500);

        this.totsUsuaris = new LinkedList<>();
        this.usuarisProjecte = new LinkedList<>();
        this.usuarisProjecte = project.getMembers();
        
        this.jcbUser = new JComboBox<String>();

        jpUsuaris.setBorder(BorderFactory.createTitledBorder("Usuaris:"));
        jpUsuaris.add(this.jcbUser, BorderLayout.NORTH);


        DefaultListModel<String> model = new DefaultListModel<>();
        this.jlistMembres = new JList(model);
        this.jlistMembres.setBorder(BorderFactory.createTitledBorder(" Usuaris del projecte: "));
        for(User u: this.usuarisProjecte){
            model.addElement(u.getNickname());
        }

        jpUsuaris.add(this.jlistMembres, BorderLayout.CENTER);
        this.jbAfegir = new JButton("Afegir");
        this.jbDelete = new JButton("Eliminar");
        this.jbNovaTasca = new JButton("Nova Tasca");

        jpBotton.add(this.jbAfegir);
        jpBotton.add(this.jbDelete);
        jpX.add(jpBotton);
        jpX.add(this.jbNovaTasca);
        jpUsuaris.add(jpX, BorderLayout.SOUTH);
        jpDades.add(jpUsuaris);
        this.jpTotal.add(jpDades);
        add(this.jpTotal, BorderLayout.CENTER);

        this.setTitle(project.getName());
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    public void registerController(ProjectViewController projectViewController){
        this.jbCloseSession.setActionCommand("Tancar Sessió");
        this.jbCloseSession.addActionListener(projectViewController);
        this.jbNovaTasca.setActionCommand("Nova Tasca");
        this.jbNovaTasca.addActionListener(projectViewController);
    }

    public void loadAllUsers(String[] users){
        int i, j = users.length;
        for (i = 0; i < j; i++){
            this.jcbUser.addItem(users[i]);
        }
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




