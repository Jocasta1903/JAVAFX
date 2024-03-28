package model;

import view.InvalidValuesException;

/**
 * This class represent the specific information of Figure (classification) and inherits PhysicalProduct class
 */
public class Figure extends PhysicalProduct {
    private char classification;

    /**
     * This is a constructor that takes in attributes of Figure
     * @param sku of figure toy
     * @param name of figure toy
     * @param price of figure toy
     * @param availableCount of figure toy
     * @param classification of figure toy
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public Figure(String sku, String name, double price, int availableCount, char classification) throws InvalidValuesException {
        super(sku, name, price, availableCount);
        if (classification == 'A' || classification == 'D' || classification == 'H') {
            this.classification = classification;
        } else {
            throw new InvalidValuesException(classification);
        }
    }

    /**
     * This method gets classification of figure toy
     * @return classification of figure toy
     */
    public char getClassification() {
        return classification;
    }

    /**
     * This method sets classification of figure toy
     * @param classification of figure toy
     */
    public void setClassification(char classification) {
        this.classification = classification;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (super.terminalToString() + ", classification: " + getClassification() + ", $" + super.getPrice());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (super.databaseToString() + ";" + getClassification());
    }
}
