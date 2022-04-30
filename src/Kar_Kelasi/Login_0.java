package Kar_Kelasi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_0 {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame jFrame= new JFrame ("LOGIN");

        GridLayout gridLayout=new GridLayout (2,2);
        jFrame.setLayout (gridLayout);

        jFrame.setLocation (0,0);
        jFrame.setSize (800,600);

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        JTextField txtUsername = new JTextField ("username",10);
        JTextField txtPass = new JTextField ("pass", 10);

        JButton btnEnter = new JButton("Enter");

        JPanel jPanel = new JPanel ();
        jPanel.add (txtUsername);
        jPanel.add (txtPass);

        jPanel.add (btnEnter);

        jFrame.add (jPanel);

        jFrame.setVisible (true);
        jFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        btnEnter.addActionListener(new ActionListener() {

            private String KEY_PASS;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    String URL0 = "jdbc:oracle:thin:@localhost:1521:XE";

                    Connection connection = DriverManager.getConnection(URL0, "private", "12345");

                    connection.setAutoCommit(true);

                    PreparedStatement preparedStatement =
                            connection.prepareStatement("select PASS from PERSON_INFO where USERNAME = ? ");

                    preparedStatement.setString(1, txtUsername.getText());

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {

                        String KEY_PASS = resultSet.getString("PASS");
                        this.KEY_PASS = String.valueOf(KEY_PASS);
                    }

                    System.out.println(KEY_PASS);
                    System.out.println(txtPass.getText());

                    if (KEY_PASS.equals(txtPass.getText())) {

                        JFrame jFrame1 = new JFrame ("LOGIN PAGE");

                        GridLayout gridLayout1 = new GridLayout (2,2);
                        jFrame1.setLayout (gridLayout1);

                        jFrame1.setLocation (0,0);
                        jFrame1.setSize (800,600);

                        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

                        JLabel jLabel = new JLabel("=========LOGE IN==========");

                        JPanel jPanel1 = new JPanel ();
                        jPanel1.add (jLabel);

                        jFrame1.setVisible (true);
                        jFrame1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

                    }

                } catch (Exception e1) {

                e1.printStackTrace();
                }
            }
        });
    }
}
