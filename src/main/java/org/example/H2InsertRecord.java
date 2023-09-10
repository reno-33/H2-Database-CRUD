package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2InsertRecord {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully...");

            //Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO USERS " + "VALUES (100, 'John', 'Doe', 18)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO USERS " + "VALUES (101, 'Jane', 'Smith', 25)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO USERS " + "VALUES (102, 'Ryan', 'Harpert', 30)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO USERS " + "VALUES(103, 'Kevin', 'James', 28)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            //Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //block used to close resources
            try {
                if(stmt!=null) stmt.close();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Shutting down!");
    }
}
