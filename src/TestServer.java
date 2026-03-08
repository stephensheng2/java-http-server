import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class TestServer {
    public static void main(String[] args) throws Exception {
        int port = 1234;

        var serverSocket = new ServerSocket(port);
        var systemScanner = new Scanner(System.in);

        while (true) {
            var socket = serverSocket.accept();

            var socketIn = socket.getInputStream();

            var socketScanner = new Scanner(socketIn);

            var socketOut = new PrintStream(socket.getOutputStream(), true);

            socketOut.println("HTTP/1.1 200 OK");
            socketOut.println("Content-Type: text/html");
            socketOut.println("Content-Length: 11");
            socketOut.println();
            socketOut.println("hello" + " world");

            System.out.println("done");
        }
    }
}
