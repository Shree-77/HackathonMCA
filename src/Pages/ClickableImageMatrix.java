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
    Login l;
    
    private ArrayList<Integer> selectedIndices;

    public ClickableImageMatrix() {
        setTitle("Clickable Image Matrix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel(new GridLayout(3, 3));

        // Create a list of image paths
        List<String> imagePaths = new ArrayList<>();
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\src\\img\\image_part_001.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_002.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_003.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_004.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_005.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_006.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_007.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_008.png");
        imagePaths.add("C:\\Users\\ELCOT\\Desktop\\HackathonMCA\\image_part_009.png");

        imageList = new ArrayList<>();
        imageButtons = new ArrayList<>();
        selectedIndices = new ArrayList<>();

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

        getContentPane().add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (imageButtons.contains(source)) {
            JButton clickedButton = (JButton) source;
            int selectedIndex = imageButtons.indexOf(clickedButton);

            // Check if the image is already selected
            if (!selectedIndices.contains(selectedIndex)) {
                selectedIndices.add(selectedIndex);
                clickedButton.setEnabled(false); // Disable the button after selecting

                System.out.println("Button " + selectedIndex + " clicked.");

                // Check if three images are selected
                if (selectedIndices.size() == 3) {
                	
                	selectedIndices.clear();
                    submitButton.setEnabled(true); // Enable the submit button
                }
            }
        } else if (source == submitButton) {
            // Handle the action for the submit button
        	Login l=new Login();
        	l.setLocationRelativeTo(null);
            l.setTitle("Login");
            l.setVisible(true);
            System.out.println("Submit button clicked.");
            // Navigate to the next page or perform the desired action
        }
    }

    public static void main(String[] args) {
        ClickableImageMatrix example = new ClickableImageMatrix();
        example.setVisible(true);
    }
}

