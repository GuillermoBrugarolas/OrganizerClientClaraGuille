package view;

/**
 * Created by Guillermo Brugarolas on 14/05/2018.
 */
import controller.UserViewController;
import model.User;

import javax.swing.*;
import java.awt.*;

public class UserView2 extends JFrame {
    private JList<String> jlOwnProjects;
    private JScrollPane jspOwnProjects;

    private JList<String> jlProjectsJoined;
    private JScrollPane jspProjectsJoined;

    private JPanel jpAddProject;
    private JPanel jpNameID;
    private JPanel jpBackground;
    private JPanel jpTags;
    private JPanel jpMembers;
    private JPanel jpColumns;

    private JButton jbCreateProject;

    private JLabel jlProjectName;
    private JTextField jtfProjectName;
    private JLabel jlProjectID;
    private JTextField jtfProjectID;

    private JLabel jlBackground;
    private JComboBox<String> jcbBackground;

    private JLabel jlTagName;
    private JTextField jtfTagName;
    private JLabel jlAvailableColors;
    private JComboBox jcbAvailableColors;
    private JButton jbAddTag;

    private JLabel jlMemberName;
    private JComboBox jcbPossibleMembers;
    private JButton jbAddMember;

    private JLabel jlColumnName;
    private JLabel jlColumnPosition;
    private JTextField jtfColumnName;
    private JButton jbAddColumn;

    private JButton jbAddProject;

    private JPanel jpJoinToProject;
    private JLabel jlProjectsShared;
    private JComboBox<String> jcbProjectsShared;
    private JButton jbJoinProject;


    public UserView2(){
        this.getContentPane().setLayout(new GridLayout(2,2));
        this.jlOwnProjects = new JList<String>();
        this.jlOwnProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jlOwnProjects.add(new PopupMenu("Open"));
        this.jspOwnProjects = new JScrollPane(jlOwnProjects);
        this.jspOwnProjects.setBorder(BorderFactory.createTitledBorder("OWN PROJECTS"));
        this.getContentPane().add(jspOwnProjects);
        this.jlProjectsJoined = new JList<String>();
        this.jlProjectsJoined.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jspProjectsJoined = new JScrollPane(jlProjectsJoined);
        this.jspProjectsJoined.setBorder(BorderFactory.createTitledBorder("PROJECTS JOINED"));
        this.getContentPane().add(jspProjectsJoined);

        this.jpAddProject = new JPanel(new GridLayout(7, 1));
        this.jpNameID = new JPanel(new FlowLayout());
        this.jpBackground = new JPanel(new FlowLayout());
        this.jpTags = new JPanel(new FlowLayout());
        this.jpMembers = new JPanel(new FlowLayout());
        this.jpColumns = new JPanel(new FlowLayout());

        this.jbCreateProject = new JButton("CREATE NEW PROJECT");
        this.jbCreateProject.setSize(75, 50);
        this.jlProjectName = new JLabel("Project name:");
        this.jtfProjectName = new JTextField();
        this.jtfProjectName.setPreferredSize(new Dimension(200, 30));
        this.jtfProjectName.setEnabled(false);
        this.jlProjectID = new JLabel("Project ID:");
        this.jtfProjectID = new JTextField();
        this.jtfProjectID.setPreferredSize(new Dimension(150, 30));
        this.jtfProjectID.setEnabled(false);
        this.jlBackground = new JLabel("Background:");
        String[] items = {"", "acuarela", "cielo", "circuito", "corcho", "madera", "pizarra", "verdor"};
        this.jcbBackground = new JComboBox<String>(items);
        this.jcbBackground.setEnabled(false);
        this.jlTagName = new JLabel("Tag name:");
        this.jtfTagName = new JTextField();
        this.jtfTagName.setPreferredSize(new Dimension(150, 30));
        this.jtfTagName.setEnabled(false);
        this.jlAvailableColors = new JLabel("Tag color:");
        String[] colorItems = {"", "red", "blue", "green", "yellow", "purple", "black", "orange"};
        this.jcbAvailableColors = new JComboBox<String>(colorItems);
        this.jcbAvailableColors.setEnabled(false);
        this.jbAddTag = new JButton("Add Tag");
        this.jbAddTag.setEnabled(false);
        this.jbAddProject = new JButton("ADD PROJECT");
        this.jbAddProject.setEnabled(false);
        this.jlMemberName = new JLabel("Share with member:");
        this.jcbPossibleMembers = new JComboBox<String>();
        this.jcbPossibleMembers.setEnabled(false);
        this.jbAddMember = new JButton("Share");
        this.jbAddMember.setEnabled(false);
        this.jlColumnName = new JLabel("Name of Column");
        this.jlColumnPosition = new JLabel("0:");
        this.jtfColumnName = new JTextField();
        this.jtfColumnName.setPreferredSize(new Dimension(150, 30));
        this.jtfColumnName.setEnabled(false);
        this.jbAddColumn = new JButton("Add Column");
        this.jbAddColumn.setEnabled(false);
        this.jbAddProject.setBackground(new Color(150, 150, 255));
        this.jbCreateProject.setBackground(new Color(255, 150, 150));
        this.jbAddTag.setBackground(new Color(255, 255, 100));
        this.jbAddMember.setBackground(new Color(255, 255, 100));
        this.jbAddColumn.setBackground(new Color(255, 255, 100));

        this.jpNameID.add(jlProjectName);
        this.jpNameID.add(jtfProjectName);
        this.jpNameID.add(jlProjectID);
        this.jpNameID.add(jtfProjectID);
        this.jpBackground.add(jlBackground);
        this.jpBackground.add(jcbBackground);
        this.jpTags.add(jlTagName);
        this.jpTags.add(jtfTagName);
        this.jpTags.add(jlAvailableColors);
        this.jpTags.add(jcbAvailableColors);
        this.jpTags.add(jbAddTag);
        this.jpColumns.add(jlColumnName);
        this.jpColumns.add(jlColumnPosition);
        this.jpColumns.add(jtfColumnName);
        this.jpColumns.add(jbAddColumn);
        this.jpMembers.add(jlMemberName);
        this.jpMembers.add(jcbPossibleMembers);
        this.jpMembers.add(jbAddMember);

        this.jpAddProject.add(jbCreateProject);
        this.jpAddProject.add(jpNameID);
        this.jpAddProject.add(jpBackground);
        this.jpAddProject.add(jpMembers);
        this.jpAddProject.add(jpColumns);
        this.jpAddProject.add(jpTags);
        this.jpAddProject.add(jbAddProject);

        this.jpAddProject.setBorder(BorderFactory.createTitledBorder("CREATE PROJECT"));
        this.getContentPane().add(jpAddProject);
        this.jpJoinToProject = new JPanel();
        this.jpJoinToProject.setLayout(new FlowLayout());
        this.jlProjectsShared = new JLabel("Projects shared with you:");
        this.jcbProjectsShared = new JComboBox<String>();
        this.jbJoinProject = new JButton("JOIN PROJECT");
        this.jbJoinProject.setSize(75, 50);
        this.jbJoinProject.setBackground(new Color(150, 255, 150));
        this.jpJoinToProject.add(jlProjectsShared);
        this.jpJoinToProject.add(jcbProjectsShared);
        this.jpJoinToProject.add(jbJoinProject);
        this.jpJoinToProject.setBorder(BorderFactory.createTitledBorder("JOIN PROJECT"));
        this.getContentPane().add(jpJoinToProject);
        this.getContentPane().setForeground(new Color(255,150,150));
        this.setSize(1200,700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void registerController(UserViewController userViewController){
        this.jbCreateProject.addActionListener(userViewController);
        this.jbAddProject.addActionListener(userViewController);
        this.jbJoinProject.addActionListener(userViewController);
    }

    public void refresh(User user, String[] usersList){
        System.out.println(usersList.toString());
        this.setTitle(user.getNickname() + " (" + user.getEmail() + ") user board");
        this.jcbPossibleMembers = new JComboBox<String>(usersList);
        int i, size;
//        size = user.getOwnProjects().size();
//        String[] ownProjectsData = new String[size];
//        for (i = 0; i < size; i++) {
//            ownProjectsData[i] = user.getOwnProjects().get(i).toString();
//        }
//        this.jlOwnProjects.setListData(ownProjectsData);
//        this.jlOwnProjects.setVisible(true);
//        size = user.getJoinedProjects().size();
//        String[] joinedProjectsData = new String[size];
//        for (i = 0; i < size; i++) {
//            joinedProjectsData[i] = user.getJoinedProjects().get(i).toString();
//        }
//        this.jlProjectsJoined.setListData(joinedProjectsData);
//        this.jlProjectsJoined.setVisible(true);
    }

    public void refreshUserProjectLists(User user){
        int i, size;
//        size = user.getOwnProjects().size();
//        String[] ownProjectsData = new String[size];
//        for (i = 0; i < size; i++) {
//            ownProjectsData[i] = user.getOwnProjects().get(i).toString();
//        }
//        this.jlOwnProjects.setListData(ownProjectsData);
//        this.jlOwnProjects.setVisible(true);
//        size = user.getJoinedProjects().size();
//        String[] joinedProjectsData = new String[size];
//        for (i = 0; i < size; i++) {
//            joinedProjectsData[i] = user.getJoinedProjects().get(i).toString();
//        }
//        this.jlProjectsJoined.setListData(joinedProjectsData);
//        this.jlProjectsJoined.setVisible(true);
    }

    public void clearProjectFields(){
        this.jtfProjectName.setText(null);
        this.jtfProjectID.setText(null);
        this.jtfTagName.setText(null);
        this.jtfColumnName.setText(null);
        this.jlColumnPosition.setText("0:");
    }

    public void unlockProjectFields(){
        this.jtfProjectName.setEnabled(true);
        this.jtfProjectID.setEnabled(true);
        this.jtfTagName.setEnabled(true);
        this.jbAddProject.setEnabled(true);
        this.jtfColumnName.setEnabled(true);
        this.jcbPossibleMembers.setEnabled(true);
        this.jbAddColumn.setEnabled(true);
        this.jbAddMember.setEnabled(true);
        this.jcbAvailableColors.setEnabled(true);
        this.jcbBackground.setEnabled(true);
    }

    public void makeDialog(String message, boolean type){
        if(type){
            Dialog.DialogOK(message);
        }else{
            Dialog.DialogKO(message);
        }
    }

    public boolean checkEmptyFieldsTag(){
        if (this.jtfTagName.getText().isEmpty() || this.jcbAvailableColors.getSelectedItem().equals("")) {
            return true;
        }
        return false;
    }

    public boolean checkEmptyFieldsMember(){
        return (this.jcbPossibleMembers.getSelectedItem().equals(""));
    }

    public boolean checkEmptyFieldsColumn(){
        return (this.jtfColumnName.getText().isEmpty());
    }

    public boolean checkEmptyFieldsBackground(){
        return (this.jcbBackground.getSelectedItem().equals(""));
    }

    public String getTagName(){
        return this.jtfTagName.getText();
    }

    public String getTagColor(){
        return this.jcbAvailableColors.getSelectedItem().toString();
    }

    public String getProjectName(){
        return this.jtfProjectName.getText();
    }

    public String getProjectID(){
        return this.jtfProjectID.getText();
    }

    public String getColumnName(){
        return this.jtfColumnName.getText();
    }

    public void clearTagFields(){
        this.jtfTagName.setText(null);
        this.jcbAvailableColors.setSelectedItem("");
    }
}





