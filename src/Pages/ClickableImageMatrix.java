package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClickableImageMatrix extends JFrame implements ActionListener {

    private List<ImageIcon> imageList;
    private List<JButton> imageButtons;
    private JButton submitButton;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ClickableImageMatrix() {
        setTitle("Clickable Image Matrix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create the card layout and panel
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel panel = new JPanel(new GridLayout(3, 3));

        // Create a list of image paths
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add("/Users/shree/Documents/JavaPrograms/HackathonMCA/src/img/image_part_001.pngs");
        imagePaths.add("img/image_part_002.png");
        imagePaths.add("img/image_part_003.png");
        imagePaths.add("img/image_part_004.png");
        imagePaths.add("img/image_part_005.png");
        imagePaths.add("img/image_part_006.png");
        imagePaths.add("img/image_part_007.png");
        imagePaths.add("img/image_part_008.png");
        imagePaths.add("img/image_part_009.png");

        imageList = new ArrayList<>();
        imageButtons = new ArrayList<>();

        // Create and add buttons with images to the panel
        for (String imagePath : imagePaths) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            imageList.add(imageIcon);

            JButton button = new JButton(imageIcon);
            button.addActionListener(this);
            panel.add(button);
            imageButtons.add(button);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.add(submitButton, BorderLayout.SOUTH);

        cardPanel.add(mainPanel, "matrix");
        getContentPane().add(cardPanel);

        // Add your new homepage panel here (replace the placeholder)
        JPanel newHomePagePanel = new JPanel();
        JLabel newHomePageLabel = new JLabel("Welcome to the new homepage!");
        newHomePagePanel.add(newHomePageLabel);



        cardPanel.add(newHomePagePanel, "newHomepage");
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (imageButtons.contains(source)) {
            JButton clickedButton = (JButton) source;
            int selectedIndex = imageButtons.indexOf(clickedButton);

            // Check if the image is already selected
            if (!clickedButton.isEnabled()) {
                return; // Ignore clicks on disabled buttons
            }

            // Check if three images are already selected
            if (getSelectedImageCount() >= 3) {
                return; // Ignore clicks when three images are already selected
            }

            clickedButton.setEnabled(false); // Disable the button after selecting
            System.out.println("Button " + selectedIndex + " clicked.");
        } else if (source == submitButton) {
            // Handle the action for the submit button
            if (getSelectedImageCount() == 3) {
                System.out.println("Submit button clicked.");
                JOptionPane.showMessageDialog(this, "Password correct!"); // Show pop-up message
                cardLayout.show(cardPanel, "newHomepage"); // Show the new homepage panel
            }
        }
    }

    private int getSelectedImageCount() {
        int count = 0;
        for (JButton button : imageButtons) {
            if (!button.isEnabled()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ClickableImageMatrix example = new ClickableImageMatrix();
        example.setVisible(true);
    }
}
