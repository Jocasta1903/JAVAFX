package model;

import view.InvalidValuesException;

/**
 * This method use to represent the specific information of puzzle (pieces) and inherits PhysicalProduct class
 */
public class Puzzle extends PhysicalProduct {
    private int minPieces;

    /**
     * This is a constructor that takes in attributes of Puzzle
     * @param sku of puzzle toy
     * @param name of puzzle toy
     * @param price of puzzle toy
     * @param availableCount of puzzle toy
     * @param minPieces of puzzle toy
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public Puzzle(String sku, String name, double price, int availableCount, int minPieces) throws InvalidValuesException {
        super(sku, name, price, availableCount);
        if (minPieces > 0) {
            this.minPieces = minPieces;
        } else {
            throw new InvalidValuesException(minPieces, sku);
        }
    }

    /**
     * MinPieces getter method
     * @return MinPieces
     */
    public int getMinPieces() {
        return minPieces;
    }

    /**
     * MinPieces setter method
     * @param minPieces of puzzle
     */
    public void setMinPieces(int minPieces) {
        this.minPieces = minPieces;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (super.terminalToString() + ", #pieces: " + getMinPieces() + ", $" + super.getPrice());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (super.databaseToString() + ";" + getMinPieces());
    }
}
