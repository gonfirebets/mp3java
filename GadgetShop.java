import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

// Main class responsible for the GUI and interaction with users
public class GadgetShop implements ActionListener {
    private JFrame frame;
    private ArrayList<Gadget> gadgets;

    // Text fields for user input
    private JTextField modelTextField;
    private JTextField priceTextField;
    private JTextField weightTextField;
    private JTextField sizeTextField;
    private JTextField creditTextField;
    private JTextField memoryTextField;
    private JTextField phoneNoTextField;
    private JTextField durationTextField;
    private JTextField downloadTextField;
    private JTextField displayNumberTextField;

    // Labels for text fields
    private JLabel modelLabel;
    private JLabel priceLabel;
    private JLabel weightLabel;
    private JLabel sizeLabel;
    private JLabel creditLabel;
    private JLabel memoryLabel;
    private JLabel phoneNoLabel;
    private JLabel durationLabel;
    private JLabel downloadLabel;
    private JLabel displayNumberLabel;

    // Buttons for user actions
    private JButton mobileButton;
    private JButton mp3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeACallButton;
    private JButton downloadMusicButton;

    // Entry point of the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GadgetShop::new);
    }

    // Constructor initializing the GUI components
    public GadgetShop() {
        frame = new JFrame("GadgetShop");
        gadgets = new ArrayList<>();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7, 4, 5, 5));

        // Initializing text fields
        modelTextField = new JTextField(15);
        priceTextField = new JTextField(15);
        weightTextField = new JTextField(15);
        sizeTextField = new JTextField(15);
        creditTextField = new JTextField(15);
        memoryTextField = new JTextField(15);
        phoneNoTextField = new JTextField(15);
        durationTextField = new JTextField(15);
        downloadTextField = new JTextField(15);
        displayNumberTextField = new JTextField(15);

        // Initializing labels for text fields
        modelLabel = new JLabel("Model:");
        contentPane.add(modelLabel);
        contentPane.add(modelTextField);
        priceLabel = new JLabel("Price:");
        contentPane.add(priceLabel);
        contentPane.add(priceTextField);
        weightLabel = new JLabel("Weight:");
        contentPane.add(weightLabel);
        contentPane.add(weightTextField);
        sizeLabel = new JLabel("Size:");
        contentPane.add(sizeLabel);
        contentPane.add(sizeTextField);

        creditLabel = new JLabel("Credit:");
        contentPane.add(creditLabel);
        contentPane.add(creditTextField);
        memoryLabel = new JLabel("Memory:");
        contentPane.add(memoryLabel);
        contentPane.add(memoryTextField);
        mobileButton = new JButton("Add Mobile");
        mobileButton.addActionListener(this);
        contentPane.add(mobileButton);
        mp3Button = new JButton("Add MP3");
        mp3Button.addActionListener(this);
        contentPane.add(mp3Button);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        contentPane.add(clearButton);
        displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(this);
        contentPane.add(displayAllButton);

        phoneNoLabel = new JLabel("Phone No:");
        contentPane.add(phoneNoLabel);
        contentPane.add(phoneNoTextField);
        durationLabel = new JLabel("Duration:");
        contentPane.add(durationLabel);
        contentPane.add(durationTextField);
        downloadLabel = new JLabel("Download:");
        contentPane.add(downloadLabel);
        contentPane.add(downloadTextField);
        displayNumberLabel = new JLabel("Display Number:");
        contentPane.add(displayNumberLabel);
        contentPane.add(displayNumberTextField);

        makeACallButton = new JButton("Make A Call");
        makeACallButton.addActionListener(this);
        contentPane.add(makeACallButton);
        downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(this);
        contentPane.add(downloadMusicButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Action listener for button clicks
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        try {
            switch (command) {
                case "Add Mobile":
                    addMobile();
                    break;
                case "Add MP3":
                    addMP3();
                    break;
                case "Display All":
                    displayAll();
                    break;
                case "Clear":
                    clear();
                    break;
                case "Make A Call":
                    makeACall();
                    break;
                case "Download Music":
                    downloadMusic();
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Unknown command.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to add a mobile gadget
    private void addMobile() {
        String model = modelTextField.getText();
        double price = Double.parseDouble(priceTextField.getText());
        int weight = Integer.parseInt(weightTextField.getText());
        String size = sizeTextField.getText();
        int credit = Integer.parseInt(creditTextField.getText());

        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);

        JOptionPane.showMessageDialog(frame, "Mobile added successfully.");
    }

    // Method to add an MP3 gadget
    private void addMP3() {
        String model = modelTextField.getText();
        double price = Double.parseDouble(priceTextField.getText());
        int weight = Integer.parseInt(weightTextField.getText());
        String size = sizeTextField.getText();
        int memory = Integer.parseInt(memoryTextField.getText());

        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);

        JOptionPane.showMessageDialog(frame, "MP3 added successfully.");
    }

    // Method to display all gadgets
    private void displayAll() {
        StringBuilder sb = new StringBuilder();
        for (Gadget gadget : gadgets) {
            sb.append(gadget).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString(), "All Gadgets", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to clear all text fields
    private void clear() {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNoTextField.setText("");
        durationTextField.setText("");
        downloadTextField.setText("");
        displayNumberTextField.setText("");
    }

    // Method to make a call using a mobile gadget
    private void makeACall() {
        int index = Integer.parseInt(displayNumberTextField.getText());
        String phoneNo = phoneNoTextField.getText();
        int duration = Integer.parseInt(durationTextField.getText());

        if (index >= 0 && index < gadgets.size() && gadgets.get(index) instanceof Mobile) {
            Mobile mobile = (Mobile) gadgets.get(index);
            mobile.makeCall(phoneNo, duration);
            JOptionPane.showMessageDialog(frame, "Call made successfully to " + phoneNo);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid gadget number or not a Mobile.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to download music to an MP3 gadget
    private void downloadMusic() {
        int index = Integer.parseInt(displayNumberTextField.getText());
        int size = Integer.parseInt(downloadTextField.getText());

        if (index >= 0 && index < gadgets.size() && gadgets.get(index) instanceof MP3) {
            MP3 mp3 = (MP3) gadgets.get(index);
            mp3.downloadMusic(size);
            JOptionPane.showMessageDialog(frame, "Music downloaded successfully.");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid gadget number or not an MP3.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
