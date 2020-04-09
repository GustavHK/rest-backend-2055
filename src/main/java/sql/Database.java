package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
//klar på JDBC hvis vi ender med det.
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s180911", "s180911", "QekXA8EbroGRPIN1MOpRI");

    }

    
}
