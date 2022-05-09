package compulsory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8100;
    private boolean stop=false;

    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (!stop) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket,this).start();
            }
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            serverSocket.close();
        }
    }

    public void stop(){
        this.stop=true;

    }
}