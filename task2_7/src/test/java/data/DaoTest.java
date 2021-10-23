package data;

import entity.Expense;
import entity.Receiver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DaoTest {
    MyDao myDao;

    @Before
    public void setUp() throws Exception {
        myDao = new MyDao();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveNewTicket() throws Exception {
        Expense expense = new Expense();
        expense.setNum(2);
        expense.setPaydate("2021-10-01");
        expense.setReceiver(6);
        expense.setValue(124);
        Receiver receiver = new Receiver();
        receiver.setNum(expense.getNum());
        receiver.setName("L:owe");

        myDao.addExpense(expense);
        myDao.addReceiver(receiver);

        System.out.println(myDao.getExpense(2));
        System.out.println(myDao.getReceiver(4));
        System.out.println(myDao.getReceivers());
        System.out.println(myDao.getExpenses());

    }
}
