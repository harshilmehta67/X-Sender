/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.*;
import java.io.*;

/**
 *
 * @author Harshil Mehta , Manav Patel , Harsh Kakasaniya 
 * AU1841010 - AU1841037 - AU1841085
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("192.168.43.208", 1268); 
            InputStream inStream = socket.getInputStream(); 
            DataInputStream dataIn = new DataInputStream(inStream)) 
        {
            String st = dataIn.readUTF();
            System.out.println(st);
        }
    }

}
