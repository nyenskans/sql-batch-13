package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Demo3 {
    public static void main(String[] args) {
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        List<Map<String, String>> tableData;
        try {
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            Statement statement = connection.createStatement();
            String query = "select * from employee";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultInfo = resultSet.getMetaData();
            // we want to store the data from the result data instead of printing it:
            // in this list of maps we store the column (header) data
            tableData = new ArrayList<>();

              for (int i=1; i<=resultInfo.getColumnCount(); i++){
            }
            System.out.println();
            while(resultSet.next()){
                // here we will store the data from the inside the table
                LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                for (int i=1; i <= resultInfo.getColumnCount(); i++){
                    // with .put() we insert the text from rows into the List of Map
                    rowData.put(resultInfo.getColumnName(i), resultSet.getString(i));
                }
                tableData.add(rowData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(tableData);
    }
}
