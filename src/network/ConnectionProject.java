package network;

import model.Project;
import model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionProject {

    private Socket serverSocket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ConnectionProject(){
        serverSocket= null;
        dos=null;
        dis=null;
    }

    //Realitzarem la conexió amb el servidor
    private void connect(){
        try{
            serverSocket= new Socket("83.12.12.27", 2727);
            dos= new DataOutputStream(serverSocket.getOutputStream());
            dis= new DataInputStream(serverSocket.getInputStream());
        }catch(IOException e){
            System.err.println("[CONNECT]"+ e.getMessage());
        }
    }

    //Realitzarem la desconexio mb el servidor
    private void disconnect(){
        try{
            dos.close();
        }catch(IOException | NullPointerException e){
            System.err.println("[DISCONECT]"+ e.getMessage());
        }
        try {
            dis.close();
        } catch (IOException | NullPointerException e) {
            System.err.println("[DISCONNECT] " + e.getMessage());
        }try {
            serverSocket.close();
        } catch (IOException | NullPointerException e) {
            System.err.println("[DISCONNECT] "+e.getMessage());
        }
    }

    public boolean removeProject(String nom, ArrayList<Project> Projects) {

        boolean status = false;
        connect();

        try {
            dos.writeUTF("Eliminar Project");
            dos.writeUTF(nom);
            status= dis.readBoolean();
            if(status){
                for(Project p: Projects) {
                    if(p.getName().equals(nom)){
                        Projects.remove(p);

                    }
                }
            }

            status = dis.readBoolean();
        } catch (IOException | NullPointerException e) {
            System.err.println("[Eliminar]" + e.getMessage());
        } finally {
            disconnect();
        }

        return status;
    }

    public boolean nouProject(String nomProject, ArrayList<User> usuaris, int columnes){

        boolean status = false;
        connect();

        try {
            dos.writeUTF("Registrar");
            dos.writeUTF(nomProject);
            for(User u: usuaris){
                dos.writeUTF(u.getNickname());
            }

            dos.writeInt(columnes);

            status = dis.readBoolean();
        } catch (IOException | NullPointerException e) {
            System.err.println("[Registrar]" + e.getMessage());
        } finally {
            disconnect();
        }

        return status;

    }

    public String getUsuari(){

        String response = "";
        connect();
        try {
            dos.writeUTF("Iniciar Sessio");
            response = dis.readUTF();
        } catch (IOException | NullPointerException e) {
            System.err.println("[GET] "+ e.getMessage());
        } finally {
            disconnect();
        }

        return response;
    }
}
