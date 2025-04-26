
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Screen {
    public static void write(String text, JLabel label, int delay, Color color) {
        label.setForeground(color);
        final int[] index = {0};
        Timer timer = new Timer(delay, e -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }
    public static void write(String text, JLabel label, int delay) {
        final int[] index = {0};
        Timer timer = new Timer(delay, e -> {
            if (index[0] < text.length()) {
                label.setText(label.getText() + text.charAt(index[0]));
                index[0]++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });
        timer.start();
    }
    public static void appearDelay(JComponent component, int delay) {
        component.setVisible(false);
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                SwingUtilities.invokeLater(() -> {
                    component.setVisible(true);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
