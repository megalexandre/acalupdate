package br.org.acal;

import br.org.acal.application.screen.login.LoginScreen;
import br.org.acal.application.screen.splash.SplashScreen;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.SwingUtilities;

@SpringBootApplication
@ComponentScan(basePackages = {"br.org.acal"})
@EntityScan(basePackages = "br.org.acal")
public class Application {

    public static void main(String[] args) {
        FlatIntelliJLaf.setup();

        SplashScreen splash = new SplashScreen();
        splash.showSplash();

        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class)
                .headless(false)
                .run(args);

        splash.hideSplash();

        SwingUtilities.invokeLater(() -> {
            LoginScreen login = context.getBean(LoginScreen.class);
            login.setVisible(true);
        });

    }

}
