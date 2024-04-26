// Class representing a general gadget
public class Gadget {
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor for initializing gadget properties
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Getter methods for gadget properties
    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    // Method to represent gadget details as a string
    @Override
    public String toString() {
        return "Model: " + model + ", Price: £" + price + ", Weight: " + weight + " grams, Size: " + size;
    }
}
