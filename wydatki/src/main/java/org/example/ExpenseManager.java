package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
     List<Expense> expenses =  new ArrayList<>();

    public void displayAllExpenses() {
        expenses.forEach(ExpenseManager::displayExpense);
    }

    private static void displayExpense(Expense expense) {
        System.out.println(expense.description());
        System.out.println(expense.type());
        System.out.println(expense.amount());
        System.out.println(expense.month());
    }

    public void addAllExpenses(Scanner scanner) {
        System.out.println("Podaj opis wydatku");
        String description = scanner.nextLine();
        System.out.println("Podaj typ wydatku");
        String type = scanner.nextLine();
        System.out.println("Podaj wartość wydatku");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj miesiąc wydatku");
        int month = Integer.parseInt(scanner.nextLine());

        Expense expense = new Expense(type, month, amount, description);
        expenses.add(expense);

    }
    public void displayMonthlyExpenses(Scanner scanner) {
        System.out.println("z którego miesiąca wydatki chcesz wyświetlić?");
        int month = Integer.parseInt(scanner.nextLine());
        expenses.stream()
                .filter(expense -> expense.month() == month)
                .forEach(ExpenseManager::displayExpense);
    }
}
