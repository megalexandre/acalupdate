package br.org.acal.application.screen.splash;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SplashScreen extends JWindow {
    private JLabel statusLabel;
    private JLabel headerLabel;
    private JLabel imageLabel;

    public SplashScreen() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);

        ImageIcon icon = new SplashImages().random();

        imageLabel = new JLabel(icon);
        content.add(imageLabel, BorderLayout.CENTER);

        headerLabel = new JLabel("ACAL", SwingConstants.CENTER);
        statusLabel = new JLabel("Versão 0.1.6", SwingConstants.CENTER);

        content.add(statusLabel, BorderLayout.SOUTH);
        content.add(headerLabel, BorderLayout.NORTH);

        int width = 1024/2;
        int height = 768/2;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        setContentPane(content);
    }

    public void showSplash() {
        setVisible(true);
    }

    public void hideSplash() {
        setVisible(false);
        dispose();
    }

    public void setStatus(String message) {
        statusLabel.setText(message);
    }
}
