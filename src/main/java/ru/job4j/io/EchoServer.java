package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String msg = in.readLine();
                    System.out.println(msg);
                    switch (msg) {
                        case "GET /?msg=Exit HTTP/1.1" -> {
                            out.write("closing the server\r\n".getBytes());
                            server.close();
                        }
                        case "GET /?msg=Hello HTTP/1.1" -> out.write("Hello\r\n".getBytes());
                        default -> out.write("What?\r\n".getBytes());
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}
