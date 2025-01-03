package sportingclub;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Tools {
    

    // Displays a message box with the specified message
    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static boolean confirmMsg(String message)
    {
        int msgC = JOptionPane.showConfirmDialog(null, message);
        if(msgC==JOptionPane.YES_OPTION)
        {
            return true;
        }
        else
            return false;
    }

    // Creates a folder with the given name at the specified path
    public static void CreateFolder(String folderName, String path) {
        File f = new File(path + "/" + folderName);
        f.mkdir();
    }

    // Creates a folder with the given name in the current directory
    public static void CreateFolder(String folderName) {
        File f = new File(folderName);
        f.mkdir();        
    }

    // Opens a JFrame form and sets its properties
    public static void openForm(JFrame form) {
        try {
            form.setLocationRelativeTo(null); // Centers the form on the screen
            Image img = ImageIO.read(Tools.class.getResource("emp.png")); // Sets the icon image
            form.setIconImage(img);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation
            form.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Clears all JTextField components within a given container
    public static void clearText(Container form) {
        for (Component c : form.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText(""); // Clears the text field
            } else if (c instanceof Container) {
                clearText((Container) c); // Recursively clears nested containers
            }
        }
    }

    // Creates an empty text file with the given name
    public static void createEmptyFile(String fileName) {
        try {
            File f = new File(fileName + ".txt");
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Creates multiple empty text files with the given names
    public static void createEmptyFiles(String[] fileNames) {
        for (String str : fileNames) {
            createEmptyFile(str);
        }
    }

    // Creates a text file with the given name and writes data to it
    public static void createFile(String fileName, Object[] data) {
        try {
            PrintWriter p = new PrintWriter(fileName + ".txt");
            for (Object obj : data) {
                p.println(obj); // Writes each object to the file
            }
            p.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    // Creates multiple files and writes corresponding data to each
    public static void createFiles(String[] fileNames, Object[][] allData) {
        for (int x = 0; x < fileNames.length; x++) {
            createFile(fileNames[x], allData[x]);
        }
    }

    // Displays an input dialog box and returns the user input
    public static Object InputBox(String title) {
        return JOptionPane.showInputDialog(title);
    }

    // Extracts numeric characters from a given string
    public static String getNumber(String text) {
        String val = "";
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                val += c;
            }            
        }
        return val;
    }

    // Extracts numeric characters from a string and converts to an integer
    public static int getNumberToInteger(String text) {
        String val = "";
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                val += c;
            }            
        }
        return Integer.parseInt(val);
    }

    // Removes numeric characters from a given string
    public static String removeNumber(String text) {
        String val = "";
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                val += c;
            }            
        }
        return val;
    }

    // Captures a screenshot of the entire screen and saves it as an image
    public static void printScreen(String imageName) {
        try {
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
            ImageIO.write(img, "jpg", new File(imageName + ".jpg"));
        } catch (Exception ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    // Captures a screenshot of the screen while minimizing a given JFrame
    public static void printScreen(String imageName, JFrame form) {
        try {
            form.setState(JFrame.ICONIFIED); // Minimizes the form
            Robot r = new Robot();
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = r.createScreenCapture(rec);
            ImageIO.write(img, "jpg", new File(imageName + ".jpg"));
            form.setState(JFrame.NORMAL); // Restores the form
        } catch (Exception ex) {
            msgBox(ex.getMessage());
        }        
    }
    public static class Table {

        public int columns;
        public Object[][] Items;

        // Initializes the table with the given number of columns
        public Table(int columns) {
            this.columns = columns;
            Items = new Object[0][columns];
        }

        // Adds a new row to the table
        public void addNewRow(Object[] row) {
            Object[][] TempItems = Items; // Store existing items in a temporary variable
            Items = new Object[Items.length + 1][columns]; // Increase table size
            for (int x = 0; x < TempItems.length; x++) {
                Items[x] = TempItems[x]; // Copy old items back into the new table
            }
            Items[Items.length - 1] = row; // Add the new row
        }

        // Prints all items in the table
        public void printItems() {
            for (Object[] objs : Items) {
                for (Object obj : objs) {
                    System.out.print(obj + " ; ");
                }
                System.out.println();
            }
        }

        // Edits a specific cell in the table
        public void editRow(int rowIndex, int columnIndex, Object newData) {
            Items[rowIndex][columnIndex] = newData;
        }

        // Deletes a specific row from the table
        public void deleteRow(int rowIndex) {
            Object[][] TempItems = Items;
            Items = new Object[Items.length - 1][columns]; // Reduce table size
            int y = 0;
            for (int x = 0; x < TempItems.length; x++) {
                if (x != rowIndex) {
                    Items[y] = TempItems[x]; // Copy rows except the one to be deleted
                    y++;
                }
            }
        }

        // Retrieves the value at a specific cell
        public Object getValue(int rowIndex, int columnIndex) {
            return Items[rowIndex][columnIndex];
        }

        // Retrieves a specific row from the table
        public Object[] getRow(int rowIndex) {
            return Items[rowIndex];
        }
    }
    // Nested class for string manipulation utilities
    public static class StringTools {

        String text;
        private String inverseText;
        String[] texts;
        String textArray;

        // Constructor for single string operations
        public StringTools(String text) {
            this.text = text;
        }

        // Constructor for string array operations
        public StringTools(String[] texts) {
            this.texts = texts;
            textArray = "";
        }

        // Prints each character of the string line by line
        public void printCharByChar() {
            for (char c : text.toCharArray()) {
                System.out.println(c);
            }
        }

        // Prints each character of the reversed string line by line
        public void printCharByCharInverse() {
            StringBuilder sb = new StringBuilder(text);
            inverseText = sb.reverse().toString();
            for (char c : inverseText.toCharArray()) {
                System.out.println(c);
            }
        }

        // Prints all elements of a string array
        public void printStringArray() {
            for (String s : texts) {
                System.out.println(s);
            }
        }

        // Returns a single string containing all elements of the array separated by " ; "
        public String getStringArrayElement() {
            for (String s : texts) {
                textArray += s + " ; ";
            }
            return textArray;
        }
    }

    // Nested class for merging two arrays
    public static class MergeArray {

        public Object[] array1;
        public Object[] array2;

        // Constructor to initialize the two arrays
        public MergeArray(Object[] array1, Object[] array2) {
            this.array1 = array1;
            this.array2 = array2;
        }

        // Merges two arrays into a single array
        public Object[] mergeTwoArrays() {
            int a1 = array1.length;
            int a2 = array2.length;
            Object[] arrayR = new Object[a1 + a2];
            System.arraycopy(array1, 0, arrayR, 0, a1);
            System.arraycopy(array2, 0, arrayR, a1, a2);
            return arrayR;
        }
    }

    // Nested class for managing a dynamic table structure
    
}
