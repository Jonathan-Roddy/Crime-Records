import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import Crime.Crime;
import Crime.CrimeDb;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jonathan Roddy
 */


public class CrimeServer {
    
  public static void main(String[] args) throws ClassNotFoundException {
    CrimeDb.doConnection();
    
    System.out.println("Server started....awaiting connections");
    
    
    try  {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);

      int clientNo = 1; // The number of a client

      while (true)   {
        // Listen for a new connection request
        Socket connectToClient = serverSocket.accept();

        // Print the new connect number on the console
        System.out.println("Start thread for client " + clientNo);

        // Find the client's host name, and IP address
        InetAddress clientInetAddress = connectToClient.getInetAddress();
        System.out.println("Client " + clientNo + "'s host name is " + clientInetAddress.getHostName());
        System.out.println("Client " + clientNo + "'s IP Address is "+ clientInetAddress.getHostAddress());

        String home = clientInetAddress.getHostName();
        String ip = clientInetAddress.getHostAddress();
        // Create a new thread for the connection
        HandleAClient thread = new HandleAClient(connectToClient);
        
        thread.start();// Start the new thread
        clientNo++;// Increment clientNo
      }
    }
    catch(IOException ex)  {
      System.err.println(ex);
    }
  }
}

// Define the thread class for handling a new connection
class HandleAClient extends Thread {

  private Socket connectToClient; // A connected socket
  private static ObjectOutputStream objOutStream;
  
  /**Construct a thread*/
  public HandleAClient(Socket socket)  {
    connectToClient = socket;
    
  }
    
  /**Implement the run() method for the thread*/
  public void run() {
    try{
        //Create data input for option functions
        DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
        
        // Sends object back to client
         objOutStream = new ObjectOutputStream(connectToClient.getOutputStream());
        getAllCrimes();        
        //get input from Client for the menu
        
        
        while(true)
        {
            boolean quit = false;
            do
            {    
                int inputFromClient = isFromClient.readInt();
                switch (inputFromClient) {
                case 1:
                    System.out.println("Client asked for All Crimes");
                    //getAllCrimes();
                    break;
                case 2:
                    System.out.println("Client asked for highest Crime");
                    break;
                case 3:   
                    System.out.println("Client asked for Total Crimes Per Offence Type");
                    break;
                case 4:  
                    System.out.println("Client asked for Most Crimes per Region");
                    break;
                case 5:  
                    System.out.println("Client asked for Total Crimes per year");
                    break;
                case 6:    
                    System.out.println("Client asked for Occurence");
                    break;
                case 7:
                    System.out.println("Client asked for what is nect for 2019 Q4");
                    break;
                default:
                    break;
                } 
            }while (!quit);
        }
    }
    
    catch(IOException ex) {
      System.err.println(ex);
    } 
    catch (SQLException ex) { 
          Logger.getLogger(HandleAClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
    private static void  getAllCrimes() throws SQLException, IOException
    {
        List<Crime> list = CrimeDb.getAllCrimes();
                displayAllCrimes(list);
    }
    
    private static void displayAllCrimes(List<Crime> allCrimes) throws IOException {
            System.out.println(allCrimes.size());
        objOutStream.writeObject(allCrimes);
    }//end displayAllCrimes    
}    