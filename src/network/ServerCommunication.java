package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.UserViewController;
import model.User;
import controller.MainViewController;

public class ServerCommunication extends Thread{
	private Socket sServer;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
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
			dataIn = new DataInputStream(sServer.getInputStream());
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			String answer;
			answer = dataIn.readUTF();
			if(answer.equals("OK")){
				mainViewController.makeDialog("The user has been successfully registered!",true);
				next = true;
			}else if(answer.equals("KO")){
				mainViewController.makeDialog("The user name is already taken!",false);
			}
			dataOut.close();
			dataIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Couldn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Couldn't connect with server", false);
		}
		return next;
	}

	public boolean sendLogUser(String message){
		boolean next = false; 
		try {
			sServer = new Socket("127.0.0.1", portServer);
			dataIn = new DataInputStream(sServer.getInputStream());
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			String answer;
			answer = dataIn.readUTF();
			if(answer.startsWith("OK")){
				mainViewController.makeDialog("The user has been successfully logged in!",true);
				//mainViewController.user = new User (user.getNickname(), user.getEmail(), user.getPassword());
				next = true;
			}else if (answer.startsWith("KO")){
				mainViewController.makeDialog("The user name or password is wrong!",false);
				next = false;
			}
			dataOut.close();
			dataIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		}
		return next;
	}

	public String sendGetUser(String message){
		String answer = "";
		try {
			sServer = new Socket("127.0.0.1", portServer);
			dataIn = new DataInputStream(sServer.getInputStream());
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(message);
			answer = dataIn.readUTF();
            if (answer.startsWith("KO")){
                mainViewController.makeDialog("The user could not be retrieved from the database!",false);
                return "";
            }
			dataOut.close();
			dataIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		}
		return answer;
	}

	public String sendGetAllUsers(String message){
	    String answer="";
		try {
            sServer = new Socket("127.0.0.1", portServer);
            dataIn = new DataInputStream(sServer.getInputStream());
            dataOut = new DataOutputStream(sServer.getOutputStream());
            dataOut.writeUTF(message);
            answer = dataIn.readUTF();
            if (answer.startsWith("KO")){
                mainViewController.makeDialog("There are no users in the database!",false);
            }
			dataOut.close();
			dataIn.close();
			sServer.close();
		} catch (UnknownHostException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		} catch (IOException e) {
			mainViewController.makeDialog("Coudn't connect with server", false);
		}
        return answer;
	}
}
