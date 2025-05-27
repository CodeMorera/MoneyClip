package util;

import model.Expense;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExpenseFileHandler {
    public static void saveExpensesToFile(List<Expense> expenses, String filename){
        Path outputTxtFilePath = Paths.get(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputTxtFilePath.toFile()))){
            for(Expense expense : expenses){
                String line = String.format("%s,%s,%.2f,%s",
                        expense.getCategory(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
                writer.write(line);
                writer.newLine();}
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void loadExpenseFromFile(String filename) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
