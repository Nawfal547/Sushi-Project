package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  IngredientPortion[] the_ingredient = new IngredientPortion[1];

  public Sashimi(SashimiType type) {
    switch (type) {
      case TUNA:
        the_ingredient[0] = new TunaPortion(0.75);

        break;
      case YELLOWTAIL:
        the_ingredient[0] = new YellowtailPortion(0.75);

        break;
      case EEL:
        the_ingredient[0] = new EelPortion(0.75);

        break;
      case CRAB:
        the_ingredient[0] = new CrabPortion(0.75);

        break;
      case SHRIMP:
        the_ingredient[0] = new ShrimpPortion(0.75);
    }
  }

  @Override
  public String getName() {
    return the_ingredient[0].getName() + " sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return the_ingredient;
  }

  @Override
  public int getCalories() {
    return (int) Math.round(the_ingredient[0].getCalories());
  }

  @Override
  public double getCost() {
    return the_ingredient[0].getCost();
  }

  @Override
  public boolean getHasRice() {
    return the_ingredient[0].getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return the_ingredient[0].getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return the_ingredient[0].getIsVegetarian();
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
