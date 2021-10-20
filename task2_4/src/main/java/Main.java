import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/task2_4?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Root";

    public static void main(String... args) {
        String argDate = args[0];
        String argReceiver = args[1];
        int newReceiver = Integer.parseInt(argReceiver);
        String values = args[2];
        double valueArg = Double.parseDouble(values);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String dateQuery = "('" + argDate + "'" + "," + newReceiver + "," + valueArg + ")";
            String query = "INSERT INTO task2_4.expenses (paydate, receiver, value) \n" +
                    "values" + dateQuery + ";";
            int res = statement.executeUpdate(query);
            ResultSet resultPrint = statement.executeQuery("SELECT * FROM expenses;");
            while (resultPrint.next()) {
                String paydate = resultPrint.getString(2);
                double value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                System.out.println(paydate + " " + value + " " + name);
            }
            resultPrint.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
