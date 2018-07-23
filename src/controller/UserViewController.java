package controller;

import model.Logics;
import model.Project;
import model.User;
import network.ServerCommunication;
import view.NewProjectView;
import view.ProjectView;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Guillermo Brugarolas on 14/05/2018.
 */
public class UserViewController implements ActionListener {
    public User user = new User();
    public Project project = new Project();
    private UserView userView = new UserView();
    private Logics logics = new Logics();
    private ServerCommunication serverCom;
    private String[] saUsersList;
    private MainViewController mainViewController;

    public UserViewController() {
    }

    public UserViewController(User user, UserView userView, Logics logics, ServerCommunication serverCom, MainViewController mainViewController) {
        this.user = user;
        this.userView = userView;
        this.logics = logics;
        this.serverCom = serverCom;
        this.mainViewController = mainViewController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message, dontInclude="";
        int nnn;
        if((e.getActionCommand().equals("Nou Projecte"))){
            NewProjectView newProjectView = new NewProjectView();
            NewProjectController newProjectController = new NewProjectController(newProjectView, user, serverCom, logics, this);
            newProjectView.registerController(newProjectController);
            this.getAllUsers();
            int ll = this.saUsersList.length;
            if (ll > 0){
                for (nnn = 0; nnn < ll; nnn++){
                    if (this.saUsersList[nnn].equals(this.user.getNickname())){
                        dontInclude = this.saUsersList[nnn];
                    }
                }
                newProjectView.loadAllUserNames(this.saUsersList, dontInclude);
            } else {
                userView.makeDialog("Error loading all the users from database", false);
            }
            this.userView.clearSelection();
        }

        if((e.getActionCommand().equals("Eliminar Projecte"))){
            if (this.userView.checkOwnProjSelected()){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Do you really want to delete this project?","Warning",dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION) {
                    String projectName;
                    Project pp;
                    pp = this.userView.getSelectedOwnProj();
                    projectName = pp.getName();
                    message = "DEL:"+projectName;
                    if (this.serverCom.sendDeleteProject(message)){
                        this.userView.deleteProject();
                    } else {}
                    // Delete
                }
            } else if (!this.userView.checkOwnProjSelected()){
                if (this.userView.checkJoinedProjSelected()){
                    this.makeDialog("You cannot delete a project you are not the owner of!", false);
                } else if (!this.userView.checkJoinedProjSelected()){
                    this.makeDialog("No project is selected!", false);
                }
            }
            this.userView.clearSelection();
        }
        if((e.getActionCommand().equals("Editar Projecte"))){
            Project chosenProject = new Project();
            if (this.userView.checkOwnProjSelected()){
                chosenProject = this.userView.getSelectedOwnProj();
            } else if (!this.userView.checkOwnProjSelected()){
                if (this.userView.checkJoinedProjSelected()){
                    chosenProject = this.userView.getSelectedJoinedProj();
                } else if (!this.userView.checkJoinedProjSelected()){
                    this.makeDialog("No project selected!", false);
                }
            }
            Project projectToLoad;
            message = "GEP:"+chosenProject.getName();
            projectToLoad = this.serverCom.sendGetProject(message);
            ProjectView projectView = new ProjectView(projectToLoad);
            this.getAllUsers();
            projectView.loadAllUsers(this.saUsersList);
            ProjectViewController projectViewController = new ProjectViewController(projectView, projectToLoad, this.serverCom);
            projectView.registerController(projectViewController);
            this.userView.clearSelection();
        }
        if((e.getActionCommand().equals("Tancar Sessió"))){
            this.userView.dispose();
            this.serverCom.stop();
        }
        if ((e.getActionCommand().equals("Join Project"))){
            message = "JIN:"+user.getNickname()+"/"+this.userView.getID();
            System.out.println(message);
            if (serverCom.sendJoinProject(message)){
            }
        }
    }

    public void loadUser(User user){
        this.userView.loadUserData(user);
    }

    public void makeDialog(String message, boolean type){
        this.userView.makeDialog(message,type);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void getAllUsers(){
        String message = "GEU:";
        String sUsersList = serverCom.sendGetAllUsers(message);
        if (!sUsersList.equals("")) {
            this.saUsersList = logics.parseAllUsersData(sUsersList);
        } else {
            userView.makeDialog("Error loading all the users from database", false);
        }
    }
}
