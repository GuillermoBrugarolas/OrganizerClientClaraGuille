package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.*;

import controller.MainViewController;

//import controller.MainViewControllerS;


public class MainView extends JFrame {

    private JPanel jpMainMenu = new JPanel();
    private static JLabel jlTitle = new JLabel("ORGANIZER CLIENT");
    private static JPanel jpRegister = new JPanel();
    private static JLabel jlNameReg = new JLabel("Name:");
    private static JTextField jtfNameReg = new JTextField();
    private static JLabel jlEMailReg = new JLabel("EMail:");
    private static JTextField jtfEMailReg = new JTextField();
    private static JLabel jlPassword1Reg = new JLabel("Password:");
    private static JPasswordField jpfPassword1Reg = new JPasswordField();
    private static JLabel jlPassword2Reg = new JLabel("Confirm password:");
    private static JPasswordField jpfPassword2Reg = new JPasswordField();
    private static JButton jbRegister = new JButton("Register");
    private static JPanel jpLogIn = new JPanel();
    private static JLabel jlNameMailLogIn = new JLabel("Name/EMail:");
    private static JTextField jtfNameMailLogIn = new JTextField();
    private static JLabel jlPasswordLogIn = new JLabel("Password:");
    private static JPasswordField jpfPasswordLogIn = new JPasswordField();
    private static JButton jbLogIn = new JButton("Log in");

    public MainView() {
        ImageIcon image = new ImageIcon("logo.png");
        JLabel imageLabel = new JLabel(image);
        add(imageLabel, BorderLayout.NORTH);
        jpMainMenu.setLayout(new FlowLayout());
        jtfEMailReg.setPreferredSize(new Dimension(120, 10));
        jtfNameReg.setPreferredSize(new Dimension(120, 10));
        jpfPassword1Reg.setPreferredSize(new Dimension(120, 10));
        jpfPassword2Reg.setPreferredSize(new Dimension(120, 10));
        jtfNameMailLogIn.setPreferredSize(new Dimension(120, 10));
        jpfPasswordLogIn.setPreferredSize(new Dimension(120, 10));
        jpRegister.setLayout(new GridLayout(0, 2));
        jpRegister.add(jlNameReg);
        jpRegister.add(jtfNameReg);
        jpRegister.add(jlEMailReg);
        jpRegister.add(jtfEMailReg);
        jpRegister.add(jlPassword1Reg);
        jpRegister.add(jpfPassword1Reg);
        jpRegister.add(jlPassword2Reg);
        jpRegister.add(jpfPassword2Reg);
        jpRegister.add(jbRegister);
        jpRegister.setBorder(BorderFactory.createTitledBorder("Register in Organizer"));
        jpMainMenu.add(jpRegister);
        jpLogIn.setLayout(new GridLayout(0, 2));
        jpLogIn.add(jlNameMailLogIn);
        jpLogIn.add(jtfNameMailLogIn);
        jpLogIn.add(jlPasswordLogIn);
        jpLogIn.add(jpfPasswordLogIn);
        jpLogIn.add(jbLogIn);
        jpLogIn.setBorder(BorderFactory.createTitledBorder("Log In in Organizer"));
        jpMainMenu.add(jpLogIn);
        this.getContentPane().add(jpMainMenu, BorderLayout.CENTER);
        setTitle("Organizer Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void registerController(MainViewController actionListener){
        jbRegister.addActionListener(actionListener);
        jbLogIn.addActionListener(actionListener);
    }

    public void makeDialog(String message, boolean type){
        if(type){
            Dialog.DialogOK(message);
        }else{
            Dialog.DialogKO(message);
        }
    }

    public String getRegNickname() {
        return jtfNameReg.getText();
    }

    public String getRegeMail() {
        return jtfEMailReg.getText();
    }

    public String getRegPassword1() {
        return String.valueOf(jpfPassword1Reg.getPassword());    }

    public String getLogInNameMail() {
        return jtfNameMailLogIn.getText();
    }

    public String getLogInPassword() {
        return String.valueOf(jpfPasswordLogIn.getPassword());
    }

    public boolean checkRegPasswords() {
        return (Arrays.equals(jpfPassword1Reg.getPassword(), jpfPassword2Reg.getPassword()));
    }

    public void clearFields() {
        jtfNameReg.setText("");
        jtfEMailReg.setText("");
        jpfPassword1Reg.setText("");
        jpfPassword2Reg.setText("");
        jtfNameMailLogIn.setText("");
        jpfPasswordLogIn.setText("");
    }

    public boolean checkLogFields(){
        return !(jtfNameMailLogIn.getText() == null || jtfNameMailLogIn.getText().equals(""));
    }
}
