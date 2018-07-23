package network;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.UserViewController;
import model.Project;
import model.Task;
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

	public Project sendGetProject(String message){
		Project answer = new Project();
		try {
			sServer = new Socket("127.0.0.1", portServer);
			objectIn = new ObjectInputStream(sServer.getInputStream());
			objectOut = new ObjectOutputStream(sServer.getOutputStream());
			objectOut.writeObject((String)message);
			answer = (Project)objectIn.readObject();
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

	public boolean sendNewProject(Project p){
        boolean added = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((Project)p);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("The new project has been successfully added to the database!",true);
                added = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("The new project could not be added to the database!",false);
                added = false;
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
        return added;
    }

    public boolean sendAddTask(Task t){
        boolean added = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((Task)t);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("The new task has been successfully added to the database!",true);
                added = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("The new task could not be added to the database!",false);
                added = false;
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
        return added;
    }

    public boolean sendDeleteProject(String message){
        boolean next = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((String)message);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("The project has been successfully deleted!",true);
                next = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("The project could not be deleted!",false);
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

    public boolean sendJoinProject(String message){
        boolean ok = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((String)message);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("Successfully joined the project!",true);
                ok = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("Could not join project / project does not exist!",false);
                ok = false;
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
        return ok;
    }

    public boolean sendDeleteMember(String message){
        boolean ok = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((String)message);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("Successfully removed from the project!",true);
                ok = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("Could not be removed from the project!",false);
                ok = false;
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
        return ok;
    }

    public boolean sendDeleteTask(String message){
        boolean ok = false;
        try {
            sServer = new Socket("127.0.0.1", portServer);
            objectIn = new ObjectInputStream(sServer.getInputStream());
            objectOut = new ObjectOutputStream(sServer.getOutputStream());
            objectOut.writeObject((String)message);
            String answer;
            answer = (String)objectIn.readObject();
            if(answer.startsWith("OK")){
                mainViewController.makeDialog("Successfully removed task from the database!",true);
                ok = true;
            }else if (answer.startsWith("KO")){
                mainViewController.makeDialog("Could not remove task from the database!",false);
                ok = false;
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
        return ok;
    }
}
