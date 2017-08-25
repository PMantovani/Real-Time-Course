import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket;

        socket = new ServerSocket(1234);

        Socket client = socket.accept();

        String hostAddress = client.getInetAddress().getHostAddress();
        System.out.println("Client connected: " + hostAddress);

        Scanner s = new Scanner(client.getInputStream());
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

        client.close();
        socket.close();
    }
}