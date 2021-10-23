package data;

import entity.Expense;
import entity.Receiver;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao {
    Receiver getReceiver(int num) throws Exception;

    ArrayList<Receiver> getReceivers() throws SQLException;

    Expense getExpense(int num) throws Exception;

    ArrayList<Expense> getExpenses() throws SQLException;

    int addReceiver(Receiver receiver) throws SQLException;

    int addExpense(Expense expense) throws SQLException;
}
