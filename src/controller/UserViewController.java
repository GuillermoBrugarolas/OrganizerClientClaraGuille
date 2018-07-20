package controller;

import model.Logics;
import model.Project;
import model.User;
import network.ServerCommunication;
import view.NewProjectView;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Guillermo Brugarolas on 14/05/2018.
 */
public class UserViewController implements ActionListener {
    public User user;
    public Project project;
    private UserView userView;
    private Logics logics;
    private ServerCommunication serverCom;
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
        if(((JButton)e.getSource()).getText().equals("CREATE NEW PROJECT")){
            project = new Project();
            //userView.unlockProjectFields();
            //userView.clearProjectFields();
        }
        if(((JButton)e.getSource()).getText().equals("Nou Projecte")){
            NewProjectView newProjectView = new NewProjectView();
        }
        if(((JButton)e.getSource()).getText().equals("Share")){

        }
        if(((JButton)e.getSource()).getText().equals("Add Column")){

        }
        if(((JButton)e.getSource()).getText().equals("ADD PROJECT")){

        }
        if(((JButton)e.getSource()).getText().equals("JOIN PROJECT")){

        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
