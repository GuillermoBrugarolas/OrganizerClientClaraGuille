package model;

import java.net.Socket;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.MainViewController;
//import network.ServerCommunication;
import controller.UserViewController;
import network.ServerCommunication;
import view.MainView;

public class MainClient {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {

                Configuration config = new Configuration();
                if (config.configurate()){

                    MainView clientView = new MainView();
                    Logics logics = new Logics();
                    ServerCommunication serverCom = new ServerCommunication(config.getIp(), config.getPortServer());
                    MainViewController mainViewController = new MainViewController(clientView, logics, serverCom);

                    logics.registerMainViewController(mainViewController);
                    clientView.registerController(mainViewController);
                    serverCom.registerControllers(mainViewController, new UserViewController());
                    clientView.setVisible(true);

                }
            }
        });
    }
}

