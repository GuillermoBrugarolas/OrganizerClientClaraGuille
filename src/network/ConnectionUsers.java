package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionUsers {

    private Socket serverSocket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ConnectionUsers(){
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

    public boolean afegirUsuari(String nom, String correu, String password,String password2){
        boolean status= false;

        connect();

        try{
            dos.writeUTF("Registrar");
            dos.writeUTF(nom);
            dos.writeUTF(correu);
            dos.writeUTF(password);
            dos.writeUTF(password2);
            status= dis.readBoolean();
        }catch(IOException|NullPointerException e){
            System.err.println("[Registrar]" + e.getMessage());
        }finally{
            disconnect();
        }

        return status;
    }

    public boolean loginUser(String name, String password) {

        boolean status = false;
        connect();

        try {
            dos.writeUTF("Iniciar Sessio");
            dos.writeUTF(name);
            dos.writeUTF(password);
            status = dis.readBoolean();

        } catch (IOException | NullPointerException e ) {
            System.err.println("[Iniciar Sessio] "+ e.getMessage());
        }
        finally {
            disconnect();
        }

        return status;
    }
}
