import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server =  new ServerSocket(4444); // Created ServerSocket Object. Listening on port 4444.

        Socket client = server.accept(); // It provides communication between the client and the server when a connection is made (input and output data).

        while (true) {

            InputStreamReader inReader = new InputStreamReader(client.getInputStream()); //Read incoming data line by line (Used BufferedReader).
            BufferedReader bfReader = new BufferedReader(inReader);

            PrintWriter print = new PrintWriter(client.getOutputStream()); // to send data to the client.

            String incomingData = bfReader.readLine(); // process of reading incoming data.
            System.out.println("Incoming Data: " + incomingData);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Send Message:");
            String send = scanner.nextLine();

            print.println(send);
            print.flush(); // send from hold.
        }
    }
}
