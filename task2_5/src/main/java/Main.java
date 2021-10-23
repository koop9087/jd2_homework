import data.DataSource;

import java.sql.*;

public class Main {
   //private static final String URL = "jdbc:mysql://localhost:3306/task2_5?serverTimezone=UTC";
   //private static final String USER = "root";
   //private static final String PASSWORD = "Root";
   protected static DataSource dataSource;
    //Запуск программы с помощью java -classpath d:\work\jd2_homework\task2_5\target\classes;c:\Users\home\.m2\repository\mysql\mysql-connector-java\8.0.26\mysql-connector-java-8.0.26.jar Main 2021-10-12 4 5 1`
    public static void main(String... args) {
        String argDate = args[0];
        String argReceiver = args[1];
        int newReceiver = Integer.parseInt(argReceiver);
        String values = args[2];
        double valueArg = Double.parseDouble(values);
        String argNum = args[3];
        int numReceiver = Integer.parseInt(argNum);
        try {
            dataSource = new DataSource();
            Statement statement = dataSource.getConnection().createStatement();
            String template = "INSERT INTO task2_5.expenses (num, paydate, receiver, value) \n " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(template);
            ps.setInt(1,numReceiver);
            ps.setString(2, argDate);
            ps.setInt(3, newReceiver);
            ps.setDouble(4, valueArg);
            ps.executeUpdate();
            ResultSet resultPrint = statement.executeQuery("SELECT * FROM expenses;");
            while (resultPrint.next()) {
                int num = resultPrint.getInt(1);
                String paydate = resultPrint.getString(2);
                double value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                System.out.println(num + " " + paydate + " " + value + " " + name);
            }
            ps.close();
            resultPrint.close();
            statement.close();
            dataSource.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
