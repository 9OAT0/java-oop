import javax.swing.*;
import java.awt.*;

public class FitnessTrackingDeviceGUI extends JFrame {

    public FitnessTrackingDeviceGUI() {
        setTitle("Fitness Tracking Device");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setPreferredSize(new Dimension(400, 100));
        
        JLabel titleLabel = new JLabel("Fitness Tracking Device");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        headerPanel.add(Box.createVerticalStrut(20));  // Padding
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(10));  // Padding

        // Tab panel
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Connection", createConnectionPanel());
        tabbedPane.addTab("Statistics", new JPanel());
        tabbedPane.addTab("Shop", new JPanel());

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.WHITE);
        
        JButton connectButton = new JButton("Connect");
        footerPanel.add(connectButton);

        add(headerPanel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createConnectionPanel() {
        JPanel connectionPanel = new JPanel();
        connectionPanel.setLayout(new BoxLayout(connectionPanel, BoxLayout.Y_AXIS));
        connectionPanel.setBackground(Color.WHITE);

        JLabel deviceLabel = new JLabel("Universal Fitness Expander");
        deviceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        deviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel qrLabel = new JLabel("Scan the device's QR to connect");
        qrLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        qrLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        ImageIcon deviceIcon = new ImageIcon("path/to/fitness-device-image.jpg"); // Replace with actual path
        JLabel imageLabel = new JLabel(deviceIcon);
        imagePanel.add(imageLabel);

        connectionPanel.add(Box.createVerticalStrut(20)); // Padding
        connectionPanel.add(deviceLabel);
        connectionPanel.add(Box.createVerticalStrut(10)); // Padding
        connectionPanel.add(qrLabel);
        connectionPanel.add(Box.createVerticalStrut(20)); // Padding
        connectionPanel.add(imagePanel);

        return connectionPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FitnessTrackingDeviceGUI app = new FitnessTrackingDeviceGUI();
            app.setVisible(true);
        });
    }
}
