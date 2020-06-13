package com.mecherycorp;

public class HomePageResult {
    private int IncomeTotal;

    public int getExpenseTotal() {
        return ExpenseTotal;
    }

    public void setExpenseTotal(int expenseTotal) {
        ExpenseTotal = expenseTotal;
    }

    private int ExpenseTotal;
    private int TotalBalance;


    public HomePageResult() {
    }








    public int getTotalBalance() {
        return TotalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        TotalBalance = totalBalance;
    }




    public int getIncomeTotal() {
        return IncomeTotal;
    }

    public void setIncomeTotal(int incomeTotal) {
        IncomeTotal = incomeTotal;
    }
}
