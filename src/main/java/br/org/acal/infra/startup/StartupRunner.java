package br.org.acal.infra.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        String dirBackup = System.getProperty("user.home") + "/acal/backup";
        File directoryBackup = new File(dirBackup);

        if (!directoryBackup.exists()) {
            directoryBackup.mkdirs();
        }

        if (directoryBackup.exists()) {
            clearDirectory(directoryBackup.toPath());
        }

        String dirPath = System.getProperty("user.home") + "/acal/reports";
        File directory = new File(dirPath);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        if (directory.exists()) {
            clearDirectory(directory.toPath());
        }

        copyFilesToDirectory(directory);
    }

    private void copyFilesToDirectory(File directory) {
        String resourcePath = "/print/acal";
        try {
            List<String> fileNames = List.of("invoice.jrxml","invoiceParam.jrxml", "invoiceDetail.jrxml", "register.jrxml");
            for (String fileName : fileNames) {
                try (InputStream inputStream = getClass().getResourceAsStream(resourcePath + "/" + fileName)) {
                    if (inputStream == null) {
                        throw new RuntimeException("Resource not found: " + resourcePath + "/" + fileName);
                    }

                    Path destinationPath = directory.toPath().resolve(fileName);
                    Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException("Não foi possível copiar os arquivos", exception);
        }
    }

    private void clearDirectory(Path path) throws IOException {
        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(Files::isRegularFile)
                    .forEach(p -> {
                        try {
                            Files.delete(p);
                        } catch (IOException ignored) {}
                    });
        }
    }
}
