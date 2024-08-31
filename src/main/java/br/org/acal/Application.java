package br.org.acal;

import br.org.acal.application.screen.MainScreen;
import br.org.acal.application.telas.TelaPrincipal;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Application {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ignored){}

        SwingUtilities.invokeLater(() -> {
            /*
            LoginScreen login = new LoginScreen();
            login.setVisible(true);
            */
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);

            MainScreen mainScreen = new MainScreen();
            mainScreen.setVisible(true);
        });

    }

}
