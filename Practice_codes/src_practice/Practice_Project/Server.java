/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice_Project;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author darpan
 */
public class Server 
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket s = new ServerSocket(1258);
        Socket s1 = s.accept();
        OutputStream s1_out = s1.getOutputStream();
        DataOutputStream docs = new DataOutputStream(s1_out);
        Scanner sc = new Scanner(System.in);
        String s2 = sc.nextLine();
        docs.writeUTF(s2);       
        docs.close();
        s1_out.close();
        s1.close();
    }    
}
