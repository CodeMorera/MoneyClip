package model;
import java.time.LocalDate;

//The core of the app. Every new expense it creates an instance of this class

public class Expense {
    private String category;
    private String description;
    private double amount;
    private LocalDate date;

    public Expense(String category, String description, double amount, LocalDate date){
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public double getAmount() {return amount;}

    public void setAmount(double amount) {this.amount = amount;}

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public String toString(){
        return String.format("%s | %s | %.2f |%s",)
    }

}
