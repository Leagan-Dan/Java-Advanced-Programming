package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;
    private Server server= null;
    private BufferedReader in=null;
    private PrintWriter out = null;
    public ClientThread (Socket socket, Server server) {
        this.socket = socket ;
        this.server=server;
    }
    public void run () {
        try {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command = in.readLine();

            out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Server received the request: " + command;

            handleCommand(command);
            out.println(raspuns);
            out.flush();

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
    public void handleCommand(String command) throws IOException {
        if(command.equals("stop")) {
            out.println("Server stopped");
            out.flush();
            in.close();
            server.stop();
        }
    }
}