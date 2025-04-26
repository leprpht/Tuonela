import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.TreeMap;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        // Fonts
        TreeMap<String, Font> fonts = FontLibrary.uploadFonts();

        JFrame frame = new JFrame("Tuonela");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.width * 9 / 16);
        frame.setLocation(0, 0);
        frame.setResizable(false);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Entry Screen
        JPanel enterScreen = new JPanel();
        enterScreen.setBackground(Color.BLACK);
        enterScreen.setLayout(new GridLayout(8,5));

        JLabel titleLabel = new JLabel();
        titleLabel.setFont(fonts.get("titleFont"));
        Screen.write("Tuonela", titleLabel, 100, Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        JButton[] buttons = {startButton, exitButton};
        for (JButton button : buttons) {
        button.setFont(fonts.get("buttonFont"));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.DARK_GRAY);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(10, 10));
        button.setFocusable(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }

        Screen.appearDelay(startButton, 1500);    
        Screen.appearDelay(exitButton, 2200);    
        
        for (int i = 0; i < 15; i++) {
            enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        }


        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(titleLabel);
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));

        for (int i = 0; i < 10; i++) {
            enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        }

        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(startButton);
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));

        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(exitButton);
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));
        enterScreen.add(Box.createRigidArea(new Dimension(0, 0)));

        startButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "MainScreen");
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Main Screen
        JPanel mainScreen = new JPanel();
        mainScreen.setBackground(Color.BLACK);


        mainPanel.add(enterScreen, "EnterScreen");
        mainPanel.add(mainScreen, "MainScreen");
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}