package view;

/**
 * Has methods which throw declartion if any inupt value of newly added product does not match its format.
 */
public class InvalidValuesException extends Exception {

    /**
     * Throws exception if sku of added product is not 10 digits.
     * @param sku of newly added product
     */
    public InvalidValuesException(String sku) {
        super("ERROR: SKU (input: " + sku + ") must be a 10-digit number.");
    }

    /**
     * Throws exception if price of added product is a negative number.
     * @param price of newly added product
     */
    public InvalidValuesException(double price) {
        super("ERROR: Price (input: " + price + ") cannot be negative.");
    }

    /**
     * Throws exception if availableCount of added product is a negative number.
     * @param availableCount of newly added product
     */
    public InvalidValuesException(int availableCount) {
        super("ERROR: Available count (input: " + availableCount + ") cannot be negative.");
    }

    /**
     * Throws exception if classification of added product is not A, D or H.
     * @param classification of newly added product
     */
    public InvalidValuesException(char classification) { // figure
        super("ERROR: Classification (input: " + classification + ") for Figure must be A, D or H.");
    }

    /**
     * Throws exception if minPieces of added product is less than 0.
     * @param minPieces of newly added product
     * @param sku of newly added product
     */
    public InvalidValuesException(int minPieces, String sku) { // puzzle
        super("ERROR: Minimum number of pieces (input: " + minPieces + ") for Puzzle must be more than 0.");
    }

    /**
     * Throws exception if minAge of added product is a negative number.
     * @param minAge of newly added product
     * @param price of newly added product
     */
    public InvalidValuesException(int minAge, double price) { // boardGame
        super("ERROR: Minimum age (input: " + minAge + ") for Board Game cannot be negative.");
    }
}
