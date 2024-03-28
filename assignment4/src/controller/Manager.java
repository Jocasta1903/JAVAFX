package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

import model.Figure;
import model.PhysicalProduct;
import model.Puzzle;
import model.BoardGame;
import model.VideoGame;
import view.InvalidValuesException;
import view.NoPhysicalStock;
import view.OutOfStockException;
import model.Toy;

/**
 * Manager class where function occurs
 */
public class Manager {

    /**
     * Builds list of all toy in database
     */
    public ArrayList<Toy> toyList = new ArrayList<Toy>();

    /**
     * Default constructor
     */
    public Manager(){}

    /**
     * Constructor that reassigns testToyList into toyList
     * @param testToyList list of hardcoded toys used for testing
     */
    public Manager(ArrayList<Toy> testToyList){
        toyList = testToyList;
    }

    /**
     * This method reads toysData.txt to create a list of all the toys in their respective subclasses.
     * @throws FileNotFoundException if toysData.txt is not found
     * @throws NumberFormatException if dataType of input does not match dataype of parameter
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public void toyDatabase() throws FileNotFoundException, NumberFormatException, InvalidValuesException {
        // create path of text file
        FileReader data = new FileReader(System.getProperty("user.dir") + "/res/toysData.txt");
        Scanner database = new Scanner(data);

        // read text file
        while (database.hasNext()) {
            String[] toyData = database.nextLine().split(";");
            // this takes the first number of sku
            char beginningSKU = toyData[0].charAt(0);

            // the SKU beginning with 0 or 1. It would be figure
            if (beginningSKU == '0' || beginningSKU == '1') {
                Figure toy = new Figure(toyData[0], toyData[1], Double.parseDouble(toyData[2]), Integer.parseInt(toyData[3]), toyData[4].charAt(0));
                toyList.add(toy);

                // the SKU beginning with 4, 5 or 6. It would be puzzle
            } else if (beginningSKU == '4' || beginningSKU == '5' || beginningSKU == '6') {
                Puzzle toy = new Puzzle(toyData[0], toyData[1], Double.parseDouble(toyData[2]), Integer.parseInt(toyData[3]), Integer.parseInt(toyData[4]));
                toyList.add(toy);

                // the SKU beginning with 7, 8 or 9. It would be boardgame
            } else if (beginningSKU == '7' || beginningSKU == '8' || beginningSKU == '9') {
                BoardGame toy = new BoardGame(toyData[0], toyData[1], Double.parseDouble(toyData[2]), Integer.parseInt(toyData[3]), Integer.parseInt(toyData[4]));
                toyList.add(toy);

                // the SKU beginning with 2 or 3. It would be video games.
            } else {
                VideoGame toy = new VideoGame(toyData[0], toyData[1], Double.parseDouble(toyData[2]), toyData[3]);
                toyList.add(toy);
            }
        }
        database.close();
    }

    /**
     * This method searches for all toys that have contains nameSearch using for-loop
     * @param nameSearch the string to see if it is contained in toy
     * @return a list of all the toys that contains nameSearch
     */
    public ArrayList<Toy> search(CharSequence nameSearch) {
        ArrayList<Toy> toySameName = new ArrayList<Toy>();

        for (Toy toy : toyList) {
            if (toy.getName().toLowerCase().contains(nameSearch)) { // true if lowercase toy name contains nameSearch
                toySameName.add(toy);
            }
        }
        return toySameName;
    }

    /**
     * This method uses sku to find the product and decreases its available count by 1
     * @param skuPurchase sku of product purchased by user
     * @throws OutOfStockException Throws exception if product is out of stock with a message
     */
    public void purchase(String skuPurchase) throws OutOfStockException {

        for (Toy toy : toyList) {
            if (toy.getSKU().equals(skuPurchase)) {

                if (skuPurchase.charAt(0) != '2' && skuPurchase.charAt(0) != '3') { // toy purchased is NOT a video game
                    PhysicalProduct physicalToy = (PhysicalProduct) toy; // since game is now specifically a Physcialproduct, casting Physcialproduct type
                    
                    if (physicalToy.getAvailableCount() < 1) {
                        throw new OutOfStockException(skuPurchase);
                    } else {
                        physicalToy.setAvailableCount(physicalToy.getAvailableCount() - 1); // decreasing available count by 1
                        System.out.println("You have purchased product " + skuPurchase + ".");
                    }
                }
            }
        }
    }

    /**
     * This method adds stock to available count of the product
     * @param skuStock is the sku of the product which stock is added for
     * @param addAmt amount of stock added
     * @throws NoPhysicalStock Throws except if product is out of stock with a message
     */
    public void addStock(String skuStock, int addAmt) throws NoPhysicalStock {
        for (Toy toy : toyList) {
            if (toy.getSKU().equals(skuStock)) {

                if (!(toy instanceof VideoGame)) {
                    PhysicalProduct physicalToy = (PhysicalProduct) toy; // casting PhysicalProduct to Toy > use PhysicalProduct methods
                    
                    if (physicalToy.getAvailableCount() > 0) {
                        physicalToy.setAvailableCount(physicalToy.getAvailableCount() + addAmt);
                        System.out.println(physicalToy.getAvailableCount() + " of product " + skuStock + " is available.");
                    }
                } else {
                    throw new NoPhysicalStock(skuStock);
                }
            }
        }
    }

    /**
     * This method is used to add new products into database using if-else to differentiate into respective subclasses
     * @param attributes holds all the information about the new product
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public void addNew(String[] attributes) throws InvalidValuesException {
        // attributes[0] is player choice
        char beginningNewSKU = attributes[1].charAt(0);
        Toy addToy; // "global"

        if (beginningNewSKU == '1' || beginningNewSKU == '0') { // add figure
            
            addToy = new Figure(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), attributes[5].toUpperCase().charAt(0));
            toyList.add(addToy);

        } else if (beginningNewSKU == '4' || beginningNewSKU == '5' || beginningNewSKU == '6') { // add puzzle
            addToy = new Puzzle(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
            toyList.add(addToy);

        } else if (beginningNewSKU == '7' || beginningNewSKU == '8' || beginningNewSKU == '9') { // add boardGames
            addToy = new BoardGame(attributes[1], attributes[2], Double.parseDouble(attributes[3]),
                    Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
            toyList.add(addToy);

        } else { // add videoGame
            addToy = new VideoGame(attributes[1], attributes[2], Double.parseDouble(attributes[3]), attributes[4]);
            toyList.add(addToy);

        }
        System.out.println(addToy.terminalToString());
    }

    /**
     * This method removes the product from database by entering SKU numbers
     * @param skuRemove sku of product to be removed
     */
    public void remove(String skuRemove) {
        Iterator<Toy> iterator = toyList.iterator(); // used this becasue cannot use .remove() when iterating through for loop
        do {
            Toy toy = iterator.next(); // conducts a loop, starting from index 0

            if (toy.getSKU().equals(skuRemove)) {
                iterator.remove();
                System.out.println("You have removed the following product: ");
                System.out.println(toy.terminalToString());
            }
        } while (iterator.hasNext()); // while it still has elements to loop through
    }

    /**
     * This method write data back to text file based on different type oftoy.
     * @throws IOException throws exception when failed or interuppted
     */
    public void outputToFile() throws IOException {
        FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/res/toysData.txt");
        for (Toy toy : toyList) {
            fw.write(toy.databaseToString() + "\n");
        }
        fw.close();
    }
}
