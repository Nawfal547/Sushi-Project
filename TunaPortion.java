package com.comp301.a01sushi;

public class TunaPortion extends IngredientPortionParent {
  static Ingredient tuna = new Tuna();

  public TunaPortion(double the_amount) {
    super(tuna, the_amount);
  }
}
