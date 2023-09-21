package com.comp301.a01sushi;

public class EelPortion extends IngredientPortionParent {
  static Ingredient eel = new Eel();

  public EelPortion(double the_amount) {

    super(eel, the_amount);
  }
}
