package controller;

//import Finestra.NewProjectView;
//import Finestra.UserView;
//import Network.ConnectionProject;

import view.NewProjectView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewProjectController implements ActionListener {

    private NewProjectView newProjectView;

    public NewProjectController(NewProjectView newProject){
        this.newProjectView = newProject;
    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Afegir Membre")){
            newProjectView.addUser();
        }

        if (e.getActionCommand().equals("Eliminar Membre")){
            newProjectView.deleteFromList();
        }
//
//        String nom= newProject.getJtfNom().getText();
//        LinkedList<Usuari> usuaris = new LinkedList<>();
//
////        for (Usuari u: newProject.getJcbMembres()){
////            usuaris.add(u);
////        }
////
////        Object columnes = newProject.getJsColumna().getValue();
////        JColorChooserDemo color= newProject.getColorModel();
////        LinkedList<Etiqueta> etiquetes = newProject.get
//        Projecte projecte;
//
//        switch (event.getActionCommand()){
//
//            case "Nou Projecte":
//
//                pantallaInicial.setVisible(false);
//                newProject.setVisible(true);
//
//
//                projecte = new Projecte();
//                pantallaInicial.addProjectLeft(projecte.getNom());
//
//
//
//
//        }else{
//                        // error.setVisible(true);
//                    }
//                    break;
//
//                case "Registrar" :
//
//                    registrarse.setVisible(true);
//                    boolean status = connectionUsers.afegirUsuari(nom,correu,contrasenya,contrasenya2);
//
//
//                    if(status|| registrarse.getJbRegistrarse().isDefaultButton()){
//                        registrarse.setVisible(false);
//                        pantallaInicial.setVisible(true);
//                    }else {
//                        //error.setVisible(true);
//                    }
//                    break;
//
//                default:
//                    break;
//            }
//        }
//    }
    }
}