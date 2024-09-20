package br.org.acal.infra.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        String dirPath = System.getProperty("user.home") + "/acal/reports";
        File directory = new File(dirPath);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        if(directory.exists()){
            clearDirectory(directory.toPath());
        }


        copyFilesToDirectory(directory);
    }

    private void copyFilesToDirectory(File directory) throws IOException {
        String resourcePath = "/print/acal";

        try (Stream<Path> fileList = Files.list(Path.of(Objects.requireNonNull(getClass().getResource(resourcePath)).toURI()))) {

            fileList.toList()
                    .stream().filter(it -> it.getFileName().toString().endsWith(".jrxml"))
                    .forEach(file -> copyFile(file, directory.toPath().resolve(file.getFileName())));

        } catch (Exception ignored) {}
    }

    private void copyFile(Path source, Path destination) {
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to copy file: " + source.toString(), e);
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

