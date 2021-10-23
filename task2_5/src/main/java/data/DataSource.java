package data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource {
    public static final String MAIN_RESOURCES_DB_PROPERTIES = "/src/main/resources/db.properties";
    public static final String JDBC_DRIVER = "jdbc.driver";
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_USERNAME = "jdbc.username";
    public static final String JDBC_PASSWORD = "jdbc.password";

    public Connection getConnection() throws Exception {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream(MAIN_RESOURCES_DB_PROPERTIES);
        properties.load(in);
        in.close();
        String driver = properties.getProperty(JDBC_DRIVER);
        if (driver != null) {
            Class.forName(driver);
        }
        String url = properties.getProperty(JDBC_URL);
        String username = properties.getProperty(JDBC_USERNAME);
        String password = properties.getProperty(JDBC_PASSWORD);
        return DriverManager.getConnection(url, username, password);
    }
}
