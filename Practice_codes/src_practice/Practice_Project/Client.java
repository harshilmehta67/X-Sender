/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice_Project;
import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author darpan
 */
public class Client 
{
    public static void main(String[] args) throws IOException
    {
        Socket s3 = new Socket("localHost",1258);
        InputStream s1_in = s3.getInputStream();
        DataInputStream dics = new DataInputStream(s1_in);
        String st = new String(dics.readUTF());
        System.out.println(st);
        dics.close();
        s1_in.close();
        s3.close();
    }    
}
