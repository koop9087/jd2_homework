package data;

import entity.Expense;
import entity.Receiver;

import java.sql.*;
import java.util.ArrayList;

public class MyDao implements Dao {
    DataSource dataSource;
    Connection connection;

    public MyDao() throws Exception {
        dataSource = new DataSource();
        connection = dataSource.getConnection();
    }

    @Override
    public Receiver getReceiver(int num) throws Exception {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM receivers WHERE num=" + num);
        ResultSet rs = ps.executeQuery();
        Receiver receiver = null;
        if (rs.next()) {
            receiver = new Receiver();
            receiver.setNum(rs.getInt("num"));
            receiver.setName(rs.getString("name"));
        }
        ps.close();
        rs.close();
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        String sqlReq = "SELECT * FROM receivers";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sqlReq);
        ArrayList<Receiver> receiversList = new ArrayList<>();
        while (rs.next()) {
            Receiver receiver = new Receiver();
            receiver.setNum(rs.getInt("num"));
            receiver.setName(rs.getString("name"));
            receiversList.add(receiver);
        }
        st.close();
        rs.close();
        return receiversList;
    }

    @Override
    public Expense getExpense(int num) throws Exception {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM expenses WHERE num=" + num);
        ResultSet rs = ps.executeQuery();
        Expense expense = null;
        if (rs.next()) {
            expense = new Expense();
            expense.setNum(rs.getInt("num"));
            expense.setPaydate(rs.getString("paydate"));
            expense.setReceiver(rs.getInt("receiver"));
            expense.setValue(rs.getDouble("value"));
        }
        ps.close();
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() throws SQLException {
        String sqlReq = "SELECT * FROM expenses";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(sqlReq);
        ArrayList<Expense> expensesList = new ArrayList<>();
        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setNum(resultSet.getInt("num"));
            expense.setPaydate(resultSet.getString("paydate"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setValue(resultSet.getDouble("value"));
            expensesList.add(expense);
        }
        st.close();
        resultSet.close();
        return expensesList;
    }

    @Override
    public int addReceiver(Receiver receiver) throws SQLException {
        String sqlReq = "INSERT INTO receivers VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(sqlReq);
        ps.setInt(1, receiver.getNum());
        ps.setString(2, receiver.getName());
        return ps.executeUpdate();
    }

    @Override
    public int addExpense(Expense expense) throws SQLException {
        String sqlReq = "INSERT INTO expenses VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sqlReq);
        ps.setInt(1, expense.getNum());
        ps.setString(2, expense.getPaydate());
        ps.setInt(3, expense.getReceiver());
        ps.setDouble(4, expense.getValue());
        return ps.executeUpdate();
    }
}
