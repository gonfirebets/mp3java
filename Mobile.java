// Class representing a mobile gadget, extending from Gadget class
public class Mobile extends Gadget {
    private int callingCredit;

    // Constructor for initializing mobile gadget properties
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    // Getter method for calling credit
    public int getCallingCredit() {
        return callingCredit;
    }

    // Method to add credit to calling credit
    public void addCredit(int credit) {
        callingCredit += credit;
        System.out.println("Credit added. Total calling credit: " + callingCredit);
    }

    // Method to make a call
    public void makeCall(String phoneNumber, int duration) {
        if (duration <= callingCredit) {
            callingCredit -= duration;
            System.out.println("Call made to " + phoneNumber + ". Duration: " + duration + " minutes. Remaining credit: " + callingCredit + " minutes.");
        } else {
            System.out.println("Not enough credit to make the call.");
        }
    }

    // Method to represent mobile gadget details as a string
    @Override
    public String toString() {
        return super.toString() + ", Calling Credit: " + callingCredit + " minutes";
    }
}
