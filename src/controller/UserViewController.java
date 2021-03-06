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
    public User user = new User();
    public Project project = new Project();
    private UserView userView = new UserView();
    private Logics logics = new Logics();
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
        String message, dontInclude="";
        int nnn;
        if((e.getActionCommand().equals("Nou Projecte"))){
            NewProjectView newProjectView = new NewProjectView();
            NewProjectController newProjectController = new NewProjectController(newProjectView);
            newProjectView.registerController(newProjectController);
            message = "GEU:";
            System.out.println("let's try");
            String sUsersList = serverCom.sendGetAllUsers(message);
            System.out.println(sUsersList);
            if (!sUsersList.equals("")) {
                String[] saUsersList = logics.parseAllUsersData(sUsersList);
                int ll = saUsersList.length;
                System.out.println(String.valueOf(ll));
                for (nnn = 0; nnn < ll; nnn++){
                    System.out.println(saUsersList[nnn]);
                    if (saUsersList[nnn].equals(user.getNickname())){
                        dontInclude = saUsersList[nnn];
                    }
                }
                newProjectView.loadAllUserNames(saUsersList, dontInclude);
            } else {
                userView.makeDialog("Error loading all the users from database", false);
            }
        }

        if((e.getActionCommand().equals("Eliminar Projecte"))){

        }
        if((e.getActionCommand().equals("Editar Projecte"))){

        }
        if (((JButton)e.getSource()).getText().equals("Search")){

        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
