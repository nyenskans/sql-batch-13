package org.example;

import java.io.PushbackReader;
import java.sql.*;

public class Demo1 {
    // we are building this api and in the end we'll be copying it into our cucumber framework
    public static void main(String[] args) {

       // this is how we provide the connection to the database we want to interact with, by creating a database url:
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        // jdbc - java api
        // mysql - type of database // we can also use Oracle
        // 3.237.189.167 - server
        // port - 3306
        // syntaxhrm_mysql - database name
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        // Now we should use Connection class and DriverManager class
        // with getConnection() where we pass these parameters in order to connect to the database we need to

        try {
            // first we establish the connection, then we can execute queries:
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            // Statement class and createStatement() takes the queries from java code, executes them on the database
            // and returns the results:
            Statement statement = connection.createStatement();
            // query to be
            String query = "select * from person";
            // once the query was executed we are getting the results and we can use ResultSet class and
            // statement.executeQuery(query) to store them :

            ResultSet resultSet = statement.executeQuery(query);
            // result set is a table that we get as a result
            // we can use the iterator to get all the values from the result set in each iteration in while loop
            while (resultSet.next()){
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("Lastname");
                String age = resultSet.getString("age");
                System.out.println(firstName+ " " + lastName + " "+ age);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   /*
         Java has a set of interfaces provided for the companies building the databases
         for the databases to be compatible with java, those interfaces need to be implemented
         JDBC (Java Database Connectivity) is the Java API that manages connecting to a database,
         issuing queries and commands, and handling result sets obtained from the database
*/
    }
}
