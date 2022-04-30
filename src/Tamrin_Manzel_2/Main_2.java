package Tamrin_Manzel_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Main_2 {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame jFrame = new JFrame ("LOGIN_PAGE");

        GridLayout gridLayout0 = new GridLayout (2,2);
        jFrame.setLayout (gridLayout0);

        jFrame.setLocation (0,0);
        jFrame.setSize (800,600);

        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        JTextField txtName = new JTextField (10);
        JTextField txtPASS = new JTextField (10);

        JButton btnEnter = new JButton("Enter");

        JPanel jPanel = new JPanel ();
        jPanel.add (txtName);
        jPanel.add (txtPASS);

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
                            connection.prepareStatement("select pass from PERSON_EDIT where NAME = ? ");

                    preparedStatement.setString(1, txtName.getText());

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {

                        String KEY_PASS = resultSet.getString("PASS");
                        this.KEY_PASS = String.valueOf(KEY_PASS);
                    }

                    System.out.println(KEY_PASS);
                    System.out.println(txtPASS.getText());

                    if (KEY_PASS.equals(txtPASS.getText())) {

                   //     Class.forName("oracle.jdbc.driver.OracleDriver");

                     //   String URL1 = "jdbc:oracle:thin:@localhost:1521:XE";

                       // Connection connection1 = DriverManager.getConnection(URL1, "private", "12345");

                        //connection1.setAutoCommit(false);

                        System.out.println("==========LOGGED IN!==========");

                        JFrame jFrame1 = new JFrame ("EDIT");

                        GridLayout gridLayout1 = new GridLayout (2,2);
                        jFrame1.setLayout (gridLayout1);

                        jFrame1.setLocation (0,0);
                        jFrame1.setSize (800,600);

                        UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");

                        JLabel jLabel = new JLabel(
                                "          =====================================\n" +
                                "               Pass -> 1\n" +
                                "               Family -> 2\n" +
                                "               Degree -> 3\n" +
                                "               Age -> 4\n" +
                                "               Email -> 5\n" +
                                "               =====================================");

                        JTextField txtKey = new JTextField("Key", 10);
                        JTextField txtData = new JTextField("Data", 10);

                        JButton btnEdit = new JButton("Edit");

                        JPanel jPanel1 = new JPanel ();
                        jPanel1.add (jLabel);

                        jPanel1.add(txtKey);
                        jPanel1.add (txtData);

                        jPanel1.add (btnEdit);

                        jFrame1.add (jPanel1);

                        jFrame1.setVisible (true);
                        jFrame1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

                        btnEdit.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                try {

                                    Class.forName("oracle.jdbc.driver.OracleDriver");

                                    String URL1 = "jdbc:oracle:thin:@localhost:1521:XE";

                                    Connection connection1 = DriverManager.getConnection(URL1, "private", "12345");

                                    connection1.setAutoCommit(false);

                                switch (txtKey.getText()) {
                                    case "1" -> {
                                        PreparedStatement preparedStatement1 =
                                                connection.prepareStatement("update Person_Edit set PASS = ? where NAME = ?");
                                        preparedStatement1.setString(1, txtData.getText());
                                        preparedStatement1.setString(2, txtName.getText());
                                        preparedStatement1.executeUpdate();
                                        connection.setAutoCommit(false);
                                        connection.commit();
                                        preparedStatement1.close();
                                        connection.close();
                                        break;
                                    }
                                    case "2" -> {
                                        PreparedStatement preparedStatement2 =
                                                connection.prepareStatement("update PERSON_EDIT set FAMILY = ? where ID = ?");
                                        preparedStatement2.setString(1, txtData.getText());
                                        preparedStatement2.setString(2, txtName.getText());
                                        preparedStatement2.executeUpdate();
                                        connection.setAutoCommit(false);
                                        connection.commit();
                                        preparedStatement2.close();
                                        connection.close();
                                        break;
                                    }
                                    case "3" -> {
                                        PreparedStatement preparedStatement3 =
                                                connection.prepareStatement("update PERSON_EDIT set DEGREE = ? where NAME = ?");
                                        preparedStatement3.setString(1, txtData.getText());
                                        preparedStatement3.setString(2, txtName.getText());
                                        preparedStatement3.executeUpdate();
                                        connection.setAutoCommit(false);
                                        connection.commit();
                                        preparedStatement3.close();
                                        connection.close();
                                        break;
                                    }
                                    case "4" -> {
                                        PreparedStatement preparedStatement4 =
                                                connection.prepareStatement("update PERSON_EDIT set AGE = ? where NAME = ?");
                                        preparedStatement4.setString(1, txtData.getText());
                                        preparedStatement4.setString(2, txtName.getText());
                                        preparedStatement4.executeUpdate();
                                        connection.setAutoCommit(false);
                                        connection.commit();
                                        preparedStatement4.close();
                                        connection.close();
                                        break;
                                    }
                                    case "5" -> {
                                        PreparedStatement preparedStatement5 =
                                                connection.prepareStatement("update PERSON_EDIT set EMAIL = ? where NAME = ?");
                                        preparedStatement5.setString(1, txtData.getText());
                                        preparedStatement5.setString(2, txtName.getText());
                                        try {
                                            preparedStatement5.executeUpdate();
                                        }catch (Exception e3) {

                                            e3.printStackTrace();
                                        }
                                        connection.setAutoCommit(false);
                                        connection.commit();
                                        preparedStatement5.close();
                                        connection.close();
                                        break;
                                    }
                                }
                            } catch (Exception e2) {

                                e2.printStackTrace();
                            }
                            }
                        });
                    }
            } catch (Exception e1) {

                    e1.printStackTrace();
                 }
            }
        });
    }
}
