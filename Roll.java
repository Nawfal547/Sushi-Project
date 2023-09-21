package com.comp301.a01sushi;

import java.util.ArrayList;
import java.util.HashMap;

public class Roll implements Sushi {
  private final String the_name;
  private IngredientPortion[] the_ingredients = new IngredientPortion[0];
  private boolean the_hasRice = false;
  private boolean the_hasShellfish = false;
  private boolean the_isVegetarian = true;

  public Roll(String name, IngredientPortion[] roll_ingredients) {

    if (roll_ingredients == null) {
      throw new IllegalArgumentException("Roll ingredients cannot be null");
    }

    this.the_name = name;
    IngredientPortion[] the_input_ingredients = roll_ingredients.clone();
    HashMap<String, Integer> keymap = new HashMap<>();
    ArrayList<String> inputtedIngredients = new ArrayList<String>();
    ArrayList<IngredientPortion> ingredientList = new ArrayList<IngredientPortion>();
    for (int i = 0; i < the_input_ingredients.length; i++) {
      if (the_input_ingredients[i] == null) {
        throw new IllegalArgumentException("Roll ingredient cannot be null");
      }

      System.out.println(
          "Ingredient: "
              + the_input_ingredients[i].getName()
              + " oz: "
              + the_input_ingredients[i].getAmount());

      if (the_input_ingredients[i].getIsShellfish()) {
        the_hasShellfish = true;
      }

      if (the_input_ingredients[i].getIsRice()) {
        the_hasRice = true;
      }

      if (!the_input_ingredients[i].getIsVegetarian()) {
        the_isVegetarian = false;
      }

      if (inputtedIngredients.contains(the_input_ingredients[i].getName())) {
        // Not the first time that this has been inputted
        int placementIndex = keymap.get(the_input_ingredients[i].getName());
        ingredientList.set(
            placementIndex, ingredientList.get(placementIndex).combine(the_input_ingredients[i]));
      } else {
        inputtedIngredients.add(the_input_ingredients[i].getName());
        keymap.put(the_input_ingredients[i].getName(), ingredientList.size());
        ingredientList.add(the_input_ingredients[i]);
      }
    }

    if (!(inputtedIngredients.contains("seaweed"))) {
      ingredientList.add(new SeaweedPortion(0.1));
    } else {
      double seaweedAmount = ingredientList.get(keymap.get("seaweed")).getAmount();
      if (seaweedAmount < 0.1) {
        System.out.println("Below needed!");
        ingredientList.set(
            keymap.get("seaweed"),
            ingredientList
                .get(keymap.get("seaweed"))
                .combine(new SeaweedPortion(0.1 - seaweedAmount)));
      }
    }
    this.the_ingredients = ingredientList.toArray(this.the_ingredients);
    System.out.println(this.the_ingredients);
  }

  @Override
  public String getName() {
    return the_name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return the_ingredients.clone();
  }

  @Override
  public int getCalories() {
    double calories_sum = 0;
    for (int i = 0; i < the_ingredients.length; i++) {
      calories_sum += the_ingredients[i].getCalories();
    }
    System.out.println(Math.round(calories_sum));
    return (int) Math.round(calories_sum);
  }

  @Override
  public double getCost() {
    double cost_sum = 0.0;
    for (int i = 0; i < the_ingredients.length; i++) {
      cost_sum += the_ingredients[i].getCost();
    }
    return Math.round(cost_sum * 100.0) / 100.0;
  }

  @Override
  public boolean getHasRice() {
    return the_hasRice;
  }

  @Override
  public boolean getHasShellfish() {
    return the_hasShellfish;
  }

  @Override
  public boolean getIsVegetarian() {
    return the_isVegetarian;
  }
}
