package br.org.acal.application.screen.splash;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SplashScreen extends JWindow {

    private JProgressBar progressBar;

    public SplashScreen() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);

        ImageIcon icon = new SplashImages().random();

        JLabel imageLabel = new JLabel(icon);
        content.add(imageLabel, BorderLayout.CENTER);

        JLabel headerLabel = new JLabel("ACAL Versão 1.2.0.BETA", SwingConstants.CENTER);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("Loading...");

        content.add(headerLabel, BorderLayout.NORTH);
        content.add(progressBar, BorderLayout.SOUTH);

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
}
