package util;

import model.Expense;

import java.util.List;

//For printing, filtering or exporting in the future
public class ExpenseUtils {
    public static void printExpenses(List<Expense> expenses){
        for (Expense e : expenses){
            System.out.println(e);
        }
    }
}
