package com.comp301.a01sushi;

import java.util.Objects;

class IngredientParent implements Ingredient {
  private final String name;
  private final double price;
  private final int calories;
  private final boolean isVegeterian;
  private final boolean hasRice;
  private final boolean shellfish;

  public IngredientParent(
      String name,
      double price,
      int calories,
      boolean isVegeterian,
      boolean hasRice,
      boolean shellfish) {
    this.name = name;
    this.price = price;
    this.calories = calories;
    this.isVegeterian = isVegeterian;
    this.hasRice = hasRice;
    this.shellfish = shellfish;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return this.calories / this.price;
  }

  @Override
  public int getCaloriesPerOunce() {
    return this.calories;
  }

  @Override
  public double getPricePerOunce() {
    return this.price;
  }

  @Override
  public boolean getIsVegetarian() {
    return this.isVegeterian;
  }

  @Override
  public boolean getIsRice() {
    return this.hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return this.shellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    return Objects.equals(other.getName(), getName());
  }
}
