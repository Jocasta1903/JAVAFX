package view;

/**
 * Has methods which throw declartion if product is out of stock with a message
 */
public class OutOfStockException extends Exception {

    /**
     * Throws exception if product is out of stock with a message
     * @param sku of product that is out of stock
     */
    public OutOfStockException (String sku) {
        super("ERROR: Product " + sku + "is out of stock.");
    }
}
