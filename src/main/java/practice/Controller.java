package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    //Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    /**
     * Create a connection to a H2 database
     * @return the created connection object
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Successfull connection!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * Create new table in the database
     * @throws SQLException
     */
    public static void createTable() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = null;
        Scanner scanner = null;

        try {
            System.out.println("What should we call the new table?");
            scanner = new Scanner(System.in);
            String tableName = scanner.nextLine();

            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                    " (id INTEGER not NULL, " +
                    " first_name VARCHAR(255), " +
                    " last_name VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
        }
    }

    public static void insertRecord() {

    }
}
