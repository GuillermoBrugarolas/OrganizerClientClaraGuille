package network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.UserViewController;
import model.User;
import controller.MainViewController;

public class ServerCommunication extends Thread{
	private Socket sServer;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	private ObjectInputStream objectIn;
	private ObjectOutputStream objectOut;
	private MainViewController mainViewController;
	private UserViewController userViewController;
	//private ProjectViewController projectViewController;
	private int portServer;

	public ServerCommunication(String ip, int portServer){
		this.portServer = portServer;
	}

	public void registerControllers(MainViewController mainViewController, UserViewController userViewController){
		this.mainViewController = mainViewController;
		this.userViewController = userViewController;
	}

	public boolean sendAddUser(String message){
		boolean next = false;
		try {
			sServer = new Socket("127.0.0.1",portServer);
			objectIn = new ObjectInputStream(sServer.getInputStream());
			objectOut = new ObjectOutputStream(sServer.getOutputStream());
			objectOut.writeObject(message);
			String answer;
			Object o = objectIn.readObject();
			answer = (String)o;
			if(answer.equals("OK")){
				mainViewController.makeDialog("The user has been successfully registered!",true);
				next = true;
			}else if(answer.equals("KO")){
				mainViewController.makeDialog("The user name is already taken!",false);
			}
			objectOut.close();
			objectIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Couldn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Couldn't connect with server", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return next;
	}

	public boolean sendLogUser(String message){
		boolean next = false;
		try {
			sServer = new Socket("127.0.0.1", portServer);
			objectIn = new ObjectInputStream(sServer.getInputStream());
			objectOut = new ObjectOutputStream(sServer.getOutputStream());
			objectOut.writeObject(message);
			String answer;
			answer = (String)objectIn.readObject();
			if(answer.startsWith("OK")){
				mainViewController.makeDialog("The user has been successfully logged in!",true);
				next = true;
			}else if (answer.startsWith("KO")){
				mainViewController.makeDialog("The user name or password is wrong!",false);
				next = false;
			}
			objectOut.close();
			objectIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return next;
	}

	public User sendGetUser(String message){
		User answer = new User();
		try {
			sServer = new Socket("127.0.0.1", portServer);
			objectIn = new ObjectInputStream(sServer.getInputStream());
			objectOut = new ObjectOutputStream(sServer.getOutputStream());
			objectOut.writeObject((String)message);
			answer = (User)objectIn.readObject();
			objectOut.close();
			objectIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return answer;
	}

	public String sendGetAllUsers(String message){
        String answer = "";
		try {
			sServer = new Socket("127.0.0.1", portServer);
			objectOut = new ObjectOutputStream(sServer.getOutputStream());
			objectIn = new ObjectInputStream(sServer.getInputStream());
			objectOut.writeObject((String)message);
			Object o = objectIn.readObject();
			if (o instanceof String) {
                answer = (String) o;
                if (answer.startsWith("KO")) {
                    mainViewController.makeDialog("There are no users in the database!", false);
                }
            }
            objectOut.close();
			objectIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return answer;
	}
}
