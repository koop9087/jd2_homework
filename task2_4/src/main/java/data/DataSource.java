package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private final boolean useTestDataSource;

    public DataSource(boolean useTestDataSource) {
        this.useTestDataSource = useTestDataSource;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                useTestDataSource ?
                        "jdbc:mysql://localhost:3306/task2_4_test" :
                        "jdbc:mysql://localhost:3306/task2_4"
                ,
                "root",
                "Root");
    }
}
