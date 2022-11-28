package NotepadFunctionality;

import javax.swing.*;

public class GUI {

    public static void main(String[] args){
        new GUI(); //constructor calling
    }
    JFrame window;
    JTextArea textArea;
    JScrollPane ScrollPane;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenu menuEdit;
    JMenu menuFormat;
    JMenu menuColour;
    JMenuItem New, Open, Save, SaveAs, Exit;
//    JMenuItem


    //constructor
    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        FileMenu();
        window.setVisible(true);

        //createTextArea(); does not work here, text area needs to be defined first
    }
    //for creating basic window
    public void createWindow(){
        window = new JFrame("Student Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //for creating an area inside the window where you can write text
    public void createTextArea(){
        textArea = new JTextArea();
        window.add(textArea);

        ScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ScrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(ScrollPane);
    }

    public void createMenuBar(){

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColour = new JMenu("Colour");
        menuBar.add(menuColour);
    }

    public void FileMenu(){
        New = new JMenuItem("New");
        menuFile.add(New);

        Open = new JMenuItem("Open");
        menuFile.add(Open);

        Save = new JMenuItem("Save");
        menuFile.add(Save);

        SaveAs = new JMenuItem("SaveAs");
        menuFile.add(SaveAs);

        Exit = new JMenuItem("Exit");
        menuFile.add(Exit);
    }

}
