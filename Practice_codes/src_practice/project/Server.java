// A Java program for a Server 
package project ;

import java.net.*; 
import java.io.*; 
  
public class Server 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    // constructor with port 
    public Server(int port) 
    { 
        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
            
            //////////////////////////////////////////////////////////////
//            File fp = new File("C:\\Users\\vivek\\Documents\\NetBeansProjects\\Project\\src\\project\\x") ;
//            byte b[] = new byte[(int)fp.length()] ;
//            FileInputStream fis = new FileInputStream(fp);
//            BufferedInputStream bis = new BufferedInputStream(fis) ;
//            bis.read(b,0,b.length) ;
//            OutputStream os = socket.getOutputStream();
//            System.out.println("Sending files....");
//            os.write(b,0,b.length);
//            os.flush();
            
            //////////////////////////////////////////////////////////////
            
            // takes input from the client socket 
            in = new DataInputStream( 
                new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = in.readLine(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        }
    } 
  
    public static void main(String args[]) 
    { 
        Server server = new Server(5016); 
    } 
} 