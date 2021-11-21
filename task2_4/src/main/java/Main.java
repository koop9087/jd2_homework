import data.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    protected static DataSource dataSource;
    //Запуск программы с помощью java -classpath d:\work\jd2_homework\task2_4\target\classes;c:\Users\home\.m2\repository\mysql\mysql-connector-java\8.0.26\mysql-connector-java-8.0.26.jar Main 2020-10-12 4 3 8
    public static void main(String... args) {
        String argDate = args[0];
        String argReceiver = args[1];
        int newReceiver = Integer.parseInt(argReceiver);
        String values = args[2];
        double valueArg = Double.parseDouble(values);
        String argNum = args[3];
        int numReceiver = Integer.parseInt(argNum);
        try {
            dataSource = new DataSource(false);
            Statement statement = dataSource.getConnection().createStatement();
            String dateQuery = "('" + argDate + "'" + "," + newReceiver + "," + valueArg + "," + numReceiver + ")";
            String query = "INSERT INTO task2_4.expenses (paydate, receiver, value, num) \n" +
                    "values" + dateQuery + ";";
            statement.executeUpdate(query);
            String template = "SELECT * FROM expenses WHERE value < ?";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(template);
            ps.setFloat(1, 200F);
            ps.executeQuery();
            ResultSet resultPrint = statement.executeQuery("SELECT * FROM expenses;");
            while (resultPrint.next()) {
                String paydate = resultPrint.getString(2);
                double value = resultPrint.getDouble(3);
                String name = resultPrint.getString(4);
                int num = resultPrint.getInt(1);
                System.out.println(num + " " + paydate + " " + value + " " + name);
            }
            resultPrint.close();
            statement.close();
            dataSource.getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
