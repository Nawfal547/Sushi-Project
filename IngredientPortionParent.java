package com.comp301.a01sushi;

public class IngredientPortionParent implements IngredientPortion {
  private final Ingredient the_ingredient;
  private final double the_amount;

  public IngredientPortionParent(Ingredient ingredient, double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }
    this.the_ingredient = ingredient;
    this.the_amount = amount;
  }

  @Override
  public Ingredient getIngredient() {
    return the_ingredient;
  }

  @Override
  public double getAmount() {
    return the_amount;
  }

  @Override
  public String getName() {
    return the_ingredient.getName();
  }

  @Override
  public boolean getIsVegetarian() {
    return the_ingredient.getIsVegetarian();
  }

  @Override
  public boolean getIsRice() {
    return the_ingredient.getIsRice();
  }

  @Override
  public boolean getIsShellfish() {
    return the_ingredient.getIsShellfish();
  }

  @Override
  public double getCalories() {
    return the_amount * the_ingredient.getCaloriesPerOunce();
  }

  @Override
  public double getCost() {
    return the_amount * the_ingredient.getPricePerOunce();
  }

  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    } else if (!other.getName().equals(this.getName())) {
      throw new IllegalArgumentException("Cannot combine two portions of different ingredients.");
    } else {
      return new IngredientPortionParent(
          this.getIngredient(), this.getAmount() + other.getAmount());
    }
  }
}
