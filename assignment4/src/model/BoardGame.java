package model;

import view.InvalidValuesException;

/**
 * This class represent the information of board game and inherits PhysicalProduct class
 */
public class BoardGame extends PhysicalProduct {
    private int minAge;

    /**
     * This is a constructor that takes in attributes of BoardGame
     * @param sku of board game toy
     * @param name of board game toy
     * @param price of board game toy
     * @param availableCount of board game toy
     * @param minAge of board game toy
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public BoardGame(String sku, String name, double price, int availableCount, int minAge) throws InvalidValuesException {
        super(sku, name, price, availableCount);
        if (minAge >= 0) {
            this.minAge = minAge;
        } else {
            throw new InvalidValuesException(minAge, price);
        }
    }

    /**
     * This methods gets minimum age of board game toy
     * @return minimum age of board game toy
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * This methods sets minimum age of board game toy
     * @param minAge of of board game toy
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (super.terminalToString() + ", min age: " + getMinAge() + ", $" + super.getPrice());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (super.databaseToString() + ";" + getMinAge());
    }
}
