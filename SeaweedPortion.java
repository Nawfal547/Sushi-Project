package com.comp301.a01sushi;

public class SeaweedPortion extends IngredientPortionParent {
  static Ingredient seaweed = new Seaweed();

  public SeaweedPortion(double the_amount) {
    super(seaweed, the_amount);
  }
}
