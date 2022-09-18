package org.example;

public class Demo4 {
    public static void main(String[] args) {
        // now we can call the method fetchDbQuery from DbUtils class:

        String query="select * from employee";
        System.out.println(DbUtils.fetchDbData(query));

    }
}
