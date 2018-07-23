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
    private NewTaskView newTaskView, newTaskView1;
    private ServerCommunication serverCom;
    private User user;
    private int col;
    private int fil;


    public ProjectViewController(ProjectView projectView, Project project, ServerCommunication serverCom, User user){
        this.projectView = projectView;
        this.project = project;
        this.serverCom = serverCom;
        this.user = user;
        this.col = 0;
        this.fil = 0;
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
        if (e.getActionCommand().equals("Actualitzar Tasca")){
            Color color;
            Task task;
            int column = (int)this.newTaskView1.getJsPos().getValue();
            String desc = (String)this.newTaskView1.getJtDescripcio().getText();
            String name = (String)this.newTaskView1.getJtfNom().getText();
            String userInCharge = (String)this.newTaskView1.getJcbUser().getSelectedItem().toString();
            String tagName = (String)this.newTaskView1.getJcbEtiqueta().getSelectedItem().toString();
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
            Task toRemove = this.project.getColumn(this.col).getTasks().get(this.fil-1);
            String message1 = "DET:"+toRemove.getName();
            if (this.serverCom.sendDeleteTask(message1)){
                this.project.getColumn(this.col).getTasks().remove((this.fil-1));
            } else if (!this.serverCom.sendDeleteTask(message1)){}
            this.project.getColumn(column).addTask(task);
            if (this.serverCom.sendAddTask(task)){
                this.projectView = new ProjectView(this.project);
            } else {}
            this.newTaskView.dispose();
        }
        if (e.getActionCommand().equals("Cancelar NovaTasca")){
            if (this.newTaskView.isActive()){   this.newTaskView.dispose();}
            else if (this.newTaskView1.isActive()){ this.newTaskView1.dispose();}
        }
        if (e.getActionCommand().equals("Tancar Sessió")){
            //i més coses!!
            this.projectView.dispose();
            this.serverCom.interrupt();
        }
        if (e.getActionCommand().equals("Afegir Usuari")){
            String message, ownerName = this.project.getOwner().getNickname();
            System.out.println(ownerName);
            String userName = this.user.getNickname();
            System.out.println(userName);
            if (!ownerName.equals(userName)){
                this.makeDialog("You cannot add or delete members to/from this project!", false);
            } else if (ownerName.equals(userName)){
                String selectedUser = this.projectView.getSelectedUser();
                int i, j = 0, lon = this.project.getMembers().size();
                for (i = 0; i < lon; i++){
                    User m = this.project.getMembers().get(i);
                    if (m.getNickname().equals(selectedUser)){
                        j = 1;
                        break;
                    }
                }
                if (j == 0){
                    message = "JIN:"+selectedUser+"/"+this.project.getId();
                    if (this.serverCom.sendJoinProject(message)){
                        this.projectView.addMember(selectedUser);
                    }
                } else {
                    this.makeDialog("The selected user is already a member!", false);
                }
            }
        }
        if (e.getActionCommand().equals("Eliminar Usuari")){
            String message;
            String ownerName = this.project.getOwner().getNickname();
            String userName = this.user.getNickname();
            if (!ownerName.equals(userName)){
                this.makeDialog("You cannot add or delete members to/from this project!", false);
            } else if (ownerName.equals(userName)){
                if (this.projectView.checkSelectedMember()){
                    String memberSel = this.projectView.getSelectedMember();
                    message = "DMP:"+memberSel+"/"+this.project.getId();
                    System.out.println(message);
                    if (this.serverCom.sendDeleteMember(message)){
                        this.projectView.deleteMember();
                    }
                } else if (!this.projectView.checkSelectedMember()){
                    this.makeDialog("No member was selected to be deleted!", false);
                }
            }
        } else if (e.getActionCommand().startsWith("Tasca")){
            String command = e.getActionCommand();
            System.out.println(command);
            String taskName, message;
            this.col = Character.getNumericValue(command.charAt(5));
            this.fil = Character.getNumericValue(command.charAt(6));
            Task tt = this.project.getColumn(this.col).getTasks().get(this.fil-1);
            taskName = tt.getName();
            if (command.charAt(7) == '0'){
                //Editar
                System.out.println("Editar "+taskName);
                this.newTaskView1 = new NewTaskView();
                this.newTaskView1.registerController3(this);
                this.newTaskView1.loadCurrentState(tt);
                this.newTaskView1.loadAllMembers(project.getMembers().toArray());
            } else if (command.charAt(7) == '1'){
                //Eliminar
                System.out.println("Eliminar "+taskName);
                message = "DET:"+taskName;
                if (this.serverCom.sendDeleteTask(message)){
                    this.project.getColumn(this.col).getTasks().remove((this.fil-1));
                } else if (!this.serverCom.sendDeleteTask(message)){}
            }
            //han premut a una tasca!
        }
    }

    public void makeDialog(String message, boolean type){
        this.projectView.makeDialog(message,type);
    }

}
