package com.example.mum;

public class Ingredients {

    public String ingredientName;
    public int ID;

    public Ingredients(String ingredientName, int ID) {
        this.ingredientName = ingredientName;
        this.ID = ID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
