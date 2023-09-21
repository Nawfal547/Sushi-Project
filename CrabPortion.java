package com.comp301.a01sushi;

public class CrabPortion extends IngredientPortionParent {
  static Ingredient crab = new Crab();

  public CrabPortion(double the_amount) {
    super(crab, the_amount);
  }

  public IngredientPortion combine(IngredientPortion other) {
    IngredientPortion total;
    if (other == null) {
      return this;
    } else if (crab.equals(other.getIngredient())) {
      total =
          new IngredientPortionParent(this.getIngredient(), this.getAmount() + other.getAmount());
    } else {
      throw new IllegalArgumentException();
    }
    return total;
  }
}
