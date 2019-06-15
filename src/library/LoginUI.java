/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import helpers.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author edgar
 */
public class LoginUI extends JFrame{
    // Swing Parameters
    JTextField username;
    JPasswordField password;
    JButton login;
    JButton register;
    JLabel userLabel;
    JLabel passLabel;
    
    // SQLite Parameters
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public LoginUI() {
        super("Login");        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(g);
        // Set Padding
        c.insets = new Insets(0, 0, 10, 0);
        
        // Username Field
        c.gridx = 0;
        c.gridy = 0;
        userLabel = new JLabel("Username");
        add(userLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        username = new JTextField(15);
        add(username, c);
        
        // End of Username Field definition
        
        // Password Field
        c.gridx = 0;
        c.gridy = 2;
        passLabel = new JLabel("Password");
        add(passLabel, c);
        
        c.gridx = 0;
        c.gridy = 3;
        password = new JPasswordField(15);
        add(password, c);      
        //End of Password Field definition
        
        // Login Button
        c.gridx = 0;
        c.gridy = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0); // top padding for login button
        login = new JButton("Login");
        add(login, c);
        
        login.addActionListener((e) -> {
            if (e.getSource() == login) {
                String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";

                try {
                    con = DriverManager.getConnection("jdbc:sqlite:library_users.db");
                    ps = con.prepareStatement(sql);
                    ps.setString(1, username.getText());
                    ps.setString(2, Utils.MD5(password.getText()));

                    rs = ps.executeQuery();

                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Username and Password Correct");
                        setVisible(false);
                        LibraryUI libraryUI = new LibraryUI();
                        libraryUI.setVisible(true);
                    }
                } catch (Exception ex) {
                    setVisible(true);
                    JOptionPane.showMessageDialog(null, "Username and Password Incorrect");
                }
            }
        });
        
        // Register Button
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        register = new JButton("Register");
        add(register, c);
        
        register.addActionListener((e) -> {
            if (e.getSource() == register) {
                RegisterUI registerUI = new RegisterUI();
                
                setVisible(false);  // sets Login visibility equal to false
                registerUI.setVisible(true);    // sets regiter ui visiblity to true   
            }
        });
        
        setVisible(true);
    }
    
    public static void main(String [] args) {
        LoginUI loginUI = new LoginUI();
    }
}
