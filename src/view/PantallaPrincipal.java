package view;

import model.Project;
import model.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.*;

public class PantallaPrincipal extends JFrame{

    private int columnes;
    private JButton jbAfegir;
    private String name;
    private int price;
    //private ArrayList<Projecte> projectes;


    public PantallaPrincipal(){

        setTitle("PantallaPrincipal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,300);
        setLayout(new BorderLayout());


        JScrollPane jspTotal = new JScrollPane();
        jspTotal.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);



        ObservableList<Task> tasques = FXCollections.observableArrayList();

        for(Task t: tasques) {
            //tasques.addAll(new Task(t.getName(),t.getPosition()));
            //tasques.addAll(new CustomThing(t.getName(), 123), new CustomThing("Horse", 456), new CustomThing("Jam", 789));
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



        //Finestretes de tasques internes



//    public static void main(String[] args) {
//
//        //CustomListView c= new CustomListView();
//        PantallaPrincipal vista = new PantallaPrincipal();
//        vista.setVisible(true);
//        //c.setVisible(true);
//    }
    public void actualitzaProjecte(Project p){


    }

}

