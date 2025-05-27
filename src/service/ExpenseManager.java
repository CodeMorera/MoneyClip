package service;

import model.Expense;

import java.util.ArrayList;

//Helper class for adding/searching/filtering exspenses
public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public ArrayList<Expense> getAllExpenses() {
        return expenses;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }


}
