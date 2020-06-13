package com.mecherycorp;

public class ExpenceData {

    private  String Date;
    private  int Amount;
    private  String Description;
    private  String category;


    public ExpenceData(String Date,int Amount,String Description,String category ) {

        this.setDate(Date);
        this.setAmount(Amount);
        this.setDescription(Description);
        this.setCategory(category);
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
