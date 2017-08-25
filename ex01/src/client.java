import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 1234);

        Scanner input = new Scanner(System.in);

        PrintStream output = new PrintStream(client.getOutputStream());

        while (input.hasNextLine()) {
            output.println(input.nextLine());
        }

        client.close();
    }
}
