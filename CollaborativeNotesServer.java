package tracker;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.swing.*;

public class CollaborativeNotesServer {
    public static void main(String[] args) {
        // Create a server socket to listen on port 8080
        // Creating a server side socket and connecting it to port 8080
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            // Create the UI for the server side panel
            JFrame frame = new JFrame("BITS Collaborative Notepad");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea textArea = new JTextArea();
            frame.add(textArea);
            frame.setVisible(true);

            // Listen for incoming connections
            // While you are getting incoming connections on the connecting port
            // We do not have to terminate and keep the server side running as long as the connections are being made from the client side
            while (true) {
                // Accepting an incoming connection from the client side as long as we are getting connection requests from the client side
                //On the client side, we have the BITSsocket defined as the client connection, in the CollaborativeNotesUI
                Socket BITSsocket = serverSocket.accept();

                // Read the notes from the input stream
                DataInputStream in = new DataInputStream(BITSsocket.getInputStream());
                String notes = in.readUTF();

                // Get the hostname of the client to capture where we have received the note from
                String hostname;
                hostname = BITSsocket.getInetAddress().getHostName();
                String ipaddress;
                ipaddress = String.valueOf(BITSsocket.getInetAddress().getLocalHost());

                // Adding the notes and the
                textArea.append( "Note from " + hostname +"("+ipaddress+")"+ ": " + notes  + "\n");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
