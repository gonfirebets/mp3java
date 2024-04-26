// Class representing an MP3 gadget, extending from Gadget class
public class MP3 extends Gadget {
    private int memory;

    // Constructor for initializing MP3 gadget properties
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    // Getter method for memory
    public int getMemory() {
        return memory;
    }

    // Method to download music
    public void downloadMusic(int size) {
        if (size <= memory) {
            memory -= size;
            System.out.println("Music downloaded. Remaining memory: " + memory + " MB.");
        } else {
            System.out.println("Not enough memory to download the music.");
        }
    }

    // Method to represent MP3 gadget details as a string
    @Override
    public String toString() {
        return super.toString() + ", Memory: " + memory + " MB";
    }
}
