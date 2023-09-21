package com.comp301.a01sushi;

public class RicePortion extends IngredientPortionParent {
  static Ingredient rice = new Rice();

  public RicePortion(double the_amount) {
    super(rice, the_amount);
  }
}
