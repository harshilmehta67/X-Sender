package project;

import java.io.*;
import static java.lang.Integer.MAX_VALUE;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFileTransfer {

    public final static int SOCKET_PORT = 13289;  // you may change this
    public final static String FILE_TO_SEND = "C:\\Users\\vivek\\Documents\\NetBeansProjects\\Project\\src\\project\\x.txt";  // you may change this

    public static void main(String[] args) throws IOException {
        FileInputStream Fileinputstream = null;
        BufferedInputStream Bufferedinput = null;
        OutputStream os = null;
        ServerSocket server = null;
        Socket sock = null;
        try {
            server = new ServerSocket(SOCKET_PORT);
            while (true) {
                System.out.println("Waiting...");
                try {
                    sock = server.accept();
                    System.out.println("Accepted connection : " + sock);
                    // send file
                    File myFile = new File(FILE_TO_SEND);
                    byte[] bytearray = new byte[(int)myFile.length()];
                    Fileinputstream = new FileInputStream(myFile);
                    Bufferedinput = new BufferedInputStream(Fileinputstream);
                    Bufferedinput.read(bytearray, 0, bytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending " + FILE_TO_SEND + "(" + bytearray.length + " bytes)");
                    os.write(bytearray, 0, bytearray.length);
                    os.flush();
                    System.out.println("Done.");
                } finally {
                    if (Bufferedinput != null) {
                        Bufferedinput.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                    if (sock != null) {
                        sock.close();
                    }
                }
            }
        } finally {
            if (server != null) {
                server.close();
            }
        }
    }
}
