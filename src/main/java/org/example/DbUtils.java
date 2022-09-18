package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    // we are writing a method to store the results of queries into a list of maps so we can call it when we need it

    public static List<Map<String, String>> fetchDbData(String query){
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        // we initialize everything before the try block
        List<Map<String, String>> tableData;
        Connection connection = null; // try catch block forces us to initialize these as null
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultInfo;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultInfo = resultSet.getMetaData();
            tableData = new ArrayList<>();
            for (int i=1; i<=resultInfo.getColumnCount(); i++){
            }
            System.out.println();
            while(resultSet.next()){
                LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                for (int i=1; i <= resultInfo.getColumnCount(); i++){
                    rowData.put(resultInfo.getColumnName(i), resultSet.getString(i));
                }
                tableData.add(rowData);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{    // we do finally block here because we have to close the following:
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) { // these exceptions come from connection.close(), etc...
                throw new RuntimeException(e);
            }
        }
        return tableData;
    }
}

