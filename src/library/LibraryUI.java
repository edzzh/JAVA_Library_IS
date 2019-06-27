/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import helpers.ActionsDB;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 * Reference Link:
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java
 */
public class LibraryUI extends JPanel{
	private static Reader reader;
	
	public LibraryUI() {
            super(new GridLayout(1,1));
            JTabbedPane tabbedPane = new JTabbedPane();
		
            JComponent panel1 = makeLibraryPanel();
            tabbedPane.addTab("Library", null, panel1, "Library");
            tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

            JComponent panel2 = makeLibraryDepartmentPanel();
            tabbedPane.addTab("Library Department", null, panel2, "Library Department");
            tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

//            JComponent panel3 = makeTextPanel(reader.getName());
//            tabbedPane.addTab("Profile", null, panel3, "Profile");
//            tabbedPane.setMnemonicAt(1, KeyEvent.VK_3);

            add(tabbedPane);
	}
	
//	private JComponent makeTextPanel(String text) {
//            JPanel panel = new JPanel(false);
//            JLabel filler = new JLabel(text);
//            filler.setHorizontalAlignment(JLabel.CENTER);
//            panel.setLayout(new GridLayout(1, 1));
//            panel.add(filler);
//            return panel;
//        }
        
        private JComponent makeLibraryPanel() {
            JPanel panel = new JPanel(false);
            
            String [] columnNames = {"ISBN", "Year", "Author", "Title", "Rating", "Condition", "Rarity"};
            Object [][] data = {
                {
                    "ISBN11111", (short) 2019, "Edgars", "DAMN", (short) 9, "Normal", "Legendary" 
                }
            };
            
            
            //ToDo: Get books from DB and fill in data Obejt 2D array
            
            JTable table = new JTable(data, columnNames);
            
            table.setPreferredScrollableViewportSize(new Dimension(900, 100));
            table.setFillsViewportHeight(true);
            
            //Create the scroll pane and add the table to it.
            JScrollPane scrollPane = new JScrollPane(table);
            
            // Buttons
            JButton addBook = new JButton("Add Book");
            addBook.setSize(40, 40);
            JButton deleteBook = new JButton("Delete Book");
            addBook.setSize(40, 40);
            
            panel.add(scrollPane);
            panel.add(addBook);
            panel.add(deleteBook);
            return panel;
        }
	
        private JComponent makeLibraryDepartmentPanel() {
            JPanel panel = new JPanel(false);
            
            return panel;
        }
        
        public static void createAndShowGUI(String readerUserName) {
            //Create and set up the window.
            JFrame frame = new JFrame("Library UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create new Reader instance
            reader = ActionsDB.getUserFromDatabase(readerUserName);

            //Add content to the window.
            frame.add(new LibraryUI(), BorderLayout.CENTER);

            //Display the window.
            frame.pack();
            frame.setSize(1000, 1000);  
            frame.setVisible(true);
        }
}
