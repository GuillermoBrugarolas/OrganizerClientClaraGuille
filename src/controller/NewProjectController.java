package controller;

//import Finestra.NewProjectView;
//import Finestra.UserView;
//import Network.ConnectionProject;

import model.*;
import network.ServerCommunication;
import view.NewProjectView;
import view.NewTaskView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;


public class NewProjectController implements ActionListener {

    private NewProjectView newProjectView;
    private NewTaskView newTaskView;
    private User user;
    private int tasksCreated;
    private Project newProject;
    private ServerCommunication serverCom;
    private Logics logics;
    private UserViewController userViewController;

    public NewProjectController(NewProjectView newProjectView, User user, ServerCommunication serverCom, Logics logics, UserViewController userViewController){
        this.newProjectView = newProjectView;
        this.user = user;
        this.tasksCreated = 0;
        this.logics = logics;
        this.serverCom = serverCom;
        this.userViewController = userViewController;
        this.newProject = new Project(this.user, new LinkedList<User>(), null, null, null, null, null, null);
    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Afegir Membre")){
            String userSelected = this.newProjectView.getSelectedUser();
            newProject.addMember(new User(userSelected, null, null, null, null));
            this.newProjectView.addUser();
        }
        if (e.getActionCommand().equals("Eliminar Membre")){
            int in = 0, rr;
            String selectedMember = this.newProjectView.getSelectedMember();
            LinkedList<User> li = this.newProject.getMembers();
            for (rr = 0; rr < li.size(); rr++) {
                if (li.get(rr).getNickname().equals(selectedMember)) {
                    li.remove(rr);
                    break;
                }
            }
            this.newProjectView.deleteFromList();
        }

        if (e.getActionCommand().equals("Afegir Tasca")){
            if (!this.newProjectView.checkColumnNamesFilled()){
                makeDialog("Not all columns have been named yet!", false);
            } else if (this.newProjectView.checkColumnNamesFilled()){
                if (this.tasksCreated == 0) {
                    this.createColumns();
                    this.tasksCreated = 1;
                }
                if (!this.newProjectView.checkMemberListFilled()){
                    makeDialog("Cannot add a task when there are no members!", false);
                } else if (this.newProjectView.checkMemberListFilled()){
                    this.newTaskView = new NewTaskView();
                    this.newTaskView.loadAllMembers(this.newProject.getMembers().toArray());
                    this.newTaskView.registerController(this);
                }
            }
        }
        if (e.getActionCommand().equals("Afegir Tasca NovaTasca")){
            Color color;
            Task task;
            int column = (int)this.newTaskView.getJsPos().getValue();
            String desc = (String)this.newTaskView.getJtDescripcio().getText();
            String name = (String)this.newTaskView.getJtfNom().getText();
            String userInCharge = (String)this.newTaskView.getJcbUser().getSelectedItem().toString();
            String tagName = (String)this.newTaskView.getJcbEtiqueta().getSelectedItem().toString();
            if (tagName.equals("Minor")){   color = new Color(50, 150, 250);}
            else if (tagName.equals("Moderate")){   color = new Color(150, 250, 100);}
            else if (tagName.equals("Important")){   color = new Color(250, 200, 50);}
            else if (tagName.equals("Urgent")){   color = new Color(200, 50, 0);}
            else if (tagName.equals("Critical")){   color = new Color(100, 0, 0);}
            else {  color = new Color(0, 0, 0);}
            task = new Task(name, column, desc, new Tag(tagName, color), new User(userInCharge, null, null, null, null));
            this.newProject.getColumn(column).addTask(task);
            this.newProjectView.addTask(task);
            this.newTaskView.dispose();
        }
        if (e.getActionCommand().equals("Cancelar NovaTasca")){
            this.newTaskView.dispose();
        }
        if (e.getActionCommand().equals("Eliminar Tasca")){
            int in, rr;
            newProjectView.deleteTaskFromList();
            String selectedTask = this.newProjectView.getSelectedTask();
            for (in = 1; in < 4; in++){
                LinkedList<Task> li = this.newProject.getColumn(in).getTasks();
                for (rr = 0; rr < li.size(); rr++){
                    if (li.get(rr).toString().equals(selectedTask)){
                        li.remove(rr);
                        break;
                    }
                }
            }
        }
        if (e.getActionCommand().equals("Nou projecte")) {
            if (!this.newProjectView.checkAllFilled()) {
                this.makeDialog("There are errors or empty fields in the new project form!", false);
            } else if (this.newProjectView.checkAllFilled()) {
                this.newProject.setName(this.newProjectView.getNewProjectName());
                this.newProject.setId(this.newProjectView.getNewProjectID());
                this.newProject.setBackground(this.newProjectView.getNewProjectBackground());
                if (this.checkProject()) {
                    printAllTasks();
                    if (serverCom.sendNewProject(this.newProject)){
                        this.newProjectView.dispose();
                        this.user.addOwnProject(this.newProject);
                        this.userViewController.loadUser(this.user);

                    } else if (!serverCom.sendNewProject(this.newProject)){
                        this.makeDialog("Could not add project to the database!", false);
                    }
                } else if (!this.checkProject()){
                    this.makeDialog("The new project has not been completed yet!", false);
                }
            }
        }
    }

    public void makeDialog(String message, boolean type){
        newProjectView.makeDialog(message,type);
    }

    public void createColumns(){
        String name1, name2, name3;
        name1 = newProjectView.getColumnOne();
        name2 = newProjectView.getColumnTwo();
        name3 = newProjectView.getColumnThree();
        this.newProject.setColumnOne(new Column(name1, 1, new LinkedList<Task>()));
        this.newProject.setColumnTwo(new Column(name2, 2, new LinkedList<Task>()));
        this.newProject.setColumnThree(new Column(name3, 3, new LinkedList<Task>()));
    }

    public boolean checkProject(){
        int ff;
        if ((this.newProject.getName() == null) || this.newProject.getName().equals("")){
            System.out.println("name error");
            return false;
        }
        if (this.newProject.getOwner() == null){
            System.out.println("owner error");
            return false;
        }
        if (this.newProject.getMembers() == null){
            System.out.println("members error");
            return true;
        }
        if (this.newProject.getId().equals("") || this.newProject.getId() == null){
            System.out.println("id error");
            return false;
        }
        for (ff = 1; ff < 4; ff++) {
            if (this.newProject.getColumn(ff) == null) {
                System.out.println("column error");
                return false;
            }
            if (this.newProject.getColumn(ff).getTasks() == null) {
                System.out.println("tasks error");
                return false;
            }
        }
        return true;
    }

    public void printAllTasks(){
        int i, j, k;
        Column c;
        Task t;
        for (i = 1; i < 4; i++){
            c = this.newProject.getColumn(i);
            System.out.println(c.getName());
            k = c.getTasks().size();
            for (j = 0; j < k; j++){
                t = c.getTasks().get(j);
                System.out.println(t.toString());
            }
        }
    }
}