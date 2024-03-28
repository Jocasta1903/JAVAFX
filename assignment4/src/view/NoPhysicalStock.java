package view;

/**
 * Has methods which throw declartion if product does not have physical stock. (Videogame)
 */
public class NoPhysicalStock extends Exception {

    /**
     * Throws except if product does not have physical stock. (Videogame)
     * @param sku of product that does not have physical stock. (Videogame)
     */
    public NoPhysicalStock(String sku) {
        super( "ERROR: Video game product " + sku + " does not have a physical stock.");
    }
}
