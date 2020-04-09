package com.example.mum.RecipeHelper;

public class Recipe {

    private int id;
    private String title;
    private String calories;
    private String completionTime;
    private String ingredients;
    private String instructions;
    //private byte[] image;

    public Recipe(String title, String calories, String completionTime, String ingredients, String instructions, int id) {
        this.title = title;
        this.calories = calories;
        this.completionTime = completionTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        //this.image = image;
        this.id = id;

    }

    // ID
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }

    // Title
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    // Calories
    public String getCalories() { return calories; }
    public void setCalories(String calories) { this.calories = calories; }

    // Completion Time
    public String getCompletionTime() { return completionTime; }
    public void setCompletionTime(String completionTime) { this.completionTime = completionTime; }

    // Ingredients
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    // Instructions
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    // Food Image
    //public byte[] getImage() { return image; }
    //public void setImage(byte[] image) { this.image = image; }



}
