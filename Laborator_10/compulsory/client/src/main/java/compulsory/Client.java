package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String serverAddress = "127.0.0.1";
    private int PORT = 8100;
    private Scanner scanner = new Scanner(System.in);
    private boolean exit = false;

    public Client() {
        while (!exit) {
            try (
                    Socket socket = new Socket(serverAddress, PORT);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String command = scanner.nextLine();

                out.println(command);
                if (command.equals("exit")) {
                    exit = true;
                    break;
                }

                String response = in.readLine();
                System.out.println(response);


            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}