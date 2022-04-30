package Kar_Kelasi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main_0 extends JFrame{

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame jFrame= new JFrame ("REGISTRATION");

        GridLayout gridLayout=new GridLayout (2,2);
        jFrame.setLayout (gridLayout);

        jFrame.setLocation (0,0);
        jFrame.setSize (800,600);

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        JTextField txtName = new JTextField ("name", 10);
        JTextField txtPass = new JTextField ("pass", 10);
        JTextField txtUsername = new JTextField("username",10);
        JTextField txtEmail = new JTextField("email", 10);

        JButton btnEnter = new JButton("Enter");

        JPanel jPanel = new JPanel ();
        jPanel.add (txtName);
        jPanel.add (txtPass);
        jPanel.add (txtUsername);
        jPanel.add (txtEmail);

        jPanel.add (btnEnter);

        jFrame.add (jPanel);

        jFrame.setVisible (true);
        jFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    String URL = "jdbc:oracle:thin:@localhost:1521:XE";

                    Connection connection;
                    connection = DriverManager.getConnection(URL, "private", "12345");

                    PreparedStatement preparedStatement;
                    preparedStatement = connection.prepareStatement("insert into PERSON_INFO(NAME, PASS, USERNAME, EMAIL) values(?, ?, ?, ?)");

                    preparedStatement.setString(1, txtName.getText());
                    preparedStatement.setString(2, txtPass.getText());
                    preparedStatement.setString(3, txtUsername.getText());
                    preparedStatement.setString(4, txtEmail.getText());

                    connection.setAutoCommit(false);
                    preparedStatement.executeUpdate();

                    connection.commit();

                    preparedStatement.close();
                    connection.close();

                }  catch (Exception e0) {

                    e0.printStackTrace();
                }
            }
        });


    }
}
