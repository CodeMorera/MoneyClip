import model.Expense;
import service.ExpenseManager;
import util.ExpenseUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        boolean stayOpen = true;

        System.out.println("********************************");
        System.out.println("Welcome to your expense tracker!");
        System.out.println("********************************");

        ExpenseManager expenseManager = new ExpenseManager();




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
            ExpenseUtils.printExpenses(expenseManager.getAllExpenses());

            Thread.sleep(1000);

            System.out.print("Would you like to add another expense (Y/N)?");
            String answer = scanner.nextLine().toUpperCase();
            if(answer.equals("N")){
                System.out.println("Here's your full expense list:");
                ExpenseUtils.printExpenses(expenseManager.getAllExpenses());
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