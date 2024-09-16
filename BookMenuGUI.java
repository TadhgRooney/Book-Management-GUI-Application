import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class BookMenuGUI {

    ArrayList<book> books = new ArrayList<>(); // Store book objects

    public BookMenuGUI() {
        createMainMenu(); // Create the main menu window
    }

    // Method to create the main menu window
    private void createMainMenu() {
        // Create the main frame
        JFrame mainFrame = new JFrame("Book Menu");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 150);

        // Create the "Add a Book", "View Books", and "Exit" buttons
        JButton addButton = new JButton("Add a Book");
        JButton viewButton = new JButton("View Books");
        JButton exitButton = new JButton("Exit");

        // Add action listener for "Add a Book" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAddBookWindow(); // Open the add book window
            }
        });

        // Add action listener for "View Books" button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createViewBooksWindow(); // Open the view books window
            }
        });

        // Add action listener for "Exit" button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Add buttons to a panel
        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(exitButton);

        // Add the panel to the main frame
        mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
        mainFrame.setVisible(true); // Make the main frame visible
    }

    // Method to create the add book window
    private void createAddBookWindow() {
        // Create the add book frame
        JFrame addBookFrame = new JFrame("Add a Book");
        addBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addBookFrame.setSize(400, 300);

        // Create labels and text fields for book details
        JLabel nameLabel = new JLabel("Book Name:");
        JTextField nameField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField(20);

        JLabel likeLabel = new JLabel("What you liked:");
        JTextField likeField = new JTextField(20);

        JLabel learnLabel = new JLabel("What you learned:");
        JTextField learnField = new JTextField(20);

        JLabel thoughtsLabel = new JLabel("Other thoughts:");
        JTextField thoughtsField = new JTextField(20);

        // Create the "Save" button
        JButton saveButton = new JButton("Save");

        // Add action listener for the "Save" button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get book details from text fields
                String bookName = nameField.getText();
                String bookAuthor = authorField.getText();
                String bookLike = likeField.getText();
                String bookLearn = learnField.getText();
                String bookThoughts = thoughtsField.getText();

                // Create a new book object
                book newBook = new book(bookName, bookLike, bookLearn, bookThoughts, bookAuthor);

                // Add the new book to the list
                books.add(newBook);

                // Save the book details to a file
                printBooksToFile();

                // Close the add book window
                addBookFrame.dispose();
            }
        });

        // Add components to a panel
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(likeLabel);
        panel.add(likeField);
        panel.add(learnLabel);
        panel.add(learnField);
        panel.add(thoughtsLabel);
        panel.add(thoughtsField);
        panel.add(new JLabel()); // Empty cell
        panel.add(saveButton);

        // Add the panel to the add book frame
        addBookFrame.getContentPane().add(panel);
        addBookFrame.setVisible(true); // Make the add book frame visible
    }

    // Method to create the view books window
    private void createViewBooksWindow() {
        // Create the view books frame
        JFrame viewBooksFrame = new JFrame("View Books");
        viewBooksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewBooksFrame.setSize(400, 300);

        // Create a text area to display the book content
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make the text area read-only
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Read the file content and display it in the text area
        try (BufferedReader reader = new BufferedReader(new FileReader("YourBooks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (Exception e) {
            textArea.setText("Error reading file.");
        }

        // Add the scroll pane to the view books frame
        viewBooksFrame.getContentPane().add(scrollPane);
        viewBooksFrame.setVisible(true); // Make the view books frame visible
    }

    // Method to save the books to a file
    private void printBooksToFile() {
        try {
            FileWriter writer = new FileWriter("YourBooks.txt", true); // Append mode

            for (book b : books) {
                writer.write("Book name: " + b.getBookName() + "\n");
                writer.write("Book author: " + b.getBookAuthor() + "\n");
                writer.write("What you liked: " + b.getBookLike() + "\n");
                writer.write("What you learned: " + b.getBookLearn() + "\n");
                writer.write("Other thoughts: " + b.getBookThoughts() + "\n");
                writer.write("\n");
            }

            writer.close(); // Close the writer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BookMenuGUI(); // Create an instance of the BookMenuGUI
    }

}



