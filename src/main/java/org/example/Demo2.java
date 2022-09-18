package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Demo2 {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        try {
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            Statement statement = connection.createStatement();
            String query = "select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            // Results meta data gives us all the column names in a query

            ResultSetMetaData metaData = resultSet.getMetaData();
            // this for loop retrieves all the column names:
            // getColumnCount returns the total number of columns in the results:
            for (int i=1; i<=metaData.getColumnCount(); i++){
                System.out.print(metaData.getColumnName(i)+" ");
            }
            System.out.println();
            while(resultSet.next()){
                // this for loop gives us the data from all the rows inside the table:
                for (int i=1; i <= metaData.getColumnCount(); i++){
                    System.out.print(resultSet.getString(i)+" ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
