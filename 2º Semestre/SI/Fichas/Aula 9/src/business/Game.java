/*
 * Game
 * ruicouto in 10/abr/2017
 */
package business;

/**
 *
 * @author ruicouto (IJ project: jfc)
 */
public class Game {
    private int id;
    private String name;
    private int year;
    private double price;
    private String description;

    public Game() {
    }

    public Game(int id, String name, int year, double price, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "id: "+id+"name: "+name;
    }


}
