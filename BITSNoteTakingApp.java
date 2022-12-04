package tracker;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BITSNoteTakingApp extends JFrame {
    private JPanel mainPanel;
    private JButton addNoteButton;
    private JButton displayAllNotesButton;
    private JTextField noteTextField;

    private JTextArea noteTextArea;
    private JComboBox<String> colorComboBox;
    private List<JTextArea> notes;

    public BITSNoteTakingApp() {
        setTitle("Note Pa(nel)d");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        notes = new ArrayList<>();

        addNoteButton = new JButton("Add Note");
        addNoteButton.addActionListener(e -> {
            String text = noteTextArea.getText();
            String color = (String) colorComboBox.getSelectedItem();
            addNote(text, color);
            noteTextArea.setText("");
        });

        noteTextArea = new JTextArea(5, 20);
        noteTextArea.setMaximumSize(noteTextArea.getPreferredSize());

        colorComboBox = new JComboBox<>(new String[]{"Red", "Green", "Blue", "Yellow", "Cyan", "Pink"});
        colorComboBox.setMaximumSize(colorComboBox.getPreferredSize());

        JPanel inputPanel = new JPanel();
        inputPanel.add(noteTextArea);
        inputPanel.add(colorComboBox);
        inputPanel.add(addNoteButton);

        mainPanel.add(inputPanel);

        setVisible(true);
    }

    private void addNote(String text, String color) {
        JTextArea note = new JTextArea(text);
        note.setBackground(getColor(color));
        note.setEditable(true);
        notes.add(note);
        mainPanel.add(note);
        revalidate();
    }

    private Color getColor(String colorName) {
        switch (colorName) {
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            case "Blue":
                return Color.BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Cyan":
                return Color.CYAN;
            case "Pink":
                return Color.PINK;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        BITSNoteTakingApp app = new BITSNoteTakingApp();
    }
}