package edu.tutorial.javaTraining;

import java.sql.*;

/**
 * Created by shivatej on 1/30/2016.
 */
public class JDBConnectivity {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/javatraining";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("EmployeeId");
                String employeeName = rs.getString("EmployeeName");
                String employeeSal = rs.getString("EmployeeSal");
                String employeeDesignation = rs.getString("EmployeeDesignation");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + employeeName);
                System.out.print(", Employee Salary: " + employeeSal);
                System.out.println(", Employee designation " + employeeDesignation);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();

        }
    }
}

/*
output
* Connecting to database...
Creating statement...
ID: 1, Name: shiva, Employee Salary: 8000, Employee designation Sr. Software Engineer
ID: 2, Name: swetha, Employee Salary: 6000, Employee designation Sr.software Engineer
*/