package tracker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollaborativeNotesGUI extends JFrame {
    //creating a GUI to enter your notes
    private JTextArea notesArea;
    private JButton sendButton;
    private JButton clearButton;
    private JButton allNotesButton;
    private JButton taskButton;
    private JLabel taskLabel;
    private JColorChooser colorChooser; //color pallete for your notes, in the color you want to send

    // creating a basic socket to communicate with the server
    private Socket BITSsocket;

    // List to store the sent notes
    private List<String> notesList;

    //constructor
    public CollaborativeNotesGUI() {
        // Set up the UI
        setLayout(new FlowLayout()); // to lay out buttons in a Directional Flow
        setTitle("BITS Collaborative Notepad : Your Note Sender");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        taskLabel = new JLabel();
        notesArea = new JTextArea();
        sendButton = new JButton("Send");
        //taskButton = new JButton("Send");
        clearButton = new JButton("Clear");
        allNotesButton = new JButton("All notes");
        colorChooser = new JColorChooser(); //for color pallette

        // Adding all the GUI components to the frame
        add(notesArea);
        System.out.println("\n");
        add(taskLabel);
        add(sendButton);
        //add(taskButton);
        add(clearButton);
        add(allNotesButton);
        add(colorChooser);


        // Maintaining a list of all notes
        notesList = new ArrayList<>();

        // Create a socket to communicate with the server
        try {
            CollaborativeNotesServer.main(null);
            BITSsocket = new Socket("localhost", 8080); // gets allocated only if we hava a server side running on the same port i.e. 8080 in this case
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adding an actionListener to the Send Button, to notify about button click

        // lambda is used here for the anonymous new ActionListener
        sendButton.addActionListener(e -> {
            // Get the notes from the text area
            String notes = notesArea.getText();
            Color color = colorChooser.getColor();

            // Add the notes and color to the list
            notesList.add(notes);

            // Send the notes and color to the server using sockets
            try {
                DataOutputStream out = new DataOutputStream(BITSsocket.getOutputStream());
                out.writeUTF(notes);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        /*
        taskButton.addActionListener(e -> {
            // Clears the note list from the local client
            String task = taskLabel.getText();
            taskLabel.setText("");
            // Clear the text field
            notesArea.setText("");
        });
        */

        // Add an action listener to the clear button
        clearButton.addActionListener(e -> {
            // Clears the note list from the local client
            notesList.clear();

            // Clear the text field
            notesArea.setText("");
        });

        allNotesButton.addActionListener(e -> {
            // Prints all notes to the console
            Iterator itr = notesList.iterator();
            while (itr.hasNext()){
                String obj = (String) itr.next();
                System.out.println(obj);
            }
            // Clear the text field
            notesArea.setText("");
        });
    }

    public static void main(String[] args) {
        CollaborativeNotesGUI frame = new CollaborativeNotesGUI();
        frame.setVisible(true);
    }
}