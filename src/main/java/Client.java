import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost",4444); // Create socket object to connect to server.

        while (true) {

            InputStreamReader inReader = new InputStreamReader(client.getInputStream()); //Read incoming data line by line (Used BufferedReader).
            BufferedReader bfReader = new BufferedReader(inReader);

            PrintWriter print = new PrintWriter(client.getOutputStream()); // to send data to the client.

            System.out.println("Send Message:");

            Scanner scanner = new Scanner(System.in);
            print.println(scanner.nextLine()); // Send request to server.
            print.flush(); // send from hold.

            System.out.println("Incoming Data: " + bfReader.readLine()); // Read the incoming request.
        }
    }
}
