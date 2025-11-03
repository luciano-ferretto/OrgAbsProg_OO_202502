package JavaHTTPSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {
    public static void main(String[] args) {
        int port = 80;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server running in port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Recebeu conexão");
                OutputStream out = clientSocket.getOutputStream();
                String response = "HTTP/1.1 200 OK\r\nContent-Length: 27\r\nContent-Type: JSON\r\n\r\n{\"greeting\": \"Hello World\"}";
                out.write(response.getBytes());
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}