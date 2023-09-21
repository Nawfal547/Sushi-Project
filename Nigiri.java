package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  IngredientPortion[] the_ingredient = new IngredientPortion[2];

  public Nigiri(NigiriType type) {
    switch (type) {
      case TUNA:
        the_ingredient[0] = new TunaPortion(0.75);
        the_ingredient[1] = new RicePortion(0.5);
        break;
      case YELLOWTAIL:
        the_ingredient[0] = new YellowtailPortion(0.75);
        the_ingredient[1] = new RicePortion(0.5);
        break;
      case EEL:
        the_ingredient[0] = new EelPortion(0.75);
        the_ingredient[1] = new RicePortion(0.5);
        break;
      case CRAB:
        the_ingredient[0] = new CrabPortion(0.75);
        the_ingredient[1] = new RicePortion(0.5);
        break;
      case SHRIMP:
        the_ingredient[0] = new ShrimpPortion(0.75);
        the_ingredient[1] = new RicePortion(0.5);
    }
  }

  @Override
  public String getName() {
    return the_ingredient[0].getName() + " nigiri";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return the_ingredient;
  }

  @Override
  public int getCalories() {
    return (int) Math.round(the_ingredient[0].getCalories() + the_ingredient[1].getCalories());
  }

  @Override
  public double getCost() {
    return the_ingredient[0].getCost() + the_ingredient[1].getCost();
  }

  @Override
  public boolean getHasRice() {
    return the_ingredient[1].getIsRice();
  }

  @Override
  public boolean getHasShellfish() {
    return the_ingredient[0].getIsShellfish();
  }

  @Override
  public boolean getIsVegetarian() {
    return the_ingredient[0].getIsVegetarian();
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
