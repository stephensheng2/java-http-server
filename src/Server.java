import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // my device's ip: 10.0.0.20
        // find using ifconfig on mac, ipconfig on windows

        System.out.println("Wesh");

        int i = Integer.parseInt("67");
        System.out.println(i);

        int port = 1234;

        var serverSocket = new ServerSocket(port);
        var socket = serverSocket.accept();

        var socketIn = socket.getInputStream();

        var systemScanner = new Scanner(System.in);
        var socketScanner = new Scanner(socketIn);

        var socketOut = new PrintStream(socket.getOutputStream(), true);

        System.out.println("Please enter your username:");
        String username = systemScanner.nextLine();

        String prefix = "<" + username + ">: ";

        System.out.println("\nWelcome to the chatroom! Type a message and press enter to send it.");

        while (true) {
            if (System.in.available() > 0) {
                String message = systemScanner.nextLine();
                System.out.println(prefix + message); // print to own console
                socketOut.println(prefix + message); // print to server socket
            }

            if (socketIn.available() > 0){
                String message = socketScanner.nextLine();
                System.out.println(message); // print to own console
            }



        }
    }
}