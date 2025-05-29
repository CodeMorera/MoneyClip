import model.Expense;
import service.ExpenseManager;
import util.ExpenseFileHandler;
import util.ExpenseUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean stayOpen = true;

        System.out.println("********************************");
        System.out.println("Welcome to your expense tracker!");
        System.out.println("********************************");
        //should use a set later
        ExpenseManager expenseManager = new ExpenseManager();
        List<Expense> loadedExpenses = ExpenseFileHandler.loadExpenseFromFile("expenses.txt");
        System.out.println("Loaded expenses:");
        ExpenseUtils.printExpenses(loadedExpenses);
        for (Expense e : loadedExpenses){
            expenseManager.addExpense(e);
        }


        while(stayOpen){
            System.out.print("Enter in the category: ");
            String category = scanner.nextLine();

            System.out.print("Enter in the description: ");
            String description = scanner.nextLine();

            System.out.print("Enter in the amount you paid: ");
            double amount = scanner.nextDouble();

            scanner.nextLine(); // clear leftover newline

            LocalDate date = LocalDate.now();
            Expense expense = new Expense(category,description,amount, date);
            expenseManager.addExpense(expense);

            System.out.println("Expense Added!");

            Thread.sleep(1000);
            ExpenseUtils.printExpenses(expenseManager.getAllExpenses());

            Thread.sleep(1000);

            System.out.print("Would you like to add another expense (Y/N)?");
            String answer = scanner.nextLine().toUpperCase();
            if(answer.equals("N")){
                System.out.println("Here's your full expense list:");
                ExpenseUtils.printExpenses(expenseManager.getAllExpenses());
                ExpenseFileHandler.saveExpensesToFile(expenseManager.getAllExpenses(), "expenses.txt");
                System.out.println("Expenses saved to file!");
                System.out.println("Have a great day!");
                stayOpen = false;
            }
            else if(answer.equals("Y")){
                continue;

            }
            else{
                System.out.print("Please use only 'Y' or 'N': ");
                answer = scanner.nextLine().toUpperCase();

            }

        }


        scanner.close();


    }
}