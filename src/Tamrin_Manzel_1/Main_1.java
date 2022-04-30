package Tamrin_Manzel_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main_1 extends JFrame {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame jFrame= new JFrame ("ENTRY_PAGE");

        GridLayout gridLayout=new GridLayout (2,2);
        jFrame.setLayout (gridLayout);

        jFrame.setLocation (0,0);
        jFrame.setSize (800,600);

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        JTextField txtName = new JTextField (10);
        JTextField txtFamily = new JTextField (10);
        JTextField txtAge = new JTextField(10);
        JTextField txtDegree = new JTextField(10);
        JTextField txtEmail = new JTextField(10);

        JButton btnEnter = new JButton("Enter");

        JPanel jPanel = new JPanel ();
        jPanel.add (txtName);
        jPanel.add (txtFamily);
        jPanel.add (txtAge);
        jPanel.add (txtDegree);
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
                    preparedStatement = connection.prepareStatement("insert into Staff_RE(name , Family, Degree, Age, Email) values(?, ?, ?, ?, ?)");

                    preparedStatement.setString(1, txtName.getText());
                    preparedStatement.setString(2, txtFamily.getText());
                    preparedStatement.setString(3, txtDegree.getText());
                    preparedStatement.setString(4, txtAge.getText());
                    preparedStatement.setString(5, txtEmail.getText());

                    connection.setAutoCommit(false);
                    preparedStatement.executeUpdate();

                    connection.commit();

                } catch (Exception e1) {

                    e1.printStackTrace();
                }
            }
        });
    }
}
