import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MiniProject extends JFrame {
    private JTextField nameField, ageField, weightField;
    private JButton createUserButton, addActivityButton, showStatsButton;
    private JTextArea outputArea;
    private User user;

    public MiniProject() {
        setTitle("Fitness Tracker");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for user input
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createTitledBorder("User Information"));

        nameField = new JTextField(15);
        ageField = new JTextField(5);
        weightField = new JTextField(5);
        createUserButton = new JButton("Create User");

        topPanel.add(new JLabel("Name:"));
        topPanel.add(nameField);
        topPanel.add(new JLabel("Age:"));
        topPanel.add(ageField);
        topPanel.add(new JLabel("Weight (kg):"));
        topPanel.add(weightField);
        topPanel.add(createUserButton);

        // Bottom panel for activity buttons and output area
        JPanel bottomPanel = new JPanel(new FlowLayout());
        addActivityButton = new JButton("Add Activity");
        showStatsButton = new JButton("Show Statistics");
        bottomPanel.add(addActivityButton);
        bottomPanel.add(showStatsButton);

        // Output area
        outputArea = new JTextArea(15, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Activity Log"));

        // Adding components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action Listeners
        createUserButton.addActionListener(e -> createUser());
        addActivityButton.addActionListener(e -> addActivity());
        showStatsButton.addActionListener(e -> showStatistics());

        // Load user data if available
        loadUser();

        setVisible(true);
        
    }

    private void createUser() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double weight = Double.parseDouble(weightField.getText());
        user = new User(name, age, weight);
        outputArea.append("User created: " + name + ", Age: " + age + ", Weight: " + weight + " kg\n");
        
        // ซ่อนปุ่มสร้างผู้ใช้หลังจากที่สร้างผู้ใช้แล้ว
        createUserButton.setVisible(false);
        
        saveUser();
    }
    
    private void addActivity() {
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Please create a user first!");
            return;
        }
    
        String[] options = {"Running", "Weightlifting", "Boxing"};
        int choice = JOptionPane.showOptionDialog(this, "Select an activity:", "Activity",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    
        FitnessActivity activity = null;
        if (choice == 0) { // Running
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            double distance = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter distance (km):"));
            activity = new RunningActivity(duration, intensity, distance);
        } else if (choice == 1) { // Weightlifting
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            int weightLifted = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter weight lifted (kg):"));
            int repetitions = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter repetitions:"));
            activity = new WeightliftingActivity(duration, intensity, weightLifted, repetitions);
        } else if (choice == 2) { // Boxing
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            int punches = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter punches thrown:"));
            activity = new BoxingActivity(duration, intensity, punches);
        }
    
        // Add the activity to the user and immediately display the result
        if (activity != null) {
            user.addActivity(activity);
            outputArea.append("Added Activity:\n" + activity.toString() + "\n");
            outputArea.append("Calories Burned: " + activity.calculateCaloriesBurned() + "\n");
        }
    }
    

    private void showStatistics() {
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Please create a user first!");
            return;
        }
        user.showStatistics(outputArea);
    }

    private void saveUser() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving user data.");
        }
    }

    private void loadUser() {
        File file = new File("user.dat");
        if (!file.exists()) {
            outputArea.append("No existing user found. Please create a new user by entering details above.\n");
            return;
        }
    
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            user = (User) ois.readObject();
            if (user != null) {
                nameField.setText(user.getName());
                ageField.setText(String.valueOf(user.getAge()));
                weightField.setText(String.valueOf(user.getWeight()));
                outputArea.append("Welcome back, " + user.getName() + "!\n");
                
                // Hide the create user button if user data is loaded
                createUserButton.setVisible(false);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            outputArea.append("Error loading user data. Please create a new user by entering details above.\n");
        }
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MiniProject::new);
    }
}

// User class
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double weight; // weight in kilograms
    private List<FitnessActivity> activities;

    public User(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void addActivity(FitnessActivity activity) {
        activities.add(activity);
    }

    public void showStatistics(JTextArea outputArea) {
        double totalCaloriesBurned = 0;
        outputArea.append("\nUser: " + name + "\n");
        for (FitnessActivity activity : activities) {
            outputArea.append(activity.toString() + "\n");
            totalCaloriesBurned += activity.calculateCaloriesBurned();
        }
        outputArea.append("Total Calories Burned: " + totalCaloriesBurned + "\n");
    }
}

// FitnessActivity, RunningActivity, WeightliftingActivity, BoxingActivity classes

abstract class FitnessActivity {
    protected String name;
    protected int duration; // duration in minutes
    protected int intensity; // intensity scale from 1 to 10

    public FitnessActivity(String name, int duration, int intensity) {
        this.name = name;
        this.duration = duration;
        this.intensity = intensity;
    }

    // Abstract method to calculate calories burned
    public abstract double calculateCaloriesBurned();

    @Override
    public String toString() {
        return "Activity: " + name + ", Duration: " + duration + " minutes, Intensity: " + intensity + "/10";
    }
}

class RunningActivity extends FitnessActivity {
    private double distance; // distance in kilometers

    public RunningActivity(int duration, int intensity, double distance) {
        super("Running", duration, intensity);
        this.distance = distance;
    }

    @Override
    public double calculateCaloriesBurned() {
        // Simple formula to calculate calories burned based on distance, intensity, and duration
        return distance * intensity * 1.036;
    }

    @Override
    public String toString() {
        return super.toString() + ", Distance: " + distance + " km";
    }
}

class WeightliftingActivity extends FitnessActivity {
    private int weightLifted; // weight in kilograms
    private int repetitions;   // number of repetitions

    public WeightliftingActivity(int duration, int intensity, int weightLifted, int repetitions) {
        super("Weightlifting", duration, intensity);
        this.weightLifted = weightLifted;
        this.repetitions = repetitions;
    }

    @Override
    public double calculateCaloriesBurned() {
        // Simple formula to calculate calories burned based on weight lifted and repetitions
        return weightLifted * repetitions * 0.1 * intensity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight Lifted: " + weightLifted + " kg, Repetitions: " + repetitions;
    }
}

class BoxingActivity extends FitnessActivity {
    private int punches; // number of punches thrown

    public BoxingActivity(int duration, int intensity, int punches) {
        super("Boxing", duration, intensity);
        this.punches = punches;
    }

    @Override
    public double calculateCaloriesBurned() {
        // Simple formula to calculate calories burned based on the number of punches and intensity
        return punches * 0.5 * intensity;
    }

    @Override
    public String toString() {
        return super.toString() + ", Punches Thrown: " + punches;
    }
}
