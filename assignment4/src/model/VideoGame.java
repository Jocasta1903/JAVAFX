package model;

import view.InvalidValuesException;

/**
 * This class represent the common information of VideoGame (team) and connect to Toy class
 */
public class VideoGame extends Toy {
    private String team;

    /**
     * This is a constructor that takes in attributes of VideoGame
     * @param sku of VideoGame
     * @param name of VideoGame
     * @param price of VideoGame
     * @param team of VideoGame
     * @throws InvalidValuesException Has methods which throw declartion if any inupt value of newly added product does not match its format.
     */
    public VideoGame(String sku, String name, double price,String team) throws InvalidValuesException {
        super(sku, name, price);
        this.team = team;
    }

    /**
     * Team getter method
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Team setter method
     * @param team of videogame  
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * String that prints to the terminal
     */
    public String terminalToString() {
        return (super.terminalToString() + ", " + getTeam() + ", $" + super.getPrice());
    }

    /**
     * String that prints back to database
     */
    public String databaseToString() {
        return (super.databaseToString() + ";" + getTeam());
    }
}

