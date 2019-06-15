/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import helpers.*;
/**
 *
 * @author edgar
 */
public class RegisterUI extends JFrame implements ActionListener{
    // Register parameters
    JButton register;
    JLabel nameLabel;
    JLabel surnameLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField name;
    JTextField surname;
    JTextField username;
    JPasswordField password;
    
    
    // SQLite Parameters
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public RegisterUI() {
        super("Register");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(g);
        c.insets = new Insets(0, 0, 10, 0);
        
        // Register Frame Paremeter Definition
        c.gridy = 0;
        nameLabel = new JLabel("Name *");
        add(nameLabel, c);
        
        c.gridy = 1;
        name = new JTextField(15);
        add(name, c);
        
        c.gridy = 2;
        surnameLabel = new JLabel("Surname *");
        add(surnameLabel, c);
        
        c.gridy = 3;
        surname = new JTextField(15);
        add(surname, c);
        
        c.gridy = 4;
        usernameLabel = new JLabel("Username *");
        add(usernameLabel, c);
        
        c.gridy = 5;
        username = new JTextField(15);
        add(username, c);
        
        c.gridy = 6;
        passwordLabel = new JLabel("Password *");
        add(passwordLabel, c);
        
        c.gridy = 7;
        password = new JPasswordField(15);
        add(password, c);
        // End Of Frame Paremeter Definition
        
        // Define Register Button And ActionListener
        c.gridy = 8;
        register = new JButton("Register");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 0, 0);
        add(register, c);
        register.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            // Save Data In Database
            String sql = "INSERT INTO USERS(NAME, SURNAME, USERNAME, PASSWORD) "
                    + "VALUES (?, ?, ?, ?)";
            try {
                con = DriverManager.getConnection("jdbc:sqlite:library_users.db");
                ps = con.prepareStatement(sql);
                
                ps.setString(1, name.getText());
                ps.setString(2, surname.getText());
                ps.setString(3, username.getText());
                ps.setString(4, Utils.MD5(password.getText()));
                
                ps.executeUpdate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                setVisible(true);
            }

            // Set Visibility False And Redirect To Login
            setVisible(false);
            LoginUI loginUi = new LoginUI();
            loginUi.setVisible(true);
        }
    }
}
