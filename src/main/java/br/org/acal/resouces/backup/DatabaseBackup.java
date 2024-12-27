package br.org.acal.resouces.backup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DatabaseBackup {

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public void backupDatabase() throws IOException, InterruptedException {
        String dirPath = System.getProperty("user.home") + "\\acal\\backup";
        File backupDir = new File(dirPath);

        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        String databaseName = getDatabaseName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String backupFilePath = dirPath + File.separator + "backup_" + databaseName + "_" + timestamp + ".sql";

        String mysqldumpPath = System.getProperty("user.home") + "\\acal\\backup";

        String command = String.format("\"%s\" -u%s -p%s -B %s -r %s",
                mysqldumpPath, dbUsername, dbPassword, databaseName, backupFilePath);

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        // Captura a saída de erro para diagnóstico
        try (InputStream errorStream = process.getErrorStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Erro: " + line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Backup realizado com sucesso: " + backupFilePath);
        } else {
            System.out.println("Falha no backup, código de saída: " + exitCode);
            throw new RuntimeException("");
        }
    }

    private String getDatabaseName() {
        String[] parts = dbUrl.split("/");
        return parts[parts.length - 1].split("\\?")[0];
    }

}
