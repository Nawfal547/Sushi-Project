package com.comp301.a01sushi;

public class ShrimpPortion extends IngredientPortionParent {
  static Ingredient shrimp = new Shrimp();

  public ShrimpPortion(double the_amount) {

    super(shrimp, the_amount);
  }
}
