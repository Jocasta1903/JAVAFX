package model;

import view.InvalidValuesException;

/**
 * Abstract superclass Toy represent general information (SKU, name, price) of the product
 */
public abstract class Toy {
    private String sku;
    private String name;
    private double price;

    /**
     * Store product information
     * 
     * @param sku   SKU number of the products
     * @param name  the name of the product
     * @param price the price of the product
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public Toy(String sku, String name, double price) throws InvalidValuesException {
        if (sku.length() == 10) {
            this.sku = sku;
        } else {
            throw new InvalidValuesException(sku);
        }

        this.name = name;

        if (price >= 0) {
            this.price = price;
        } else {
            throw new InvalidValuesException(price);
        }
    }

    /**
     * SKU getter method
     * 
     * @return SKU
     */
    public String getSKU() {
        return sku;
    }

    /**
     * SKU setter method
     * 
     * @param sku of toy
     */
    public void setSKU(String sku) {
        this.sku = sku;
    }

    /**
     * name getter method
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * name setter method
     * 
     * @param name of toy
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * price getter method
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * price setter method
     * 
     * @param price of toy
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (getSKU() + ": " + getName());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (getSKU() + ";" + getName() + ";" + getPrice());
    }
}