package controller;

import model.Logics;
import model.User;
import network.ServerCommunication;
import view.MainView;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Guillermo Brugarolas on 06/05/2018.
 */
public class MainViewController implements ActionListener {

    private MainView view;
    private UserView userView;
    private Logics logics;
    private ServerCommunication serverCom;
    private User user, userLoaded;

    public MainViewController(MainView view, Logics logics, ServerCommunication serverCom){
        this.view = view;
        this.logics = logics;
        this.serverCom = serverCom;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message;
        boolean regPasswords;
        if(((JButton)e.getSource()).getText().equals("Register")){
            message = view.getRegNickname()+"/"+view.getRegeMail()+"/"+view.getRegPassword1();
            regPasswords = view.checkRegPasswords();
            if (!logics.checkRegData(message, regPasswords)) {
                view.makeDialog("There are errors or blank spaces in your registration form!", false);
            } else if (logics.checkRegData(message, regPasswords)){
                message = "ADD:"+view.getRegNickname()+"/"+view.getRegeMail()+"/"+view.getRegPassword1();
                if (serverCom.sendAddUser(message)){
                    view.clearFields();
                }
            }
        }

        if(((JButton)e.getSource()).getText().equals("Log in")){
            if (view.checkLogFields()) {
                message = "LOG:" + view.getLogInNameMail() + "/" + view.getLogInPassword();
                if (serverCom.sendLogUser(message)) {
                    userView = new UserView();
                    message = "GET:" + view.getLogInNameMail();
                    userLoaded = serverCom.sendGetUser(message);
                    userView.loadUserData(userLoaded);
                    UserViewController userViewController = new UserViewController(userLoaded, userView, logics, serverCom, this);
                    userView.registerController(userViewController);
                }
            } else {
                makeDialog("There are errors or blank spaces in your Log In form!", false);
            }
        }
    }

    public void makeDialog(String message, boolean type){
        view.makeDialog(message,type);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
