package controller;

import model.Project;
import model.Tag;
import model.Task;
import model.User;
import network.ServerCommunication;
import view.NewTaskView;
import view.ProjectView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Guillermo Brugarolas on 22/07/2018.
 */
public class ProjectViewController implements ActionListener {
    private ProjectView projectView;
    private Project project;
    private NewTaskView newTaskView;
    private ServerCommunication serverCom;


    public ProjectViewController(ProjectView projectView, Project project, ServerCommunication serverCom){
        this.projectView = projectView;
        this.project = project;
        this.serverCom = serverCom;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand().equals("Nova Tasca"))){
            this.newTaskView = new NewTaskView();
            this.newTaskView.registerController2(this);
            this.newTaskView.loadAllMembers(project.getMembers().toArray());
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
            String projectName, category;
            projectName = this.project.getName();
            category = this.project.getColumn(column).getName();
            task = new Task(name, column, desc, new Tag(tagName, color), new User(userInCharge, null, null, null, null), projectName, category);
            this.project.getColumn(column).addTask(task);
            if (this.serverCom.sendAddTask(task)){
                this.projectView = new ProjectView(this.project);
            } else {}
            this.newTaskView.dispose();
        }
        if (e.getActionCommand().equals("Cancelar NovaTasca")){
            this.newTaskView.dispose();
        }
    }
}
