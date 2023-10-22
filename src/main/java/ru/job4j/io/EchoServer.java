package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String msg = in.readLine();
                    System.out.println(msg);
                    if ("GET /?msg=Bye HTTP/1.1".equals(msg)) {
                        out.write("Bye\r\n".getBytes());
                        server.close();
                    }
                    out.flush();
                }
            }
        }
    }
}
