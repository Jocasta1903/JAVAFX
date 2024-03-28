package model;

import view.InvalidValuesException;

/**
 * This class represent the common information of physical product (available
 * count) and connect to Toy class
 */
public abstract class PhysicalProduct extends Toy {
    private int availableCount; // changed to private

    /**
     * This constructor takes in attributes of physical product
     * @param sku            SKU number of the physical products
     * @param name           the name of the physical product
     * @param price          the price of the physical product
     * @param availableCount the available number of physical product
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public PhysicalProduct(String sku, String name, double price, int availableCount) throws InvalidValuesException {
        super(sku, name, price);
        if (availableCount >= 0) {
            this.availableCount = availableCount;
        } else {
            throw new InvalidValuesException(availableCount);
        }
    }

    /**
     * AvailableCount getter method
     * 
     * @return availableCount
     */
    public int getAvailableCount() {
            return availableCount;
    }

    /**
     * AvailableCount setter method
     * 
     * @param availableCount of physical product
     */
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (super.terminalToString() + ", available count: " + getAvailableCount());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (super.databaseToString() + ";" + getAvailableCount());
    }
}