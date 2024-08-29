import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        setLayout(new FlowLayout());

        // User details input
        nameField = new JTextField(15);
        ageField = new JTextField(5);
        weightField = new JTextField(5);
        createUserButton = new JButton("Create User");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Weight (kg):"));
        add(weightField);
        add(createUserButton);

        // Activity buttons
        addActivityButton = new JButton("Add Activity");
        showStatsButton = new JButton("Show Statistics");

        add(addActivityButton);
        add(showStatsButton);

        // Output area
        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Action Listeners
        createUserButton.addActionListener(e -> createUser());
        addActivityButton.addActionListener(e -> addActivity());
        showStatsButton.addActionListener(e -> showStatistics());

        setVisible(true);
    }

    private void createUser() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double weight = Double.parseDouble(weightField.getText());
        user = new User(name, age, weight);
        outputArea.append("User created: " + name + ", Age: " + age + ", Weight: " + weight + " kg\n");
    }

    private void addActivity() {
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Please create a user first!");
            return;
        }

        String[] options = {"Running", "Weightlifting", "Boxing"};
        int choice = JOptionPane.showOptionDialog(this, "Select an activity:", "Activity",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // Running
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            double distance = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter distance (km):"));
            RunningActivity runningActivity = new RunningActivity(duration, intensity, distance);
            user.addActivity(runningActivity);
            outputArea.append("Running activity added.\n");
        } else if (choice == 1) { // Weightlifting
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            int weightLifted = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter weight lifted (kg):"));
            int repetitions = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter repetitions:"));
            WeightliftingActivity weightliftingActivity = new WeightliftingActivity(duration, intensity, weightLifted, repetitions);
            user.addActivity(weightliftingActivity);
            outputArea.append("Weightlifting activity added.\n");
        } else if (choice == 2) { // Boxing
            int duration = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter duration (minutes):"));
            int intensity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter intensity (1-10):"));
            int punches = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter punches thrown:"));
            BoxingActivity boxingActivity = new BoxingActivity(duration, intensity, punches);
            user.addActivity(boxingActivity);
            outputArea.append("Boxing activity added.\n");
        }
    }

    private void showStatistics() {
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Please create a user first!");
            return;
        }
        user.showStatistics(outputArea);
    }

    public static void main(String[] args) {
        new MiniProject();
    }
}

class User {
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

// FitnessActivity, RunningActivity, WeightliftingActivity, BoxingActivity classes remain the same


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

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getIntensity() {
        return intensity;
    }

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

    public double getDistance() {
        return distance;
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
        return weightLifted * repetitions * 0.1;
    }

    public int getWeightLifted() {
        return weightLifted;
    }

    public int getRepetitions() {
        return repetitions;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight Lifted: " + weightLifted + " kg, Repetitions: " + repetitions;
    }
}

// New BoxingActivity class
class BoxingActivity extends FitnessActivity {
    private int punches; // number of punches thrown

    public BoxingActivity(int duration, int intensity, int punches) {
        super("Boxing", duration, intensity);
        this.punches = punches;
    }

    @Override
    public double calculateCaloriesBurned() {
        // Simple formula to calculate calories burned based on punches thrown, intensity, and duration
        return punches * intensity * 0.5;
    }

    public int getPunches() {
        return punches;
    }

    @Override
    public String toString() {
        return super.toString() + ", Punches Thrown: " + punches;
    }
}
